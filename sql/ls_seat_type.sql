/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : seat_select

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 22/04/2020 00:54:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ls_seat_type
-- ----------------------------
DROP TABLE IF EXISTS `ls_seat_type`;
CREATE TABLE `ls_seat_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '座位类型',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型名称 空位 离开 有人',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标url',
  `isShow` tinyint(1) NULL DEFAULT 1 COMMENT '是否在移动端显示 状态 1 为显示 0不显示',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ls_seat_type
-- ----------------------------
INSERT INTO `ls_seat_type` VALUES (1, '0', '空位', 'http://img.wydxda.com/seats/BbbWyY5D_image.png', 1);
INSERT INTO `ls_seat_type` VALUES (2, '1', '离开', 'http://img.wydxda.com/seats/1X2dd93h_image.png', 1);
INSERT INTO `ls_seat_type` VALUES (3, '2', '有人', 'http://img.wydxda.com/seats/LXywzkds_image.png', 1);
INSERT INTO `ls_seat_type` VALUES (4, '3', '维修', 'http://img.wydxda.com/seats/BZVRbCcY_image.png', 1);
INSERT INTO `ls_seat_type` VALUES (5, '4', '我', 'http://img.wydxda.com/seats/isme_image.png', 1);
INSERT INTO `ls_seat_type` VALUES (6, '5', '有物无人', 'http://img.wydxda.com/seats/zz_image.png', 1);

SET FOREIGN_KEY_CHECKS = 1;
