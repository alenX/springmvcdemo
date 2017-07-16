SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(32) NOT NULL DEFAULT '0',
  `name` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', '张飞', '16');
INSERT INTO `person` VALUES ('2', '关羽', '18');
INSERT INTO `person` VALUES ('3', '刘备', '30');

/*用户权限部门控制*/

/*用户表*/
CREATE  table sys_user(id varchar(32) not null ,username varchar(32),password VARCHAR(32),nickname VARCHAR(32),salt varchar(32),PRIMARY KEY (id))ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*角色表*/
create table sys_role(id varchar(32) not NULL ,rolename varchar(32),roledesc varchar(255),PRIMARY KEY (id))ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*权限表*/
create table sys_auth(id varchar(32) not null,authname varchar(32),authdesc varchar(255),PRIMARY KEY (id))ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*用户角色对应表*/
create table sys_user_role (id VARCHAR(32), userid varchar(32),roleid varchar(32),PRIMARY KEY (userid,roleid))ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*角色权限对应表*/
create table sys_role_auth (id VARCHAR(32), roleid varchar(32),authid varchar(32),PRIMARY KEY (roleid,authid))ENGINE=InnoDB DEFAULT CHARSET=utf8;
