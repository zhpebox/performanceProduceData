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
import com.performance.service.GeneratorService;

/**
 * 造数过程控制类
 * @author zhp
 */
@Controller
@RequestMapping("/generator")
public class GeneratorController {
	private static final Logger logger = LoggerFactory.getLogger(GeneratorController.class);
	
	@Autowired
	GeneratorService generatorService;
	
	/**
	 * 根据gid获取generator
	 * @param gid
	 * @return
	 */
	@RequestMapping(value="/getGen/{gid}",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getGenerator(@PathVariable(value="gid")String gid){
		logger.info(" Controller：/generator/getGen/{gid} param: gid="+gid);
		String result = generatorService.getOneGeneratorData(gid);
		logger.debug(" Controller：/generator/getGen/{gid} param: gid="+gid + "  reuslt="+result);
		return result;
	}
	
	/**
	 * 获取所有的generator
	 * @return
	 */
	@RequestMapping(value="/getAll",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getAllGeneratorJSon(){
		logger.info(" Contorller: /generator/getAll");
		String resultStr = generatorService.getAllGenerator("");
		resultStr = "{\"data\":"+resultStr+"}";
		logger.debug(" Contorller: /generator/getAll  result"+resultStr);
		return resultStr;
	}
	
	/**
	 * 保存提交的generator信息
	 * @param generator
	 * @return
	 */
	@RequestMapping(value="/submit",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String submitGeneratorJson(@RequestParam(value="generator",defaultValue="")String generator){
		logger.info(" Controller: /generator/submit  param="+generator);
		int result = generatorService.setGenerator(generator);
		logger.debug(" Controller: /generator/submit  param="+generator+"  result="+result);
		return "OK";
	}
	
	/**
	 * 保存提交的generator信息，并开始造数
	 * @param generator
	 * @return
	 */
	@RequestMapping(value="/startGenerator",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String startGenerator(@RequestParam(value="generator",defaultValue="")String generator){
		logger.info(" Controller: /generator/startGenerator  param="+generator);
		//开始生成数据文件
		int result = generatorService.startGenerator(generator);
		logger.debug(" Controller: /generator/startGenerator  param="+generator+" result="+result);
		return "OK";
	}
	
	/**
	 * 根据gid删除generator信息
	 * @param gid
	 * @return
	 */
	@RequestMapping(value="/delete/{gid}",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteGeneratorById(@PathVariable(value="gid")String gid){
		logger.info(" Controller: /generator/delete/{gid} gid="+gid);
		int result = generatorService.deleteGeneratorOne(gid);
		logger.debug(" Controller: /generator/delete/{gid} gid="+gid+" result="+result);
		return "OK";
	}
	
	/**
	 * 批量删除generator信息
	 * @param gidList
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteGenerator(@RequestParam(value="gidList")String gidList){
		logger.info(" Controller: /generator/delete gidList="+gidList);
		int result = generatorService.deleteGenerator(gidList);
		logger.debug(" Controller: /generator/delete gidList="+gidList+" result="+result);
		return "OK";
	}
	
}
