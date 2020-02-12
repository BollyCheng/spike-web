package com.bolly.spike.service.math;

import com.bolly.spike.model.entity.math.Question;
import com.bolly.spike.service.math.gen.subject.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;

public class QuestionFactory {

    public static Question generateQuestion() {
        int rndType = new Random().nextInt(100);
        int rndValue = new Random().nextInt(100);
        AbstractSubjectGen subjectGen;
        if (rndType >= 50) {
            if (rndValue >= 90) {
                subjectGen = new SimpleSubtractIn100Subject();
            } else if (rndValue >= 20) {
                subjectGen = new SimpleSubtractIn20Subject();
            } else {
                subjectGen = new SimpleSubtractIn10Subject();
            }
        } else {
            if (rndValue >= 90) {
                subjectGen = new SimplePlusIn100Subject();
            } else if (rndValue >= 20) {
                subjectGen = new SimplePlusIn20Subject();
            } else {
                subjectGen = new SimplePlusIn10Subject();
            }
        }

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
