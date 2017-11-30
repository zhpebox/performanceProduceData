package com.performance.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.performance.commonclass.CommonVariable;
import com.performance.dao.TblGeneratorMapper;
import com.performance.dao.TblModuleRuleMapper;
import com.performance.dao.TblRuleMapper;
import com.performance.model.TblGenerator;
import com.performance.model.TblModuleRule;
import com.performance.model.TblRule;
import com.performance.service.ModuleRuleService;

@Service
public class ModuleRuleServiceImpl implements ModuleRuleService {
	private static final Logger logger = LoggerFactory.getLogger(ModuleRuleServiceImpl.class);
	@Autowired
	TblModuleRuleMapper tblModuleRuleMapper;
	@Autowired
	TblRuleMapper tblRuleMappper;
	@Autowired
	TblGeneratorMapper tblGeneratorMapper;
	
	@Override
	@Transactional
	public int saveModuleRule(String moduleRuleStr) {
		
		JSONObject source = JSONObject.parseObject(moduleRuleStr);
		JSONArray fileNameRule = source.getJSONArray("fileNameRule");
		JSONArray fileHeaderRule = source.getJSONArray("fileHeaderRule");
		JSONArray moduleRule = source.getJSONArray("moduleRule");
		
		
		TblModuleRule tblModuleRule = new TblModuleRule();
		tblModuleRule.setModuleKey(source.getInteger("moduleId"));
		
		//将已关联规则的module插入t_generator
		TblGenerator tblGenerator = new TblGenerator();
		tblGenerator.setModuleid(source.getInteger("moduleId"));
		tblGenerator.setModulename(source.getString("moduleName"));
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		tblGenerator.setUpdatetime(sf.format(new Date()));	
		int genResult = tblGeneratorMapper.insertSelective(tblGenerator);
		logger.info(" save the information of module into table t_generator "+tblGenerator.toString()+"  reusltId="+tblGenerator.getGid());

		tblModuleRule.setGeneratorKey(tblGenerator.getGid());
		
		HashMap<Integer,String> ruleMap = this.getAllRule();
		
		//修改，将 tblGenerator 所插入的主键信息存入moduleRule，方便删除
		for(int i=0;i<fileNameRule.size();i++){
			tblModuleRule.setParamIndex(i);
			tblModuleRule.setParamType(CommonVariable.PARAM_TYPE_FILENAME);
			tblModuleRule.setRuleKey(fileNameRule.getInteger(i));
			tblModuleRule.setRuleName(ruleMap.get(fileNameRule.getInteger(i)));
			tblModuleRule.setFlag(CommonVariable.PARAM_TYPE_FILENAME);
			int result = tblModuleRuleMapper.insertSelective(tblModuleRule);
			logger.info(" save fileNameRule to DB, result is "+result+" value is "+tblModuleRule.toString()); 
		}
		for(int i=0;i<fileHeaderRule.size();i++){
			tblModuleRule.setParamIndex(i);
			tblModuleRule.setParamType(CommonVariable.PARAM_TYPE_FILEHEADER);
			tblModuleRule.setRuleKey(fileHeaderRule.getInteger(i));
			tblModuleRule.setRuleName(ruleMap.get(fileHeaderRule.getInteger(i)));
			tblModuleRule.setFlag(CommonVariable.PARAM_TYPE_FILEHEADER);
			int result = tblModuleRuleMapper.insertSelective(tblModuleRule);
			logger.info(" save fileHeaderRule to DB, result is "+result+" value is "+tblModuleRule.toString()); 
		}
		for(int i=0;i<moduleRule.size();i++){
			tblModuleRule.setParamIndex(i);
			tblModuleRule.setParamType(CommonVariable.PARAM_TYPE_MODULE);
			tblModuleRule.setRuleKey(moduleRule.getInteger(i));
			tblModuleRule.setRuleName(ruleMap.get(moduleRule.getInteger(i)));
			tblModuleRule.setFlag(CommonVariable.PARAM_TYPE_MODULE);
			int result = tblModuleRuleMapper.insertSelective(tblModuleRule);
			logger.info(" save moduleRule to DB, result is "+result+" value is "+tblModuleRule.toString()); 
		}
		
		return genResult;
	}
	
	//获取规则列表，按id，ruleName封装到map里
	public HashMap<Integer,String> getAllRule(){
		HashMap<Integer,String> resultList = new HashMap<Integer,String>();
		List<TblRule> ruleList = tblRuleMappper.selectByExample(null);
		for(TblRule e:ruleList){
			resultList.put(e.getRuleId(), e.getRuleName());
		}
		
		return resultList;
	}

}
