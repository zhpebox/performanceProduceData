/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : generatordb

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2017-12-04 10:35:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orgcodelist156
-- ----------------------------
DROP TABLE IF EXISTS `orgcodelist156`;
CREATE TABLE `orgcodelist156` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pindex` int(10) DEFAULT NULL,
  `pvalue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orgcodelist156
-- ----------------------------
INSERT INTO `orgcodelist156` VALUES ('1', '0', '北京市');
INSERT INTO `orgcodelist156` VALUES ('2', '1', '天津市');
INSERT INTO `orgcodelist156` VALUES ('3', '2', '上海市');
INSERT INTO `orgcodelist156` VALUES ('4', '3', '重庆市');
INSERT INTO `orgcodelist156` VALUES ('5', '4', '河北省');
INSERT INTO `orgcodelist156` VALUES ('6', '5', '山西省');
INSERT INTO `orgcodelist156` VALUES ('7', '6', '辽宁省');
INSERT INTO `orgcodelist156` VALUES ('8', '7', '吉林省');
INSERT INTO `orgcodelist156` VALUES ('9', '8', '黑龙江省');
INSERT INTO `orgcodelist156` VALUES ('10', '9', '江苏省');
INSERT INTO `orgcodelist156` VALUES ('11', '10', '浙江省');
INSERT INTO `orgcodelist156` VALUES ('12', '11', '安徽省');
INSERT INTO `orgcodelist156` VALUES ('13', '12', '福建省');
INSERT INTO `orgcodelist156` VALUES ('14', '13', '江西省');
INSERT INTO `orgcodelist156` VALUES ('15', '14', '山东省');
INSERT INTO `orgcodelist156` VALUES ('16', '15', '河南省');
INSERT INTO `orgcodelist156` VALUES ('17', '16', '湖北省');
INSERT INTO `orgcodelist156` VALUES ('18', '17', '湖南省');
INSERT INTO `orgcodelist156` VALUES ('19', '18', '广东省');
INSERT INTO `orgcodelist156` VALUES ('20', '19', '海南省');
INSERT INTO `orgcodelist156` VALUES ('21', '20', '四川省');
INSERT INTO `orgcodelist156` VALUES ('22', '21', '贵州省');
INSERT INTO `orgcodelist156` VALUES ('23', '22', '云南省');
INSERT INTO `orgcodelist156` VALUES ('24', '23', '陕西省');
INSERT INTO `orgcodelist156` VALUES ('25', '24', '甘肃省');
INSERT INTO `orgcodelist156` VALUES ('26', '25', '青海省');
INSERT INTO `orgcodelist156` VALUES ('27', '26', '台湾省');
INSERT INTO `orgcodelist156` VALUES ('28', '27', '内蒙古自治区');
INSERT INTO `orgcodelist156` VALUES ('29', '28', '广西壮族自治区');
INSERT INTO `orgcodelist156` VALUES ('30', '29', '西藏自治区');
INSERT INTO `orgcodelist156` VALUES ('31', '30', '宁夏回族自治区');
INSERT INTO `orgcodelist156` VALUES ('32', '31', '新疆维吾尔自治区');
INSERT INTO `orgcodelist156` VALUES ('33', '32', '香港特别行政区');
INSERT INTO `orgcodelist156` VALUES ('34', '33', '澳门特别行政区');

-- ----------------------------
-- Table structure for orgcodelist937
-- ----------------------------
DROP TABLE IF EXISTS `orgcodelist937`;
CREATE TABLE `orgcodelist937` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pindex` int(10) DEFAULT NULL,
  `pvalue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orgcodelist937
