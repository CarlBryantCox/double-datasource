/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.17-log : Database - zrm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zrm` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `monitor_single_all` */

CREATE TABLE `monitor_single_all` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `request_count` int(11) unsigned NOT NULL DEFAULT '0',
  `concurrent_max` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_count` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_time_millis` bigint(20) unsigned NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=utf8;

/*Table structure for table `monitor_single_get_paper` */

CREATE TABLE `monitor_single_get_paper` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `request_count` int(11) unsigned NOT NULL DEFAULT '0',
  `request_time_millis` bigint(20) unsigned NOT NULL DEFAULT '0',
  `request_time_millis_max` int(11) unsigned NOT NULL DEFAULT '0',
  `request_time_millis_max_occur_time` datetime DEFAULT NULL,
  `last_access_time` datetime DEFAULT NULL,
  `concurrent_max` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_count` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_peak` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_time_millis` bigint(20) unsigned NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=308 DEFAULT CHARSET=utf8;

/*Table structure for table `monitor_single_submit_score` */

CREATE TABLE `monitor_single_submit_score` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `request_count` int(11) unsigned NOT NULL DEFAULT '0',
  `request_time_millis` bigint(20) unsigned NOT NULL DEFAULT '0',
  `request_time_millis_max` int(11) unsigned NOT NULL DEFAULT '0',
  `request_time_millis_max_occur_time` datetime DEFAULT NULL,
  `last_access_time` datetime DEFAULT NULL,
  `concurrent_max` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_count` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_peak` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_time_millis` bigint(20) unsigned NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=308 DEFAULT CHARSET=utf8;

/*Table structure for table `monitor_union_all` */

CREATE TABLE `monitor_union_all` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `request_count` int(11) unsigned NOT NULL DEFAULT '0',
  `concurrent_max` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_count` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_time_millis` bigint(20) unsigned NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=utf8;

/*Table structure for table `monitor_union_get_paper` */

CREATE TABLE `monitor_union_get_paper` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `request_count` int(11) unsigned NOT NULL DEFAULT '0',
  `request_time_millis` bigint(20) unsigned NOT NULL DEFAULT '0',
  `request_time_millis_max` int(11) unsigned NOT NULL DEFAULT '0',
  `request_time_millis_max_occur_time` datetime DEFAULT NULL,
  `last_access_time` datetime DEFAULT NULL,
  `concurrent_max` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_count` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_peak` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_time_millis` bigint(20) unsigned NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=308 DEFAULT CHARSET=utf8;

/*Table structure for table `monitor_union_submit_score` */

CREATE TABLE `monitor_union_submit_score` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `request_count` int(11) unsigned NOT NULL DEFAULT '0',
  `request_time_millis` bigint(20) unsigned NOT NULL DEFAULT '0',
  `request_time_millis_max` int(11) unsigned NOT NULL DEFAULT '0',
  `request_time_millis_max_occur_time` datetime DEFAULT NULL,
  `last_access_time` datetime DEFAULT NULL,
  `concurrent_max` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_count` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_peak` int(11) unsigned NOT NULL DEFAULT '0',
  `jdbc_execute_time_millis` bigint(20) unsigned NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=308 DEFAULT CHARSET=utf8;

/*Table structure for table `record_single_all` */

CREATE TABLE `record_single_all` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `seconds` int(11) DEFAULT NULL,
  `qps` int(11) DEFAULT NULL,
  `get_count` int(11) DEFAULT NULL,
  `get_jdbc_time` bigint(20) DEFAULT NULL,
  `get_jdbc_count` int(11) DEFAULT NULL,
  `avg_jdbc_get_time` bigint(20) DEFAULT NULL,
  `creat_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Table structure for table `record_single_get_paper` */

CREATE TABLE `record_single_get_paper` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `seconds` int(11) DEFAULT NULL,
  `get_time` bigint(20) DEFAULT NULL,
  `get_count` int(11) DEFAULT NULL,
  `avg_get_time` bigint(20) DEFAULT NULL,
  `get_jdbc_time` bigint(20) DEFAULT NULL,
  `get_jdbc_count` int(11) DEFAULT NULL,
  `avg_jdbc_get_time` bigint(20) DEFAULT NULL,
  `creat_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Table structure for table `record_single_submit_score` */

CREATE TABLE `record_single_submit_score` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `seconds` int(11) DEFAULT NULL,
  `get_time` bigint(20) DEFAULT NULL,
  `get_count` int(11) DEFAULT NULL,
  `avg_get_time` bigint(20) DEFAULT NULL,
  `get_jdbc_time` bigint(20) DEFAULT NULL,
  `get_jdbc_count` int(11) DEFAULT NULL,
  `avg_jdbc_get_time` bigint(20) DEFAULT NULL,
  `creat_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Table structure for table `record_union_all` */

CREATE TABLE `record_union_all` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `seconds` int(11) DEFAULT NULL,
  `qps` int(11) DEFAULT NULL,
  `get_count` int(11) DEFAULT NULL,
  `get_jdbc_time` bigint(20) DEFAULT NULL,
  `get_jdbc_count` int(11) DEFAULT NULL,
  `avg_jdbc_get_time` bigint(20) DEFAULT NULL,
  `creat_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Table structure for table `record_union_get_paper` */

CREATE TABLE `record_union_get_paper` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `seconds` int(11) DEFAULT NULL,
  `get_time` bigint(20) DEFAULT NULL,
  `get_count` int(11) DEFAULT NULL,
  `avg_get_time` bigint(20) DEFAULT NULL,
  `get_jdbc_time` bigint(20) DEFAULT NULL,
  `get_jdbc_count` int(11) DEFAULT NULL,
  `avg_jdbc_get_time` bigint(20) DEFAULT NULL,
  `creat_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Table structure for table `record_union_submit_score` */

CREATE TABLE `record_union_submit_score` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `seconds` int(11) DEFAULT NULL,
  `get_time` bigint(20) DEFAULT NULL,
  `get_count` int(11) DEFAULT NULL,
  `avg_get_time` bigint(20) DEFAULT NULL,
  `get_jdbc_time` bigint(20) DEFAULT NULL,
  `get_jdbc_count` int(11) DEFAULT NULL,
  `avg_jdbc_get_time` bigint(20) DEFAULT NULL,
  `creat_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Table structure for table `score` */

/*Table structure for table `student` */

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
