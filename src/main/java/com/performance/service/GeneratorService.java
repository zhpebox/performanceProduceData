package com.performance.service;


public interface GeneratorService {

	public String getAllGenerator(String param);

	public String getOneGeneratorData(String gid);

	public int addGenerator(String generator);

	public int setGenerator(String generator);

	/**
	 * 开始造数，生成文件
	 * @param generator
	 * @return
	 */
	public int startGenerator(String generator);

	public int deleteGenerator(String gidArray);

	public int deleteGeneratorOne(String gid);
	
	/**
	 * 按照moduleId查询模板是否在generator表中
	 * @param mid
	 * @return int 存在的个数
	 */
	public int selectNumExistData(int mid);
}
