DROP TABLE  IF EXISTS sys_module;
CREATE TABLE sys_module
(
  f_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
  f_name VARCHAR(20) NOT NULL COMMENT '模块名称',
  f_parent_id INT DEFAULT '0' COMMENT '上级模块',
  f_url VARCHAR(200) NULL COMMENT '链接地址',
  f_application_id INT NOT NULL COMMENT '所属应用',
  f_delete CHAR(1) DEFAULT 1 COMMENT  '是否删除 1:未删除 9:已删除',
  f_create_by INT NULL COMMENT '创建人',
  f_create_at DATETIME NULL COMMENT '创建时间',
  f_last_edit_by INT NULL COMMENT '最后更新人',
  f_last_edit_at DATETIME NULL COMMENT '最后更新时间',
  CONSTRAINT t_module_uk UNIQUE (f_application_id, f_parent_id, f_name),
  CONSTRAINT t_module_fk_application FOREIGN KEY (f_application_id) REFERENCES sys_application (f_id)
) COMMENT '模块表';

-- 初始数据
INSERT INTO sys_module (f_application_id, f_parent_id, f_name, f_url) VALUES
  (1,0,'基础资料',NULL ),
  (1,1,'部门&用户管理',NULL ),
  (1,1,'应用&模块管理',NULL ),
  (1,1,'角色&权限管理',NULL )
