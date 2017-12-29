package com.performance.commonclass;

public interface CommonVariable {
	
	/**
	 * 参数 生成来源 = 文件
	 */
	public static final int RULE_SOURCE_FILE=1;
	/**
	 * 参数 文件来源 = 程序
	 */
	public static final int RULE_SOURCE_CODE=2;
	/**
	 * 项目所在的根目录
	 */
	public static final String POJECT_PATH = System.getProperty("user.dir").replace("\\", "/").replace("\\\\", "/");
	/**
	 * 文件上传的默认路径
	 */
	public static final String UPLOAD_PATH = POJECT_PATH+"/upload/";
	/**
	 * 机构名称前缀
	 */
	public static final String ORGNAMESTR = "ABCorg";
	/**
	 * 机构代码起始位置
	 */
	public static final long ORGCODE_START_INDEX = 88000000000000L;
	
	/**
	 * 上传文件前缀
	 */
	public static final String UPDLOADFILEHEADER = "upload_";
	
	public static final String RULE_CLASS_PACKAGE="com.performance.generator.sourceclass";
	
	/**
	 * module_rule关联表：参数的数据类型
	 * 文件名的类型
	 */
	public static final int PARAM_TYPE_FILENAME = 0;
	
	/**
	 * module_rule关联表：参数的数据类型
	 * 文件头的类型
	 */
	public static final int PARAM_TYPE_FILEHEADER = 1;
	
	/**
	 * module_rule关联表：参数的数据类型
	 * 模板的类型
	 */
	public static final int PARAM_TYPE_MODULE = 2;
}
