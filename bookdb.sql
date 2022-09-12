/*
 Navicat MySQL Data Transfer

 Source Server         : swx mysql02
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : bookdb

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 12/09/2022 18:06:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookImg` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bookName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT 0.00,
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `saleCount` int(11) NULL DEFAULT NULL,
  `bookCount` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, 'cyuyanrumenjingdian.jpg', 'C语言入门经典', 99.00, '亚历山大', 8, 197);
INSERT INTO `t_book` VALUES (2, 'santi.jpg', '三体', 55.56, '周杰伦', 18, 892);
INSERT INTO `t_book` VALUES (3, 'ailuntulingzhuan.jpg', '艾伦图灵传', 50.00, '刘若英', 12, 143);
INSERT INTO `t_book` VALUES (4, 'bainiangudu.jpg', '百年孤独', 40.00, '王力宏', 3, 98);
INSERT INTO `t_book` VALUES (5, 'biancheng.jpg', '边城', 30.00, '刘德华', 2, 99);
INSERT INTO `t_book` VALUES (6, 'jieyouzahuodian.jpg', '解忧杂货店', 27.00, '东野圭吾', 5, 100);
INSERT INTO `t_book` VALUES (7, 'zhongguozhexueshi.jpg', '中国哲学史', 45.00, '冯友兰', 3, 100);
INSERT INTO `t_book` VALUES (8, 'huranqiri.jpg', '忽然七日', 19.00, '劳伦', 50, 200);
INSERT INTO `t_book` VALUES (9, 'sudongpozhuan.jpg', '苏东坡传', 20.00, '林语堂', 50, 300);
INSERT INTO `t_book` VALUES (10, 'fusang.jpg', '扶桑', 20.00, '严歌岑', 10, 89);
INSERT INTO `t_book` VALUES (11, 'geihaizideshi.jpg', '给孩子的诗', 23.00, '北岛', 5, 99);
INSERT INTO `t_book` VALUES (12, 'geihaizideshi.jpg', '给孩子的诗', 23.00, '北岛', 2, 99);
INSERT INTO `t_book` VALUES (13, 'geihaizideshi.jpg', '给孩子的诗', 23.00, '北岛', 2, 99);
INSERT INTO `t_book` VALUES (16, 'geihaizideshi.jpg', '给孩子的诗', 23.00, '北岛', 4, 99);

-- ----------------------------
-- Table structure for t_cart_item
-- ----------------------------
DROP TABLE IF EXISTS `t_cart_item`;
CREATE TABLE `t_cart_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book` int(11) NULL DEFAULT NULL,
  `buyCount` int(11) NULL DEFAULT NULL,
  `userBean` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_cart_book`(`book`) USING BTREE,
  INDEX `FK_cart_user`(`userBean`) USING BTREE,
  CONSTRAINT `FK_cart_book` FOREIGN KEY (`book`) REFERENCES `t_book` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_cart_user` FOREIGN KEY (`userBean`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_cart_item
-- ----------------------------
INSERT INTO `t_cart_item` VALUES (44, 8, 1, 2);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `orderDate` datetime NULL DEFAULT NULL,
  `orderUser` int(11) NULL DEFAULT NULL,
  `orderMoney` double(10, 2) NULL DEFAULT NULL,
  `orderStatus` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `orderNo`(`orderNo`) USING BTREE,
  INDEX `FK_order_user`(`orderUser`) USING BTREE,
  CONSTRAINT `FK_order_user` FOREIGN KEY (`orderUser`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (2, '99eb7fe8-7c95-4df1-aece-5a960170560320220817190435', '2022-08-17 19:04:36', 2, 55.56, 0);
INSERT INTO `t_order` VALUES (40, '70567e46-ac0f-4979-97c6-ebbbcd766f6920220817190446', '2022-08-17 19:04:47', 29, 90.00, 0);
INSERT INTO `t_order` VALUES (41, 'e8069ff0-ae95-49df-84b2-7f5dd633bc6920220826102849', '2022-08-26 10:28:49', 29, 117.56, 0);
INSERT INTO `t_order` VALUES (42, '470d2564-43c9-4904-a495-5f1aec2430f620220826102851', '2022-08-26 10:28:51', 28, 117.56, 0);
INSERT INTO `t_order` VALUES (43, '1959eb04-dba1-4952-9600-5f4f968f936720220826102930', '2022-08-26 10:29:30', 29, 40.00, 0);
INSERT INTO `t_order` VALUES (44, '21c32cf4-8d63-41ef-8e06-88e045a988f320220826102948', '2022-08-26 10:29:49', 28, 154.56, 0);
INSERT INTO `t_order` VALUES (45, '39f5ab04-50df-498e-afe2-df03ac9911fc20220826183142', '2022-08-26 18:31:43', 29, 50.00, 0);
INSERT INTO `t_order` VALUES (46, '726375a3-fbad-49a8-8bb9-d2bf370ab2e520220826183155', '2022-08-26 18:31:55', 29, 50.00, 0);
INSERT INTO `t_order` VALUES (47, '8a472d03-ae84-4075-aafa-b9985fba2bfc20220826183157', '2022-08-26 18:31:57', 29, 50.00, 0);
INSERT INTO `t_order` VALUES (48, '8846c19e-3fa8-436c-a645-0a72e42e03fc20220830212031', '2022-08-30 21:20:32', 30, 105.56, 0);
INSERT INTO `t_order` VALUES (49, '096a613a-a57b-4b78-a40e-ec0af8fea95a20220830212105', '2022-08-30 21:21:05', 30, 86.00, 0);
INSERT INTO `t_order` VALUES (50, 'a8dfb551-5c93-4d92-ad61-2816d6870c6020220910153851', '2022-09-10 07:38:51', 2, 74.56, 0);
INSERT INTO `t_order` VALUES (51, '990aa102-39dd-4325-b0e0-ab03a47d3f2b20220910153924', '2022-09-10 07:39:24', 2, 20.00, 0);
INSERT INTO `t_order` VALUES (52, '8d5adf2e-a703-4730-826b-7bc7d46c902c20220910175305', '2022-09-10 09:53:06', 2, 95.00, 0);
INSERT INTO `t_order` VALUES (53, '54567fa2-b8ec-4641-b70e-2fcd4ae5957620220910185030', '2022-09-10 10:50:31', 2, 970.56, 0);
INSERT INTO `t_order` VALUES (54, 'f5c04cf1-a448-4ec4-861b-5f638ae5466520220911214829', '2022-09-11 13:48:30', 2, 596.00, 0);

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book` int(11) NULL DEFAULT NULL,
  `buyCount` int(11) NULL DEFAULT NULL,
  `orderBean` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_detail_book`(`book`) USING BTREE,
  INDEX `FK_detail_order`(`orderBean`) USING BTREE,
  CONSTRAINT `FK_detail_book` FOREIGN KEY (`book`) REFERENCES `t_book` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_detail_order` FOREIGN KEY (`orderBean`) REFERENCES `t_order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
INSERT INTO `t_order_item` VALUES (1, 2, 3, 2);
INSERT INTO `t_order_item` VALUES (2, 1, 5, 2);
INSERT INTO `t_order_item` VALUES (3, 2, 1, 50);
INSERT INTO `t_order_item` VALUES (4, 8, 1, 50);
INSERT INTO `t_order_item` VALUES (5, 9, 1, 51);
INSERT INTO `t_order_item` VALUES (6, 3, 1, 52);
INSERT INTO `t_order_item` VALUES (7, 7, 1, 52);
INSERT INTO `t_order_item` VALUES (8, 2, 1, 53);
INSERT INTO `t_order_item` VALUES (9, 4, 21, 53);
INSERT INTO `t_order_item` VALUES (10, 5, 1, 53);
INSERT INTO `t_order_item` VALUES (11, 7, 1, 53);
INSERT INTO `t_order_item` VALUES (12, 1, 4, 54);
INSERT INTO `t_order_item` VALUES (13, 3, 4, 54);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uname`(`uname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, ' swx', 'swx', 'lina@sina.com.cn', 0);
INSERT INTO `t_user` VALUES (2, 'kate', 'ok', 'hello_kate@126.com', 1);
INSERT INTO `t_user` VALUES (3, '鸠摩智', 'ok', 'jiujiu@126.com', 0);
INSERT INTO `t_user` VALUES (4, '宝2021', 'ok', 'bao2021@sohu.com.cn', 0);
INSERT INTO `t_user` VALUES (5, '宝2022', '123', 'bao2022@sohu.com.cn', 0);
INSERT INTO `t_user` VALUES (17, 'cyx', 'cyx', 'swx@123.com', 0);
INSERT INTO `t_user` VALUES (18, 'lfy', 'lfy', 'lfy@qq.com', 0);
INSERT INTO `t_user` VALUES (19, 'lyx', 'lyx', 'lyx@qq.com', 0);
INSERT INTO `t_user` VALUES (28, 'sxy', 'sxy', 'czy@qq.com', 0);
INSERT INTO `t_user` VALUES (29, 'dcndcn', '123123123', 'dcn@qq.com', 0);
INSERT INTO `t_user` VALUES (30, 'sxysxy', '123123123', '123@qq.com', 0);

SET FOREIGN_KEY_CHECKS = 1;
