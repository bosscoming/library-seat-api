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

 Date: 24/04/2020 00:20:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ls_seats
-- ----------------------------
DROP TABLE IF EXISTS `ls_seats`;
CREATE TABLE `ls_seats`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `x` int(11) NULL DEFAULT NULL COMMENT 'X坐标',
  `y` int(11) NULL DEFAULT NULL COMMENT 'Y坐标',
  `row` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '排',
  `col` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '列',
  `room_num` int(10) NULL DEFAULT 0 COMMENT '阅览室号',
  `type` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应seat_type表中的id',
  `templete_id` int(11) NULL DEFAULT NULL COMMENT '对阅览室id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `reader_openid` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前座位的读者id',
  `release_time` datetime(0) NULL DEFAULT NULL COMMENT '读者使用结束时间',
  `flag` tinyint(1) NULL DEFAULT 0 COMMENT '预留标示位 0位有效 1为无效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `templete_index`(`templete_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5782 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '座位表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
