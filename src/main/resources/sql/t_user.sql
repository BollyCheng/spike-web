create table t_user
(
  f_id int not null auto_increment primary key,
	f_username varchar(50) not null,
	f_password varchar(255) null,
  f_nickname varchar(20) not null,
	f_department_id int not null,
	t_create_by int null,
	t_create_at datetime null,
	t_last_edit_by int null,
	t_last_edit_at datetime null,
	constraint t_user_uk_username unique (f_username),
	constraint t_user_fk_department foreign key (f_department_id) references t_department (f_id)
)
;

create index t_user_fk_department on t_user (f_department_id);

comment on table t_user is '用户表';
comment on column t_user.f_username is '用户名';
comment on column t_user.f_password is '用户密码';
comment on column t_user.f_id is '用户ID';
comment on column t_user.f_department_id is '所属部门';
comment on column t_user.f_nickname is '用户昵称，系统内显示的名称';
comment on column t_user.f_create_by is '创建人';
comment on column t_user.f_create_at is '创建时间';
comment on column t_user.f_last_edit_by is '最后更新人';
comment on column t_user.f_last_edit_at is '最后更新时间';

