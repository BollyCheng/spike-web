DROP TABLE  IF EXISTS t_application;
CREATE TABLE t_application
(
  f_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
  f_name VARCHAR(20) NOT NULL COMMENT '应用名称',
  f_description VARCHAR(255) NULL COMMENT '应用描述',
  t_create_by INT NULL COMMENT '创建人',
  t_create_at DATETIME NULL COMMENT '创建时间',
  t_last_edit_by INT NULL COMMENT '最后更新人',
  t_last_edit_at DATETIME NULL COMMENT '最后更新时间',
  CONSTRAINT t_application_uk_name UNIQUE (f_name)
) COMMENT '应用（子系统）';

-- 初始数据
INSERT INTO t_application (f_name, f_description) VALUES
  ('UPS','用户权限管理系统'),
  ('ITS','问题追踪系统')
