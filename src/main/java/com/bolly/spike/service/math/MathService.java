package com.bolly.spike.service.math;

import com.bolly.spike.model.entity.math.Examination;
import com.bolly.spike.model.entity.math.Question;

import java.util.Map;

public interface MathService {

    /**
     * 开始考试. 生成试卷
     *
     * @return 试卷和第一题
     */
    Map startExam();

    /**
     * 回答问题
     *
     * @return 带结果的题目
     */
    Question answerQuestion(Question question);

    /**
     * 获取指定的题目
     *
     * @param examId 试卷id
     * @param index  题目编号
     * @return 题目
     */
    Question findQuestionByExamIndex(long examId, int index);

    /**
     * 提交试卷
     *
     * @param examination
     * @return
     */
    Examination submitExam(Examination examination);
}
