package com.performance.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.performance.commonclass.CommonVariable;
import com.performance.dao.TblRuleMapper;
import com.performance.dao.TblUtil;
import com.performance.model.TblRule;
import com.performance.model.TblRuleExample;
import com.performance.service.RuleService;

@Service
public class RuleServiceImpl implements RuleService {
	private static final Logger logger = LoggerFactory.getLogger(RuleServiceImpl.class);
	
	@Autowired
	private TblRuleMapper tblRuleMapper;
	
	@Autowired
	private TblUtil tblUtil;
	
    @Autowired
    private RedisTemplate<String, String> template;

	
	@Override
	public int saveRule(String ruleStr) {
		TblRule tblRule = JSON.parseObject(ruleStr, new TypeReference<TblRule>(){});
		if(tblRule.getRuleSource()==CommonVariable.RULE_SOURCE_FILE){
			tblRule.setClassName("");
			tblRule.setMethodName("");
		}else if(tblRule.getRuleSource()==CommonVariable.RULE_SOURCE_CODE){
			tblRule.setClassName(CommonVariable.RULE_CLASS_PACKAGE+"."+tblRule.getClassName());
			tblRule.setParamFile("");
		}
		int result = tblRuleMapper.insertSelective(tblRule);
		logger.info("save rule = "+ruleStr+"  result is "+result);
		return result;
	}

	@Override
	public String getRule(String param) {
		List<TblRule> resultList = new ArrayList<TblRule>();
		if("".equals(param)){
			resultList = tblRuleMapper.selectByExample(null);
		}
		return JSON.toJSONString(resultList);
	}

	@Override
	public int deleteRuleList(String ruleIdList) {
		int result = 0;
		List<Integer> ruleList = JSON.parseArray(ruleIdList, Integer.class);
		TblRuleExample example = new TblRuleExample();
		TblRuleExample.Criteria criteria = example.createCriteria();
		criteria.andRuleIdIn(ruleList);
		
		result = tblRuleMapper.deleteByExample(example);
		return result;
	}

	@Override
	public int deleteRuleOne(String ridStr) {
		int rid = Integer.parseInt(ridStr);
		int result = tblRuleMapper.deleteByPrimaryKey(rid);
		return result;
	}

	@Override
	public int afterUploadedFile(String fileName,File uploadedFile) {
		//1.数据库建表
		tblUtil.createTable(fileName);
		//2.按行读文件
		try {
			FileInputStream fileis = new FileInputStream(uploadedFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(fileis));
			String temp = "";
			Map<String,String> paramMap = new HashMap<String,String>();
			paramMap.put("tableName", fileName);
			int index = 0;
			while((temp=br.readLine())!=null) {
				//2.1写库mysql
				paramMap.put("index", String.valueOf(index));
				paramMap.put("value", temp);
				tblUtil.insertData(paramMap);
				//2.2同步到redis
				template.opsForValue().set(fileName+String.valueOf(index), temp);
				index++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
