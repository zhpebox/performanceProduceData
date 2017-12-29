package com.performance.generator.sourceclass;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.performance.commonclass.CommonVariable;

public class D1_Methods {
	
	/*fileName*/
	public static String getOrgCode(int index){
		return String.valueOf(CommonVariable.ORGCODE_START_INDEX+index);
	}
	
	public static String getDateStr(int index){
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		return sf.format(new Date());
	}
	
	public static String getFileId(int index){
		String indexStr = index % 1000 + 1000 + "";
		return indexStr.substring(1);
	}
	
	/*fileHeader*/
	public static String getDateTimeStr(int index){
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sf.format(new Date());
	}
	
	/*data*/
	public static String getAcctCode(int index){
		return "XXXXXXXXX"+"D1"+index;
	}
	
	public static String getFileSize(int index,int fileSize){
		return (fileSize + 10000000 + "").substring(1);
	}
}
