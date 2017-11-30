package com.performance.generator.sourceclass;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.performance.commonclass.CommonVariable;

public class R2_Methods2 {
	
	/*fileName*/
	public static String getOrgCode(int index){
		return String.valueOf(CommonVariable.orgcode_start_index+index);
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
	
	public static String getNextPersonName(int index){
		return IDCardUtil.getOnePersonInfo(index+1).getName();
	}
	public static String getNextPersonIdCard(int index){
		return IDCardUtil.getOnePersonInfo(index+1).getIdcard();
	}
	
	public static String getMcc(int index){
		return "cont"+index;
	}
	
	/*data*/
	public static String getR2AcctCode(int index){
		return "R2"+index;
	}
	
	public static String getFileSize(int index,int fileSize){
		return (fileSize + 10000000 + "").substring(1);
	}
}
