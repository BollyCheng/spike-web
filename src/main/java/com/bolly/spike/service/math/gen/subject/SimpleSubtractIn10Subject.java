package com.bolly.spike.service.math.gen.subject;

import com.bolly.spike.service.math.gen.options.AbstractOptionsGen;
import com.bolly.spike.service.math.gen.options.SimpleOptions;

public class SimpleSubtractIn10Subject extends SimpleSubtractSubject {

    public SimpleSubtractIn10Subject() {
        super();
    }

    @Override
    public int getMinValue() {
        return 0;
    }

    @Override
    public int getMaxValue() {
        return 10;
    }

    @Override
    public AbstractOptionsGen getOptionsGen() {
        return new SimpleOptions(rightAnswer, getMinValue(), num1);
    }
}
