/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.5-10.1.16-MariaDB : Database - signup
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`signup` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `signup`;

/*Table structure for table `persson` */

DROP TABLE IF EXISTS `persson`;

CREATE TABLE `persson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `idcard` varchar(25) DEFAULT NULL,
  `political` varchar(20) DEFAULT NULL,
  `photo` text,
  `work` varchar(50) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `punit` varchar(30) DEFAULT NULL,
  `ppost` varchar(10) DEFAULT NULL,
  `education` varchar(10) DEFAULT NULL,
  `degree` varchar(10) DEFAULT NULL,
  `birthday` varchar(10) DEFAULT NULL,
  `degschool` varchar(20) DEFAULT NULL,
  `degmajor` varchar(20) DEFAULT NULL,
  `pother` text,
  `other` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `persson` */

insert  into `persson`(`id`,`name`,`sex`,`idcard`,`political`,`photo`,`work`,`telephone`,`punit`,`ppost`,`education`,`degree`,`birthday`,`degschool`,`degmajor`,`pother`,`other`) values (1,'张三','男','511602199604021150','群众','/photo/511602199604021150.jpg','大连大学','13812345678','大连大学乒乓球中等职业技术学校','教练A','本科','学士','1996-12-12','大连大学','计算机科学与技术',NULL,NULL);

/*Table structure for table `unit` */

DROP TABLE IF EXISTS `unit`;

CREATE TABLE `unit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unit` varchar(20) DEFAULT NULL,
  `post` varchar(10) DEFAULT NULL,
  `education` varchar(20) DEFAULT NULL,
  `degree` varchar(20) DEFAULT NULL,
  `other` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `unit` */

insert  into `unit`(`id`,`unit`,`post`,`education`,`degree`,`other`) values (1,'大连大学','教师D','研究生','硕士及以上','交响乐队指挥'),(2,'大连大学','教师A','研究生','硕士及以上',NULL),(3,'大连中山医院',NULL,NULL,NULL,NULL),(4,'大连大学',NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
