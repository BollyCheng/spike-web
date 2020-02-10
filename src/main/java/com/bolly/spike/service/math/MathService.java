package com.bolly.spike.service.math;

import com.bolly.spike.model.entity.math.Question;

public interface MathService {

    /**
     * 开始考试. 生成试卷
     *
     * @return 第一题
     */
    Question startExam();

    /**
     * 回答问题
     *
     * @return 下一题, 没有下一题则回答完毕
     */
    Question answerQuestion();

}
