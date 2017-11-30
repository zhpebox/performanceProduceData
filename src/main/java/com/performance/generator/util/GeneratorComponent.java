package com.performance.generator.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.performance.commonclass.CommonVariable;
import com.performance.dao.TblModuleMapper;
import com.performance.dao.TblModuleRuleMapper;
import com.performance.dao.TblRuleMapper;
import com.performance.dao.TblUtil;
import com.performance.model.TblGenerator;
import com.performance.model.TblModule;
import com.performance.model.TblRule;
import com.performance.model.TblRuleExample;

@Component
@Scope(value="prototype")
public class GeneratorComponent {
	private static final Logger logger = LoggerFactory.getLogger(GeneratorComponent.class);
	
	@Autowired
	TblModuleMapper tblModuleMapper;

	@Autowired
	TblModuleRuleMapper tblModuleRuleMapper;

	@Autowired
	TblRuleMapper tblRuleMapper;

	@Autowired
	GeneratorDataUtil generatorDataUtil;
	

	/**
	 * 用来缓存当前generator所关联的规则，避免频繁的数据库查询
	 */
	private HashMap<String, TblRule> localRuleMap;
	
	/**
	 * 标识全局index-机构级别
	 */
	private int global_index0 = 0;
	/**
	 * 标识全局index-文件级别
	 */
	private int global_file_index = 0;
	/**
	 * 标识全局index-记录级别
	 */
	private int global_register_index = 0;

	
	/**
	 * 主方法：生成所有的数据文件
	 * @param genrator 当前造数过程的基本配置
	 * @param moduleRuleList 当前造数过程使用到的参数位置与规则集合
	 */
	public void generatorOrgFile(TblGenerator genrator, String moduleRuleList) {
		
		long start = System.currentTimeMillis();
		
		int startOrg = genrator.getStartorg();
		int endOrg = genrator.getEndorg();
		int fileNum = genrator.getFilenum();
		int orgIndex = startOrg; //标识当前的机构号

		// 获取模板
		TblModule tblModule = tblModuleMapper.selectByPrimaryKey(genrator.getModuleid());

		// 封装规则
		JSONArray jsonRuleArray = JSON.parseArray(moduleRuleList);
		getRuleMap(jsonRuleArray);

		//初始化造数过程使用的 index
		global_index0 = 0;
		global_file_index = 0;
		global_register_index = 0;
		
		// 循环每个机构
		for (; orgIndex <= endOrg; orgIndex++) {
			for (int j = 1; j <= fileNum; j++) {
				try {
					genratorFile4org(orgIndex, j + "", genrator, tblModule);
				} catch (Exception e) {
					e.printStackTrace();
				}
				global_file_index++;
			}
			global_index0++;
		}
		
		long end = System.currentTimeMillis() - start;
		logger.info("整个造数过程耗时："+end/1000+"s"); 
		
	}

	/**
	 * 对一个机构生成批量文件
	 * 
	 * @param currentOrg
	 * @param fileIndex
	 * @param genrator
	 * @param ModuleText
	 * @param ruleList
	 * @throws IOException 
	 * @throws Exception
	 */
	private void genratorFile4org(int orgIndex, String fileIndex, TblGenerator genrator, TblModule module) throws IOException {

		// 生成文件路径
		String basePathStr = genrator.getFilebasepath() + "/" + CommonVariable.orgcode_start_index+orgIndex + "/";
		File basePath = new File(basePathStr);
		if (!basePath.exists()) {
			basePath.mkdirs();
		}

		// 拼接文件名
		String fileName = module.getFileName();
		String[] fileNameArray;
		int endFileNameFlag = 0;
		if(!fileName.endsWith("$")){
			fileNameArray = fileName.split("\\$");
		}else{
			endFileNameFlag = 1;
			fileNameArray = (fileName+"*").split("\\$");
		}
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<fileNameArray.length-1;i++){
			sb.append(fileNameArray[i]);
			try {
				//根据规则生成String
				getStringForRule(CommonVariable.PARAM_TYPE_FILENAME+"_"+i,genrator, sb);
			} catch (NoSuchMethodException | ClassNotFoundException e) {
				TblRule errorRle = localRuleMap.get(CommonVariable.PARAM_TYPE_FILENAME+"_"+i);
				logger.error("没有找到造数过程中相关的参数类:"+errorRle.getClassName()+" 或 参数方法："+errorRle.getMethodName());
				e.printStackTrace();
			}
			
		}
		if(endFileNameFlag!=1){
			sb.append(fileNameArray[fileNameArray.length - 1]);
		}
		fileName = sb.toString();

		// 获取输出Out
		File outFile = new File(basePathStr + fileName + ".txt");
		FileOutputStream out = new FileOutputStream(outFile);
		logger.info("当前文件输出到："+basePathStr + fileName + ".txt"); 

		// 拼接文件head
		String fileHeader = module.getFileHeader()+"\r\n";
		String[] fileHeaderArray = fileHeader.split("\\$");
		
		sb = new StringBuffer();
		for(int i = 0;i<fileHeaderArray.length-1;i++){
			sb.append(fileHeaderArray[i]);
			try{
				getStringForRule(CommonVariable.PARAM_TYPE_FILEHEADER+"_"+i,genrator, sb);
			} catch (NoSuchMethodException | ClassNotFoundException e) {
				TblRule errorRle = localRuleMap.get(CommonVariable.PARAM_TYPE_FILEHEADER+"_"+i);
				logger.error("没有找到造数过程中相关的参数类:"+errorRle.getClassName()+" 或 参数方法："+errorRle.getMethodName());
				e.printStackTrace();
			}
		}
		
