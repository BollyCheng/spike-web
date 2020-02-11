package com.bolly.spike.service.math;

import com.bolly.spike.model.entity.math.Question;

public class QuestionFactory {

    public static Question generateQuestion() {
        Question question = new Question();
        question.setSubject("3 + 4 = ?");
        question.setOptions("A.6;B.7;C.8;D.9");
        question.setDifficultyDegree(2);
        return question;
    }

    public static boolean validAnswer(Question question) {

        return true;
    }

}
