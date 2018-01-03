package com.performance.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
	public String validateAuth(String authStr) {
		JSONObject authObj = JSON.parseObject(authStr);
		System.out.println(authObj.getString("name")+"  "+authObj.getString("pwd"));
		if("think".equals(authObj.getString("name")) && "123456".equals(authObj.getString("pwd"))) {
			logger.info("登陆成功 "+authStr);
			UsernamePasswordToken token = new UsernamePasswordToken(authObj.getString("name"), authObj.getString("pwd"));
			token.setRememberMe(true);

			Subject currentUserSubject = SecurityUtils.getSubject();
			currentUserSubject.login(token);
			return "Y";
		}
		logger.info("登陆失败 "+authStr);
		return "N";
	}

}
