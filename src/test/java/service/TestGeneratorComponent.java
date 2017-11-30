package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.performance.generator.util.GeneratorComponent;
import com.performance.model.TblGenerator;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:conftest/spring*.xml"})
public class TestGeneratorComponent {
	
	@Autowired
	GeneratorComponent generatorComponent;
	
	@Test
	public void testGeneratorOrgFile(){
		TblGenerator generator = new TblGenerator();
		generator.setFilebasepath("D:/111/55/");
		generator.setFilenum(3);
		generator.setFilesize(10);
		generator.setModuleid(46);
		generator.setStartorg(1);
		generator.setEndorg(10);
//		String moduleRuleList = "[{\"startIndex\":\"2\",\"moduleName\":\"模板_1\",\"ruleName\":\"三标姓名\",\"id\":9,\"ruleKey\":1,\"moduleKey\":2,\"paramIndex\":0},"
//				+ "{\"startIndex\":\"3\",\"moduleName\":\"模板_1\",\"ruleName\":\"三标号\",\"id\":10,\"ruleKey\":2,\"moduleKey\":2,\"paramIndex\":1},"
//				+ "{\"startIndex\":\"4\",\"moduleName\":\"模板_1\",\"ruleName\":\"组织机构名称\",\"id\":11,\"ruleKey\":3,\"moduleKey\":2,\"paramIndex\":2},{\"startIndex\":\"5\",\"moduleName\":\"模板_1\",\"ruleName\":\"组织机构代码\",\"id\":12,\"ruleKey\":4,\"moduleKey\":2,\"paramIndex\":3}]";
//		String moduleRuleList = "[{\"startIndex\":0,\"generatorKey\":40,\"moduleName\":\"\",\"ruleName\":\"\",\"id\":159,\"ruleKey\":1,\"moduleKey\":33,\"paramIndex\":0},"
//				+ "{\"startIndex\":0,\"generatorKey\":40,\"moduleName\":\"\",\"ruleName\":\"\",\"id\":160,\"ruleKey\":2,\"moduleKey\":33,\"paramIndex\":1},"
//				+ "{\"startIndex\":0,\"generatorKey\":40,\"moduleName\":\"\",\"ruleName\":\"\",\"id\":161,\"ruleKey\":4,\"moduleKey\":33,\"paramIndex\":2},"
//				+ "{\"startIndex\":0,\"generatorKey\":40,\"moduleName\":\"\",\"ruleName\":\"\",\"id\":162,\"ruleKey\":18,\"moduleKey\":33,\"paramIndex\":3}]";
		String moduleRuleListn = 
				 "[{\"paramType\":0,\"startIndex\":0,\"generatorKey\":52,\"moduleName\":\"\",\"ruleName\":\"T1\",\"id\":270,\"ruleKey\":38,\"moduleKey\":46,\"paramIndex\":0},"
				 + "{\"paramType\":0,\"startIndex\":0,\"generatorKey\":52,\"moduleName\":\"\",\"ruleName\":\"T2\",\"id\":271,\"ruleKey\":39,\"moduleKey\":46,\"paramIndex\":1},"
				 + "{\"paramType\":0,\"startIndex\":0,\"generatorKey\":52,\"moduleName\":\"\",\"ruleName\":\"T3\",\"id\":272,\"ruleKey\":40,\"moduleKey\":46,\"paramIndex\":2},"
				 + "{\"paramType\":0,\"startIndex\":0,\"generatorKey\":52,\"moduleName\":\"\",\"ruleName\":\"T4\",\"id\":273,\"ruleKey\":41,\"moduleKey\":46,\"paramIndex\":3},"
				 + "{\"paramType\":0,\"startIndex\":0,\"generatorKey\":52,\"moduleName\":\"\",\"ruleName\":\"T5\",\"id\":274,\"ruleKey\":42,\"moduleKey\":46,\"paramIndex\":4},"
				 + "{\"paramType\":1,\"startIndex\":0,\"generatorKey\":52,\"moduleName\":\"\",\"ruleName\":\"T6\",\"id\":275,\"ruleKey\":43,\"moduleKey\":46,\"paramIndex\":0},"
				 + "{\"paramType\":1,\"startIndex\":0,\"generatorKey\":52,\"moduleName\":\"\",\"ruleName\":\"T7\",\"id\":276,\"ruleKey\":44,\"moduleKey\":46,\"paramIndex\":1},"
				 + "{\"paramType\":1,\"startIndex\":0,\"generatorKey\":52,\"moduleName\":\"\",\"ruleName\":\"T8\",\"id\":277,\"ruleKey\":45,\"moduleKey\":46,\"paramIndex\":2},"
				 + "{\"paramType\":1,\"startIndex\":0,\"generatorKey\":52,\"moduleName\":\"\",\"ruleName\":\"T9\",\"id\":278,\"ruleKey\":46,\"moduleKey\":46,\"paramIndex\":3},"
				 + "{\"paramType\":1,\"startIndex\":0,\"generatorKey\":52,\"moduleName\":\"\",\"ruleName\":\"T10\",\"id\":279,\"ruleKey\":47,\"moduleKey\":46,\"paramIndex\":4},"
				 + "{\"paramType\":2,\"startIndex\":0,\"generatorKey\":52,\"moduleName\":\"\",\"ruleName\":\"三标姓名\",\"id\":280,\"ruleKey\":1,\"moduleKey\":46,\"paramIndex\":0},"
				 + "{\"paramType\":2,\"startIndex\":0,\"generatorKey\":52,\"moduleName\":\"\",\"ruleName\":\"三标号\",\"id\":281,\"ruleKey\":2,\"moduleKey\":46,\"paramIndex\":1},"
				 + "{\"paramType\":2,\"startIndex\":0,\"generatorKey\":52,\"moduleName\":\"\",\"ruleName\":\"组织机构代码\",\"id\":282,\"ruleKey\":4,\"moduleKey\":46,\"paramIndex\":2},"
				 + "{\"paramType\":2,\"startIndex\":0,\"generatorKey\":52,\"moduleName\":\"\",\"ruleName\":\"组织机构名称\",\"id\":283,\"ruleKey\":18,\"moduleKey\":46,\"paramIndex\":3}]";
		generatorComponent.generatorOrgFile(generator,moduleRuleListn);
		
//	CountDownLatch latch = new CountDownLatch(10);
//	try {
//		latch.await();
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//		
	}
	
}
