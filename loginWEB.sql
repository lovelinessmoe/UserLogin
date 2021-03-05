/*
 Navicat Premium Data Transfer

 Source Server         : MyMeow
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : loginWEB

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 05/03/2021 20:39:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int NOT NULL AUTO_INCREMENT,
  `u_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `u_pwd` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`u_id`) USING BTREE,
  UNIQUE KEY `u_name` (`u_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'xiaoming', '123');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
