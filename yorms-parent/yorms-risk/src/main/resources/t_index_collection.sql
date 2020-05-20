-- 创建风险分类表
DROP TABLE IF EXISTS `t_risk_classification`;
CREATE TABLE `t_risk_classification` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '主键ID',
  `parent_id` int(11) DEFAULT '0' COMMENT '父节点分类',
  `name` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '分类名称',
  `status` varchar(2) CHARACTER SET utf8mb4 DEFAULT '0' COMMENT '分类状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 插入测试数据
INSERT INTO `t_risk_classification` VALUES ('1001', '0', '信息分级与保护风险', '0');
INSERT INTO `t_risk_classification` VALUES ('1002', '1001', '安全制度管理', '0');
INSERT INTO `t_risk_classification` VALUES ('1003', '1002', '风险例会', '0');
INSERT INTO `t_risk_classification` VALUES ('1004', '0', '信息系统风险', '0');
INSERT INTO `t_risk_classification` VALUES ('1005', '0', '信息科技运行和维护', '0');
INSERT INTO `t_risk_classification` VALUES ('1006', '0', '访问控制', '0');
INSERT INTO `t_risk_classification` VALUES ('1007', '1006', '操作系统访问风险', '0');
INSERT INTO `t_risk_classification` VALUES ('1008', '1007', 'Windows操作系统访问', '0');
INSERT INTO `t_risk_classification` VALUES ('1009', '0', '物理安全', '0');
INSERT INTO `t_risk_classification` VALUES ('1010', '1009', '自然灾害', '0');
INSERT INTO `t_risk_classification` VALUES ('1011', '1010', '洪水', '0');
INSERT INTO `t_risk_classification` VALUES ('1012', '0', '人员安全', '0');
INSERT INTO `t_risk_classification` VALUES ('1013', '0', '业务连续性计划与应急处置', '0');

/**这张表手工维护  展示一级，二级，三级树状*/
select a.`name` as 一级分类,a.id as 一级分类ID,b.`name` as 二级分类,b.id as 二级分类ID,c.`name` as 三级分类,c.id as 三级分类ID  from t_risk_classification a left join t_risk_classification b on a.id = b.parent_id
left join t_risk_classification c on b.id = c.parent_id
where a.parent_id = 0

-- 查询所有的一级分类
select a.* from t_risk_classification a where a.parent_id = 0;

-- 查询所有的一级分类
select a.* from t_risk_classification a left join t_risk_classification b on a.id = b.parent_id
where a.parent_id = 0

-- 查询所有的二级分类
select b.* from t_risk_classification a left join t_risk_classification b on a.id = b.parent_id
where a.parent_id = 0 and b.id != 0

-- 查询所有的三级分类
select b.* from t_risk_classification a left join t_risk_classification b on a.id = b.parent_id
where a.parent_id !=0 and b.id !=0


-- 根据二级分类查询三级分类
select b.* from t_risk_classification a left join t_risk_classification b on a.id = b.parent_id
where b.id is not null
and a.parent_id != 0
and b.parent_id != 0