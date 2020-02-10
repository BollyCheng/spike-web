package com.bolly.spike.mapper.math;

import com.bolly.spike.model.entity.math.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionMapper {

    void batchInsertQuestions(@Param("questionList") List<Question> questionList);

    void updateAnswer(Question question);

    Question findQuestionByExamIndex(@Param("examId") String examId, @Param("index") String index);
}
