package com.bolly.spike.service.math.impl;

import com.bolly.spike.model.entity.math.Examination;
import com.bolly.spike.model.entity.math.Question;
import com.bolly.spike.service.math.ExaminationService;
import com.bolly.spike.service.math.MathService;
import com.bolly.spike.service.math.QuestionService;

import javax.annotation.Resource;

public class MathServiceImpl implements MathService {

    @Resource
    protected ExaminationService examinationService;
    @Resource
    protected QuestionService questionService;

    @Override
    public Question startExam() {
        // 生成考试试卷和考试题目
        Examination exam = examinationService.generateExam();
        return null;
    }

    @Override
    public Question answerQuestion() {
        return null;
    }

}
