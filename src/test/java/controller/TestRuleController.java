package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.performance.controller.RuleController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:conftest/spring*.xml"})
public class TestRuleController {
	@Autowired
	RuleController c;
	
//	@Test
	public void testGetRuleModule(){
		String result = c.getAllRule();
		System.out.println(result);
		
	}
	
	@Test
	public void testAddRule(){
		String rule = "{\"ruleName\":\"规则参数s\",\"ruleSource\":\"1\",\"paramFile\":\"C:\\\\fakepath\\\\apache-tomcat-7.0.68.tar.gz\",\"className\":\"参数Class\",\"methodName\":\"参数Method\"}";
		c.addRule(rule);
	}
}
