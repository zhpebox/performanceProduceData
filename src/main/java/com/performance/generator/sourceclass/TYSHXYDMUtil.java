package com.performance.generator.sourceclass;

import java.util.HashMap;
import java.util.Map;

/**
* @author wangchen
* @version 创建时间:2017年8月28日上午11:22:12
*
*/
public class TYSHXYDMUtil {
	public static void main(String[] args) {
		for(int i = 0 ;i<1000000000;i++){
			System.out.println(generatorCode(i).getCode() +  "," +generatorCode(i).getName());
		}
	}
	
	public static char createValid(String businessCode) {
		
		String baseCode = "0123456789ABCDEFGHJKLMNPQRTUWXY";
		char[] baseCodeArray = baseCode.toCharArray();
		Map<Character, Integer> codes = new HashMap<Character, Integer>();
		for(int i = 0; i < baseCode.length(); i++) {
			codes.put(baseCodeArray[i], i);
		}
		char [] businessCodeArray = businessCode.toCharArray();
	 	
		
	 	int[] wi = { 1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 13, 8, 24, 10, 30, 28};
	 	int sum = 0;
	 	for (int i = 0; i < 17; i++) {
	 		Character key = businessCodeArray[i];
	 		
	 		sum += (codes.get(key) * wi[i]);
	 	}
	 	int value = 31 - sum % 31;
		//return value == codes.get(check);
	 	value = value==31?0:value;
	 	return baseCodeArray[value];
	}
	public  static TYSHXYDMObject generatorCode(int index){
		TYSHXYDMObject to = new TYSHXYDMObject();
		String code;
		code = "91330105" + ZUZHIJIGOUUtil.generatorCompanyInfo(index).getCode();
		code = code + createValid(code);
		to.setCode(code);
		to.setName("公司"+index+"");
		return to;
	}
	
	
}
