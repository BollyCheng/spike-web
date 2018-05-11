DROP TABLE IF EXISTS sys_department;
CREATE TABLE sys_department
(
  f_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '部门ID',
  f_name VARCHAR(50) NULL COMMENT '部门名称',
  f_level INT DEFAULT '0' NOT NULL COMMENT '部门级别，顶级为1. 数字越大，级别越小',
  f_parent_id INT DEFAULT '0' NOT NULL COMMENT '上级部门ID',
  f_order INT(4) DEFAULT '0' NULL COMMENT '排序,指同一个上级部门下子部门的排序',
  f_delete INT(1) DEFAULT '1' NULL COMMENT '是否删除，1:未删除 9:已删除',
  f_create_by INT NULL COMMENT '创建人',
  f_create_at DATETIME NOT NULL COMMENT '创建时间',
  f_last_edit_by INT NULL COMMENT '最后更新人',
  f_last_edit_at DATETIME NULL COMMENT '最后更新时间',
  CONSTRAINT t_department_uk_name UNIQUE (f_name)
) COMMENT '部门表';


