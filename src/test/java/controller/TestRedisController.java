package controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.performance.dao.TblUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:conftest/spring*.xml"})
public class TestRedisController {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	private TblUtil tblUtil;
	
	@Test
	public void testAccessDB() {
		int count = 100000;
		String tableName = "orgCodeList937";
		
		long s1 = System.currentTimeMillis();
		for(int i = 0 ;i<count;i++) {
			int index = i % 35;
			redisTemplate.opsForValue().get(tableName+index);
//			System.out.println("=    "+redisTemplate.opsForValue().get(tableName+index));
		}
		System.out.println("redis 用时 "+(System.currentTimeMillis()-s1));
		
		
		long s2 = System.currentTimeMillis();
		for(int i = 0 ;i<count;i++) {
			int index = i % 35;
			Map<String,String> paramMap = new HashMap<String,String>();
			paramMap.put("tableName", tableName);
			paramMap.put("index", String.valueOf(index));
			tblUtil.selectData(paramMap);
//			System.out.println("=    "+tblUtil.selectData(paramMap));
		}
		System.out.println("mysql 用时 "+(System.currentTimeMillis()-s2));
		
	}
	
}
