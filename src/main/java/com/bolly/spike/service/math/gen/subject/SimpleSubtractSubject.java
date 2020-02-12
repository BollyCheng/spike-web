package com.bolly.spike.service.math.gen.subject;

import java.util.Random;

/**
 * 简单减法
 */
public abstract class SimpleSubtractSubject extends AbstractSubjectGen {

    protected int num1, num2;

    public SimpleSubtractSubject() {
        int maxValue = getMaxValue();
        int minValue = getMinValue();

        Random random = new Random();
        num1 = random.nextInt(maxValue - minValue) + minValue;
        if (num1 == minValue) {
            num2 = minValue;
        } else {
            num2 = random.nextInt(num1);
        }
        rightAnswer = num1 - num2;
    }

    public abstract int getMinValue();

    public abstract int getMaxValue();

    @Override
    public String getSubject() {
        return num1 + " - " + num2 + " = ?";
    }

}
