/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : startup_backend

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 22/10/2021 16:58:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `meta` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` tinyint(10) NULL DEFAULT NULL,
  `p_id` bigint(20) NULL DEFAULT NULL,
  `hidden` bit(1) NULL DEFAULT NULL,
  `redirect` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cache` bit(1) NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` int(10) NULL DEFAULT NULL,
  `level` tinyint(10) NULL DEFAULT NULL,
  `enabled` tinyint(10) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '/system', 'Layout', '系统管理', '', 0, NULL, b'0', 'noredirect', b'1', 'el-icon-s-home', NULL, 1, 0, 1, '2021-10-08 17:09:05', '2021-10-08 17:09:05');
INSERT INTO `sys_menu` VALUES (2, 'user', 'user/index', '用户管理', '', 1, 1, b'0', '', b'1', 'el-icon-user', NULL, 2, 1, 1, '2021-10-07 16:33:19', '2021-10-07 16:33:19');
INSERT INTO `sys_menu` VALUES (3, 'role', 'role/index', '角色管理', '', 1, 1, b'0', '', b'1', 'el-icon-user-solid', NULL, 3, 1, 1, '2021-10-07 16:33:26', '2021-10-07 16:33:26');
INSERT INTO `sys_menu` VALUES (4, 'menu', 'menu/index', '菜单管理', '', 1, 1, b'0', '', b'1', 'el-icon-menu', NULL, 4, 1, 1, '2021-10-07 16:28:58', '2021-10-07 16:28:58');
INSERT INTO `sys_menu` VALUES (5, '/setting', 'Layout', '系统配置', NULL, NULL, NULL, NULL, NULL, NULL, 'el-icon-s-management', NULL, 2, NULL, 0, '2021-10-21 16:19:29', '2021-10-21 16:19:29');
INSERT INTO `sys_menu` VALUES (6, '12', '1222', '2', NULL, NULL, 5, NULL, NULL, NULL, 'el-icon-s-order', NULL, 0, NULL, 0, '2021-10-21 14:21:36', '2021-10-21 14:21:36');
INSERT INTO `sys_menu` VALUES (7, '3', '3', '3', NULL, NULL, 5, NULL, NULL, NULL, 'el-icon-s-cooperation', NULL, 1, NULL, 0, '2021-10-21 14:21:36', '2021-10-21 14:21:36');
INSERT INTO `sys_menu` VALUES (8, 'param', 'param/index', '参数设置', NULL, NULL, 5, NULL, NULL, NULL, 'el-icon-bicycle', NULL, 1, NULL, 0, '2021-10-21 16:21:04', '2021-10-21 16:21:04');
INSERT INTO `sys_menu` VALUES (9, '1', '1', '1', NULL, NULL, 5, NULL, NULL, NULL, 'el-icon-delete-solid', NULL, 1, NULL, 0, '2021-10-21 16:19:29', '2021-10-21 16:19:29');
INSERT INTO `sys_menu` VALUES (10, '2', '2', '2', NULL, NULL, 5, NULL, NULL, NULL, 'el-icon-s-order', NULL, 2, NULL, 0, '2021-10-21 16:19:29', '2021-10-21 16:19:29');
INSERT INTO `sys_menu` VALUES (11, '/setting', 'Layout', '系统设置', NULL, NULL, 1, NULL, NULL, NULL, 'el-icon-setting', NULL, 2, NULL, 0, '2021-10-22 15:44:35', '2021-10-22 15:44:35');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL,
  `menu_id` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, 1, 1, '2021-08-24 17:09:00');
INSERT INTO `sys_permission` VALUES (2, 1, 2, '2021-08-24 17:09:12');
INSERT INTO `sys_permission` VALUES (3, 1, 3, '2021-08-24 17:09:20');
INSERT INTO `sys_permission` VALUES (4, 1, 4, '2021-10-07 15:49:53');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` tinyint(4) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', '管理员', '系统管理员角色', 1, '2021-08-24 16:48:11', '2021-08-24 16:48:14');
INSERT INTO `sys_role` VALUES (2, 'user', '普通用户', '普通用', 1, '2021-09-15 11:52:56', '2021-09-15 11:52:56');
INSERT INTO `sys_role` VALUES (3, 'purchase-admin', '采购主管', '普通用户角', 0, '2021-09-16 17:40:07', '2021-09-16 17:40:07');
INSERT INTO `sys_role` VALUES (4, 'sales-admin', '销售主管', '普通用户角色普通用户角色普通用户角色', 0, '2021-09-16 17:43:51', '2021-09-16 17:43:51');
INSERT INTO `sys_role` VALUES (5, 'sales', '业务员', '普通用户角色普通用户角色普通用户角色', 1, '2021-09-15 11:58:39', '2021-09-15 11:58:39');
INSERT INTO `sys_role` VALUES (6, NULL, NULL, NULL, 0, '2021-09-17 15:24:22', '2021-09-17 15:24:22');
INSERT INTO `sys_role` VALUES (7, NULL, NULL, NULL, 0, '2021-09-17 15:25:26', '2021-09-17 15:25:26');
INSERT INTO `sys_role` VALUES (8, '12', '21', '12', 0, '2021-09-17 15:27:46', '2021-09-17 15:27:46');
INSERT INTO `sys_role` VALUES (9, '1q', '业务员', NULL, 0, '2021-09-17 15:28:55', '2021-09-17 15:28:55');
INSERT INTO `sys_role` VALUES (10, 'user1', '用户1', NULL, 0, '2021-09-17 15:38:38', '2021-09-17 15:38:38');
INSERT INTO `sys_role` VALUES (11, 'salesManager', '业务主管', '业务部的主管', 1, '2021-09-22 16:36:57', '2021-09-22 16:36:57');
INSERT INTO `sys_role` VALUES (12, 'pur', '采购员', NULL, 0, '2021-09-22 16:41:17', '2021-09-22 16:41:17');
INSERT INTO `sys_role` VALUES (13, 'pur', '采购员', '123', 0, '2021-09-22 16:41:56', '2021-09-22 16:41:56');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` int(11) NULL DEFAULT NULL COMMENT '0-未知 1-male 2-female',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` int(11) NULL DEFAULT 1 COMMENT '1-激活 0-禁用',
  `last_password_reset_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (15, 'admin@163.com', '$2a$10$IwBWyl/qV6QWXbJ9QQ4iXuQctM..54V.NNH0k/RzuuCQ8x8IPbp1O', '管理员', 1, 'image\\avatar-202108230445150.png', '黄浦区', '上海市', '市辖区', 'zhuhuix@163.com', '13214412313', NULL, 1, NULL, '2021-08-17 15:38:30', '2021-09-29 16:35:44');
INSERT INTO `sys_user` VALUES (16, 'user@163.com', '$2a$10$IwBWyl/qV6QWXbJ9QQ4iXuQctM..54V.NNH0k/RzuuCQ8x8IPbp1O', '张三', 2, '', '朝阳区', '北京市', '市辖区', 'user@163.com', '1237895556', NULL, 1, NULL, '2021-09-17 15:38:30', '2021-09-29 13:18:49');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `role_id` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (17, 15, 1, '2021-09-30 16:36:12');
INSERT INTO `sys_user_role` VALUES (18, 15, 2, '2021-09-30 16:36:12');
INSERT INTO `sys_user_role` VALUES (19, 16, 2, '2021-10-06 12:28:50');
INSERT INTO `sys_user_role` VALUES (20, 16, 5, '2021-10-06 12:28:50');

-- ----------------------------
-- Table structure for upload_file
-- ----------------------------
DROP TABLE IF EXISTS `upload_file`;
CREATE TABLE `upload_file`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件实际名称',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `primary_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件主名',
  `extension` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件扩展名',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存放路径',
  `size` bigint(100) NULL DEFAULT NULL COMMENT '大小',
  `uploader` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9276 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
