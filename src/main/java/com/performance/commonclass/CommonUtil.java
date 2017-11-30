package com.performance.commonclass;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtil {
	
	public static Properties initProp() throws Exception{
		Properties prop = new Properties();
		
		File tempFile = new File(System.getProperty("user.dir").replaceAll("\\\\", "/")+"/conf.properties");
		InputStream in;
		if(tempFile.exists()){
			in = new BufferedInputStream(new FileInputStream(tempFile));
		}else{
			in = ClassLoader.getSystemResourceAsStream("conf.properties");
		}
		prop.load(in);
		return prop;
	}
	
	public static int getRandom(int bound) {
		return java.util.concurrent.ThreadLocalRandom.current().nextInt(bound);
	}
	
}
