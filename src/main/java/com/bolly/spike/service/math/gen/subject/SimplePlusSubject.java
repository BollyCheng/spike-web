package com.bolly.spike.service.math.gen.subject;

import com.bolly.spike.service.math.gen.options.AbstractOptionsGen;
import com.bolly.spike.service.math.gen.options.SimpleOptions;

import java.util.Random;

public abstract class SimplePlusSubject extends AbstractSubjectGen {

    protected int num1, num2;

    public SimplePlusSubject() {
        int maxValue = getMaxValue();
        int minValue = getMinValue();
        Random random = new Random();
        num1 = random.nextInt(maxValue);
        if (num1 == maxValue) {
            num2 = minValue;
        } else {
            num2 = random.nextInt(maxValue - num1);
        }
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
