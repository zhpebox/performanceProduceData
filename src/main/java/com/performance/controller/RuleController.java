package com.performance.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.performance.commonclass.CommonUtil;
import com.performance.commonclass.CommonVariable;
import com.performance.service.RuleService;

/**
 * 造数规则控制类
 * @author zhp
 * 
 */
@Component
@RequestMapping("/rule")
public class RuleController {
	private static final Logger logger = LoggerFactory.getLogger(RuleController.class);
	
	@Autowired
	RuleService ruleService;
	
	/**
	 * 上传参数文件
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws MaxUploadSizeExceededException
	 */
	@RequestMapping(value="/uploadFile",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String uploadFile(HttpServletRequest request){
		String newPathFile = "";
		logger.info(" Controller: /rule/uploadFile 上传文件");
		//创建一个通用的多部分解析器
		CommonsMultipartResolver mulltipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		//判断 request 是否有文件上传，即多部分请求
		if(mulltipartResolver.isMultipart(request)){
			//转换成多部分的request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			//取得request中的所有文件名
			Iterator<String> it = multiRequest.getFileNames();
			while(it.hasNext()){
				//记录上传过程起始的时间，用来计算上传时间
				int pre = (int)System.currentTimeMillis();
				MultipartFile file = multiRequest.getFile(it.next());
				//如果名称不为""，说明文件存在，否则说明文件不存在
				if(file!=null){
					String myFileName = file.getOriginalFilename();
					myFileName = myFileName.substring(0, myFileName.indexOf("."));
					if(myFileName.trim() != ""){
						System.out.println(myFileName);
						//重命名上传的文件名
						String fileName = myFileName+CommonUtil.getRandom(1000);
						//定义上传路径
						String path = CommonVariable.UPLOAD_PATH+CommonVariable.UPDLOADFILEHEADER+fileName;
						File localFile = new File(path);
						newPathFile = fileName;
						logger.info(" source File="+myFileName+"====>>>>"+path+"  starting 开始传输");
						try{
							file.transferTo(localFile);
						} catch (IllegalStateException | IOException e) {
							e.printStackTrace();
						} catch(MaxUploadSizeExceededException e){
							return "文件太大";
						}
						ruleService.afterUploadedFile(fileName,localFile);
					}
				}
				//记录上传该文件后的时间
				int finalTime = (int)System.currentTimeMillis();
				System.out.println((finalTime-pre)+"ms"); 
			}
		}
		
		logger.debug(" Controller: /rule/uploadFile 完成！");
		return newPathFile;
	}
	
	/**
	 * 新增造数规则
	 * @param rule
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addRule(@RequestParam(value="rule",defaultValue="")String rule){
		logger.info(" Controller: /rule/add rule="+rule);
		int result = ruleService.saveRule(rule);
		logger.debug(" Controller: /rule/add rule="+rule+" result="+result);
		return "successful!";
	}
	
	/**
	 * 获得所有的造数规则
	 * @return
	 */
	@RequestMapping(value="/getAll",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getAllRule(){
		logger.info(" Controller: /rule/get ");
		String resultList = ruleService.getRule("");
		logger.debug(" Controller: /rule/get result"+resultList);
		return resultList;
	}
	
	/**
	 * 获得所有的造数规则—JSON格式
	 * @return
	 */
	@RequestMapping(value="/getAllJSon",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getAllRuleJSon(){
		logger.info(" Controller: /rule/getAllJSon ");
		String resultList = ruleService.getRule("");
		resultList = "{\"data\":"+resultList+"}";
		logger.debug(" Controller: /rule/getAllJSon result="+resultList);
		return resultList;
	}
	
	/**
	 * 批量删除造数规则
	 * @param ruleIdList
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteRuleList(@RequestParam(value="ruleId")String ruleIdList){
		logger.info(" Controller: /rule/delete ");
		int result = ruleService.deleteRuleList(ruleIdList);
		logger.debug(" Controller: /rule/delete result="+result);
		return "OK";
	}
	
	/**
	 * 删除造数规则
	 * @param rid
	 * @return
	 */
	@RequestMapping(value="/delete/{rid}",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteRule(@PathVariable(value="rid")String rid){
		logger.info(" Controller： /rule/delete/{rid} rid="+rid);
		int result = ruleService.deleteRuleOne(rid);
		logger.debug(" Controller: /rule/delete/{rid} rid="+rid+" result="+result);
		return "OK";
	}
	
}
