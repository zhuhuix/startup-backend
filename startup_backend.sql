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

 Date: 15/06/2022 08:27:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bbs
-- ----------------------------
DROP TABLE IF EXISTS `bbs`;
CREATE TABLE `bbs`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言人昵称',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '留言内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `replied` bit(1) NULL DEFAULT NULL COMMENT '是否回复',
  `reply_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复人名称',
  `reply_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '回复内容',
  `reply_time` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  `enabled` bit(1) NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 136 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bbs
-- ----------------------------
INSERT INTO `bbs` VALUES (126, 'zhuhuix', NULL, '这是第一条留言', '2022-06-10 16:04:53', b'0', NULL, NULL, NULL, b'1');
INSERT INTO `bbs` VALUES (127, '小刚', NULL, '想学习vue', '2022-06-10 16:05:08', b'0', NULL, NULL, NULL, b'0');
INSERT INTO `bbs` VALUES (128, '小红', NULL, '测试留言板功能', '2022-06-10 16:16:14', b'1', '管理员', '芪', '2022-06-10 16:16:14', b'0');
INSERT INTO `bbs` VALUES (129, '小李', NULL, '天天学习，好好向上', '2022-06-10 16:07:21', b'1', '管理员', NULL, NULL, b'0');
INSERT INTO `bbs` VALUES (130, '小明', NULL, '希望得到礼物！', '2022-06-10 16:19:17', b'1', '管理员', 'OK', '2022-06-10 16:20:23', b'0');
INSERT INTO `bbs` VALUES (131, '小明', NULL, '希望得到礼物！', '2022-06-10 16:19:18', b'1', '管理员', '', '2022-06-10 16:22:58', b'0');
INSERT INTO `bbs` VALUES (132, '小刚', NULL, '测试', '2022-06-10 16:45:14', b'1', '管理员', '23', '2022-06-11 07:54:03', b'0');
INSERT INTO `bbs` VALUES (133, '小李', NULL, '输入一条留言', '2022-06-10 16:48:07', b'1', '管理员', '欢迎', '2022-06-10 16:52:10', b'1');
INSERT INTO `bbs` VALUES (134, '小红', NULL, '希望尽快得到回复', '2022-06-13 16:23:03', b'1', '管理员', '好的，非常感谢留言', '2022-06-15 08:17:45', b'1');
INSERT INTO `bbs` VALUES (135, '小明', NULL, '测试一下留言是否正常', '2022-06-15 08:23:55', b'1', '管理员', '好的，非常感谢', '2022-06-15 08:24:46', b'1');

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
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '/system', 'Layout', '系统管理', '', 0, NULL, b'0', 'noredirect', b'1', 'el-icon-s-home', NULL, 1, 0, 1, '2021-10-08 17:09:05', '2021-10-08 17:09:05');
INSERT INTO `sys_menu` VALUES (2, 'user', 'user/index', '用户管理', '', 1, 1, b'0', '', b'1', 'el-icon-user', NULL, 2, 1, 1, '2021-11-15 14:08:47', '2021-11-15 14:08:47');
INSERT INTO `sys_menu` VALUES (3, 'role', 'role/index', '角色管理', '', 1, 1, b'0', '', b'1', 'el-icon-user-solid', NULL, 3, 1, 1, '2021-10-07 16:33:26', '2021-10-07 16:33:26');
INSERT INTO `sys_menu` VALUES (4, 'menu', 'menu/index', '菜单管理', '', 1, 1, b'0', '', b'1', 'el-icon-menu', NULL, 4, 1, 1, '2021-10-07 16:28:58', '2021-10-07 16:28:58');
INSERT INTO `sys_menu` VALUES (5, '/setting', 'Layout', '系统配置', NULL, NULL, NULL, NULL, NULL, NULL, 'el-icon-s-management', NULL, 2, NULL, 0, '2021-10-21 16:19:29', '2021-10-21 16:19:29');
INSERT INTO `sys_menu` VALUES (6, '12', '1222', '2', NULL, NULL, 5, NULL, NULL, NULL, 'el-icon-s-order', NULL, 0, NULL, 0, '2021-10-21 14:21:36', '2021-10-21 14:21:36');
INSERT INTO `sys_menu` VALUES (7, '3', '3', '3', NULL, NULL, 5, NULL, NULL, NULL, 'el-icon-s-cooperation', NULL, 1, NULL, 0, '2021-10-21 14:21:36', '2021-10-21 14:21:36');
INSERT INTO `sys_menu` VALUES (8, 'param', 'param/index', '参数设置', NULL, NULL, 5, NULL, NULL, NULL, 'el-icon-bicycle', NULL, 1, NULL, 0, '2021-10-21 16:21:04', '2021-10-21 16:21:04');
INSERT INTO `sys_menu` VALUES (9, '1', '1', '1', NULL, NULL, 5, NULL, NULL, NULL, 'el-icon-delete-solid', NULL, 1, NULL, 0, '2021-10-21 16:19:29', '2021-10-21 16:19:29');
INSERT INTO `sys_menu` VALUES (10, '2', '2', '2', NULL, NULL, 5, NULL, NULL, NULL, 'el-icon-s-order', NULL, 2, NULL, 0, '2021-10-21 16:19:29', '2021-10-21 16:19:29');
INSERT INTO `sys_menu` VALUES (11, '/setting', 'Layout', '系统设置', NULL, NULL, 1, NULL, NULL, NULL, 'el-icon-setting', NULL, 2, NULL, 0, '2021-10-22 15:44:35', '2021-10-22 15:44:35');
INSERT INTO `sys_menu` VALUES (12, '/setting', 'Layout', '系统配置', NULL, NULL, NULL, NULL, NULL, NULL, 'el-icon-s-cooperation', NULL, 2, NULL, 0, '2021-10-27 09:47:56', '2021-10-27 09:47:56');
INSERT INTO `sys_menu` VALUES (13, 'product', '/product/index', '商品配置', NULL, NULL, 12, NULL, NULL, NULL, 'el-icon-notebook-2', NULL, 1, NULL, 0, '2021-10-27 09:47:56', '2021-10-27 09:47:56');
INSERT INTO `sys_menu` VALUES (14, 'detail', 'goods_detail/index', '明细配置', NULL, NULL, 12, NULL, NULL, NULL, 'el-icon-s-unfold', NULL, 2, NULL, 0, '2021-10-27 09:47:56', '2021-10-27 09:47:56');
INSERT INTO `sys_menu` VALUES (15, '/wms', 'Layout', '库存管理', NULL, NULL, NULL, b'0', NULL, NULL, 'el-icon-house', NULL, 0, NULL, 0, '2021-10-27 08:46:42', '2021-10-27 08:46:42');
INSERT INTO `sys_menu` VALUES (16, 'inout', 'wms/inout/index', '商品进出', NULL, NULL, 15, NULL, NULL, NULL, 'el-icon-shopping-cart-2', NULL, 1, NULL, 0, '2021-10-26 17:49:23', '2021-10-26 17:49:23');
INSERT INTO `sys_menu` VALUES (17, 'inout', 'wms/inout', '商品进出', NULL, NULL, 15, NULL, NULL, NULL, 'el-icon-eleme', NULL, 2, NULL, 0, '2021-10-27 08:46:42', '2021-10-27 08:46:42');
INSERT INTO `sys_menu` VALUES (18, '/bussiness', 'Layout', '业务功能', NULL, NULL, NULL, b'0', NULL, NULL, 'el-icon-upload', NULL, 3, NULL, 0, '2021-10-27 09:47:56', '2021-10-27 09:47:56');
INSERT INTO `sys_menu` VALUES (19, 'goodsin', 'business/goodsin', '商品入库', NULL, NULL, 18, NULL, NULL, NULL, 'el-icon-s-promotion', NULL, 2, NULL, 0, '2021-10-27 09:47:56', '2021-10-27 09:47:56');
INSERT INTO `sys_menu` VALUES (20, '/manager', 'Layout', '系统运维', NULL, NULL, NULL, b'0', NULL, NULL, 'el-icon-s-help', NULL, 3, NULL, 0, '2021-10-27 09:47:56', '2021-10-27 09:47:56');
INSERT INTO `sys_menu` VALUES (21, 'data', 'manager/data', '数据管理', NULL, NULL, 20, NULL, NULL, NULL, 'el-icon-s-management', NULL, 2, NULL, 0, '2021-10-27 09:47:56', '2021-10-27 09:47:56');
INSERT INTO `sys_menu` VALUES (22, '/setting', 'Layout', '系统配置', NULL, NULL, NULL, NULL, NULL, NULL, 'el-icon-upload', NULL, 2, NULL, 1, '2021-10-27 15:59:21', '2021-10-27 15:59:21');
INSERT INTO `sys_menu` VALUES (23, 'goods', 'goods/index', '商品配置', NULL, NULL, 22, NULL, NULL, NULL, 'el-icon-s-shop', NULL, 1, NULL, 1, '2021-10-27 15:59:54', '2021-10-27 15:59:54');
INSERT INTO `sys_menu` VALUES (24, 'bbs', 'bbs/admin', '留言管理', NULL, NULL, 1, NULL, NULL, NULL, 'el-icon-chat-line-square', NULL, 5, NULL, 1, '2022-06-10 13:46:08', '2022-06-10 13:46:08');

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
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (78, 2, 22, '2021-10-27 17:30:17');
INSERT INTO `sys_permission` VALUES (79, 2, 23, '2021-10-27 17:30:17');
INSERT INTO `sys_permission` VALUES (84, 11, 1, '2022-03-24 16:40:00');
INSERT INTO `sys_permission` VALUES (85, 11, 2, '2022-03-24 16:40:00');
INSERT INTO `sys_permission` VALUES (86, 11, 4, '2022-03-24 16:40:00');
INSERT INTO `sys_permission` VALUES (87, 1, 1, '2022-06-10 13:46:44');
INSERT INTO `sys_permission` VALUES (88, 1, 2, '2022-06-10 13:46:44');
INSERT INTO `sys_permission` VALUES (89, 1, 3, '2022-06-10 13:46:45');
INSERT INTO `sys_permission` VALUES (90, 1, 4, '2022-06-10 13:46:45');
INSERT INTO `sys_permission` VALUES (91, 1, 22, '2022-06-10 13:46:45');
INSERT INTO `sys_permission` VALUES (92, 1, 23, '2022-06-10 13:46:45');
INSERT INTO `sys_permission` VALUES (93, 1, 24, '2022-06-10 13:46:45');

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
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `sys_role` VALUES (14, 'aa', 'aa', 'aaaaaa', 0, '2022-03-24 16:47:01', '2022-03-24 16:47:01');

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
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (15, 'admin@163.com', '$2a$10$IwBWyl/qV6QWXbJ9QQ4iXuQctM..54V.NNH0k/RzuuCQ8x8IPbp1O', '管理员', 1, 'image\\avatar-202108230445150.png', '', '上海市', '', 'zhuhuix@163.com', '13214412313', NULL, 1, NULL, '2021-08-17 15:38:30', '2021-09-29 16:35:44');
INSERT INTO `sys_user` VALUES (16, 'user@163.com', '$2a$10$IwBWyl/qV6QWXbJ9QQ4iXuQctM..54V.NNH0k/RzuuCQ8x8IPbp1O', '张三', 2, '', '', '北京市', '', 'user@163.com', '13901299901', NULL, 1, NULL, '2021-09-17 15:38:30', '2021-09-29 13:18:49');
INSERT INTO `sys_user` VALUES (17, 'a@163.com', '$2a$10$IwBWyl/qV6QWXbJ9QQ4iXuQctM..54V.NNH0k/RzuuCQ8x8IPbp1O', '李四', 1, '', '', '重庆市', '', 'user@163.com', '15890293112', NULL, 1, NULL, '2021-09-17 15:38:30', '2021-09-29 13:18:49');
INSERT INTO `sys_user` VALUES (18, 'b@163.com', '$2a$10$IwBWyl/qV6QWXbJ9QQ4iXuQctM..54V.NNH0k/RzuuCQ8x8IPbp1O', '王五', 2, '', '', '江苏省', '', 'user@163.com', '13450929131', NULL, 1, NULL, '2021-09-17 15:38:30', '2021-09-29 13:18:49');
INSERT INTO `sys_user` VALUES (19, 'c@163.com', '$2a$10$IwBWyl/qV6QWXbJ9QQ4iXuQctM..54V.NNH0k/RzuuCQ8x8IPbp1O', '赵六', 1, '', '', '山东省', '', 'user@163.com', '13689302321', NULL, 1, NULL, '2021-09-17 15:38:30', '2021-09-29 13:18:49');
INSERT INTO `sys_user` VALUES (20, 'd@163.com', '$2a$10$IwBWyl/qV6QWXbJ9QQ4iXuQctM..54V.NNH0k/RzuuCQ8x8IPbp1O', '朱七', 2, '', '', '广东省', '', 'user@163.com', '13788899221', NULL, 1, NULL, '2021-09-17 15:38:30', '2021-09-29 13:18:49');
INSERT INTO `sys_user` VALUES (21, 'e@163.com', '$2a$10$IwBWyl/qV6QWXbJ9QQ4iXuQctM..54V.NNH0k/RzuuCQ8x8IPbp1O', '高八', 1, '', '', '福建省', '', 'user@163.com', '13567889000', NULL, 1, NULL, '2021-09-17 15:38:30', '2021-09-29 13:18:49');
INSERT INTO `sys_user` VALUES (22, 'f@163.com', '$2a$10$IwBWyl/qV6QWXbJ9QQ4iXuQctM..54V.NNH0k/RzuuCQ8x8IPbp1O', '秦九', 2, '', '', '湖南省', '', 'user@163.com', '13488442166', NULL, 1, NULL, '2021-09-17 15:38:30', '2021-09-29 13:18:49');
INSERT INTO `sys_user` VALUES (23, 'g@163.com', '$2a$10$IwBWyl/qV6QWXbJ9QQ4iXuQctM..54V.NNH0k/RzuuCQ8x8IPbp1O', '马十', 1, '', '', '湖北省', '', 'user@163.com', '13452334454', NULL, 1, NULL, '2021-09-17 15:38:30', '2021-09-29 13:18:49');
INSERT INTO `sys_user` VALUES (24, 'h@163.com', '$2a$10$IwBWyl/qV6QWXbJ9QQ4iXuQctM..54V.NNH0k/RzuuCQ8x8IPbp1O', '崔十一', 2, '', '', '江西省', '', 'user@163.com', '13567889902', NULL, 1, NULL, '2021-09-17 15:38:30', '2021-09-29 13:18:49');
INSERT INTO `sys_user` VALUES (25, 'i@163.com', '$2a$10$IwBWyl/qV6QWXbJ9QQ4iXuQctM..54V.NNH0k/RzuuCQ8x8IPbp1O', '李十二', 1, '', '', '吉林省', '', 'user@163.com', '15908666544', NULL, 1, NULL, '2021-09-17 15:38:30', '2021-09-29 13:18:49');

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
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (21, 15, 1, '2021-10-27 09:48:19');
INSERT INTO `sys_user_role` VALUES (22, 16, 2, '2022-04-07 17:26:18');
INSERT INTO `sys_user_role` VALUES (23, 16, 5, '2022-04-07 17:26:18');
INSERT INTO `sys_user_role` VALUES (24, 16, 11, '2022-04-07 17:26:18');

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
) ENGINE = InnoDB AUTO_INCREMENT = 9277 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
