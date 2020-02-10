package com.bolly.spike.service.math;


import com.bolly.spike.model.entity.math.Examination;
import com.bolly.spike.model.entity.math.Question;

public interface QuestionService {

    /**
     * 生成考试题目
     */
    void generateQuestions();

}
