package com.bolly.spike.service.math.gen.subject;

import com.bolly.spike.service.math.gen.options.AbstractOptionsGen;

public abstract class AbstractSubjectGen {

    protected int rightAnswer;

    public int getDifficultyDegree() {
        return 100;
    }

    public abstract String getSubject();

    public int getRightAnswer() {
        return rightAnswer;
    }

    public abstract AbstractOptionsGen getOptionsGen();

    public String getOptions() {
        return getOptionsGen().getOptions();
    }

}
