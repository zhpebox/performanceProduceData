package com.performance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.performance.model.TblModule;
import com.performance.service.GeneratorService;
import com.performance.service.ModuleRuleService;
import com.performance.service.ModuleService;

/**
 * 模板控制类
 * @author zhp
 */
@Controller
@RequestMapping("/module")
public class ModuleController {
	private static final Logger logger = LoggerFactory.getLogger(ModuleController.class);
	
	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private ModuleRuleService moduleRuleService;
	
	@Autowired
	private GeneratorService generatorService;
	
	/**
	 * 保存提交module信息
	 * @param moduleData
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addDataModule(@RequestParam(value="moduleData",defaultValue="") String moduleData){
		logger.info(" Controller: /module/add moduleData="+moduleData); 
		int saveResult = moduleService.saveMudule(moduleData);
		String result = saveResult!=0?String.valueOf(saveResult):"处理失败";
		logger.debug(" Controller: /module/add moduleData="+moduleData+" result="+saveResult); 
		return result;
	}
	
	/**
	 * 修改
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateDataModule(@RequestParam(value="moduleData",defaultValue="")String moduleData) {
		logger.info(" Controller: /module/add moduleData="+moduleData);
		TblModule tblModule = JSON.parseObject(moduleData, new TypeReference<TblModule>() {});

		//首先判断待更新项，是否已使用，如果已使用，禁止修改
		int size = generatorService.selectNumExistData(tblModule.getModuleId());
		if(size>0) {
			logger.debug("genger表中已使用模板id="+tblModule.getModuleId()+" 次数"+size+"次"); 
			return "该模板已用于造数过程，请勿修改！";
		}

		//更新模板信息
		int updateResult = moduleService.updateMudule(tblModule);
		String result = updateResult!=0?String.valueOf(updateResult):"处理失败";
		logger.debug(" Controller: /module/update moduleData="+moduleData+" result="+updateResult);
		return result;
	}
	
	/**
	 * 针对具体module关联相关规则
	 * @param moduleRuleData
	 * @return
	 */
	@RequestMapping(value="/moduleRule/add",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addModuleRule(@RequestParam(value="moduleRuleData",defaultValue="")String moduleRuleData){
		logger.info(" Controller: /moduleRule/add moduleRuleData"+moduleRuleData);
		int result = moduleRuleService.saveModuleRule(moduleRuleData);
		logger.debug(" Controller: /moduleRule/add moduleRuleData"+moduleRuleData+" result="+result);
		return "OK";
	}
	
	
	/**
	 * 查询module详细信息
	 * @param moduleId
	 * @return
	 */
	@RequestMapping(value="/get/{moduleId}",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getDataModule(@PathVariable(value="moduleId")String moduleId){
		logger.info(" Controller: /module/get/{moduleId} moduleId="+moduleId);
		String result = moduleService.getModuleById(moduleId);
		logger.debug(" Controller: /module/get/{moduleId} moduleId="+moduleId +" result="+result);
		return result;
	}
	
	/**
	 * 查询所有module信息
	 * @return
	 */
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@ResponseBody
	public String getAll(){
		logger.info(" Controller: /module/getAll");
		String result = moduleService.getModuleList("");
		result = "{\"data\":"+result+"}";
		logger.debug(" Controller: /module/getAll result"+result);
		return result;
	}
	
	/**
	 * 批量删除模板信息
	 * @param midList
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteModuleList(@RequestParam(value="midList")String midList){
		logger.info(" Controller: /module/delete midList="+midList);
		int result = moduleService.deleteModule(midList);
		logger.debug(" Controller: /module/delete midList="+midList+" result="+result);
		return "OK";
	}
	
	/**
	 * 删除模板信息
	 * @param mid
	 * @return
	 */
	@RequestMapping(value="/delete/{mid}",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteModuleOne(@PathVariable(value="mid")String mid){
		logger.info(" Controller：/module/delete/{mid} RequestParam mid="+mid);
		int result = moduleService.deleteModuleOne(mid);
		logger.debug(" Controller：/module/delete/{mid} RequestParam mid="+mid+" result="+result);
		return "OK";
	}
	
}
