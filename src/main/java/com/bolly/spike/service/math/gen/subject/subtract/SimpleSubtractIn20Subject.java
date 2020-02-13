package com.bolly.spike.service.math.gen.subject.subtract;

import com.bolly.spike.service.math.gen.options.AbstractOptionsGen;
import com.bolly.spike.service.math.gen.options.RandomOptions;
import com.bolly.spike.service.math.gen.options.SimpleOptions;

public class SimpleSubtractIn20Subject extends SimpleSubtractSubject {

    public SimpleSubtractIn20Subject() {
        super();
    }

    @Override
    public int getMinValue() {
        return 10;
    }

    @Override
    public int getMaxValue() {
        return 20;
    }

    @Override
    public int getDifficultyDegree() {
        return 110;
    }

    @Override
    public AbstractOptionsGen getOptionsGen() {
        int rndValue = generateRandomNum(0, 100);
        if (rndValue >= 40) {
            return new RandomOptions(rightAnswer, 0, num1);
        }
        return new SimpleOptions(rightAnswer, 0, num1);
    }

}
