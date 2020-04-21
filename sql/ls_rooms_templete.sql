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

 Date: 22/04/2020 00:54:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ls_rooms_templete
-- ----------------------------
DROP TABLE IF EXISTS `ls_rooms_templete`;
CREATE TABLE `ls_rooms_templete`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `floor_num` int(11) NULL DEFAULT NULL COMMENT '楼层号',
  `room_num` int(10) NULL DEFAULT 0 COMMENT '阅览室号',
  `s_id` int(11) NULL DEFAULT NULL COMMENT '学校 id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态 1 为 维修 0 为 正常',
  `flag` tinyint(1) NULL DEFAULT NULL COMMENT '状态 1 为 删除 0 为 有效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '座位模版表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
