/*
Navicat MySQL Data Transfer

Source Server         : hzb
Source Server Version : 50544
Source Host           : localhost:3306
Source Database       : ajax

Target Server Type    : MYSQL
Target Server Version : 50544
File Encoding         : 65001

Date: 2018-02-17 16:03:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `cityId` int(11) NOT NULL AUTO_INCREMENT,
  `cityName` varchar(20) NOT NULL,
  `personSize` int(11) NOT NULL,
  `cityArea` int(11) NOT NULL,
  `place` varchar(20) NOT NULL,
  `provinceId` int(11) NOT NULL,
  PRIMARY KEY (`cityId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '西安', '800', '380', '大雁塔', '1');
INSERT INTO `city` VALUES ('2', '宝鸡', '200', '100', '法门寺', '1');
INSERT INTO `city` VALUES ('3', '洛阳', '400', '200', '白马寺', '2');
INSERT INTO `city` VALUES ('4', '开封', '100', '50', '少林寺', '2');

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `provinceId` int(11) NOT NULL AUTO_INCREMENT,
  `provinceName` varchar(20) NOT NULL,
  PRIMARY KEY (`provinceId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('1', '陕西省');
INSERT INTO `province` VALUES ('2', '河南省');
