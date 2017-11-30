package com.performance.generator.sourceclass;

import org.springframework.stereotype.Component;

@Component
public class ExampleMethodsClass {
	public static String getIdCardName(int index){
		return IDCardUtil.getOnePersonInfo(index).getName();
	}
	
	public static String getIdCardCode(int index){
		return IDCardUtil.getOnePersonInfo(index).getIdcard();
	}
	
	public static String getZUZHIJIGOUName(int index){
		return ZUZHIJIGOUUtil.generatorCompanyInfo(index).getName();
	}
	
	public static String getZUZHIJIGOUCode(int index){
		return ZUZHIJIGOUUtil.generatorCompanyInfo(index).getCode();
	}
}
