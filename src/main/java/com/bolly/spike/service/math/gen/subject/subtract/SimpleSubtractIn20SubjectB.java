package com.bolly.spike.service.math.gen.subject.subtract;

public class SimpleSubtractIn20SubjectB extends SimpleSubtractIn20Subject {

    public SimpleSubtractIn20SubjectB() {
        super();
    }

    @Override
    public int getMinValue() {
        return 0;
    }

    @Override
    public String getSubject() {
        return num1 + " - ? = " + num2;
    }

    @Override
    public int getDifficultyDegree() {
        return 120;
    }

}
