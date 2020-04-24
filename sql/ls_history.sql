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

 Date: 25/04/2020 00:30:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ls_history
-- ----------------------------
DROP TABLE IF EXISTS `ls_history`;
CREATE TABLE `ls_history`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生读者账号（外键） openid',
  `seat_id` int(11) NULL DEFAULT NULL COMMENT 'ls_seats_id 座位号',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '座位使用开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '座位使用结束时间',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '离开/使用',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ls_reader_id`(`openid`) USING BTREE,
  INDEX `ls_seat_id`(`seat_id`) USING BTREE,
  CONSTRAINT `ls_reader_id` FOREIGN KEY (`openid`) REFERENCES `ls_readers` (`openid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ls_seat_id` FOREIGN KEY (`seat_id`) REFERENCES `ls_seats` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
