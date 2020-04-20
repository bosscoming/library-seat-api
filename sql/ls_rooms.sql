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

 Date: 20/04/2020 00:10:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ls_rooms
-- ----------------------------
DROP TABLE IF EXISTS `ls_rooms`;
CREATE TABLE `ls_rooms`  (
  `id` int(11) NOT NULL,
  `floor_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼层名称',
  `room_num` int(11) NULL DEFAULT NULL COMMENT '房间号',
  `s_id` int(11) NULL DEFAULT NULL COMMENT '学校',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '状态 1 为 维修 0 为 正常',
  `flag` tinyint(1) NULL DEFAULT 0 COMMENT '状态 1 为 删除 0 为 有效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ls_rooms_school_id`(`s_id`) USING BTREE,
  CONSTRAINT `ls_rooms_school_id` FOREIGN KEY (`s_id`) REFERENCES `ls_schools` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '阅览室信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
