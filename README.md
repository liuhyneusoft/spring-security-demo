# spring-security-demo

CREATE TABLE `s_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

insert  into `s_user`(`id`,`name`,`email`,`password`,`dob`) values (1,'admin','admin@neusoft.com','$2a$10$5wkiAqo0Olpc0E9i9wauROsbZTMASuMZlqVm27WaLBHXyneEGJguy',NULL),(2,'neusoft','neusoft@neusoft.com','$2a$10$tYo945elXw0tPX05ls4q6Oz19aG8V/z3cWyk1O0GFALoWKtvsoqnC',NULL);
--admin/admin  neusoft/neusoft

CREATE TABLE `s_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `uid` int(11) NOT NULL,
  `suser` tinyblob,
  PRIMARY KEY (`id`),
  KEY `userrole` (`uid`),
  CONSTRAINT `userrole` FOREIGN KEY (`uid`) REFERENCES `s_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

insert  into `s_role`(`id`,`name`,`uid`,`suser`) values (1,'ADMIN',1,NULL),(2,'NEUSOFT',2,NULL),(3,'role_xxx',1,NULL);
 
