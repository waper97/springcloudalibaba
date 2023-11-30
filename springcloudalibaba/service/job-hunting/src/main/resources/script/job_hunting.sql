/*
 Navicat Premium Data Transfer

 Source Server         : docker-mysql 192.168.128.128
 Source Server Type    : MySQL
 Source Server Version : 80027 (8.0.27)
 Source Host           : 192.168.128.128:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80027 (8.0.27)
 File Encoding         : 65001

 Date: 30/11/2023 17:25:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for job_hunting
-- ----------------------------
DROP TABLE IF EXISTS `job_hunting`;
CREATE TABLE `job_hunting`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  `salary` decimal(10, 2) NULL DEFAULT NULL COMMENT '薪资',
  `birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '生日',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '找工作' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of job_hunting
-- ----------------------------
INSERT INTO `job_hunting` VALUES (1, '王鹏', 26, '18302392883', 5.00, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
