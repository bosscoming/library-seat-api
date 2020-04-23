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

 Date: 24/04/2020 00:21:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_coslers
-- ----------------------------
DROP TABLE IF EXISTS `t_coslers`;
CREATE TABLE `t_coslers`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `f_PY` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cBegin` smallint(5) UNSIGNED NOT NULL,
  `cEnd` smallint(5) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '学校首字母分类排序临时表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_coslers
-- ----------------------------
INSERT INTO `t_coslers` VALUES (1, 'A', 45217, 45252);
INSERT INTO `t_coslers` VALUES (2, 'B', 45253, 45760);
INSERT INTO `t_coslers` VALUES (3, 'C', 45761, 46317);
INSERT INTO `t_coslers` VALUES (4, 'D', 46318, 46825);
INSERT INTO `t_coslers` VALUES (5, 'E', 46826, 47009);
INSERT INTO `t_coslers` VALUES (6, 'F', 47010, 47296);
INSERT INTO `t_coslers` VALUES (7, 'G', 47297, 47613);
INSERT INTO `t_coslers` VALUES (8, 'H', 47614, 48118);
INSERT INTO `t_coslers` VALUES (9, 'J', 48119, 49061);
INSERT INTO `t_coslers` VALUES (10, 'K', 49062, 49323);
INSERT INTO `t_coslers` VALUES (11, 'L', 49324, 49895);
INSERT INTO `t_coslers` VALUES (12, 'M', 49896, 50370);
INSERT INTO `t_coslers` VALUES (13, 'N', 50371, 50613);
INSERT INTO `t_coslers` VALUES (14, 'O', 50614, 50621);
INSERT INTO `t_coslers` VALUES (15, 'P', 50622, 50905);
INSERT INTO `t_coslers` VALUES (16, 'Q', 50906, 51386);
INSERT INTO `t_coslers` VALUES (17, 'R', 51387, 51445);
INSERT INTO `t_coslers` VALUES (18, 'S', 51446, 52217);
INSERT INTO `t_coslers` VALUES (19, 'T', 52218, 52697);
INSERT INTO `t_coslers` VALUES (20, 'W', 52698, 52979);
INSERT INTO `t_coslers` VALUES (21, 'X', 52980, 53640);
INSERT INTO `t_coslers` VALUES (22, 'Y', 53689, 54480);
INSERT INTO `t_coslers` VALUES (23, 'Z', 54481, 55289);

SET FOREIGN_KEY_CHECKS = 1;
