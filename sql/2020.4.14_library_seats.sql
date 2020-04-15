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

 Date: 14/04/2020 11:37:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ls_blacklist
-- ----------------------------
DROP TABLE IF EXISTS `ls_blacklist`;
CREATE TABLE `ls_blacklist`  (
  `id` int(11) NOT NULL,
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生读者账号（外键） 学号id / openid',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '禁用开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '禁用结束时间',
  `flag` tinyint(1) NULL DEFAULT NULL COMMENT '状态 1 为 删除 0 为 有效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ls_reader_black_list_openid`(`openid`) USING BTREE,
  CONSTRAINT `ls_reader_black_list_openid` FOREIGN KEY (`openid`) REFERENCES `ls_readers` (`openid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ls_history
-- ----------------------------
DROP TABLE IF EXISTS `ls_history`;
CREATE TABLE `ls_history`  (
  `id` int(11) NOT NULL,
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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ls_librarians
-- ----------------------------
DROP TABLE IF EXISTS `ls_librarians`;
CREATE TABLE `ls_librarians`  (
  `id` int(11) NOT NULL COMMENT '教工号',
  `openid` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信 openid',
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `s_id` int(11) NULL DEFAULT NULL COMMENT '学校',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信昵称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮件',
  `flag` tinyint(1) NULL DEFAULT NULL COMMENT '状态 1 为 删除 0 为 有效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ls_librarians_school_id`(`s_id`) USING BTREE,
  CONSTRAINT `ls_librarians_school_id` FOREIGN KEY (`s_id`) REFERENCES `ls_schools` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图书馆管理员信息表' ROW_FORMAT = Dynamic;

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

-- ----------------------------
-- Table structure for ls_readers
-- ----------------------------
DROP TABLE IF EXISTS `ls_readers`;
CREATE TABLE `ls_readers`  (
  `id` int(255) NOT NULL COMMENT '学号',
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '微信openid',
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信昵称',
  `sex` enum('男','女','保密') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '保密' COMMENT '性别',
  `s_id` int(11) NOT NULL COMMENT '学校',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院系',
  `professional` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `grade` int(255) NULL DEFAULT NULL COMMENT '年级',
  `status` int(255) NULL DEFAULT NULL COMMENT '是否违规禁用中 1 是 0 否',
  `flag` tinyint(1) NULL DEFAULT NULL COMMENT '状态 1 为 删除 0 为 有效',
  PRIMARY KEY (`id`, `openid`) USING BTREE,
  INDEX `ls_readers_school_id`(`s_id`) USING BTREE,
  INDEX `openid`(`openid`) USING BTREE,
  CONSTRAINT `ls_readers_school_id` FOREIGN KEY (`s_id`) REFERENCES `ls_schools` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生读者信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ls_rooms
-- ----------------------------
DROP TABLE IF EXISTS `ls_rooms`;
CREATE TABLE `ls_rooms`  (
  `id` int(11) NOT NULL,
  `floor_num` int(11) NULL DEFAULT NULL COMMENT '楼层号',
  `room_num` int(11) NULL DEFAULT NULL COMMENT '房间号',
  `s_id` int(11) NULL DEFAULT NULL COMMENT '学校',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态 1 为 维修 0 为 正常',
  `flag` tinyint(1) NULL DEFAULT NULL COMMENT '状态 1 为 删除 0 为 有效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ls_rooms_school_id`(`s_id`) USING BTREE,
  CONSTRAINT `ls_rooms_school_id` FOREIGN KEY (`s_id`) REFERENCES `ls_schools` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '阅览室信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ls_schools
-- ----------------------------
DROP TABLE IF EXISTS `ls_schools`;
CREATE TABLE `ls_schools`  (
  `id` int(11) NOT NULL,
  `school_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校名称',
  `campuse_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '校区名称',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在省份',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院校类型\r\n	• 理工类 \r\n	• 综合类 \r\n	• 财经类 \r\n	• 师范类 \r\n	• 艺术类 \r\n	• 农林类 \r\n	• 医药类 \r\n	• 政法类 \r\n	• 民族类 \r\n	• 军事类 \r\n	•语言类',
  `attributes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院校属性\r\n	• 985工程\r\n	• 211工程 \r\n	• 一流大学建设高校\r\n	• 一流学科建设高校\r\n	• 教育部直属\r\n	• 中央部委\r\n	• 自主招生试点',
  `badge` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '校徽 地址url',
  `longitude` double(255, 0) NULL DEFAULT NULL COMMENT '图书馆 经度',
  `latitude` double(255, 0) NULL DEFAULT NULL COMMENT '图书馆 纬度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学校信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ls_seat_type
-- ----------------------------
DROP TABLE IF EXISTS `ls_seat_type`;
CREATE TABLE `ls_seat_type`  (
  `id` int(11) NOT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '座位类型',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型名称 空位 离开 有人',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标url',
  `isShow` tinyint(1) NULL DEFAULT NULL COMMENT '是否在移动端显示 状态 1 为显示 0不显示',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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

-- ----------------------------
-- Table structure for ls_violations
-- ----------------------------
DROP TABLE IF EXISTS `ls_violations`;
CREATE TABLE `ls_violations`  (
  `id` int(11) NOT NULL,
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生读者账号（外键） 学号id / openid',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '违规类型说明',
  `from_id` int(11) NULL DEFAULT NULL COMMENT '发出违规管理员 from_id',
  `flag` tinyint(1) NULL DEFAULT NULL COMMENT '状态 1 为 删除 0 为 有效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ls_reader_openid`(`openid`) USING BTREE,
  CONSTRAINT `ls_reader_openid` FOREIGN KEY (`openid`) REFERENCES `ls_readers` (`openid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
