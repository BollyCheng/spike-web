DROP TABLE  IF EXISTS sys_application;
CREATE TABLE sys_application
(
  f_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
  f_name VARCHAR(20) NOT NULL COMMENT '应用名称',
  f_description VARCHAR(255) NULL COMMENT '应用描述',
  f_delete CHAR(1) DEFAULT 1 COMMENT  '是否删除 1:未删除 9:已删除',
  f_create_by INT NULL COMMENT '创建人',
  f_create_at DATETIME NULL COMMENT '创建时间',
  f_last_edit_by INT NULL COMMENT '最后更新人',
  f_last_edit_at DATETIME NULL COMMENT '最后更新时间',
  CONSTRAINT t_application_uk_name UNIQUE (f_name)
) COMMENT '系统应用表（子系统）';

-- 初始数据
INSERT INTO sys_application (f_name, f_description) VALUES
  ('UPS','用户权限管理系统'),
  ('ITS','问题追踪系统')
