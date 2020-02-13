package com.bolly.spike.service.math.gen.subject.plus;

import com.bolly.spike.service.math.gen.subject.subtract.SimpleSubtractIn20Subject;

public class SimplePlusIn20SubjectA extends SimpleSubtractIn20Subject {

    public SimplePlusIn20SubjectA() {
        super();
    }

    @Override
    public int getMinValue() {
        return 0;
    }

    @Override
    public String getSubject() {
        return "? + " + num2 + " = " + num1;
    }

    @Override
    public int getDifficultyDegree() {
        return 120;
    }
}
