package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.performance.controller.GeneratorController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:conftest/spring*.xml"})
public class TestGeneratorController {
	@Autowired
	GeneratorController c;
	
	@Test
	public void testDeletGenerator(){
//		String gid = "[\"4\",\"5\"]";
//		String gid = "[4,5]";
//		JSONArray gidList = new JSONArray();
//		gidList.add("4");
//		gidList.add("5");
//		c.deleteGenerator(gid);
	}
	
	@Test
	public void testDeleteOne(){
		String gid = "14";
		c.deleteGeneratorById(gid);
	}
	
}
