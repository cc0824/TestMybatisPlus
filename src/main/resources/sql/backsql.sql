/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.17 : Database - mybatis_plus
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatis_plus` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mybatis_plus`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `NAME` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `deleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`NAME`,`age`,`email`,`create_time`,`update_time`,`version`,`deleted`) values (1,'Jone',18,'test1@baomidou.com',NULL,NULL,NULL,NULL),(2,'Jack',20,'test2@baomidou.com',NULL,NULL,NULL,NULL),(3,'Tom',28,'test3@baomidou.com',NULL,NULL,NULL,NULL),(4,'Sandy',21,'test4@baomidou.com',NULL,NULL,NULL,NULL),(1395299376172863490,'lucymary2',20,'1243@qq.com',NULL,'2021-05-21 16:38:23',NULL,NULL),(1395660120135528450,'lucy2',20,'1243@qq.com','2021-05-21 16:37:57','2021-05-21 16:37:57',NULL,NULL),(1401731426140463106,'新张三',20,'1243@qq.com','2021-06-07 10:43:10','2021-06-07 10:43:44',2,NULL),(1402186061695324161,'王五六',20,'1243@qq.com','2021-06-08 16:49:43','2021-06-08 16:49:43',1,NULL),(1402187049806303233,'王六',20,'1243@qq.com','2021-06-08 16:53:39','2021-06-08 16:53:39',1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
