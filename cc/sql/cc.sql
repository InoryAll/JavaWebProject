/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.16-log : Database - cc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cc` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `cc`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` varchar(8) COLLATE utf8_unicode_ci NOT NULL COMMENT 'id',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `email` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `tel` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电话',
  `gender` varchar(4) COLLATE utf8_unicode_ci DEFAULT '男' COMMENT '性别',
  `pflag` smallint(6) DEFAULT NULL COMMENT '权限标志 0-学生，1-教师，2-管理员',
  `dflag` smallint(6) DEFAULT NULL COMMENT '删除标志 0-未删除，1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `admin` */

insert  into `admin`(`id`,`name`,`password`,`email`,`tel`,`gender`,`pflag`,`dflag`) values ('14422004','123456','123456','123456','123456','男',0,0);

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(80) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '课程名',
  `tid` varchar(8) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '老师id',
  `date` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '上课日期',
  `info` text COLLATE utf8_unicode_ci COMMENT '课程简介',
  `dflag` smallint(6) DEFAULT NULL COMMENT '删除标志 0-未删除，1-已删除',
  PRIMARY KEY (`id`),
  KEY `tid` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `course` */

insert  into `course`(`id`,`name`,`tid`,`date`,`info`,`dflag`) values (1,'测试','14422001','2007.5.28','nonono',0),(2,'测试','14422001','2007.5.28','nonono',0),(3,'测试','14422001','2007.5.28','nonono',0),(5,'测试','14422001','2007.5.28','nonono',0);

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` int(11) NOT NULL COMMENT 'id',
  `name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `level` int(11) DEFAULT NULL COMMENT '所在层',
  `parentid` int(11) DEFAULT NULL,
  `power` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '管理员|教师|学生',
  `dflag` smallint(6) DEFAULT NULL COMMENT '删除标示 0-未删除，1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `permission` */

/*Table structure for table `sc_fact_relation` */

DROP TABLE IF EXISTS `sc_fact_relation`;

CREATE TABLE `sc_fact_relation` (
  `sid` varchar(8) COLLATE utf8_unicode_ci NOT NULL COMMENT '学生id',
  `cid` int(11) NOT NULL COMMENT '课程id',
  `date` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '课程上课时间',
  `grade` smallint(6) DEFAULT NULL COMMENT '评分',
  `evaluate` text COLLATE utf8_unicode_ci COMMENT '评价',
  `remark` text COLLATE utf8_unicode_ci COMMENT '备注',
  `dflag` smallint(6) DEFAULT NULL COMMENT '删除标志 0-未删除，1-已删除',
  PRIMARY KEY (`sid`,`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `sc_fact_relation` */

insert  into `sc_fact_relation`(`sid`,`cid`,`date`,`grade`,`evaluate`,`remark`,`dflag`) values ('14422105',1,'2007.5.18',8,'4 4 4 5,',NULL,0);

/*Table structure for table `sc_re_relation` */

DROP TABLE IF EXISTS `sc_re_relation`;

CREATE TABLE `sc_re_relation` (
  `sid` varchar(8) COLLATE utf8_unicode_ci NOT NULL COMMENT '学生id',
  `cid` int(11) NOT NULL COMMENT '课程id',
  `date` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '课程上课时间',
  `remark` text COLLATE utf8_unicode_ci COMMENT '备注',
  `dflag` smallint(6) DEFAULT NULL COMMENT '删除标志 0-未删除，1-已删除',
  PRIMARY KEY (`sid`,`cid`),
  KEY `sid` (`sid`),
  KEY `cid` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `sc_re_relation` */

insert  into `sc_re_relation`(`sid`,`cid`,`date`,`remark`,`dflag`) values ('14422105',1,'2007.5.18',NULL,0),('14422105',2,'2007.5.18',NULL,0),('14422105',3,'2007.5.18',NULL,1),('14422105',5,'2007.5.28',NULL,0),('14422106',1,'2007.5.28',NULL,0),('14422106',2,'2007.5.28',NULL,0),('14422106',3,'2007.5.28',NULL,0);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` varchar(8) COLLATE utf8_unicode_ci NOT NULL COMMENT 'id',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '姓名',
  `password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `gender` varchar(2) COLLATE utf8_unicode_ci DEFAULT '男' COMMENT '性别',
  `email` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `tel` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电话',
  `department` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '院系',
  `classes` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '专业班级',
  `pflag` smallint(6) DEFAULT NULL COMMENT '权限标志 0-学生，1-老师，2-管理员',
  `dflag` smallint(6) DEFAULT NULL COMMENT '删除标志 0-未删除，1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `student` */

insert  into `student`(`id`,`name`,`password`,`gender`,`email`,`tel`,`department`,`classes`,`pflag`,`dflag`) values ('14422105','赵家庆','123456','男','zjq2133318@163.com','15382186081','物理学院','计算机科学与技术 143',0,0),('14422106','亿元','123456','男','456456564231','456456564231','信息工程学院','通信工程 141',0,0);

/*Table structure for table `tc_relation` */

DROP TABLE IF EXISTS `tc_relation`;

CREATE TABLE `tc_relation` (
  `tid` varchar(8) COLLATE utf8_unicode_ci DEFAULT '',
  `cid` int(11) DEFAULT NULL,
  `date` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '课程上课时间',
  `dflag` smallint(6) DEFAULT NULL COMMENT '删除标志 0-未删除，1-已删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tc_relation` */

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id` varchar(8) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT 'id',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '姓名',
  `password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `gender` varchar(2) COLLATE utf8_unicode_ci DEFAULT '男' COMMENT '性别',
  `onlinetool` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'qq或者微信',
  `email` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `tel` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电话',
  `nation` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '民族',
  `title` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '职称',
  `department` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部门',
  `image` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '头像',
  `info` text COLLATE utf8_unicode_ci COMMENT '老师简介',
  `goodfield` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '擅长领域',
  `pflag` smallint(6) DEFAULT NULL COMMENT '权限标志 0-学生，1-老师，2-管理员',
  `dflag` smallint(6) DEFAULT NULL COMMENT '删除标志 0-未删除，1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `teacher` */

insert  into `teacher`(`id`,`name`,`password`,`gender`,`onlinetool`,`email`,`tel`,`nation`,`title`,`department`,`image`,`info`,`goodfield`,`pflag`,`dflag`) values ('14422001','教师一','123456','男','463155731',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,0),('14422002','教师二','123456','男',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,0);

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

/*!50001 DROP VIEW IF EXISTS `person` */;
/*!50001 DROP TABLE IF EXISTS `person` */;

/*!50001 CREATE TABLE  `person`(
 `id` varchar(8) NOT NULL  default '' ,
 `name` varchar(20) NOT NULL  default '' ,
 `password` varchar(20) NULL ,
 `pflag` smallint(6) NULL ,
 `dflag` smallint(6) NULL 
)*/;

/*View structure for view person */

/*!50001 DROP TABLE IF EXISTS `person` */;
/*!50001 DROP VIEW IF EXISTS `person` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `person` AS select `student`.`id` AS `id`,`student`.`name` AS `name`,`student`.`password` AS `password`,`student`.`pflag` AS `pflag`,`student`.`dflag` AS `dflag` from `student` union select `teacher`.`id` AS `id`,`teacher`.`name` AS `name`,`teacher`.`password` AS `password`,`teacher`.`pflag` AS `pflag`,`teacher`.`dflag` AS `dflag` from `teacher` union select `admin`.`id` AS `id`,`admin`.`name` AS `name`,`admin`.`password` AS `password`,`admin`.`pflag` AS `pflag`,`admin`.`dflag` AS `dflag` from `admin` */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
