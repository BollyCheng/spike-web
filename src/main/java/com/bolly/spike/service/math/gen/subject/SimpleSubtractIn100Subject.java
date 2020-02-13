package com.bolly.spike.service.math.gen.subject;

import com.bolly.spike.service.math.gen.options.AbstractOptionsGen;
import com.bolly.spike.service.math.gen.options.RandomOptions;
import com.bolly.spike.service.math.gen.options.SimpleOptions;

import java.util.Random;

public class SimpleSubtractIn100Subject extends SimpleSubtractSubject {

    public SimpleSubtractIn100Subject() {
        super();
    }

    @Override
    public int getMinValue() {
        return 20;
    }

    @Override
    public int getMaxValue() {
        return 100;
    }

    @Override
    public AbstractOptionsGen getOptionsGen() {
        int rndValue = generateRandomNum(0, 100);
        if (rndValue >= 20) {
            return new RandomOptions(rightAnswer, 0, num1);
        }
        return new SimpleOptions(rightAnswer, 0, num1);
    }
}
