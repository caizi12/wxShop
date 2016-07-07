create table SYS_USER
(
   USER_ID              VARCHAR(10) not null comment '用户编号',
   USER_NAME            VARCHAR(20) not null comment '登录名称',
   PASSWORD             VARCHAR(32) comment '密码',
   REAL_NAME            VARCHAR(40) comment '真实姓名',
   STATUS               CHAR(1) comment '用户状态：0 正常 ，1 停用， 2 锁定',
   SEX                  CHAR(1) comment '0 男，1 女 ，2 未知',
   MOBILE_NO            VARCHAR(30) comment '手机号码',
   PHONE_NO             VARCHAR(30) comment '联系电话',
   EMAIL                VARCHAR(200) comment '邮箱地址',
   INVALID_DATE         DATE comment '密码失效日期',
   LAST_LOGIN           VARCHAR(25) comment '最近登录时间',
   UNLOCK_TIME          VARCHAR(25) comment '当状态为锁定时，解锁的时间',
   MAX_LOGIN_COUNT      INT default 10 comment '默认最大错误次数10次',
   ERR_LOGIN_COUNT      INT comment '错误登录次数',
   LAST_IP              VARCHAR(128) comment '允许设置多个IP地址',
   ORG_ID               VARCHAR(20) comment '所属机构编号',
   DEPT_ID              VARCHAR(20) comment '所属部门编号',
   LANG                 VARCHAR(25) comment '语言',
   REMARK               VARCHAR(400) comment '备注',
   CREATE_TIME          TIME,
   UPDATE_TIME          TIME
)
charset = UTF8;

alter table SYS_USER comment '管理员表';

alter table SYS_USER
   add primary key (USER_ID, USER_NAME);
