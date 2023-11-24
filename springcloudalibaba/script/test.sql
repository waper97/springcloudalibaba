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

 Date: 24/11/2023 11:14:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `request_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `business_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '业务名称',
  `request_params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '数据',
  `request_body` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `original_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `request_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `response_time` bigint NULL DEFAULT NULL,
  `interface_response_time` bigint NULL DEFAULT NULL,
  `create_time` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '日志表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
