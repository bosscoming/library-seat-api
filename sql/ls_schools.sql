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

 Date: 24/04/2020 00:20:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  `longitude` double(65, 10) NULL DEFAULT NULL COMMENT '图书馆 经度',
  `latitude` double(65, 10) NULL DEFAULT NULL COMMENT '图书馆 纬度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学校信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ls_schools
-- ----------------------------
INSERT INTO `ls_schools` VALUES (1, '江西理工大学', '红旗校区', '江西省', '理工类', NULL, 'http://img.wydxda.com/logos/4ee6c4dc072d41c79c4615757bf3caac.jpg', 114.9366710000, 25.8599430000);
INSERT INTO `ls_schools` VALUES (2, '江西理工大学', '黄金校区', '江西省', '理工类', NULL, 'http://img.wydxda.com/logos/4ee6c4dc072d41c79c4615757bf3caac.jpg', NULL, NULL);
INSERT INTO `ls_schools` VALUES (3, '清华大学', '东区', '北京市', '综合类', NULL, 'http://img.wydxda.com/logos/afef57fb3e3f489dbf3f6683c99680a3.jpg', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
