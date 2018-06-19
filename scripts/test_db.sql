drop database if exists test_db;
create database test_db;
use test_db;


-- ----------------------------
-- Table structure for `upm_user`
-- ----------------------------
DROP TABLE IF EXISTS `upm_user`;
CREATE TABLE `upm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `logini_no` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '登录账号',
  `pwd` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '登录密码',
  `user_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `address` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `mobile` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号码',
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `enable_flag` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `org_desc` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '组织机构',
  `email` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of upm_user
-- ----------------------------
INSERT INTO `upm_user` VALUES ('1', null, '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, null, '15838028035', null, null, null, null, null, null, null);
INSERT INTO `upm_user` VALUES ('2', 'user2', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, null, '15838028033', null, null, null, null, null, null, null);



SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sec_groups
-- ----------------------------
DROP TABLE IF EXISTS `sec_groups`;
CREATE TABLE `sec_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '分组名称',
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `enable_flag` datetime DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `create_by_uName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `update_by_uName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sec_groups
-- ----------------------------
INSERT INTO `sec_groups` VALUES ('1', '111', '0', '2018-06-19 17:41:35', null, null, null, '11', '111', 'test', null);
