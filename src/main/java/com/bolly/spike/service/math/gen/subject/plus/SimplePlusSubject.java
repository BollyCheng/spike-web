package com.bolly.spike.service.math.gen.subject.plus;

import com.bolly.spike.service.math.gen.options.AbstractOptionsGen;
import com.bolly.spike.service.math.gen.options.SimpleOptions;
import com.bolly.spike.service.math.gen.subject.AbstractSubjectGen;

public abstract class SimplePlusSubject extends AbstractSubjectGen {

    protected int num1, num2;

    public SimplePlusSubject() {
        int maxValue = getMaxValue();
        int minValue = getMinValue();
        num1 = generateRandomNum(0, maxValue);
        num2 = generateRandomNum(num1 > minValue ? 0 : minValue - num1, maxValue - num1);
        rightAnswer = num1 + num2;
    }

    protected abstract int getMinValue();

    protected abstract int getMaxValue();

    @Override
    public String getSubject() {
        return num1 + " + " + num2 + " = ?";
    }

    @Override
    public AbstractOptionsGen getOptionsGen() {
        return new SimpleOptions(rightAnswer, getMinValue(), getMaxValue());
    }

}
