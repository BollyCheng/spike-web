DROP TABLE  IF EXISTS sys_user_application;
CREATE TABLE sys_user_application
(
    f_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    f_user_id INT NOT NULL COMMENT '用户ID',
    f_application_id INT NOT NULL COMMENT '应用ID',
    f_delete CHAR(1) DEFAULT 1 COMMENT  '是否删除 1:未删除 9:已删除',
    f_create_by INT NULL COMMENT '创建人',
    f_create_at DATETIME NULL COMMENT '创建时间',
    f_last_edit_by INT NULL COMMENT '最后更新人',
    f_last_edit_at DATETIME NULL COMMENT '最后更新时间',
    CONSTRAINT sys_user_application_fk_user FOREIGN KEY (f_user_id) REFERENCES sys_user (f_id),
    CONSTRAINT sys_user_application_fk_application FOREIGN KEY (f_application_id) REFERENCES sys_application (f_id)
) COMMENT '用户应用信息表';
