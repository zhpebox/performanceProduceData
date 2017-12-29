package com.performance.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.performance.service.AuthService;
/**
 * 权限验证类
 * @author peng
 *
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired 
	HttpServletRequest requesta;
	
	@Autowired
	AuthService authService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public String loginAction(String auth,HttpServletRequest request) {
		logger.info("Controller /auth/login  参数为:"+auth);
		authService.validateAuth(auth);
		HttpSession session = request.getSession();
		Cookie cookie = new Cookie("u", "zhp");
		request.getCookies();
		
		return "YY";
	}
	
}
