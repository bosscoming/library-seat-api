/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : library_seats

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 19/04/2020 17:12:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ls_seats
-- ----------------------------
DROP TABLE IF EXISTS `ls_seats`;
CREATE TABLE `ls_seats`  (
  `id` int(11) NOT NULL COMMENT '座位号',
  `room_id` int(11) NULL DEFAULT NULL COMMENT '阅览室id',
  `row` int(11) NULL DEFAULT NULL COMMENT '座位排数',
  `col` int(11) NULL DEFAULT NULL COMMENT '座位列数',
  `x` int(11) NULL DEFAULT NULL COMMENT '横坐标',
  `y` int(11) NULL DEFAULT NULL COMMENT '纵坐标',
  `type` int(11) NULL DEFAULT NULL COMMENT 'ls_seat_type中id 座位类型',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `flag` tinyint(1) NULL DEFAULT NULL COMMENT '状态 1 为 删除 0 为 有效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ls_room_id`(`room_id`) USING BTREE,
  INDEX `ls_seat_type_id`(`type`) USING BTREE,
  CONSTRAINT `ls_room_id` FOREIGN KEY (`room_id`) REFERENCES `ls_rooms` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ls_seat_type_id` FOREIGN KEY (`type`) REFERENCES `ls_seat_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
