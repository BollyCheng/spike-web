package com.bolly.spike.service.math.impl;

import com.bolly.spike.mapper.math.QuestionMapper;
import com.bolly.spike.model.entity.math.Examination;
import com.bolly.spike.model.entity.math.Question;
import com.bolly.spike.service.math.QuestionFactory;
import com.bolly.spike.service.math.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Override
    public void generateQuestions(Examination examination) {
        int totalCount = 50; // 题目总数
        int totalScore = 0;
        int totlDifficultyDegree = 0;
        List<Question> questionList = new ArrayList<>();
        for (int i = Question.INDEX_FIRST; i <= totalCount; i++) {
            Question question = QuestionFactory.generateQuestion();
            question.setExamId(examination.getId());
            question.setIndex(i);
            question.setScore(2);// 每个题目的分数
            questionList.add(question);
            totalScore += question.getScore();
            totlDifficultyDegree += question.getDifficultyDegree();
        }
        questionMapper.batchInsertQuestions(questionList);
        examination.setTotalCount(totalCount);
        examination.setTotalScore(totalScore);
        examination.setDifficultyDegree(totlDifficultyDegree / totalCount);
    }

    @Override
    public Question findQuestion(Long examId, Integer index) {
        return questionMapper.findQuestionByExamIndex(examId, index);
    }

    @Override
    public Question answerQuestion(Question qst) {
        if (qst == null || qst.getId() == null) {
            throw new IllegalArgumentException("回答问题不能为空");
        }
        Question question = questionMapper.findQuestionById(qst.getId());
        // 校验是否回答正确
        question.setAnswer(qst.getAnswer());
        boolean isValid = QuestionFactory.validAnswer(question);
        question.setActualScore(isValid ? question.getScore() : 0);
        // 更新回答结果
        questionMapper.updateAnswer(question);
        // 查找题目
        return questionMapper.findQuestionById(qst.getId());
    }

}
