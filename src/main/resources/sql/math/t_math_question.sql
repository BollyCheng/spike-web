DROP TABLE IF EXISTS t_math_question;
CREATE TABLE t_math_question
(
    f_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '问题ID',
    f_exam_id INT NOT NULL COMMENT '试卷id',
    f_index VARCHAR(10) NOT NULL COMMENT '问题序号',
    f_subject VARCHAR(200) NOT NULL COMMENT '题目',
    f_options VARCHAR(200) NOT NULL COMMENT '选项',
    f_score VARCHAR(10) NOT NULL DEFAULT '0' COMMENT '题目分数',
    f_difficulty_degree VARCHAR(10) NOT NULL DEFAULT '0' COMMENT '难度系数',
    f_answer VARCHAR(10) NULL COMMENT '答案',
    f_actual_score VARCHAR(10) NULL COMMENT '得分',
    f_create_by VARCHAR(20) NULL COMMENT '创建人',
    f_create_at DATETIME NULL COMMENT '创建时间',
    f_last_edit_by VARCHAR(20) NULL COMMENT '最后更新人',
    f_last_edit_at DATETIME NULL COMMENT '最后更新时间',
    CONSTRAINT t_math_question_uk_exam_index UNIQUE (f_exam_id, f_index),
    CONSTRAINT t_math_question_fk_exam FOREIGN KEY (f_exam_id) REFERENCES t_math_examination (f_id)
) COMMENT '考试题目表';
