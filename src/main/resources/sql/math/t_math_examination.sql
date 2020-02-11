DROP TABLE IF EXISTS t_math_examination;
CREATE TABLE t_math_examination
(
    f_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '试卷ID',
    f_date VARCHAR(20) NOT NULL COMMENT '日期',
    f_title VARCHAR(255) NOT NULL COMMENT '试卷标题',
    f_total_count VARCHAR(20) NULL COMMENT '问题数量',
    f_total_score VARCHAR(20) NULL COMMENT '试卷总分',
    f_difficulty_degree VARCHAR(10) NULL COMMENT '难度系数',
    f_actual_score VARCHAR(10) NULL COMMENT '试卷得分',
    f_create_by VARCHAR(20) NULL COMMENT '创建人',
    f_create_at DATETIME NULL COMMENT '创建时间',
    f_last_edit_by VARCHAR(20) NULL COMMENT '最后更新人',
    f_last_edit_at DATETIME NULL COMMENT '最后更新时间'
) COMMENT '试卷表';

