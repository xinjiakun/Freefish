/*
 Navicat Premium Data Transfer

 Source Server         : testdemo
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : freefish

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 14/02/2020 21:11:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `good_id` int(20) NOT NULL COMMENT '商品id',
  `from_user_id` int(20) NOT NULL COMMENT '评论用户id',
  `to_user_id` int(20) NULL DEFAULT NULL COMMENT '评论to用户id',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '评论内容',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `parent_id` int(20) NULL DEFAULT NULL COMMENT '顶级父评论id(无父评论填0)',
  PRIMARY KEY (`id`, `good_id`, `from_user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES (1, 1, 1, 0, 'nice ', '2020-02-14 21:07:54', 0);
INSERT INTO `tb_comment` VALUES (2, 1, 2, 1, '还不错', '2020-02-14 21:09:26', 1);

-- ----------------------------
-- Table structure for tb_good
-- ----------------------------
DROP TABLE IF EXISTS `tb_good`;
CREATE TABLE `tb_good`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sku_id` int(20) NULL DEFAULT NULL COMMENT '商品编号',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标题\r\n',
  `sub_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品介绍',
  `ali_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品主图',
  `price` int(10) NULL DEFAULT NULL COMMENT '商品价格',
  `ali_images_1` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用图1',
  `ali_images_2` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用图2',
  `ali_images_3` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用图3',
  `ali_images_4` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备用图4',
  `type_ob` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '类别',
  `old_or` int(10) NULL DEFAULT NULL COMMENT '新旧程度',
  `score` float(10, 1) NULL DEFAULT NULL COMMENT '分数',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `user_id` int(20) NOT NULL COMMENT '上传商品用户id',
  PRIMARY KEY (`id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_good
-- ----------------------------
INSERT INTO `tb_good` VALUES (1, 100027101, '坚果 Pro 软胶保护套1', 'TPU 环保材质、耐磨、耐油、耐久性强1', 'http://image.smartisanos.cn/resource/902befd5f32a8caf4ca79b55d39ee25a.jpg', 49, 'http://image.smartisanos.cn/resource/ca760e50409c796a4e770c54554f92bf.jpg', 'http://image.smartisanos.cn/resource/493c65d42fe83ec3daaf058d79fc1a95.jpg', 'http://image.smartisanos.cn/resource/0bf30081dd17431c4fdfbd237c53743f.jpg', 'http://image.smartisanos.cn/resource/cba7b4cdb2fc41d7f29fb45d94972e41.jpg', '配件', 7, 4.5, '2020-02-14 16:48:08', '2020-02-14 16:48:14', 1);
INSERT INTO `tb_good` VALUES (2, 100027102, '坚果 Pro 软胶保护套2', 'TPU 环保材质、耐磨、耐油、耐久性强2', 'http://image.smartisanos.cn/resource/902befd5f32a8caf4ca79b55d39ee25a.jpg', 43, 'http://image.smartisanos.cn/resource/ca760e50409c796a4e770c54554f92bf.jpg', 'http://image.smartisanos.cn/resource/493c65d42fe83ec3daaf058d79fc1a95.jpg', 'http://image.smartisanos.cn/resource/0bf30081dd17431c4fdfbd237c53743f.jpg', 'http://image.smartisanos.cn/resource/cba7b4cdb2fc41d7f29fb45d94972e41.jpg', '配件', 5, 5.0, '2020-02-14 15:48:08', '2020-02-14 16:48:14', 1);
INSERT INTO `tb_good` VALUES (3, 100027103, '坚果 Pro 软胶保护套3', 'TPU 环保材质、耐磨、耐油、耐久性强3', 'http://image.smartisanos.cn/resource/902befd5f32a8caf4ca79b55d39ee25a.jpg', 491, 'http://image.smartisanos.cn/resource/ca760e50409c796a4e770c54554f92bf.jpg', 'http://image.smartisanos.cn/resource/493c65d42fe83ec3daaf058d79fc1a95.jpg', 'http://image.smartisanos.cn/resource/0bf30081dd17431c4fdfbd237c53743f.jpg', 'http://image.smartisanos.cn/resource/cba7b4cdb2fc41d7f29fb45d94972e41.jpg', '配件', 10, 2.3, '2020-02-14 18:48:08', '2020-02-14 19:48:14', 1);
INSERT INTO `tb_good` VALUES (4, 100027104, '坚果 Pro 软胶保护套4', 'TPU 环保材质、耐磨、耐油、耐久性强4', 'http://image.smartisanos.cn/resource/902befd5f32a8caf4ca79b55d39ee25a.jpg', 21, 'http://image.smartisanos.cn/resource/ca760e50409c796a4e770c54554f92bf.jpg', 'http://image.smartisanos.cn/resource/493c65d42fe83ec3daaf058d79fc1a95.jpg', 'http://image.smartisanos.cn/resource/0bf30081dd17431c4fdfbd237c53743f.jpg', 'http://image.smartisanos.cn/resource/cba7b4cdb2fc41d7f29fb45d94972e41.jpg', '配件', 5, 4.0, '2020-02-14 17:48:08', '2020-02-14 18:48:14', 1);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
  `headImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户头像',
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'xjk', 'https://ae01.alicdn.com/kf/Hd60a3f7c06fd47ae85624badd32ce54dv.jpg', '15226505320');
INSERT INTO `tb_user` VALUES (2, 'xinjiakun', 'https://ae01.alicdn.com/kf/Hd60a3f7c06fd47ae85624badd32ce54dv.jpg', '12345654325');

SET FOREIGN_KEY_CHECKS = 1;
