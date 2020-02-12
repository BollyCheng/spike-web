package com.bolly.spike.service.math.gen.subject;

import com.bolly.spike.service.math.gen.options.AbstractOptionsGen;
import com.bolly.spike.service.math.gen.options.SimpleOptions;

import java.util.Random;

public class SimplePlusIn10Subject extends AbstractSubjectGen {

    public static final int MAX_VALUE = 10;
    public static final int MIN_VALUE = 0;

    private int num1, num2;

    public SimplePlusIn10Subject() {
        Random random = new Random();
        num1 = random.nextInt(MAX_VALUE);
        if (num1 == MAX_VALUE) {
            num2 = MIN_VALUE;
        } else {
            num2 = random.nextInt(MAX_VALUE - num1);
        }
        rightAnswer = num1 + num2;
    }

    @Override
    public String getSubject() {
        return num1 + " + " + num2 + " = ?";
    }

    @Override
    public AbstractOptionsGen getOptionsGen() {
        return new SimpleOptions(rightAnswer, MIN_VALUE, MAX_VALUE);
    }

}
