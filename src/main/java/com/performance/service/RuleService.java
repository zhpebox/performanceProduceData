package com.performance.service;

import java.io.File;

public interface RuleService {

	public int saveRule(String ruleStr);
	
	/**
	 * 根据paramObj的参数进行数据查询
	 * @param paramObj
	 * @return
	 */
	public String getRule(String param);
	
	public int afterUploadedFile(String fileName,File uploadFile);

	public int deleteRuleList(String ruleIdList);

	public int deleteRuleOne(String rid);
}
