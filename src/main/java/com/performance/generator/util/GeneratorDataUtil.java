package com.performance.generator.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.performance.dao.TblUtil;

@Component
public class GeneratorDataUtil {
	private static final Logger logger = LoggerFactory.getLogger(GeneratorDataUtil.class);
	
	private static RedisTemplate<String, String> redisTemplate;
	private static TblUtil tblUtil;
	
	@Autowired
	RedisTemplate<String, String> initRedisTemplate;
	@Autowired
	TblUtil initTblUtile;
	
	@PostConstruct
	public void init() {
		redisTemplate = initRedisTemplate;
		tblUtil = initTblUtile;
	}
	
	/**
	 * 调用参数生成算法，返回对应的value
	 * @param classStr
	 * @param methodStr
	 * @param index
	 * @return
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 */
	public static Object getParamValue(String classStr, String methodStr, int index) throws NoSuchMethodException, ClassNotFoundException {
		logger.info("method(getParamValue) "+classStr+" "+methodStr+" "+index);
		Object resultStr = "";
		Class<?> c = Class.forName(classStr);
		Method m = c.getMethod(methodStr, int.class);
		try {
			resultStr = m.invoke(c, index);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return resultStr;
	}
	
	/**
	 * 调用参数生成算法2，返回对应的value
	 * @param classStr
	 * @param methodStr
	 * @param index
	 * @return
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 */
	public static Object getParamValue(String classStr, String methodStr, int index, int size) throws NoSuchMethodException, ClassNotFoundException {
		Object resultStr = "";
		Class<?> c = Class.forName(classStr);
		Method m = c.getMethod(methodStr, int.class,int.class);
		try {
			resultStr = m.invoke(c, index,size);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return resultStr;
	}
	
	
	public static Object getParamValue(String table,int index) {
		
		Object valueStr = null; 
		int connFalse = 0;
		//redis读取
		try {
			valueStr = redisTemplate.opsForValue().get(table+index);
		}catch(RedisConnectionFailureException n) {
			connFalse = 1;
			logger.error("redis 连接失败！请检查redis服务器……");
		} 
		
		if(valueStr==null ) {
			//mySQL读取
			Map<String,String> paramMap = new HashMap<String,String>();
			paramMap.put("tableName", table);
			paramMap.put("index", String.valueOf(index));
			valueStr = tblUtil.selectData(paramMap); 
			
			//redis服务正常，但需要查询的数据不在redis，需要进行同步
			if(connFalse == 0) {
				redisTemplate.opsForValue().set(table+index, String.valueOf(valueStr));
//				syncRedis(table);
			}
		}
		System.out.println("A");
		return valueStr;
	}
	
	public static void syncRedis(String tableName) {
		System.out.println("B");
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(new Runnable() {
			@Override
			public void run() {
				List<String> resultList = tblUtil.selectAllData(tableName);
				for(int i = 0 ;i<resultList.size();i++) {
					redisTemplate.opsForValue().set(tableName+i, resultList.get(i));
				}
				System.out.println("D");
			}
		});
		System.out.println("C");
	}
	
	
	/**
	 * 从参数文件获取参数值，以String形式返回
	 * @param fileName
	 * @param index 从0开始
	 * @return
	 */
	@Deprecated
	public static String getFileParam(String fileName, int index) {
		String resultStr = "";
		if(index>=0){
			try {
				InputStream is = ClassLoader.getSystemResourceAsStream(fileName);
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				for (int i = 0; i <= index; i++) {
					if ((resultStr = br.readLine()) == null){
						resultStr = "（下标index="+index+"越界，超过最大行值，是否有错？）";
						break;
					} 
				}
				br.close();
				is.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			resultStr = "（下标index="+index+"小于0，是否有错？）";
		}
		return resultStr;
	}

	// 读取配置文件
	public static Properties getProperties(String propName) throws Exception {
		Properties prop = new Properties();
		File propFile = new File(System.getProperty("user.dir").replaceAll("\\\\", "/") + "/" + propName);
		InputStream in;
		if (propFile.exists()) {
			in = new BufferedInputStream(new FileInputStream(propFile));
			System.out.println("加载外部配置文件！" + System.getProperty("user.dir").replaceAll("\\\\", "/") + "/" + propName);
		} else {
			in = ClassLoader.getSystemResourceAsStream(propName);
			System.out.println("加载内部配置文件！" + propName);
		}
		prop.load(in);
		return prop;
	}

}
