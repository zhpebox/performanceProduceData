package com.performance.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.performance.dao.TblGeneratorMapper;
import com.performance.dao.TblModuleRuleMapper;
import com.performance.generator.util.GeneratorComponent;
import com.performance.model.TblGenerator;
import com.performance.model.TblGeneratorExample;
import com.performance.model.TblModuleRule;
import com.performance.model.TblModuleRuleExample;
import com.performance.service.GeneratorService;

@Service
public class GeneratorServiceImpl implements GeneratorService {
	private static final Logger logger = LoggerFactory.getLogger(GeneratorServiceImpl.class);
	
	@Autowired
	TblGeneratorMapper tblGeneratorMapper;
	
	@Autowired
	TblModuleRuleMapper tblModuleRuleMapper;
	
	@Autowired
	GeneratorComponent generatorComponent;
	
	
	@Override
	public String getAllGenerator(String param) {
		List<TblGenerator> resultList = tblGeneratorMapper.selectByExample(null);
		String resultStr = JSONObject.toJSONString(resultList);
		return resultStr;
	}

	@Override
	public String getOneGeneratorData(String gidStr) {
		int gid = Integer.parseInt(gidStr);
		TblGenerator result = tblGeneratorMapper.selectByPrimaryKey(gid);
		
		TblModuleRuleExample example = new TblModuleRuleExample();
		TblModuleRuleExample.Criteria  criteria = example.createCriteria();
		criteria.andGeneratorKeyEqualTo(gid);
		List<TblModuleRule> moduleRuleList = tblModuleRuleMapper.selectByExample(example);
		
		JSONObject resultJSon = new JSONObject();
		resultJSon.put("generator", result);
		//查询所关联的规则，封装到JSON
		resultJSon.put("linkedRule", moduleRuleList);
		System.out.println(resultJSon.toJSONString());
		return resultJSon.toJSONString();
	}

	@Override
	public int addGenerator(String generator) {
		TblGenerator tblGenerator = JSONObject.parseObject(generator, new TypeReference<TblGenerator>(){});
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		tblGenerator.setUpdatetime(sf.format(new Date()));
		int result = tblGeneratorMapper.insertSelective(tblGenerator);
		if(result!=1){
			logger.error(" generaor 插入数据库失败！"+tblGenerator.toString());
			return 0;
		}
		return tblGenerator.getGid();
	}

	@Override
	public int setGenerator(String generator) {
		TblGenerator tblGenerator = JSONObject.parseObject(generator, new TypeReference<TblGenerator>(){});
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		tblGenerator.setUpdatetime(sf.format(new Date()));
		int result = tblGeneratorMapper.updateByPrimaryKeySelective(tblGenerator);
		if(result!=1){
			logger.error(" generaor 更新数据库失败！"+tblGenerator.toString());
			return 0;
		}
		return result;
	}

	@Override
	public int startGenerator(String generatorStr) {
		
		TblGenerator tblGenerator = JSON.parseObject(generatorStr,new TypeReference<TblGenerator>(){});
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		tblGenerator.setUpdatetime(sf.format(new Date()));
		int result = tblGeneratorMapper.updateByPrimaryKeySelective(tblGenerator);
		if(result!=1){
			logger.error(" generaor 更新数据库失败！"+tblGenerator.toString());
			return 0;
		}
		JSONObject generatorJSon = JSON.parseObject(generatorStr);
		generatorComponent.generatorOrgFile(tblGenerator,generatorJSon.get("moduleRuleList").toString());
		return 0;
	}


	@Override
	@Transactional
	public int deleteGenerator(String gidArray) {
		int result = 0;
		List<Integer> tempArray = JSONArray.parseArray(gidArray, Integer.class);
		
		TblGeneratorExample example = new TblGeneratorExample();
		TblGeneratorExample.Criteria criteria = example.createCriteria();
		criteria.andGidIn(tempArray);
		
		result = tblGeneratorMapper.deleteByExample(example);
		
		//删除moduleRule表的关联记录
		TblModuleRuleExample linkExample = new TblModuleRuleExample();
		TblModuleRuleExample.Criteria linkCriteria = linkExample.createCriteria();
		linkCriteria.andGeneratorKeyIn(tempArray);
		
		tblModuleRuleMapper.deleteByExample(linkExample);
		
		return result;
	}

	@Override
	@Transactional
	public int deleteGeneratorOne(String gidStr) {
		int gid = Integer.parseInt(gidStr);
		int result = tblGeneratorMapper.deleteByPrimaryKey(gid);
		
		//删除moduleRule表的关联记录
		TblModuleRuleExample example = new TblModuleRuleExample();
		TblModuleRuleExample.Criteria criteria = example.createCriteria();
		criteria.andGeneratorKeyEqualTo(gid);
		
		tblModuleRuleMapper.deleteByExample(example);
		
		return result;
	}

}
