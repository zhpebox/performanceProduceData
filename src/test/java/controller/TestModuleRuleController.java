package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.performance.controller.ModuleController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:conftest/spring*.xml"})
public class TestModuleRuleController {
	
	@Autowired
	ModuleController c ;
//
	@Test
	public void testAddModuleRule(){
		String moduleRuleData = "{\"moduleId\":26,\"moduleName\":\"模板名称2\",\"ruleValues\":[1,2,4,18]}";
		c.addModuleRule(moduleRuleData);
	} 
	
}
