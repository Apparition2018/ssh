/*
Navicat MySQL Data Transfer

Source Server         : ljh
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : ssh2

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-02-25 22:51:27
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(20) DEFAULT NULL,
  `ddesc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '财务部', '负责财务管理');
INSERT INTO `department` VALUES ('2', '教学部', '负责教学工作');
INSERT INTO `department` VALUES ('3', '人事部', '负责人事管理');
INSERT INTO `department` VALUES ('4', '市场部', '负责市场运营');
INSERT INTO `department` VALUES ('5', '研发部', '负责产品研发');
INSERT INTO `department` VALUES ('6', '咨询部', '负责资讯管理');
INSERT INTO `department` VALUES ('7', '学工部', '负责学工管理');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `joinDate` datetime DEFAULT NULL,
  `eno` varchar(20) DEFAULT NULL,
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `dno` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKliyqiooso8ar5j2n18pry22p2` (`dno`),
  CONSTRAINT `FKliyqiooso8ar5j2n18pry22p2` FOREIGN KEY (`dno`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '张三', '男', '2002-02-08 00:02:07', '2016-02-01 00:02:29', '20160201', 'zs', '123', null);
