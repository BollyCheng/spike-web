package com.bolly.spike.service.math.gen.subject;

import com.bolly.spike.service.math.gen.options.AbstractOptionsGen;
import com.bolly.spike.service.math.gen.options.RandomOptions;
import com.bolly.spike.service.math.gen.options.SimpleOptions;

import java.util.Random;

public class SimplePlusIn20Subject extends SimplePlusSubject {

    public SimplePlusIn20Subject() {
        super();
    }

    @Override
    protected int getMinValue() {
        return 10;
    }

    @Override
    protected int getMaxValue() {
        return 20;
    }

    @Override
    public int getDifficultyDegree() {
        return 110;
    }

    @Override
    public AbstractOptionsGen getOptionsGen() {
        int rndValue = new Random().nextInt(100);
        if (rndValue >= 50) {
            return new RandomOptions(rightAnswer, getMinValue(), getMaxValue());
        }
        return new SimpleOptions(rightAnswer, getMinValue(), getMaxValue());

    }
}
