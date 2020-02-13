package com.bolly.spike.service.math.gen.subject.subtract;

import com.bolly.spike.service.math.gen.subject.plus.SimplePlusIn20Subject;

public class SimpleSubtractIn20SubjectA extends SimplePlusIn20Subject {

    public SimpleSubtractIn20SubjectA() {
        super();
    }

    @Override
    protected int getMinValue() {
        return 0;
    }

    @Override
    public String getSubject() {
        return "? - " + num1 + " = " + num2;
    }

    @Override
    public int getDifficultyDegree() {
        return 115;
    }

}
