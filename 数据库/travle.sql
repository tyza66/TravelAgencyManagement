/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : travle

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 16/06/2023 13:21:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for buser
-- ----------------------------
DROP TABLE IF EXISTS `buser`;
CREATE TABLE `buser`  (
  `bid` int NOT NULL,
  `bname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `btel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bnum` int NOT NULL,
  `bstate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buser
-- ----------------------------
INSERT INTO `buser` VALUES (1, '张三', '123', 23, '1');
INSERT INTO `buser` VALUES (2, '李四', '234', 2, '1');

-- ----------------------------
-- Table structure for cus
-- ----------------------------
DROP TABLE IF EXISTS `cus`;
CREATE TABLE `cus`  (
  `cid` int NOT NULL,
  `cname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bid` int NULL DEFAULT NULL,
  `gid` int NULL DEFAULT NULL,
  `oid` int NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  INDEX `oid`(`oid`) USING BTREE,
  CONSTRAINT `oid` FOREIGN KEY (`oid`) REFERENCES `out1` (`oid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cus
-- ----------------------------

-- ----------------------------
-- Table structure for guide
-- ----------------------------
DROP TABLE IF EXISTS `guide`;
CREATE TABLE `guide`  (
  `gid` int NOT NULL,
  `gname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gstate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gtel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gotime` datetime NULL DEFAULT NULL,
  `willdays` int NULL DEFAULT NULL,
  PRIMARY KEY (`gid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of guide
-- ----------------------------

-- ----------------------------
-- Table structure for massage
-- ----------------------------
DROP TABLE IF EXISTS `massage`;
CREATE TABLE `massage`  (
  `massage_id` int NOT NULL,
  `massage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `oid` int NULL DEFAULT NULL,
  PRIMARY KEY (`massage_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of massage
-- ----------------------------
INSERT INTO `massage` VALUES (1, '上海到南京', 1);

-- ----------------------------
-- Table structure for out1
-- ----------------------------
DROP TABLE IF EXISTS `out1`;
CREATE TABLE `out1`  (
  `oid` int NOT NULL,
  `out1` datetime NULL DEFAULT NULL,
  `back` datetime NULL DEFAULT NULL,
  `gid` int NULL DEFAULT NULL,
  `bid` int NULL DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of out1
-- ----------------------------
INSERT INTO `out1` VALUES (1, '2023-06-15 10:11:43', '2023-06-30 10:11:49', 1, 1);
INSERT INTO `out1` VALUES (2, '2023-07-05 09:12:11', '2023-07-13 10:12:19', 1, 1);
INSERT INTO `out1` VALUES (3, '2023-06-16 10:12:39', '2023-06-22 10:12:42', 2, 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `upw` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
