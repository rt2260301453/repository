/*
Navicat MySQL Data Transfer

Source Server         : fuwuqi20190112
Source Server Version : 50717
Source Host           : 192.168.0.222:3306
Source Database       : wetech_admin

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-01-16 15:04:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `associatedaddress`
-- ----------------------------
DROP TABLE IF EXISTS `associatedaddress`;
CREATE TABLE `associatedaddress` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fixedareano` varchar(20) NOT NULL COMMENT '定区编号',
  `cityname` varchar(20) NOT NULL COMMENT '城市名',
  `customerno` varchar(50) NOT NULL COMMENT '客户编号',
  `partitionno` varchar(20) NOT NULL COMMENT '分区编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of associatedaddress
-- ----------------------------
INSERT INTO `associatedaddress` VALUES ('3', 'fa1001', '南京市', '234', 'FQ001');
INSERT INTO `associatedaddress` VALUES ('4', 'fa1001', '南京市', '123', 'FQ001');

-- ----------------------------
-- Table structure for `associatedwidgets`
-- ----------------------------
DROP TABLE IF EXISTS `associatedwidgets`;
CREATE TABLE `associatedwidgets` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fixedareano` varchar(20) NOT NULL COMMENT '定区编号',
  `fetchpeopleno` varchar(20) NOT NULL COMMENT '取派人工号',
  `fetchpeoplename` varchar(20) NOT NULL COMMENT '取派人姓名',
  `collectionstandard` varchar(20) NOT NULL COMMENT '收派标准',
  `collectiontime` varchar(20) NOT NULL COMMENT '收派时间',
  `institute` varchar(20) NOT NULL COMMENT '所属单位',
  `type` varchar(20) NOT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of associatedwidgets
-- ----------------------------
INSERT INTO `associatedwidgets` VALUES ('3', 'fa1002', 's00004', 'TOM', '0-30公斤', '时间1', '总部', '司机');
INSERT INTO `associatedwidgets` VALUES ('4', 'fa1002', 's00003', '小米', '0-30公斤', '第三方士大夫', '总部', '小件员');

-- ----------------------------
-- Table structure for `basic`
-- ----------------------------
DROP TABLE IF EXISTS `basic`;
CREATE TABLE `basic` (
  `basicno` varchar(255) NOT NULL COMMENT '基本档案编号',
  `basicname` varchar(255) NOT NULL COMMENT '基本档案名称',
  `classifying` int(1) NOT NULL COMMENT '档案是否分级1为是0为否',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `operator` varchar(255) NOT NULL COMMENT '操作人员',
  `operationunit` varchar(255) NOT NULL COMMENT '操作单位',
  `operationdate` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`basicno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of basic
-- ----------------------------
INSERT INTO `basic` VALUES ('d00001', '路线类型', '1', '大苏打睡交界', '张三', '路线单位', '2018-12-12 00:00:00');
INSERT INTO `basic` VALUES ('d00002', '取派员类型', '0', '客户即可', '李四', '取派件单位', '2018-12-12 00:00:00');
INSERT INTO `basic` VALUES ('d00004', '哈哈哈', '1', '萨达', 'admin', '撒大大', '2019-01-14 00:00:00');
INSERT INTO `basic` VALUES ('d12345', '哈哈哈哈', '1', '大幅度浮点数第三个', 'admin', '大萨达撒', '2019-01-14 00:00:00');
INSERT INTO `basic` VALUES ('d12349', '大苏打', '0', '撒打', 'admin', '撒旦撒', '2019-01-14 14:21:34');

-- ----------------------------
-- Table structure for `bus`
-- ----------------------------
DROP TABLE IF EXISTS `bus`;
CREATE TABLE `bus` (
  `busid` int(100) NOT NULL AUTO_INCREMENT,
  `routeid` int(100) DEFAULT NULL,
  `license` varchar(200) DEFAULT '',
  `operators` varchar(200) DEFAULT NULL,
  `model` varchar(200) DEFAULT NULL,
  `driver` varchar(200) DEFAULT NULL,
  `phone` bigint(200) DEFAULT NULL,
  `weight` int(20) DEFAULT NULL,
  `operater` varchar(200) DEFAULT NULL,
  `company` varchar(200) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  UNIQUE KEY `id` (`busid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus
-- ----------------------------
INSERT INTO `bus` VALUES ('23', '41', '苏A1B201', '么么哒', '坦克', '熊大', '18260051111', '22', 'admin', '鍟﹀暒鍟﹀叕鍙�', '2019-01-15 14:22:13');
INSERT INTO `bus` VALUES ('30', '48', '苏A1B202', '', '', '', null, null, 'admin', '鎾掔殑鎾�', '2019-01-14 17:16:18');
INSERT INTO `bus` VALUES ('31', '49', '苏A1B202', '', '', '', null, null, 'admin', '鎾掔殑鎾�', '2019-01-14 17:22:13');
INSERT INTO `bus` VALUES ('32', '50', '苏A1B202', '', '', '', null, null, 'admin', '鎾掔殑鎾�', '2019-01-14 17:23:05');
INSERT INTO `bus` VALUES ('33', '51', '苏A1B204', '大大大', '呵呵', '熊大', '18260051111', '22', 'admin', '鍟﹀暒鍟﹀叕鍙�', '2019-01-15 14:23:45');
INSERT INTO `bus` VALUES ('34', '52', '苏A1B202', '大大大', '热热热', '熊大', '18260051111', '34', 'admin', '啦啦啦公司', '2019-01-16 14:30:20');
INSERT INTO `bus` VALUES ('35', '53', '苏A1B203', '得到', '大大大', '熊二', '13866666666', '22', 'admin', '啦啦啦公司', '2019-01-16 12:16:28');

-- ----------------------------
-- Table structure for `busroute`
-- ----------------------------
DROP TABLE IF EXISTS `busroute`;
CREATE TABLE `busroute` (
  `busid` int(100) NOT NULL AUTO_INCREMENT,
  `license` varchar(200) DEFAULT '',
  `operators` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `model` varchar(200) DEFAULT NULL,
  `driver` varchar(200) DEFAULT NULL,
  `phone` bigint(200) DEFAULT NULL,
  `weight` int(20) DEFAULT NULL,
  `style` varchar(200) DEFAULT NULL,
  `namefrom` varchar(200) DEFAULT NULL,
  `nameto` varchar(200) DEFAULT NULL,
  `operator` varchar(200) DEFAULT NULL,
  `company` varchar(200) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`busid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of busroute
-- ----------------------------
INSERT INTO `busroute` VALUES ('1', 'qqq', 'wwww', 'eeer', 'rtrttt', '22233', '444', 'yf', '上海', '上海', 'ffdwewe', 'eweff', '2019-01-14', 'dsadads');
INSERT INTO `busroute` VALUES ('2', 'ffdefe', 'kiukyukju', 'jytru', 'ytuyiu', '222', '555', 'fdf', '天津', '北京', 'wdsa', 'sda', '2019-01-26', 'sdasdsa');
INSERT INTO `busroute` VALUES ('3', 'sadsad', 'eqe', 'kujyuj', 'utrytr', '2222', '6666', 'dfdsf', '南京', '四川', 'weewq', 'ewqe', '2019-01-21', 'dasdasd');
INSERT INTO `busroute` VALUES ('4', 'ou9iouo', 'ssdsad', 'wewe', 'lk;klj', '18260059395', '2121', '全部', '山东', '重庆', 'qsws', 'xsaxsax', '2019-01-14', 'zczxc');
INSERT INTO `busroute` VALUES ('7', 'eeee', 'tttt', 'yyy', 'rrrr', '18260059395', '523424', '临时', '山东', '西安', 'uuuu', '22', '2019-01-13', 'uuuuu');
INSERT INTO `busroute` VALUES ('15', '苏A1B206', 'jjj', '啦啦啦', '啦啦啦', '18260059395', '23', '全部', '上海', '四川', 'admin', '啦啦啦公司', '2019-01-09', '啦啦啦啦');
INSERT INTO `busroute` VALUES ('18', '苏A1B204', '大神', '发发发', '洒洒水', '18260059395', '1000', '周边', '搜索', '大萨达', 'admin', '啦啦啦公司', '2019-01-10', '123456');
INSERT INTO `busroute` VALUES ('19', '苏A1B205', '大大大', '啦啦啦', '啦啦啦', '18260059395', '5', '全部', '大萨达', 'sss', 'admin', '鍟﹀暒鍟﹀叕鍙�', '2019-01-12', '啦啦啦');

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `customerno` varchar(20) NOT NULL COMMENT '客户编号',
  `customername` varchar(20) NOT NULL COMMENT '客户姓名',
  `pwd` varchar(20) NOT NULL COMMENT '客户密码',
  `customeraddress` varchar(100) NOT NULL COMMENT '客户地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '123', '老祝', 'wqe123', '江苏省南京市栖霞区');
INSERT INTO `customer` VALUES ('2', '234', '老朱', 'asd123', '江苏省南京市玄武区');

-- ----------------------------
-- Table structure for `fixedarea`
-- ----------------------------
DROP TABLE IF EXISTS `fixedarea`;
CREATE TABLE `fixedarea` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fixedareano` varchar(10) NOT NULL COMMENT '定区编码',
  `fixedareaname` varchar(20) NOT NULL COMMENT '定区名称',
  `fixedareamanager` varchar(20) DEFAULT NULL COMMENT '定区负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `institute` varchar(100) NOT NULL COMMENT '所属单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fixedarea
-- ----------------------------
INSERT INTO `fixedarea` VALUES ('2', 'fa1001', 'qweqwer', '老家', '13245678909', '总部');
INSERT INTO `fixedarea` VALUES ('3', 'fa1002', '老韩', '菲', '', '总部');

-- ----------------------------
-- Table structure for `namefromto`
-- ----------------------------
DROP TABLE IF EXISTS `namefromto`;
CREATE TABLE `namefromto` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `namefrom` varchar(200) DEFAULT NULL,
  `nameto` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of namefromto
-- ----------------------------
INSERT INTO `namefromto` VALUES ('1', '天津', '上海');
INSERT INTO `namefromto` VALUES ('2', '上海', '北京');
INSERT INTO `namefromto` VALUES ('3', '南京', '四川');
INSERT INTO `namefromto` VALUES ('4', '山东', '重庆');
INSERT INTO `namefromto` VALUES ('6', '大市口', '江大');
INSERT INTO `namefromto` VALUES ('7', '无锡', '天津');
INSERT INTO `namefromto` VALUES ('8', '苏州', '玄武区');

-- ----------------------------
-- Table structure for `replay`
-- ----------------------------
DROP TABLE IF EXISTS `replay`;
CREATE TABLE `replay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `replayid` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT '0000-00-00 00:00:00',
  `station` varchar(255) NOT NULL,
  `deltag` varchar(255) NOT NULL,
  `upusername` varchar(255) DEFAULT NULL,
  `uptime` datetime DEFAULT NULL,
  `replayofid` varchar(255) DEFAULT NULL,
  `nameof` varchar(255) DEFAULT NULL,
  `stationof` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of replay
-- ----------------------------
INSERT INTO `replay` VALUES ('3', 's00001', '李四', '2019-01-21 21:04:00', '2019-01-29 23:13:00', '总组', '否', 'admin', '2019-01-14 10:11:25', '000001', 'TOM', '德邦物流');
INSERT INTO `replay` VALUES ('26', 's00004', 'TOM', '2019-01-26 12:21:00', '2019-01-31 21:21:00', '德邦物流', '是', 'admin', '2019-01-16 14:17:10', 's00002', 'jack', '京东物流');
INSERT INTO `replay` VALUES ('27', 's000006', '张三', '2019-01-30 12:12:00', '2019-01-31 21:21:00', '京东', '是', 'admin', '2019-01-16 14:19:52', 's00003', '小米', '京东物流');
INSERT INTO `replay` VALUES ('28', 's00003', '小米', '2019-01-23 12:12:00', '2019-01-26 21:21:00', '京东物流', '否', 'admin', '2019-01-16 14:22:36', 's000006', '张三', '京东');

-- ----------------------------
-- Table structure for `route`
-- ----------------------------
DROP TABLE IF EXISTS `route`;
CREATE TABLE `route` (
  `routeid` int(10) NOT NULL AUTO_INCREMENT,
  `style` varchar(200) DEFAULT '',
  `namefrom` varchar(200) DEFAULT NULL,
  `nameto` varchar(200) DEFAULT NULL,
  `operator` varchar(200) DEFAULT NULL,
  `company` varchar(200) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  UNIQUE KEY `id` (`routeid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of route
-- ----------------------------
INSERT INTO `route` VALUES ('52', '干线', '天津', '上海', 'admin', '啦啦啦公司', '2019-01-16 14:30:20', '啪啪啪');
INSERT INTO `route` VALUES ('53', '全部', '无锡', '江大', 'admin', '啦啦啦公司', '2019-01-16 12:16:28', '啦啦啦');

-- ----------------------------
-- Table structure for `spdate`
-- ----------------------------
DROP TABLE IF EXISTS `spdate`;
CREATE TABLE `spdate` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `datename` varchar(200) NOT NULL,
  `pacificup` time NOT NULL,
  `pacificoff` time NOT NULL,
  `satup` time NOT NULL,
  `satoff` time NOT NULL,
  `sunup` time NOT NULL,
  `sunoff` time NOT NULL,
  `state` varchar(200) DEFAULT NULL,
  `unit` varchar(200) DEFAULT NULL,
  `updateid` varchar(200) DEFAULT NULL,
  `updatename` varchar(200) DEFAULT NULL,
  `updateunit` varchar(200) DEFAULT NULL,
  `updatedate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of spdate
-- ----------------------------
INSERT INTO `spdate` VALUES ('1001', '时间1', '10:09:11', '10:09:15', '10:09:17', '10:09:19', '10:09:23', '10:09:25', '良好', '配送员', 'gl1001', '彦辰', '管理员', '2019-01-08');
INSERT INTO `spdate` VALUES ('1002', '时间2', '16:30:35', '16:30:38', '16:30:40', '16:30:42', '16:30:44', '16:30:46', null, null, null, null, null, null);
INSERT INTO `spdate` VALUES ('1004', '第三方士大夫', '12:12:00', '12:12:00', '12:12:00', '23:23:00', '03:34:00', '12:12:00', null, 'GROUP_1', null, 'admin', null, '2019-01-16');

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `staid` varchar(255) NOT NULL COMMENT '员工编号',
  `name` varchar(255) NOT NULL COMMENT '员工名称',
  `telephone` varchar(255) NOT NULL COMMENT '电话',
  `haspad` varchar(255) NOT NULL COMMENT '移动设备',
  `deltag` varchar(255) NOT NULL,
  `station` varchar(255) NOT NULL COMMENT '单位',
  `shuttleid` varchar(255) NOT NULL COMMENT '班车id',
  `standardid` varchar(255) NOT NULL COMMENT '收取标准id',
  `basisid` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', 's00004', 'TOM', '18112346793', 'PDA', '否', '德邦物流', '苏A.SBAE86', '0-30公斤', '小件员');
INSERT INTO `staff` VALUES ('2', 's00002', 'jack', '13423132323', 'PDA', '否', '京东物流', '苏A1B202', '0-30公斤', '小件员');
INSERT INTO `staff` VALUES ('3', 's00003', '小米', '13434343443', 'PDA', '否', '京东物流', '苏A1B202', '0-30公斤', '小件人员');
INSERT INTO `staff` VALUES ('4', 's00001', '李四', '13123123123', 'PDA', '否', '就', '苏A.SBAE86', '0-30公斤', '小件人员');
INSERT INTO `staff` VALUES ('5', 's000006', '张三', '13333333333', 'PDA', '是', '京东', '苏A1B202', '0-30公斤', '小件人员');

-- ----------------------------
-- Table structure for `subarea`
-- ----------------------------
DROP TABLE IF EXISTS `subarea`;
CREATE TABLE `subarea` (
  `id` varchar(255) NOT NULL,
  `fixedarea_id` varchar(255) DEFAULT NULL,
  `pro` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `county` varchar(255) DEFAULT NULL,
  `attribute` varchar(255) DEFAULT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `auxiliarykeywords` varchar(255) DEFAULT NULL,
  `starnum` int(11) DEFAULT NULL,
  `endnum` int(11) DEFAULT NULL,
  `single` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subarea
-- ----------------------------
INSERT INTO `subarea` VALUES ('FQ001', 'DQ001', '安徽省', '安庆市', '枞阳县', '高级', 'XX镇', 'XX村', '1', '100', '2');
INSERT INTO `subarea` VALUES ('FQ002', 'DQ002', '安徽省', '安庆市', '枞阳县', null, '鼓楼社区', '古', '1', '99', '0');

-- ----------------------------
-- Table structure for `subbasic`
-- ----------------------------
DROP TABLE IF EXISTS `subbasic`;
CREATE TABLE `subbasic` (
  `subbasicno` varchar(255) NOT NULL COMMENT '子级档案编号',
  `subbasicname` varchar(255) NOT NULL COMMENT '子级档案名称',
  `mainbasicno` varchar(255) DEFAULT NULL COMMENT '上级编码',
  `mnemoniccode` varchar(255) DEFAULT NULL COMMENT '助记码',
  `archivemark` int(1) NOT NULL COMMENT '封存标记',
  `subremark` varchar(255) DEFAULT NULL COMMENT '子级备注',
  `suboperator` varchar(255) NOT NULL COMMENT '子级操作人员',
  `suboperationunit` varchar(255) NOT NULL COMMENT '子级操作单位',
  `suboperationdate` datetime NOT NULL COMMENT '子级操作时间',
  PRIMARY KEY (`subbasicno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subbasic
-- ----------------------------
INSERT INTO `subbasic` VALUES ('zd00001', '陆地路线', 'd00001', 'hklx', '0', '请问1', 'admin', '路线单位', '2019-01-15 09:08:37');
INSERT INTO `subbasic` VALUES ('zd00002', '水运路线', 'd00001', 'sylx', '0', 'dsad sa 撒旦', 'admin', '路线单位', '2019-01-14 15:10:10');
INSERT INTO `subbasic` VALUES ('zd00003', '小件人员', 'd00002', 'xjry', '0', null, '李四', '取派件单位', '2018-12-12 00:00:00');
INSERT INTO `subbasic` VALUES ('zd00004', '小件员', 'd00002', 'djry', '0', null, '李四', '取派件单位', '2018-12-12 00:00:00');
INSERT INTO `subbasic` VALUES ('zd00076', '你好呀', 'd00001', 'adsa', '0', '6666', 'admin', 'dsadsad sa', '2019-01-14 13:50:16');
INSERT INTO `subbasic` VALUES ('zd12342', '啦啦啦', 'd00001', 'nnn', '0', 'sad ', 'admin', 'sdad as', '2019-01-14 14:31:15');
INSERT INTO `subbasic` VALUES ('zd12345', '你好呀1', 'd00001', 'nhy', '0', '阿斯顿撒', 'admin', 'sdas', '2019-01-15 09:08:51');

-- ----------------------------
-- Table structure for `sys_group`
-- ----------------------------
DROP TABLE IF EXISTS `sys_group`;
CREATE TABLE `sys_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '组名称',
  `type` varchar(50) DEFAULT NULL COMMENT '组类型',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户组表';

-- ----------------------------
-- Records of sys_group
-- ----------------------------
INSERT INTO `sys_group` VALUES ('1', '第一组', 'GROUP_1', '第一组描述');
INSERT INTO `sys_group` VALUES ('2', '第二组', 'GROUP_2', '第二组描述');
INSERT INTO `sys_group` VALUES ('3', '第三组', 'GROUP_3', '第三组描述');

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `ip` varchar(45) DEFAULT NULL COMMENT '用户ip',
  `req_method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `req_uri` text COMMENT '请求URL',
  `exec_method` varchar(200) DEFAULT NULL COMMENT '执行方法',
  `exec_time` bigint(20) DEFAULT NULL COMMENT '响应时间',
  `args` text COMMENT '参数',
  `return_val` text COMMENT '返回值',
  `exec_desc` varchar(200) DEFAULT NULL COMMENT '描述',
  `status` varchar(45) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=762 DEFAULT CHARSET=utf8 COMMENT='系统日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('760', 'admin', '127.0.0.1', 'POST HTTP/1.1', 'http://localhost:28080/wetech-admin/quyu/delete', 'Result tech.wetech.admin.modules.system.web.QuYuController.delete(Integer[],HttpServletRequest)', '59', '[26,28,29]', '{\"success\":true,\"code\":\"200\",\"msg\":\"处理成功\",\"data\":{}}', '用户管理删除用户', '处理成功', '2019-01-16 15:03:43');
INSERT INTO `sys_log` VALUES ('761', 'admin', '127.0.0.1', 'POST HTTP/1.1', 'http://localhost:28080/wetech-admin/quyu/delete', 'Result tech.wetech.admin.modules.system.web.QuYuController.delete(Integer[],HttpServletRequest)', '19', '[27]', '{\"success\":true,\"code\":\"200\",\"msg\":\"处理成功\",\"data\":{}}', '用户管理删除用户', '处理成功', '2019-01-16 15:03:48');

-- ----------------------------
-- Table structure for `sys_organization`
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '组织名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父编号',
  `parent_ids` varchar(100) DEFAULT NULL COMMENT '父编号列表',
  `available` tinyint(1) DEFAULT '0' COMMENT '是否有效',
  `priority` int(11) DEFAULT NULL COMMENT '优先级',
  `leaf` tinyint(1) DEFAULT '0' COMMENT '叶子节点',
  PRIMARY KEY (`id`),
  KEY `idx_sys_organization_parent_id` (`parent_id`),
  KEY `idx_sys_organization_parent_ids` (`parent_ids`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='组织机构表';

-- ----------------------------
-- Records of sys_organization
-- ----------------------------
INSERT INTO `sys_organization` VALUES ('1', '总公司', '0', '0/', '1', '0', '0');
INSERT INTO `sys_organization` VALUES ('2', '分公司', '1', '0/1/', '1', '1', '0');
INSERT INTO `sys_organization` VALUES ('3', '分公司33', '1', '0/1/', '1', '23', '0');
INSERT INTO `sys_organization` VALUES ('4', '分公司10', '2', '0/1/2/', '1', '221', '0');
INSERT INTO `sys_organization` VALUES ('5', '一级节点', '1', '0/1/', '1', '122', '0');
INSERT INTO `sys_organization` VALUES ('6', '二级节点', '17', '0/1/17/', '1', null, '0');
INSERT INTO `sys_organization` VALUES ('7', '三级节点', '18', '0/1/17/18/', '0', null, '0');
INSERT INTO `sys_organization` VALUES ('8', '133', '2', '0/1/2/', '1', '121212', '0');
INSERT INTO `sys_organization` VALUES ('9', '222', '3', '0/1/3/', '1', '3333', '0');
INSERT INTO `sys_organization` VALUES ('10', '222', '24', '0/1/2/24/', '1', '333', '0');
INSERT INTO `sys_organization` VALUES ('11', '232', '3', '0/1/3/', '1', '2323', '0');
INSERT INTO `sys_organization` VALUES ('12', '333', '32', '0/1/3/32/', '1', '444', '0');
INSERT INTO `sys_organization` VALUES ('13', '222', '2', '0/1/2/', '1', '3333', '0');
INSERT INTO `sys_organization` VALUES ('14', '333', '25', '0/1/3/25/', '1', '232332', '0');

-- ----------------------------
-- Table structure for `sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `type` varchar(50) DEFAULT NULL COMMENT '资源类型',
  `url` varchar(200) DEFAULT NULL COMMENT '链接地址',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父编号',
  `parent_ids` varchar(100) DEFAULT NULL COMMENT '父编号列表',
  `permission` varchar(100) DEFAULT NULL COMMENT '权限字符串',
  `available` tinyint(1) DEFAULT '0' COMMENT '是否有效',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `priority` int(11) DEFAULT NULL COMMENT '优先级',
  `leaf` tinyint(1) DEFAULT '0' COMMENT '叶子节点',
  PRIMARY KEY (`id`),
  KEY `idx_sys_resource_parent_id` (`parent_id`),
  KEY `idx_sys_resource_parent_ids` (`parent_ids`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '资源', 'MENU', '#', '0', '0/', '', '1', '', '0', '0');
INSERT INTO `sys_resource` VALUES ('11', '组织机构管理', 'MENU', '#', '1', '0/1/', 'organization:*', '1', 'fa fa-sitemap', '3', '0');
INSERT INTO `sys_resource` VALUES ('12', '组织机构新增', 'BUTTON', '', '11', '0/1/11/', 'organization:create', '1', null, null, '0');
INSERT INTO `sys_resource` VALUES ('13', '组织机构修改', 'BUTTON', '', '11', '0/1/11/', 'organization:update', '1', null, null, '0');
INSERT INTO `sys_resource` VALUES ('14', '组织机构删除', 'BUTTON', '', '11', '0/1/11/', 'organization:delete', '1', null, null, '0');
INSERT INTO `sys_resource` VALUES ('15', '组织机构查看', 'BUTTON', '', '11', '0/1/11/', 'organization:view', '1', null, null, '0');
INSERT INTO `sys_resource` VALUES ('21', '用户管理', 'MENU', '#', '1', '0/1/', 'user:*', '1', 'fa fa-user', '1', '0');
INSERT INTO `sys_resource` VALUES ('22', '用户新增', 'BUTTON', '', '46', '0/1/21/', 'user:create', '1', null, null, '0');
INSERT INTO `sys_resource` VALUES ('23', '用户修改', 'BUTTON', '', '46', '0/1/21/', 'user:update', '1', '', null, '0');
INSERT INTO `sys_resource` VALUES ('24', '用户删除', 'BUTTON', '', '46', '0/1/21/', 'user:delete', '1', null, null, '0');
INSERT INTO `sys_resource` VALUES ('25', '用户查看', 'BUTTON', '', '46', '0/1/21/', 'user:view', '1', null, null, '0');
INSERT INTO `sys_resource` VALUES ('31', '资源管理', 'MENU', '#', '1', '0/1/', 'resource:*', '1', 'fa fa-desktop', '2', '0');
INSERT INTO `sys_resource` VALUES ('32', '资源新增', 'BUTTON', '', '31', '0/1/31/', 'resource:create', '1', null, null, '0');
INSERT INTO `sys_resource` VALUES ('33', '资源修改', 'BUTTON', '', '31', '0/1/31/', 'resource:update', '1', '', null, '0');
INSERT INTO `sys_resource` VALUES ('34', '资源删除', 'BUTTON', '', '31', '0/1/31/', 'resource:delete', '1', null, null, '0');
INSERT INTO `sys_resource` VALUES ('35', '资源查看', 'BUTTON', '', '31', '0/1/31/', 'resource:view', '1', null, null, '0');
INSERT INTO `sys_resource` VALUES ('41', '角色管理', 'MENU', '#role', '21', '0/1/', 'role:*', '1', 'fa fa-child', '2', '1');
INSERT INTO `sys_resource` VALUES ('42', '角色新增', 'BUTTON', '', '41', '0/1/41/', 'role:create', '1', null, null, '0');
INSERT INTO `sys_resource` VALUES ('43', '角色修改', 'BUTTON', '', '41', '0/1/41/', 'role:update', '1', null, null, '0');
INSERT INTO `sys_resource` VALUES ('44', '角色删除', 'BUTTON', '', '41', '0/1/41/', 'role:delete', '1', null, null, '0');
INSERT INTO `sys_resource` VALUES ('45', '角色查看', 'BUTTON', '', '41', '0/1/41/', 'role:view', '1', null, null, '0');
INSERT INTO `sys_resource` VALUES ('46', '系统用户', 'MENU', '#user', '21', '0/1/11/', '', '1', 'fa fa-wrench', '1', '0');
INSERT INTO `sys_resource` VALUES ('47', '组织机构', 'MENU', '#organization', '11', '0/1/11/', 'organization:*', '1', 'fa fa-suitcase', null, '1');
INSERT INTO `sys_resource` VALUES ('50', '资源管理', 'MENU', '#resource', '31', '0/1/', 'resource:*', '1', 'fa fa-cubes', null, '1');
INSERT INTO `sys_resource` VALUES ('69', '系统管理', 'MENU', '#', '1', '0/1/', 'system:*', '1', 'fa fa-wrench', '12', '0');
INSERT INTO `sys_resource` VALUES ('70', '系统日志', 'MENU', '#log', '69', '0/1/69/', 'log:*', '1', 'fa fa-history', null, '1');
INSERT INTO `sys_resource` VALUES ('73', '一级菜单', 'MENU', '#', '1', '0/1/', '', '1', '', '999', '0');
INSERT INTO `sys_resource` VALUES ('83', '用户组管理', 'MENU', '#group', '21', '0/1/21/', 'group:*', '1', 'fa fa-users', '3', '0');
INSERT INTO `sys_resource` VALUES ('84', '用户组新增', 'BUTTON', '', '83', '0/1/21/83/', 'group:create', '1', '', null, '0');
INSERT INTO `sys_resource` VALUES ('85', '用户组修改', 'BUTTON', '', '83', '0/1/21/83/', 'group:update', '1', '', null, '0');
INSERT INTO `sys_resource` VALUES ('86', '用户组删除', 'BUTTON', '', '83', '0/1/21/83/', 'group:delete', '1', '', null, '0');
INSERT INTO `sys_resource` VALUES ('87', '用户组查看', 'BUTTON', '#', '83', '0/1/21/83/', 'group:view', '1', '', null, '0');
INSERT INTO `sys_resource` VALUES ('88', '百度', 'MENU', 'https://www.baidu.com', '73', '0/1/73/', '', '1', '', null, '0');
INSERT INTO `sys_resource` VALUES ('89', '班车管理', 'MENU', '#', '1', '0/1/', 'bus:*', '1', 'glyphicon glyphicon-bold', '7', '0');
INSERT INTO `sys_resource` VALUES ('90', '区域管理', 'MENU', '#', '1', '0/1/', 'quyu:*', '1', 'glyphicon glyphicon-th', '9', '0');
INSERT INTO `sys_resource` VALUES ('91', '取派管理/替班', 'MENU', '#', '1', '0/1/', 'staff:*', '1', 'fa fa-user', '8', '0');
INSERT INTO `sys_resource` VALUES ('92', '取派员管理', 'MENU', '#staff', '91', '0/1/91/', 'staff:view', '1', '', '0', '0');
INSERT INTO `sys_resource` VALUES ('93', '定区管理', 'MENU', '#', '1', '0/1/', '', '1', 'fa fa-fort-awesome', '11', '0');
INSERT INTO `sys_resource` VALUES ('94', '定区管理', 'MENU', '#fixedArea', '93', '0/1/93/', 'fixedarea:*', '1', 'glyphicon glyphicon-record', '0', '0');
INSERT INTO `sys_resource` VALUES ('95', '收派时间管理', 'MENU', '#', '1', '0/1/', '', '0', 'glyphicon glyphicon-dashboard', '6', '0');
INSERT INTO `sys_resource` VALUES ('96', '替班', 'MENU', '#replay', '91', '0/1/91/', 'replay:*', '1', '', null, '0');
INSERT INTO `sys_resource` VALUES ('100', '收派时间管理', 'MENU', '#sp', '95', '0/1/95/', '', '1', '', null, '0');
INSERT INTO `sys_resource` VALUES ('101', '关联地址管理', 'MENU', '#assAddress', '93', '0/1/93/', 'assAddress:*', '1', 'glyphicon glyphicon-map-marker', '2', '0');
INSERT INTO `sys_resource` VALUES ('102', '关联收派人员管理', 'MENU', '#assWidgets', '93', '0/1/93/', 'assWidgets:*', '1', 'glyphicon glyphicon-pawn', '2', '0');
INSERT INTO `sys_resource` VALUES ('103', '班车', 'MENU', '#bus', '89', '0/1/89/', 'bus:*', '1', 'glyphicon glyphicon-play', '1', '0');
INSERT INTO `sys_resource` VALUES ('104', '班车2', 'MENU', '#bus1', '89', '0/1/89/', 'bus:*', '1', 'glyphicon glyphicon-forward', '2', '0');
INSERT INTO `sys_resource` VALUES ('105', '基本档案管理', 'MENU', '#', '1', '0/1/', '', '1', 'glyphicon glyphicon-floppy-disk', '4', '0');
INSERT INTO `sys_resource` VALUES ('106', '基础档案', 'MENU', '#basic', '105', '0/1/105/', 'basic:*', '1', 'glyphicon glyphicon-floppy-saved', null, '0');
INSERT INTO `sys_resource` VALUES ('107', '基础档案子级', 'MENU', '#subbasic', '105', '0/1/105/', 'subbasic:*', '1', 'glyphicon glyphicon-floppy-saved', null, '0');
INSERT INTO `sys_resource` VALUES ('108', '查看基础档案子级', 'BUTTON', '', '105', '0/1/105/', 'subbasic:view', '1', '', null, '0');
INSERT INTO `sys_resource` VALUES ('109', '被替班', 'MENU', '#replayof', '91', '0/1/91/', 'replayof:*', '1', '', null, '0');
INSERT INTO `sys_resource` VALUES ('110', '分区管理', 'MENU', '#', '1', '0/1/', 'subarea:*', '1', 'fa fa-sitemap', '10', '0');
INSERT INTO `sys_resource` VALUES ('111', '分区管理', 'MENU', '#subarea', '110', '0/1/110/', '', '1', 'fa fa-fort-awesome', null, '0');
INSERT INTO `sys_resource` VALUES ('112', '分区查看', 'BUTTON', '', '111', '0/1/110/111/', 'subarea:view', '1', '', null, '0');
INSERT INTO `sys_resource` VALUES ('113', '分区删除', 'BUTTON', '', '111', '0/1/110/111/', 'subarea:delete', '1', '', null, '0');
INSERT INTO `sys_resource` VALUES ('114', '分区新增', 'BUTTON', '', '111', '0/1/110/111/', 'subarea:create', '1', '', null, '0');
INSERT INTO `sys_resource` VALUES ('115', '分区修改', 'BUTTON', '', '111', '0/1/110/111/', 'subarea:update', '1', '', null, '0');
INSERT INTO `sys_resource` VALUES ('116', '区域管理', 'MENU', '#quyu', '90', '0/1/90/', '', '1', 'glyphicon glyphicon-th-large', '1', '0');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role` varchar(100) DEFAULT NULL COMMENT '角色名',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `resource_ids` varchar(100) DEFAULT NULL COMMENT '资源编号列表',
  `available` tinyint(1) DEFAULT '0' COMMENT '是否有效',
  PRIMARY KEY (`id`),
  KEY `idx_sys_role_resource_ids` (`resource_ids`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '超级管理员', '11,21,31,41,46,69,70,83,89,90,91,92,93,94,95,96,100,101,102,105,106,107,108,109,110,111', '0');
INSERT INTO `sys_role` VALUES ('2', 'guest', '访客', '15,25,35,45', '0');
INSERT INTO `sys_role` VALUES ('4', 'ceshi3', '测试的角色', '12,14,34,35', '0');
INSERT INTO `sys_role` VALUES ('5', 'test', '测试角色', '12,13,14,43,47', '0');
INSERT INTO `sys_role` VALUES ('6', '测试1', '222', '73', '0');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `organization_id` bigint(20) DEFAULT NULL COMMENT '组织机构编号',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐值',
  `role_ids` varchar(100) DEFAULT NULL COMMENT '角色列表',
  `group_ids` varchar(100) DEFAULT NULL COMMENT '组列表',
  `locked` tinyint(1) DEFAULT '0' COMMENT '是否锁定',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_user_username` (`username`),
  KEY `idx_sys_user_organization_id` (`organization_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', 'admin', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '1', '1', '0');
INSERT INTO `sys_user` VALUES ('2', '2', 'ceshi', 'c067bee5cf7f216f352011cb9064241e', '2632e0a577dba732bbfb4b298ff0b6e5', '4', '1', '0');
INSERT INTO `sys_user` VALUES ('3', '4', 'qqq', 'f0c6227912db35e27eaa82308be055cd', 'a2425da3d41a6ef79a1ec69a7d845767', '1', '1', '0');
INSERT INTO `sys_user` VALUES ('5', '3', 'guest', 'fdd97263888fb3767d55ff084751c125', '9f1bdc22981ae8730e89f94d241a73cc', '2', '1', '0');
INSERT INTO `sys_user` VALUES ('6', '14', '12434', 'f17bf5e211de8a5cb611c4b6d83b728b', 'ffb57814a69d37ec1898282d4090cbfc', '2', '1', '0');
INSERT INTO `sys_user` VALUES ('7', '3', 'admin212', 'f51764c4e21a7226f92ce79bef273a33', 'b184db3641404a412c28d0863f46054e', '2,4', '1', '0');
INSERT INTO `sys_user` VALUES ('8', '4', '1208', '0aff55b46e9c7f91f622c0f579f6b43f', '3f83092c188d3de0695d260aec6ac4c1', '1,2,4,5', '1', '0');
INSERT INTO `sys_user` VALUES ('9', '14', 'tttt', '3e5657ac9987290841d99ed6f575f4e0', 'b48f560c40f4a53a0793184e45992f3d', '1,2,4,5', '1', '0');
INSERT INTO `sys_user` VALUES ('12', '3', 'ceshcie', 'cca5985abc9a89f4d29e2e02aa6afca2', 'b789c54f40d592cdeaa17c452cee27b2', '4', '1', '0');
INSERT INTO `sys_user` VALUES ('13', '3', '1233445', '6283a19b895a571a2637a3bec3215cf3', '34245e29965cfcd25da1fa671f5047d3', '2', '1', '0');
INSERT INTO `sys_user` VALUES ('14', '3', '12334', '677a3e446421395315aeb52844959acd', '4e8f403e236e5910a2d13532796963bd', '4', '1', '0');
INSERT INTO `sys_user` VALUES ('15', '3', '1221', '3a7b7a1d99a5e23fb9f9e1e88da499b0', 'f91e00aadbdea44b8d3a18f490173eb6', '1', '1', '0');
INSERT INTO `sys_user` VALUES ('16', '3', '123456', '2aa2c7bf65db34867eb4fd7a49b8b18f', '685e4e4a2a9d57ccb2a3bd24ee01691a', '5', '1', '0');
INSERT INTO `sys_user` VALUES ('17', '2', '123434', '355ff1f1a7c60a82b9d0685ec6406987', '821b7c15dcf108502a1a024a5746e7b7', '2', '1', '0');
INSERT INTO `sys_user` VALUES ('18', '3', 'admin2', '6e327ade642adb0d344b9909f7d9f990', 'ccf50557508af772c13bedfcc320c4f1', '1,2,4,5', '1', '0');
INSERT INTO `sys_user` VALUES ('19', '3', 'cee', 'ca9708541f98523b5c0b88661b2bb559', '3ea093a5cb06042f825fcdb51b76cb5c', '1,2,4,5', '1', '0');
INSERT INTO `sys_user` VALUES ('20', '3', 'admin222', '13503530117f28b48fc32a1eea299bf0', '7292e549e492358c0233fde9e1c46ac3', '1,2,4', '1', '0');
INSERT INTO `sys_user` VALUES ('21', '14', 'admin333', '387a1e939344d1dee392a7c02debb34b', '28e95c4e30c53414e5b63cca2427e173', '1,2,4', '1', '0');
INSERT INTO `sys_user` VALUES ('22', '4', 'john', 'e755e2c4bb208ac9665bed5b9f6b81c5', '33a2c9562d191e090d83840a2920f3c1', '1', '1', '0');
INSERT INTO `sys_user` VALUES ('23', '10', 'qqqqqq', 'd1ae1387d45a1276aa8672d28b3c9638', '728a99bc46fc0d33672ece74d3d383b9', '4', '1', '0');
INSERT INTO `sys_user` VALUES ('24', '9', 'wwww', 'b86e1ab99a636fa907fdb8433b347a46', 'e2883f9c826290d88ee520c4e8549895', '1', '2', '0');
INSERT INTO `sys_user` VALUES ('33', '3', 'guest22223', '6622b95a30cf730253550985718102bc', '7de124e9822c092d56750969eebcf260', '1,2', '1', '0');

-- ----------------------------
-- Table structure for `xzqyinfo`
-- ----------------------------
DROP TABLE IF EXISTS `xzqyinfo`;
CREATE TABLE `xzqyinfo` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `province` varchar(10) NOT NULL,
  `city` varchar(10) DEFAULT NULL,
  `qu` varchar(10) DEFAULT NULL,
  `yzbm` varchar(10) DEFAULT NULL,
  `jm` varchar(3) NOT NULL,
  `csbm` varchar(10) NOT NULL,
  `cgdw` varchar(10) NOT NULL,
  `jgdw` varchar(10) NOT NULL,
  `kfwqy` varchar(15) NOT NULL,
  `bkfwqy` varchar(15) NOT NULL,
  `tsqy` varchar(15) NOT NULL,
  `sfkcz` tinyint(1) NOT NULL,
  `sfkczCOD` tinyint(1) NOT NULL,
  `sfww` tinyint(1) NOT NULL,
  `sfjqx` tinyint(1) NOT NULL,
  `xz` varchar(5) NOT NULL,
  `ssqy` varchar(10) NOT NULL,
  `pycsjb` int(1) NOT NULL,
  `sjzxjgczfwq` varchar(10) NOT NULL,
  `kouan` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xzqyinfo
-- ----------------------------
INSERT INTO `xzqyinfo` VALUES ('1', '江苏省', '南京市', '鼓楼区', '100013', 'g', 'js', '公司3', '公司2', 'b,c', 'a,d', 'b,c', '1', '1', '0', '1', '省级', '华东区', '1', 'ddd', '1');
INSERT INTO `xzqyinfo` VALUES ('3', '浙江省', '杭州市', '上城区', '123412', 'S', 's', '公司1', '公司3', 'b', 'd', 'c', '0', '0', '0', '0', '省级', '东北区', '1', '1', '1');
INSERT INTO `xzqyinfo` VALUES ('4', '河北省', '承德市', '下板城镇', '123443', 'x', 's', '总公司', '公司1', 'd', 'c', 'b', '0', '0', '0', '0', '省级', '东北区', '1', '1', '1');
INSERT INTO `xzqyinfo` VALUES ('5', '内蒙古', '乌兰察布市', '察哈尔右翼后旗', '123578', 'C', 'c', '公司1', '公司3', 'b', 'c', 'c', '0', '0', '0', '0', '省级', '东北区', '1', '1', '1');
INSERT INTO `xzqyinfo` VALUES ('6', '上海市', '上海市', '徐汇区', '121222', 'S', 's', '总公司', '公司1', 'c', 'd', 'a', '0', '0', '0', '0', '省级', '东北区', '1', '1', '1');
INSERT INTO `xzqyinfo` VALUES ('7', '江苏省', '徐州市', '云龙区', '111111', 'a', 'a', '公司2', '公司3', 'c,d', 'b,d', 'b,d', '1', '1', '0', '0', '直辖市', '东北区', '2', '1', '3');
INSERT INTO `xzqyinfo` VALUES ('12', '北京市', '北京市', '西城区', '555555', 'a', 'a', '公司3', '公司2', 'c,d', 'a,b', 'a,c', '1', '1', '1', '1', '直辖市', '华东区', '3', '2', '2');
INSERT INTO `xzqyinfo` VALUES ('13', '北京市', '北京市', '西城区', '555555', 'a', 'a', '公司3', '公司2', 'c,d', 'a,b', 'a,c', '1', '1', '1', '1', '直辖市', '华东区', '3', '2', '2');
INSERT INTO `xzqyinfo` VALUES ('14', '北京市', '北京市', '西城区', '555555', 'a', 'a', '公司3', '公司2', 'c,d', 'a,b', 'a,c', '1', '1', '1', '1', '直辖市', '华东区', '3', '2', '2');
INSERT INTO `xzqyinfo` VALUES ('15', '北京市', '北京市', '西城区', '555555', 'a', 'a', '公司3', '公司2', 'c,d', 'a,b', 'a,c', '1', '1', '1', '1', '直辖市', '华东区', '3', '2', '2');
INSERT INTO `xzqyinfo` VALUES ('16', '北京市', '北京市', '西城区', '555555', 'a', 'a', '公司3', '公司2', 'c,d', 'a,b', 'a,c', '1', '1', '1', '1', '直辖市', '华东区', '3', '2', '2');
INSERT INTO `xzqyinfo` VALUES ('17', '北京市', '北京市', '西城区', '555555', 'a', 'a', '公司3', '公司2', 'c,d', 'a,b', 'a,c', '1', '1', '1', '1', '直辖市', '华东区', '3', '2', '2');
INSERT INTO `xzqyinfo` VALUES ('18', '北京市', '北京市', '西城区', '555555', 'a', 'a', '公司3', '公司2', 'c,d', 'a,b', 'a,c', '1', '1', '1', '1', '直辖市', '华东区', '3', '2', '2');
INSERT INTO `xzqyinfo` VALUES ('19', '北京市', '北京市', '西城区', '555555', 'a', 'a', '公司3', '公司2', 'c,d', 'a,b', 'a,c', '1', '1', '1', '1', '直辖市', '华东区', '3', '2', '2');
INSERT INTO `xzqyinfo` VALUES ('20', '北京市', '北京市', '西城区', '555555', 'a', 'a', '公司3', '公司2', 'c,d', 'a,b', 'a,c', '1', '1', '1', '1', '直辖市', '华东区', '3', '2', '2');
INSERT INTO `xzqyinfo` VALUES ('21', '上海市', '上海市', '卢湾区', '123124', 'l', 'l', '总公司', '公司1', 'b,c', 'a,c,d', 'b,c,d', '0', '0', '0', '0', '省级', '东北区', '1', '1', '1');
INSERT INTO `xzqyinfo` VALUES ('22', '上海市', '上海市', '卢湾区', '123124', 'l', 'l', '总公司', '公司1', 'b,c', 'a,c,d', 'b,c,d', '0', '0', '0', '0', '省级', '东北区', '1', '1', '1');
INSERT INTO `xzqyinfo` VALUES ('23', '上海市', '上海市', '卢湾区', '123124', 'l', 'l', '总公司', '公司1', 'b,c', 'a,c,d', 'b,c,d', '0', '0', '0', '0', '省级', '东北区', '1', '1', '1');
INSERT INTO `xzqyinfo` VALUES ('24', '上海市', '上海市', '卢湾区', '123124', 'l', 'l', '总公司', '公司1', 'b,c', 'a,c,d', 'b,c,d', '0', '0', '0', '0', '省级', '东北区', '1', '1', '1');
INSERT INTO `xzqyinfo` VALUES ('25', '上海市', '上海市', '卢湾区', '123124', 'l', 'l', '总公司', '公司1', 'b,c', 'a,c,d', 'b,c,d', '0', '0', '0', '0', '省级', '东北区', '1', '1', '1');
