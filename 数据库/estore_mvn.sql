/*
 Navicat Premium Data Transfer

 Source Server         : estore_mvn
 Source Server Type    : MySQL
 Source Server Version : 50529
 Source Host           : localhost:3306
 Source Schema         : estore_mvn

 Target Server Type    : MySQL
 Target Server Version : 50529
 File Encoding         : 65001

 Date: 23/10/2020 07:22:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for e_book
-- ----------------------------
DROP TABLE IF EXISTS `e_book`;
CREATE TABLE `e_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` float(10, 2) NULL DEFAULT NULL,
  `category_id` int(11) NULL DEFAULT NULL,
  `image` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_book`(`category_id`) USING BTREE,
  CONSTRAINT `fk_book` FOREIGN KEY (`category_id`) REFERENCES `e_category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of e_book
-- ----------------------------
INSERT INTO `e_book` VALUES (1, 'Java EE技术', 81.00, 3, 'book1.jpg');
INSERT INTO `e_book` VALUES (2, 'Spring Cloud微服务实战', 21.15, 3, 'book2.jpg');
INSERT INTO `e_book` VALUES (3, 'Python核心编程', 108.00, 3, 'book3.jpg');
INSERT INTO `e_book` VALUES (4, 'SpringBoot实战', 59.25, 3, 'book4.jpg');
INSERT INTO `e_book` VALUES (5, 'JAVA SERVLET 编程(第二版)', 38.25, 3, 'book5.jpg');
INSERT INTO `e_book` VALUES (6, 'XML高阶编程', 97.20, 3, 'book6.jpg');
INSERT INTO `e_book` VALUES (7, '精通STRUTS:基于MVC的JAVA WEB设计与开发', 36.75, 3, 'book7.jpg');
INSERT INTO `e_book` VALUES (8, '精通HIBERNATE：JAVA对象持久化技术详解', 44.25, 3, 'book8.jpg');
INSERT INTO `e_book` VALUES (9, 'SPRING IN ACTION中文版', 29.25, 3, 'book9.jpg');
INSERT INTO `e_book` VALUES (10, '精通EJB 3.0', 44.25, 3, 'book10.jpg');

-- ----------------------------
-- Table structure for e_category
-- ----------------------------
DROP TABLE IF EXISTS `e_category`;
CREATE TABLE `e_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `father_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of e_category
-- ----------------------------
INSERT INTO `e_category` VALUES (1, '文学类', NULL);
INSERT INTO `e_category` VALUES (2, '教育类', NULL);
INSERT INTO `e_category` VALUES (3, '计算机类', NULL);
INSERT INTO `e_category` VALUES (4, '儿童类', NULL);
INSERT INTO `e_category` VALUES (5, '漫画类', NULL);
INSERT INTO `e_category` VALUES (6, '工具书类', NULL);
INSERT INTO `e_category` VALUES (7, '期刊类', NULL);
INSERT INTO `e_category` VALUES (8, '诗歌', 1);
INSERT INTO `e_category` VALUES (9, '散文', 1);
INSERT INTO `e_category` VALUES (10, '小说', 1);
INSERT INTO `e_category` VALUES (11, '高中', 2);
INSERT INTO `e_category` VALUES (12, '大学', 2);
INSERT INTO `e_category` VALUES (13, '软件', 3);
INSERT INTO `e_category` VALUES (14, '硬件', 3);
INSERT INTO `e_category` VALUES (15, '益智', 4);
INSERT INTO `e_category` VALUES (16, '生活', 4);
INSERT INTO `e_category` VALUES (17, '特长', 4);
INSERT INTO `e_category` VALUES (18, '科幻', 5);
INSERT INTO `e_category` VALUES (19, '冒险', 5);
INSERT INTO `e_category` VALUES (20, '灾难', 5);
INSERT INTO `e_category` VALUES (21, '农业', 6);
INSERT INTO `e_category` VALUES (22, '金融', 6);
INSERT INTO `e_category` VALUES (23, '医学', 6);
INSERT INTO `e_category` VALUES (24, '编程', 7);
INSERT INTO `e_category` VALUES (25, '图像', 7);
INSERT INTO `e_category` VALUES (26, '股市', 7);

-- ----------------------------
-- Table structure for e_customer
-- ----------------------------
DROP TABLE IF EXISTS `e_customer`;
CREATE TABLE `e_customer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `zip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of e_customer
-- ----------------------------
INSERT INTO `e_customer` VALUES (1, 'zhangsan', '124', '2222', '2222', '13611111', '22@22.com');

-- ----------------------------
-- Table structure for e_order
-- ----------------------------
DROP TABLE IF EXISTS `e_order`;
CREATE TABLE `e_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total` float(10, 2) NULL DEFAULT NULL,
  `orderDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `customer_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_order`(`customer_id`) USING BTREE,
  CONSTRAINT `fk_order` FOREIGN KEY (`customer_id`) REFERENCES `e_customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for e_orderline
-- ----------------------------
DROP TABLE IF EXISTS `e_orderline`;
CREATE TABLE `e_orderline`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) NULL DEFAULT NULL,
  `book_id` int(11) NULL DEFAULT NULL,
  `order_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_orderline`(`book_id`) USING BTREE,
  INDEX `fk_orderline_1`(`order_id`) USING BTREE,
  CONSTRAINT `fk_orderline` FOREIGN KEY (`book_id`) REFERENCES `e_book` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_orderline_1` FOREIGN KEY (`order_id`) REFERENCES `e_order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for e_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `e_shopcar`;
CREATE TABLE `e_shopcar`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL DEFAULT 0,
  `book_id` int(11) NOT NULL DEFAULT 0,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `customer_id`(`customer_id`) USING BTREE,
  INDEX `book_id`(`book_id`) USING BTREE,
  CONSTRAINT `shopCar_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `e_customer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `shopCar_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `e_book` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
