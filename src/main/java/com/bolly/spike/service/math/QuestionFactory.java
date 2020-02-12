package com.bolly.spike.service.math;

import com.bolly.spike.model.entity.math.Question;
import com.bolly.spike.service.math.gen.subject.AbstractSubjectGen;
import com.bolly.spike.service.math.gen.subject.SimplePlusIn10Subject;
import org.apache.commons.lang3.StringUtils;

public class QuestionFactory {

    public static Question generateQuestion() {
        AbstractSubjectGen subjectGen = new SimplePlusIn10Subject();

        Question question = new Question();
        question.setSubject(subjectGen.getSubject());
        question.setRightAnswer(subjectGen.getRightAnswer());
        question.setOptions(subjectGen.getOptions());
        question.setDifficultyDegree(subjectGen.getDifficultyDegree());
        return question;
    }

    public static boolean validAnswer(Question question) {
        String answer = question.getAnswer();
        String answerValue = StringUtils.right(answer, StringUtils.length(answer) - 2);
        return StringUtils.equals(answerValue, question.getRightAnswer() + "");
    }

}
