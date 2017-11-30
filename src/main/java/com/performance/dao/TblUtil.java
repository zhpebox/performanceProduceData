package com.performance.dao;

import java.util.List;
import java.util.Map;

public interface TblUtil {

	public int createTable(String tableNmae);
	
	public int insertData(Map<String,String> paramMap);
	
	public String selectData(Map<String,String> paramMap);
	
	public List<String> selectAllData(String tableName);
	
}
