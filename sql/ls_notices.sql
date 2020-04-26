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

 Date: 25/04/2020 22:07:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ls_notices
-- ----------------------------
DROP TABLE IF EXISTS `ls_notices`;
CREATE TABLE `ls_notices`  (
  `id` int(11) NOT NULL,
  `school_id` int(11) NULL DEFAULT NULL COMMENT '所属学校  ls_schools id',
  `librarian_id` int(11) NULL DEFAULT NULL COMMENT '发布者管理员 ls_librarian_id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公告内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `num` int(11) NULL DEFAULT NULL COMMENT '阅览数',
  `flag` tinyint(1) NULL DEFAULT NULL COMMENT '状态 1 为 删除 0 为 有效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ls_school_id`(`school_id`) USING BTREE,
  INDEX `ls_librarian_id`(`librarian_id`) USING BTREE,
  CONSTRAINT `ls_librarian_id` FOREIGN KEY (`librarian_id`) REFERENCES `ls_librarians` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ls_school_id` FOREIGN KEY (`school_id`) REFERENCES `ls_schools` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
