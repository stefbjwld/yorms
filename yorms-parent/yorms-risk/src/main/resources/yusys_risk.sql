/*
Navicat MySQL Data Transfer

Source Server         : docker-mysql
Source Server Version : 50547
Source Host           : 192.168.60.137:3306
Source Database       : yusys_risk

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2020-03-02 08:28:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_regulation_polic
-- ----------------------------
DROP TABLE IF EXISTS `t_regulation_polic`;
CREATE TABLE `t_regulation_polic` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `regulation_name` varchar(256) DEFAULT NULL COMMENT '制度名称',
  `regulation_no` varchar(32) DEFAULT NULL COMMENT '制度文号',
  `grp_id` int(11) DEFAULT NULL COMMENT '发布机构',
  `regulation_type` int(11) DEFAULT NULL COMMENT '制度分类',
  `status` varchar(2) DEFAULT NULL COMMENT '启用状态：0 启用，1 未启用',
  `dept_no` varchar(32) DEFAULT NULL COMMENT '部门编码',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上传日期',
  `img_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_regulation_type
-- ----------------------------
DROP TABLE IF EXISTS `t_regulation_type`;
CREATE TABLE `t_regulation_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `type_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '二级分类名称',
  `type_code` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '二级分类编码',
  `type_tree_code` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '一级分类编码',
  `type_tree_name` varchar(4) CHARACTER SET utf8 DEFAULT NULL COMMENT '一级分类名称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
