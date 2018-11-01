CREATE DATABASE FRSP;-- 建立数据库

-- 金融风险监管平台项目表结构 --
CREATE TABLE FRSP_USER(
ID INT(11) PRIMARY KEY AUTO_INCREMENT,
ACCOUNT VARCHAR(100) DEFAULT NULL COMMENT '用户账号',
PASSWORD VARCHAR(100)  DEFAULT NULL COMMENT '用户密码',
USERNAME VARCHAR(100)  DEFAULT NULL COMMENT '用户姓名',
ORGANIZATION VARCHAR(250)  DEFAULT NULL COMMENT '所属机构',
DEPARTMENT VARCHAR(250)  DEFAULT NULL COMMENT '所属部门',
LEADER VARCHAR(100)  DEFAULT NULL COMMENT '上级领导',
TYPE INT(1)  DEFAULT NULL COMMENT '用户类型',
SEX INT(1)  DEFAULT NULL COMMENT '用户性别1-男,0-女',
MOBILE VARCHAR(13)  DEFAULT NULL COMMENT '手机号',
EMAIL VARCHAR(200)  DEFAULT NULL COMMENT '邮箱',
ROLE_ID INT(11) DEFAULT NULL COMMENT '对应角色表主键',
STATUS INT(1) DEFAULT 0 COMMENT '用户状态1-有效,0无效',
CREATE_TIME DATETIME DEFAULT NULL COMMENT '创建日期',
UPDATE_TIME DATETIME  DEFAULT NULL COMMENT '修改日期',
IS_DELETED INT(1) DEFAULT 0 COMMENT '逻辑删除1-已删除,0-未删除'
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '用户信息表';
-- 初始化未加密的用户
INSERT INTO frsp_user(account,password,username) values('admin','admin','admin_wjh');

CREATE TABLE FRSP_ROLE(
ID INT(11) PRIMARY KEY AUTO_INCREMENT,
ROLE_NAME VARCHAR(100) DEFAULT NULL COMMENT '角色名称',
ROLE_MARK VARCHAR(100) DEFAULT NULL COMMENT '角色标识',
ORGANIZATION VARCHAR(250)  DEFAULT NULL COMMENT '所属机构',
ROLE_DESC VARCHAR(100) DEFAULT NULL COMMENT '角色描述',
CREATOR VARCHAR(100) DEFAULT NULL COMMENT '角色描述',
UPDATOR VARCHAR(100) DEFAULT NULL COMMENT '修改人',
CREATE_TIME DATETIME DEFAULT NULL COMMENT '创建日期',
UPDATE_TIME DATETIME  DEFAULT NULL COMMENT '修改日期',
IS_DELETED INT(1) DEFAULT 0 COMMENT '逻辑删除1-已删除,0-未删除',
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT '角色信息表';