		sb.append(fileHeaderArray[fileHeaderArray.length - 1]);
		fileHeader = sb.toString();
		out.write(fileHeader.getBytes());

		// 批量生成记录
		for (int j = 0; j < genrator.getFilesize(); j++) {
			generatorRegisterBatch(module.getModuleText(), out,fileName);
			global_register_index++;
		}

		out.flush();
		out.close();
		
	}

	/**
	 * 对一个文件批量生成记录
	 * 
	 * @param moduleStr
	 * @param ruleMap
	 * @param out
	 * @throws IOException 
	 * @throws Exception
	 */
	public void generatorRegisterBatch(String moduleStr, FileOutputStream out,String fileName) throws IOException {
		moduleStr = moduleStr.replaceAll("\n", "").replaceAll("\t", "").replace("\r", "");

		// 生成记录，设置参数
		String[] moduleStrArray = moduleStr.split("\\$");

		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < moduleStrArray.length - 1; i++) {
			sb.append(moduleStrArray[i]);
			try{
				getStringForRule(CommonVariable.PARAM_TYPE_MODULE+"_"+i,null, sb);
			} catch (NullPointerException | NoSuchMethodException | ClassNotFoundException e) {
				TblRule errorRle = localRuleMap.get(CommonVariable.PARAM_TYPE_MODULE+"_"+i);
				logger.error("没有找到造数过程中相关的参数类:"+errorRle.getClassName()+" 或 参数方法："+errorRle.getMethodName());
				e.printStackTrace();
			}
		}
		sb.append(moduleStrArray[moduleStrArray.length - 1]);
		// 获取记录
		String curDataStr = sb.toString() + "\r\n";
		out.write(curDataStr.getBytes());
	}

	
	/**
	 * 根据规则主键，拼接该规则生成的字符创
	 * @param ruleIndexLabel
	 * @param generator
	 * @param localSb
	 * @throws ClassNotFoundException 
	 * @throws NoSuchMethodException
	 */
	public void getStringForRule(String ruleIndexLabel,TblGenerator generator, StringBuffer localSb) throws NoSuchMethodException, ClassNotFoundException{
		TblRule currentRule = localRuleMap.get(ruleIndexLabel);
		
		//获取全局index作为生成String的标识
		int local_index = 0 ; 
		switch (currentRule.getFlag()) {
		case CommonVariable.PARAM_TYPE_MODULE:
			local_index = global_register_index;
			break;
		case CommonVariable.PARAM_TYPE_FILEHEADER:
			local_index = global_file_index;
			break;
		case CommonVariable.PARAM_TYPE_FILENAME:
			local_index = global_index0;
			break;
		}
		
		Object resultStr = "";
		//解析规则
		if (currentRule.getRuleSource().equals(CommonVariable.RULE_SOURCE_FILE)) {
			// 读参数文件
//			resultStr = "FileParam" + ruleIndexLabel;
			resultStr = GeneratorDataUtil.getParamValue(currentRule.getParamFile(), currentRule.getStartIndex()+local_index);
		} else if (currentRule.getRuleSource().equals(CommonVariable.RULE_SOURCE_CODE)) {
			try {
				resultStr = GeneratorDataUtil.getParamValue(currentRule.getClassName(), currentRule.getMethodName(),currentRule.getStartIndex()+local_index);
			} catch (NoSuchMethodException e) {
				resultStr = GeneratorDataUtil.getParamValue(currentRule.getClassName(), currentRule.getMethodName(), currentRule.getStartIndex()+local_index, generator.getFilesize());
			} 
		}
		
		localSb.append(resultStr);
	}
	
	/**
	 * 封装 当前generator 包含的 rule
	 * @param generatorRuleList
	 */
	public void getRuleMap(JSONArray generatorRuleList) {
		//result 以参数类型和参数index作为key
		HashMap<String, TblRule> paramRule = new HashMap<String, TblRule>();

		//获取该generter关联的所有rule id
		List<Integer> ruleIdList = new ArrayList<Integer>();
		for (int i = 0; i < generatorRuleList.size(); i++) {
			ruleIdList.add(generatorRuleList.getJSONObject(i).getInteger("ruleKey"));
		}

		//按照关联的ruleId，查询出所有的关联规则信息
		TblRuleExample ruleExample = new TblRuleExample();
		TblRuleExample.Criteria ruleCriteria = ruleExample.createCriteria();
		ruleCriteria.andRuleIdIn(ruleIdList);

		//将关联规则进行封装
		List<TblRule> ruleList = tblRuleMapper.selectByExample(ruleExample);
		HashMap<Integer,TblRule> ruleMap = new HashMap<Integer,TblRule>();
		for(int i=0;i<ruleList.size();i++){
			ruleMap.put(ruleList.get(i).getRuleId(), ruleList.get(i));
		}
		
		TblRule temp = null;
		for(int i=0;i<generatorRuleList.size();i++){
			JSONObject json = generatorRuleList.getJSONObject(i);
			temp = ruleMap.get(json.getInteger("ruleKey"));
			TblRule tblRule = getNewTblRule(temp);
			tblRule.setStartIndex(json.getInteger("startIndex"));
			tblRule.setFlag(json.getInteger("flag"));
			paramRule.put(json.getInteger("paramType")+"_"+json.getInteger("paramIndex"), tblRule);
		}
		
		this.localRuleMap = paramRule;
	}
	
	public TblRule getNewTblRule(TblRule source){
		TblRule dest = new TblRule();
		dest.setClassName(source.getClassName());
		dest.setMethodName(source.getMethodName());
		dest.setParamFile(source.getParamFile());
		dest.setRuleId(source.getRuleId());
		dest.setRuleName(source.getRuleName());
		dest.setRuleSource(source.getRuleSource());
		return dest;
	}
	
}
