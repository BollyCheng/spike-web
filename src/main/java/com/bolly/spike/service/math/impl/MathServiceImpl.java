package com.bolly.spike.service.math.impl;

import com.bolly.spike.model.entity.math.Examination;
import com.bolly.spike.model.entity.math.Question;
import com.bolly.spike.service.math.ExaminationService;
import com.bolly.spike.service.math.MathService;
import com.bolly.spike.service.math.QuestionFactory;
import com.bolly.spike.service.math.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class MathServiceImpl implements MathService {

    @Resource
    protected ExaminationService examinationService;
    @Resource
    protected QuestionService questionService;

    @Override
    public Map startExam() {
        // 生成考试试卷和考试题目
        Examination exam = examinationService.generateExam();
        questionService.generateQuestions(exam);
        examinationService.updateExamDegreeById(exam);

        Map result = new HashMap();
        result.put("examination", exam);
        result.put("question", questionService.findQuestion(exam.getId(), 1));
        return result;
    }

    @Override
    public Question answerQuestion(Question question) {
        return questionService.answerQuestion(question);
    }

}
