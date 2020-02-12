package com.bolly.spike.service.math.gen.subject;

import com.bolly.spike.service.math.gen.options.AbstractOptionsGen;
import com.bolly.spike.service.math.gen.options.SimpleOptions;

public class SimplePlusIn10Subject extends SimplePlusSubject {

    public SimplePlusIn10Subject() {
        super();
    }

    @Override
    protected int getMinValue() {
        return 0;
    }

    @Override
    protected int getMaxValue() {
        return 10;
    }

    @Override
    public AbstractOptionsGen getOptionsGen() {
        return new SimpleOptions(rightAnswer, getMinValue(), getMaxValue());
    }

}