-- ----------------------------
INSERT INTO `orgcodelist937` VALUES ('1', '0', '北京市');
INSERT INTO `orgcodelist937` VALUES ('2', '1', '天津市');
INSERT INTO `orgcodelist937` VALUES ('3', '2', '上海市');
INSERT INTO `orgcodelist937` VALUES ('4', '3', '重庆市');
INSERT INTO `orgcodelist937` VALUES ('5', '4', '河北省');
INSERT INTO `orgcodelist937` VALUES ('6', '5', '山西省');
INSERT INTO `orgcodelist937` VALUES ('7', '6', '辽宁省');
INSERT INTO `orgcodelist937` VALUES ('8', '7', '吉林省');
INSERT INTO `orgcodelist937` VALUES ('9', '8', '黑龙江省');
INSERT INTO `orgcodelist937` VALUES ('10', '9', '江苏省');
INSERT INTO `orgcodelist937` VALUES ('11', '10', '浙江省');
INSERT INTO `orgcodelist937` VALUES ('12', '11', '安徽省');
INSERT INTO `orgcodelist937` VALUES ('13', '12', '福建省');
INSERT INTO `orgcodelist937` VALUES ('14', '13', '江西省');
INSERT INTO `orgcodelist937` VALUES ('15', '14', '山东省');
INSERT INTO `orgcodelist937` VALUES ('16', '15', '河南省');
INSERT INTO `orgcodelist937` VALUES ('17', '16', '湖北省');
INSERT INTO `orgcodelist937` VALUES ('18', '17', '湖南省');
INSERT INTO `orgcodelist937` VALUES ('19', '18', '广东省');
INSERT INTO `orgcodelist937` VALUES ('20', '19', '海南省');
INSERT INTO `orgcodelist937` VALUES ('21', '20', '四川省');
INSERT INTO `orgcodelist937` VALUES ('22', '21', '贵州省');
INSERT INTO `orgcodelist937` VALUES ('23', '22', '云南省');
INSERT INTO `orgcodelist937` VALUES ('24', '23', '陕西省');
INSERT INTO `orgcodelist937` VALUES ('25', '24', '甘肃省');
INSERT INTO `orgcodelist937` VALUES ('26', '25', '青海省');
INSERT INTO `orgcodelist937` VALUES ('27', '26', '台湾省');
INSERT INTO `orgcodelist937` VALUES ('28', '27', '内蒙古自治区');
INSERT INTO `orgcodelist937` VALUES ('29', '28', '广西壮族自治区');
INSERT INTO `orgcodelist937` VALUES ('30', '29', '西藏自治区');
INSERT INTO `orgcodelist937` VALUES ('31', '30', '宁夏回族自治区');
INSERT INTO `orgcodelist937` VALUES ('32', '31', '新疆维吾尔自治区');
INSERT INTO `orgcodelist937` VALUES ('33', '32', '香港特别行政区');
INSERT INTO `orgcodelist937` VALUES ('34', '33', '澳门特别行政区');

-- ----------------------------
-- Table structure for orgcodelistdata266
-- ----------------------------
DROP TABLE IF EXISTS `orgcodelistdata266`;
CREATE TABLE `orgcodelistdata266` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pindex` int(10) DEFAULT NULL,
  `pvalue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orgcodelistdata266
-- ----------------------------
INSERT INTO `orgcodelistdata266` VALUES ('1', '0', '北京市');
INSERT INTO `orgcodelistdata266` VALUES ('2', '1', '天津市');
INSERT INTO `orgcodelistdata266` VALUES ('3', '2', '上海市');
INSERT INTO `orgcodelistdata266` VALUES ('4', '3', '重庆市');
INSERT INTO `orgcodelistdata266` VALUES ('5', '4', '河北省');
INSERT INTO `orgcodelistdata266` VALUES ('6', '5', '山西省');
INSERT INTO `orgcodelistdata266` VALUES ('7', '6', '辽宁省');
INSERT INTO `orgcodelistdata266` VALUES ('8', '7', '吉林省');
INSERT INTO `orgcodelistdata266` VALUES ('9', '8', '黑龙江省');
INSERT INTO `orgcodelistdata266` VALUES ('10', '9', '江苏省');
INSERT INTO `orgcodelistdata266` VALUES ('11', '10', '浙江省');
INSERT INTO `orgcodelistdata266` VALUES ('12', '11', '安徽省');
INSERT INTO `orgcodelistdata266` VALUES ('13', '12', '福建省');
INSERT INTO `orgcodelistdata266` VALUES ('14', '13', '江西省');
INSERT INTO `orgcodelistdata266` VALUES ('15', '14', '山东省');
INSERT INTO `orgcodelistdata266` VALUES ('16', '15', '河南省');
INSERT INTO `orgcodelistdata266` VALUES ('17', '16', '湖北省');
INSERT INTO `orgcodelistdata266` VALUES ('18', '17', '湖南省');
INSERT INTO `orgcodelistdata266` VALUES ('19', '18', '广东省');
INSERT INTO `orgcodelistdata266` VALUES ('20', '19', '海南省');
INSERT INTO `orgcodelistdata266` VALUES ('21', '20', '四川省');
INSERT INTO `orgcodelistdata266` VALUES ('22', '21', '贵州省');
INSERT INTO `orgcodelistdata266` VALUES ('23', '22', '云南省');
INSERT INTO `orgcodelistdata266` VALUES ('24', '23', '陕西省');
INSERT INTO `orgcodelistdata266` VALUES ('25', '24', '甘肃省');
INSERT INTO `orgcodelistdata266` VALUES ('26', '25', '青海省');
INSERT INTO `orgcodelistdata266` VALUES ('27', '26', '台湾省');
INSERT INTO `orgcodelistdata266` VALUES ('28', '27', '内蒙古自治区');
INSERT INTO `orgcodelistdata266` VALUES ('29', '28', '广西壮族自治区');
INSERT INTO `orgcodelistdata266` VALUES ('30', '29', '西藏自治区');
INSERT INTO `orgcodelistdata266` VALUES ('31', '30', '宁夏回族自治区');
INSERT INTO `orgcodelistdata266` VALUES ('32', '31', '新疆维吾尔自治区');
INSERT INTO `orgcodelistdata266` VALUES ('33', '32', '香港特别行政区');
INSERT INTO `orgcodelistdata266` VALUES ('34', '33', '澳门特别行政区');

