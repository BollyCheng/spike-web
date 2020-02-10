DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    f_id            INT          NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
    f_username      VARCHAR(50)  NOT NULL COMMENT '用户名',
    f_password      VARCHAR(255) NULL COMMENT '用户密码',
    f_nickname      VARCHAR(20)  NOT NULL COMMENT '用户昵称，系统内显示的名称',
    f_department_id INT          NOT NULL COMMENT '所属部门',
    f_name          VARCHAR(100) NULL COMMENT '姓名',
    f_sex           VARCHAR(10)  NULL COMMENT '性别',
    f_email         VARCHAR(255) NULL COMMENT '邮箱',
    f_birthday      DATE         NULL COMMENT '生日',
    f_hire_date     DATE         NULL COMMENT '入职日期',
    f_state         VARCHAR(20)  NULL COMMENT '状态 1:正常 2:锁定 9:离职',
    f_leave_date    DATE         NULL COMMENT '离职日期',
    f_create_by     INT          NULL COMMENT '创建人',
    f_create_at     DATETIME     NULL COMMENT '创建时间',
    f_last_edit_by  INT          NULL COMMENT '最后更新人',
    f_last_edit_at  DATETIME     NULL COMMENT '最后更新时间',
    CONSTRAINT sys_user_uk_username UNIQUE (f_username),
    CONSTRAINT sys_user_fk_department FOREIGN KEY (f_department_id) REFERENCES sys_department (f_id)
) COMMENT '用户表';

create index t_user_fk_department on sys_user (f_department_id);

INSERT INTO sys_user(f_username, f_password, f_nickname, f_department_id, f_create_at, f_last_edit_at)
VALUES ('chengxianglin', '123456', '成响林', '1', sysdate(), sysdate()),
       ('chengjinyan', '123456', '成锦言', '1', sysdate(), sysdate())


