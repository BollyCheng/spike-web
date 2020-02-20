package com.bolly.spike.service.math;

import com.bolly.spike.model.entity.math.Question;
import com.bolly.spike.service.math.gen.subject.*;
import com.bolly.spike.service.math.gen.subject.plus.*;
import com.bolly.spike.service.math.gen.subject.subtract.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;

public class QuestionFactory {

    public static Question generateQuestion() {
        int rndType = new Random().nextInt(100);
        int rndValue = new Random().nextInt(100);
        AbstractSubjectGen subjectGen;
        if (rndType >= 50) {
            if (rndValue >= 101) {
                subjectGen = new SimpleSubtractIn100Subject();
            } else if (rndValue >= 70) {
                subjectGen = new SimpleSubtractIn20Subject();
            } else if (rndValue >= 40) {
                subjectGen = new SimpleSubtractIn20SubjectA();
            } else if (rndValue >= 10) {
                subjectGen = new SimpleSubtractIn20SubjectB();
            } else {
                subjectGen = new SimpleSubtractIn10Subject();
            }
        } else {
            if (rndValue >= 101) {
                subjectGen = new SimplePlusIn100Subject();
            } else if (rndValue >= 70) {
                subjectGen = new SimplePlusIn20Subject();
            } else if (rndValue >= 40) {
                subjectGen = new SimplePlusIn20SubjectA();
            } else if (rndValue >= 10) {
                subjectGen = new SimplePlusIn20SubjectB();
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
