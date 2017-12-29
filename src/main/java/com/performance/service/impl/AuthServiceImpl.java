package com.performance.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.performance.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
	
	@Override
	public int validateAuth(String authStr) {
		logger.info("验证权限"+authStr);
		JSONObject authObj = JSON.parseObject(authStr);
		System.out.println(authObj.getString("name")+"  "+authObj.getString("pwd"));
		return 1;
	}

}
