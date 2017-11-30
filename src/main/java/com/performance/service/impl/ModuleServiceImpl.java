package com.performance.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.performance.dao.TblGeneratorMapper;
import com.performance.dao.TblModuleMapper;
import com.performance.dao.TblModuleRuleMapper;
import com.performance.model.TblGeneratorExample;
import com.performance.model.TblModule;
import com.performance.model.TblModuleExample;
import com.performance.model.TblModuleRuleExample;
import com.performance.service.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {
	private static final Logger logger = LoggerFactory.getLogger(ModuleServiceImpl.class);
	
	@Autowired
	TblModuleMapper tblModuleMapper;
	@Autowired
	TblModuleRuleMapper tblModuleRuleMapper;
	@Autowired
	TblGeneratorMapper tblGeneratorMapper;
	
	@Override
	@Transactional
	public int saveMudule(String moduleStr) {
		TblModule tblModule = JSON.parseObject(moduleStr, new TypeReference<TblModule>(){});
		int result = tblModuleMapper.insert(tblModule);
		if(result!=1){
			logger.error("module 插入数据库失败！"+tblModule.toString());
			return 0;
		}
		return tblModule.getModuleId();
	}

	@Override
	public String getModuleById(String moduleId) {
		TblModule result = tblModuleMapper.selectByPrimaryKey(Integer.parseInt(moduleId));
		return JSON.toJSONString(result);
	}

	@Override
	public String getModuleList(String paramStr) {
		List<TblModule> resultList = tblModuleMapper.selectByExampleWithBLOBs(null);
		String resultStr = JSON.toJSONString(resultList);
		resultStr = resultStr.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		return resultStr;
	}

	@Override
	@Transactional
	public int deleteModule(String midList) {
		logger.info(" service: deleteModuleList="+midList);
		int result = 0;
		List<Integer> mids = JSONArray.parseArray(midList,Integer.class);
		
		TblModuleExample example = new TblModuleExample();
		TblModuleExample.Criteria criteria = example.createCriteria();
		criteria.andModuleIdIn(mids);
		
		result = tblModuleMapper.deleteByExample(example);
		logger.info(" service: deleteModule="+midList+"  process result = "+result);
		
		if(result==mids.size()){
			TblModuleRuleExample linkExample = new TblModuleRuleExample();
			TblModuleRuleExample.Criteria linkcriteria = linkExample.createCriteria();
			linkcriteria.andModuleKeyIn(mids);
			int moduleRuleResult = tblModuleRuleMapper.deleteByExample(linkExample);
			logger.info(" service: deleteModuleRule-moduleId="+midList+" delete result = "+moduleRuleResult);
			
			TblGeneratorExample generatorExample = new TblGeneratorExample();
			TblGeneratorExample.Criteria generatorcriteria = generatorExample.createCriteria();
			generatorcriteria.andModuleidIn(mids);
			int generatorResult = tblGeneratorMapper.deleteByExample(generatorExample);
			logger.info(" service: deleteGenerator-moduleId="+midList+" delete result = "+generatorResult);
		}
		
		return result;
	}

	@Override
	public int deleteModuleOne(String mid) {
		logger.info(" service: deleteModuleOne="+mid);
		int moduleId = Integer.parseInt(mid);
		int result = tblModuleMapper.deleteByPrimaryKey(moduleId);
		if(result>0){
			TblModuleRuleExample linkExample = new TblModuleRuleExample();
			TblModuleRuleExample.Criteria linkcriteria = linkExample.createCriteria();
			linkcriteria.andModuleKeyEqualTo(moduleId);
			int moduleRuleResult = tblModuleRuleMapper.deleteByExample(linkExample);
			logger.info(" service: deleteModuleRuleOne-moduleId="+moduleId+" delete result = "+moduleRuleResult);
			
			TblGeneratorExample generatorExample = new TblGeneratorExample();
			TblGeneratorExample.Criteria generatorcriteria = generatorExample.createCriteria();
			generatorcriteria.andModuleidEqualTo(moduleId);
			int generatorResult = tblGeneratorMapper.deleteByExample(generatorExample);
			logger.info(" service: deleteGeneratorOne-moduleId="+moduleId+" delete result = "+generatorResult);
		}
		
		return 0;
	}

}
