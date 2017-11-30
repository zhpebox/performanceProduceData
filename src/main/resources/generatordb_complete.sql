/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50148
Source Host           : localhost:3306
Source Database       : generatordb_complete

Target Server Type    : MYSQL
Target Server Version : 50148
File Encoding         : 65001

Date: 2017-11-23 10:37:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_generator
-- ----------------------------
DROP TABLE IF EXISTS `t_generator`;
CREATE TABLE `t_generator` (
  `gid` int(11) NOT NULL AUTO_INCREMENT COMMENT '造数记录主键',
  `moduleId` int(11) NOT NULL COMMENT '使用模板id',
  `moduleName` varchar(255) DEFAULT '' COMMENT '模板名称',
  `startOrg` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '起始机构标识',
  `endOrg` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '终止机构标识',
  `fileNum` int(11) NOT NULL DEFAULT '3' COMMENT '每个机构产生的文件数',
  `fileSize` int(11) NOT NULL DEFAULT '3' COMMENT '每个文件的记录数量',
  `fileBasePath` varchar(255) NOT NULL DEFAULT '' COMMENT '生成文件的路径',
  `updateTime` varchar(100) DEFAULT NULL COMMENT '生成记录更新时间',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_generator
-- ----------------------------
INSERT INTO `t_generator` VALUES ('55', '47', '模板名称s', '0', '0', '3', '3', '', '2017-11-19 10:16:09');

-- ----------------------------
-- Table structure for t_module
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `file_name` varchar(100) DEFAULT '' COMMENT '报文文件名模板',
  `file_header` varchar(100) DEFAULT '' COMMENT '报文文件头模板',
  `module_name` varchar(50) NOT NULL COMMENT '模板名字',
  `module_text` text COMMENT '模板内容',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_module
-- ----------------------------
INSERT INTO `t_module` VALUES ('47', '$$2100$XXXX0ddd', 'A0502102.0.0  $$0$', '模板名称s', '<Document>\n							<EnAcctInf>\n						<AcctBsSgmt>\n							<InfRecType>a</InfRecType>\n							<AcctType>b</AcctType>\n							<AcctCode>c</AcctCode>\n							<RptDate>2016-1-1</RptDate>\n							<RptDateCode>$</RptDateCode>\n							<Name>$</Name>\n							<IDType>$</IDType>\n							<IDNum>$</IDNum>\n							<MngmtOrgCode></MngmtOrgCode>\n						</AcctBsSgmt>\n					</EnAcctInf>\n				</Document>');
INSERT INTO `t_module` VALUES ('48', 'sd$asd$sa', 'A0502102.0.0  $$0$', '模板名称', '<Document>\n							<EnAcctInf>\n						<AcctBsSgmt>\n							<InfRecType>a</InfRecType>\n							<AcctType>b</AcctType>\n							<AcctCode>c</AcctCode>\n							<RptDate>2016-1-1</RptDate>\n							<RptDateCode>$</RptDateCode>\n							<Name>$</Name>\n							<IDType>$</IDType>\n							<IDNum>$</IDNum>\n							<MngmtOrgCode></MngmtOrgCode>\n						</AcctBsSgmt>\n					</EnAcctInf>\n				</Document>');

-- ----------------------------
-- Table structure for t_module_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_module_rule`;
CREATE TABLE `t_module_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `generator_key` int(11) DEFAULT '0' COMMENT '关联的generatorId',
  `module_key` int(11) DEFAULT NULL COMMENT 'T_module表主键',
  `module_name` varchar(255) DEFAULT '' COMMENT '模板名称',
  `param_type` int(1) DEFAULT '2' COMMENT '参数的类型/位置：0=文件名；1=文件头；2=记录',
  `param_index` int(3) DEFAULT NULL,
  `rule_key` int(11) DEFAULT NULL COMMENT 'T_rule主键',
  `rule_name` varchar(255) DEFAULT '' COMMENT '规则名称',
  `start_index` int(11) DEFAULT '0' COMMENT '增量起始位置',
  `flag` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=322 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_module_rule
-- ----------------------------
INSERT INTO `t_module_rule` VALUES ('312', '55', '47', '', '0', '0', '1', '三标姓名', '0', '0');
INSERT INTO `t_module_rule` VALUES ('313', '55', '47', '', '0', '1', '2', '三标号', '0', '0');
INSERT INTO `t_module_rule` VALUES ('314', '55', '47', '', '0', '2', '4', '组织机构代码', '0', '0');
INSERT INTO `t_module_rule` VALUES ('315', '55', '47', '', '1', '0', '4', '组织机构代码', '0', '1');
INSERT INTO `t_module_rule` VALUES ('316', '55', '47', '', '1', '1', '39', 'T2', '0', '1');
INSERT INTO `t_module_rule` VALUES ('317', '55', '47', '', '1', '2', '18', '组织机构名称', '0', '1');
INSERT INTO `t_module_rule` VALUES ('318', '55', '47', '', '2', '0', '46', 'T9', '0', '2');
INSERT INTO `t_module_rule` VALUES ('319', '55', '47', '', '2', '1', '47', 'T10', '0', '2');
INSERT INTO `t_module_rule` VALUES ('320', '55', '47', '', '2', '2', '42', 'T5', '0', '2');
INSERT INTO `t_module_rule` VALUES ('321', '55', '47', '', '2', '3', '39', 'T2', '0', '2');

-- ----------------------------
-- Table structure for t_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_rule`;
CREATE TABLE `t_rule` (
  `rule_id` int(11) NOT NULL AUTO_INCREMENT,
  `rule_name` varchar(50) NOT NULL DEFAULT '' COMMENT '规则名称',
  `rule_source` int(1) NOT NULL COMMENT '参数文件来源：1参数文件；2生成程序',
  `param_file` varchar(200) DEFAULT NULL,
  `class_name` varchar(200) DEFAULT NULL,
  `method_name` varchar(50) DEFAULT NULL COMMENT '针对参数来源为“生成程序”的情况，标记调用的方法名',
  `start_index` int(11) DEFAULT '0' COMMENT '代码中传参使用字段，无意义',
  `flag` varchar(10) DEFAULT '0' COMMENT '用于判断规则生成index，是否是文件级别，便于生成在文件中所有记录都一样的变量',
  PRIMARY KEY (`rule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_rule
-- ----------------------------
INSERT INTO `t_rule` VALUES ('1', '三标姓名', '2', '', 'com.performance.generator.sourceclass.ExampleMethodsClass', 'getIdCardName', '0', '0');
INSERT INTO `t_rule` VALUES ('2', '三标号', '2', '', 'com.performance.generator.sourceclass.ExampleMethodsClass', 'getIdCardCode', '0', '0');
INSERT INTO `t_rule` VALUES ('4', '组织机构代码', '2', '', 'com.performance.generator.sourceclass.ExampleMethodsClass', 'getZUZHIJIGOUCode', '0', '0');
INSERT INTO `t_rule` VALUES ('18', '组织机构名称', '2', '', 'com.performance.generator.sourceclass.ExampleMethodsClass', 'getZUZHIJIGOUName', '0', '0');
INSERT INTO `t_rule` VALUES ('38', 'T1', '2', '', 'com.performance.generator.sourceclass.GeneratorTruleString', 'getT1String', '0', '0');
INSERT INTO `t_rule` VALUES ('39', 'T2', '2', '', 'com.performance.generator.sourceclass.GeneratorTruleString', 'getT2String', '0', '0');
INSERT INTO `t_rule` VALUES ('40', 'T3', '2', '', 'com.performance.generator.sourceclass.GeneratorTruleString', 'getT3String', '0', '0');
INSERT INTO `t_rule` VALUES ('41', 'T4', '2', '', 'com.performance.generator.sourceclass.GeneratorTruleString', 'getT4String', '0', '0');
INSERT INTO `t_rule` VALUES ('42', 'T5', '2', '', 'com.performance.generator.sourceclass.GeneratorTruleString', 'getT5String', '0', '0');
INSERT INTO `t_rule` VALUES ('43', 'T6', '2', '', 'com.performance.generator.sourceclass.GeneratorTruleString', 'getT6String', '0', '0');
INSERT INTO `t_rule` VALUES ('44', 'T7', '2', '', 'com.performance.generator.sourceclass.GeneratorTruleString', 'getT7String', '0', '0');
INSERT INTO `t_rule` VALUES ('45', 'T8', '2', '', 'com.performance.generator.sourceclass.GeneratorTruleString', 'getT8String', '0', '0');
INSERT INTO `t_rule` VALUES ('46', 'T9', '2', '', 'com.performance.generator.sourceclass.GeneratorTruleString', 'getT9String', '0', '0');
INSERT INTO `t_rule` VALUES ('47', 'T10', '2', '', 'com.performance.generator.sourceclass.GeneratorTruleString', 'getT10String', '0', '0');
INSERT INTO `t_rule` VALUES ('48', 'T11', '2', '', 'com.performance.generator.sourceclass.GeneratorTruleString', 'getT11String', '0', '0');