-- ----------------------------
-- Table structure for orgcodelist_data611
-- ----------------------------
DROP TABLE IF EXISTS `orgcodelist_data611`;
CREATE TABLE `orgcodelist_data611` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pindex` int(10) DEFAULT NULL,
  `pvalue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orgcodelist_data611
-- ----------------------------
INSERT INTO `orgcodelist_data611` VALUES ('1', '0', '北京市');
INSERT INTO `orgcodelist_data611` VALUES ('2', '1', '天津市');
INSERT INTO `orgcodelist_data611` VALUES ('3', '2', '上海市');
INSERT INTO `orgcodelist_data611` VALUES ('4', '3', '重庆市');
INSERT INTO `orgcodelist_data611` VALUES ('5', '4', '河北省');
INSERT INTO `orgcodelist_data611` VALUES ('6', '5', '山西省');
INSERT INTO `orgcodelist_data611` VALUES ('7', '6', '辽宁省');
INSERT INTO `orgcodelist_data611` VALUES ('8', '7', '吉林省');
INSERT INTO `orgcodelist_data611` VALUES ('9', '8', '黑龙江省');
INSERT INTO `orgcodelist_data611` VALUES ('10', '9', '江苏省');
INSERT INTO `orgcodelist_data611` VALUES ('11', '10', '浙江省');
INSERT INTO `orgcodelist_data611` VALUES ('12', '11', '安徽省');
INSERT INTO `orgcodelist_data611` VALUES ('13', '12', '福建省');
INSERT INTO `orgcodelist_data611` VALUES ('14', '13', '江西省');
INSERT INTO `orgcodelist_data611` VALUES ('15', '14', '山东省');
INSERT INTO `orgcodelist_data611` VALUES ('16', '15', '河南省');
INSERT INTO `orgcodelist_data611` VALUES ('17', '16', '湖北省');
INSERT INTO `orgcodelist_data611` VALUES ('18', '17', '湖南省');
INSERT INTO `orgcodelist_data611` VALUES ('19', '18', '广东省');
INSERT INTO `orgcodelist_data611` VALUES ('20', '19', '海南省');
INSERT INTO `orgcodelist_data611` VALUES ('21', '20', '四川省');
INSERT INTO `orgcodelist_data611` VALUES ('22', '21', '贵州省');
INSERT INTO `orgcodelist_data611` VALUES ('23', '22', '云南省');
INSERT INTO `orgcodelist_data611` VALUES ('24', '23', '陕西省');
INSERT INTO `orgcodelist_data611` VALUES ('25', '24', '甘肃省');
INSERT INTO `orgcodelist_data611` VALUES ('26', '25', '青海省');
INSERT INTO `orgcodelist_data611` VALUES ('27', '26', '台湾省');
INSERT INTO `orgcodelist_data611` VALUES ('28', '27', '内蒙古自治区');
INSERT INTO `orgcodelist_data611` VALUES ('29', '28', '广西壮族自治区');
INSERT INTO `orgcodelist_data611` VALUES ('30', '29', '西藏自治区');
INSERT INTO `orgcodelist_data611` VALUES ('31', '30', '宁夏回族自治区');
INSERT INTO `orgcodelist_data611` VALUES ('32', '31', '新疆维吾尔自治区');
INSERT INTO `orgcodelist_data611` VALUES ('33', '32', '香港特别行政区');
INSERT INTO `orgcodelist_data611` VALUES ('34', '33', '澳门特别行政区');

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
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_generator
-- ----------------------------
INSERT INTO `t_generator` VALUES ('55', '47', '模板名称s', '0', '0', '3', '3', '', '2017-11-19 10:16:09');
INSERT INTO `t_generator` VALUES ('56', '49', '模板名称', '0', '0', '1', '10', 'E:/55/', '2017-11-29 17:58:45');
INSERT INTO `t_generator` VALUES ('57', '49', '模板名称', '0', '1', '3', '3', 'E:/55', '2017-11-30 13:47:42');
INSERT INTO `t_generator` VALUES ('58', '49', '模板名称', '0', '0', '3', '3', 'E:/55', '2017-11-30 16:09:01');

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
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_module
-- ----------------------------
INSERT INTO `t_module` VALUES ('47', '$$2100$XXXX0ddd', 'A0502102.0.0  $$0$', '模板名称s', '<Document>\n							<EnAcctInf>\n						<AcctBsSgmt>\n							<InfRecType>a</InfRecType>\n							<AcctType>b</AcctType>\n							<AcctCode>c</AcctCode>\n							<RptDate>2016-1-1</RptDate>\n							<RptDateCode>$</RptDateCode>\n							<Name>$</Name>\n							<IDType>$</IDType>\n							<IDNum>$</IDNum>\n							<MngmtOrgCode></MngmtOrgCode>\n						</AcctBsSgmt>\n					</EnAcctInf>\n				</Document>');
INSERT INTO `t_module` VALUES ('48', 'sd$asd$saWQ', 'A0502102.0.0  $$0$WQ', '模板名称WQ', '<Document>\n							<EnAcctInf>\n						<AcctBsSgmt>\n							<InfRecType>a</InfRecType>\n							<AcctType>b</AcctType>\n							<AcctCode>c</AcctCode>\n							<RptDate>2016-1-1</RptDate>\n							<RptDateCode>$</RptDateCode>\n							<Name>$</Name>\n							<IDType>$</IDType>\n							<IDNum>$</IDNum>\n							<MngmtOrgCode></MngmtOrgCode>\n						</AcctBsSgmt>\n					</EnAcctInf>\n				</Document>');
INSERT INTO `t_module` VALUES ('49', 'XXXXEE', 'AAAAAEE', '模板名称EE', '<DocumentEE>\n							<EnAcctInf>\n						<AcctBsSgmt>\n							<InfRecType>a</InfRecType>\n							<AcctType>b</AcctType>\n							<AcctCode>c</AcctCode>\n							<RptDate>2016-1-1</RptDate>\n							<RptDateCode>$</RptDateCode>\n							<Name>$</Name>\n							<IDType>$</IDType>\n							<IDNum>$</IDNum>\n							<MngmtOrgCode></MngmtOrgCode>\n						</AcctBsSgmt>\n					</EnAcctInf>\n				</Document>');

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
) ENGINE=InnoDB AUTO_INCREMENT=334 DEFAULT CHARSET=utf8;

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
INSERT INTO `t_module_rule` VALUES ('322', '56', '49', '', '2', '0', '1', '三标姓名', '0', '2');
INSERT INTO `t_module_rule` VALUES ('323', '56', '49', '', '2', '1', '65', 'TF', '0', '2');
INSERT INTO `t_module_rule` VALUES ('324', '56', '49', '', '2', '2', '65', 'TF', '0', '2');
INSERT INTO `t_module_rule` VALUES ('325', '56', '49', '', '2', '3', '65', 'TF', '0', '2');
INSERT INTO `t_module_rule` VALUES ('326', '57', '49', '', '2', '0', '66', 'T', '0', '2');
INSERT INTO `t_module_rule` VALUES ('327', '57', '49', '', '2', '1', '1', '三标姓名', '0', '2');
INSERT INTO `t_module_rule` VALUES ('328', '57', '49', '', '2', '2', '2', '三标号', '0', '2');
INSERT INTO `t_module_rule` VALUES ('329', '57', '49', '', '2', '3', '4', '组织机构代码', '0', '2');
INSERT INTO `t_module_rule` VALUES ('330', '58', '49', '', '2', '0', '67', 'TMS', '0', '2');
INSERT INTO `t_module_rule` VALUES ('331', '58', '49', '', '2', '1', '1', '三标姓名', '0', '2');
INSERT INTO `t_module_rule` VALUES ('332', '58', '49', '', '2', '2', '2', '三标号', '0', '2');
INSERT INTO `t_module_rule` VALUES ('333', '58', '49', '', '2', '3', '4', '组织机构代码', '0', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

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
INSERT INTO `t_rule` VALUES ('65', 'TF', '1', 'orgCodeList.data215', '', '', '0', '0');
INSERT INTO `t_rule` VALUES ('66', 'T', '1', 'orgCodeList.data611', '', '', '0', '0');
INSERT INTO `t_rule` VALUES ('67', 'TMS', '1', 'orgCodeListdata266', '', '', '0', '0');
INSERT INTO `t_rule` VALUES ('68', 'TWW', '1', 'orgCodeList156', '', '', '0', '0');
INSERT INTO `t_rule` VALUES ('69', 'TEE', '1', 'orgCodeList937', '', '', '0', '0');
