package com.bolly.spike.service.math;

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
     * @return 下一题, 没有下一题则回答完毕
     */
    Question answerQuestion(Question question);

}
