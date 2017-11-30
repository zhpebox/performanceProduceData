package com.performance.service;


public interface ModuleService {
	
	/**
	 * 向数据库插入模板
	 * @param moduleStr
	 * @return 主键
	 */
	public int saveMudule(String moduleStr);

	/**
	 * 根据主键id返回，模板内容的json
	 * @param moduleId
	 * @return
	 */
	public String getModuleById(String moduleId);

	public String getModuleList(String paramStr);

	public int deleteModule(String midList);

	public int deleteModuleOne(String mid);
	
}
