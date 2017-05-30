create table t_department
(
  f_id int not null auto_increment primary key,
  f_name varchar(50) null,
  f_level int default '0' not null,
  f_parent_id int default '0' not null,
  f_create_by int null,
  f_create_at datetime not null,
  f_last_edit_by int null,
  f_last_edit_at datetime null,
  constraint t_department_uk_name unique (f_name)
);

comment on table t_department is '部门表';
comment on column t_department.f_id is '部门ID';
comment on column t_department.f_name is '部门名称';
comment on column t_department.f_level is '部门级别，顶级为1. 数字越大，级别越小';
comment on column t_department.f_parent_id is '上级部门ID';
comment on column t_department.f_create_by is '创建人';
comment on column t_department.f_create_at is '创建时间';
comment on column t_department.f_last_edit_by is '最后更新人';
comment on column t_department.f_last_edit_at is '最后更新时间';

