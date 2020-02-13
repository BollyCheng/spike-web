package com.bolly.spike.service.math.gen.subject;

import com.bolly.spike.service.math.gen.options.AbstractOptionsGen;
import com.bolly.spike.service.math.gen.options.RandomOptions;
import com.bolly.spike.service.math.gen.options.SimpleOptions;

import java.util.Random;

public class SimplePlusIn100Subject extends SimplePlusSubject {

    public SimplePlusIn100Subject() {
        super();
    }

    @Override
    protected int getMinValue() {
        return 20;
    }

    @Override
    protected int getMaxValue() {
        return 100;
    }

    @Override
    public int getDifficultyDegree() {
        return 130;
    }

    @Override
    public AbstractOptionsGen getOptionsGen() {
        int rndValue = generateRandomNum(0, 100);
        if (rndValue >= 20) {
            return new RandomOptions(rightAnswer, getMinValue(), getMaxValue());
        }
        return new SimpleOptions(rightAnswer, getMinValue(), getMaxValue());
    }
}
