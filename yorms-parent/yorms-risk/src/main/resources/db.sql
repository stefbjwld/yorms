--政策制度表
CREATE TABLE `t_regulation_polic` (
  `id` int(11) NOT NULL COMMENT '主键',
  `regulation_name` varchar(32) DEFAULT NULL COMMENT '制度名称',
  `regulation_no` varchar(32) DEFAULT NULL COMMENT '制度文号',
  `grp_id` int(11) DEFAULT NULL COMMENT '发布机构',
  `regulation_type` varchar(2) DEFAULT NULL COMMENT '制度分类',
  `status` varchar(2) DEFAULT NULL COMMENT '启用状态：0 启用，1 未启用',
  `dept_no` varchar(32) DEFAULT NULL COMMENT '部门编码',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上传日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--政策制度分类表
CREATE TABLE `t_regulation_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `type_name` int(11) DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

