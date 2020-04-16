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

 Date: 16/04/2020 21:41:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ls_readers
-- ----------------------------
DROP TABLE IF EXISTS `ls_readers`;
CREATE TABLE `ls_readers`  (
  `id` int(255) NOT NULL COMMENT '学号',
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信openid',
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信昵称',
  `sex` enum('男','女','保密') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '保密' COMMENT '性别',
  `s_id` int(11) NULL DEFAULT NULL COMMENT '学校',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院系',
  `professional` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `grade` int(255) NULL DEFAULT NULL COMMENT '年级',
  `status` int(11) UNSIGNED NULL DEFAULT 0 COMMENT '是否违规禁用中 1 是 0 否',
  `flag` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '状态 1 为 删除 0 为 有效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ls_readers_school_id`(`s_id`) USING BTREE,
  INDEX `openid`(`openid`) USING BTREE,
  CONSTRAINT `ls_readers_school_id` FOREIGN KEY (`s_id`) REFERENCES `ls_schools` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生读者信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ls_readers
-- ----------------------------
INSERT INTO `ls_readers` VALUES (1520163312, NULL, '123456', 'https://wx.qlogo.cn/mmhead/Q3auHgzwzM7hWo0U0qsSXA2SbYYkhSOL4p5z6iaVKWYvZWWA13q7yqA/0', NULL, NULL, '保密', 1, NULL, NULL, NULL, NULL, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
