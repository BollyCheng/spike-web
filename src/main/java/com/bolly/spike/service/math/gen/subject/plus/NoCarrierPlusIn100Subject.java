package com.bolly.spike.service.math.gen.subject.plus;

import com.bolly.spike.service.math.gen.options.AbstractOptionsGen;
import com.bolly.spike.service.math.gen.options.RandomOptions;
import com.bolly.spike.service.math.gen.options.SimpleOptions;

/**
 * 100以内不进位加法
 */
public class NoCarrierPlusIn100Subject extends SimplePlusSubject {

    public NoCarrierPlusIn100Subject() {
        int unitDigit = generateRandomNum(0, 9);
        int tensDigit = generateRandomNum(1, 9);
        num1 = tensDigit * 10 + unitDigit;

        unitDigit = generateRandomNum(0, 9 - unitDigit);
        tensDigit = tensDigit == 9 ? 0 : generateRandomNum(1, 9 - tensDigit);
        num2 = tensDigit * 10 + unitDigit;
        rightAnswer = num1 + num2;
        LOGGER.info("subject=[{}]", getSubject());
    }

    @Override
    protected int getMinValue() {
        return 10;
    }

    @Override
    protected int getMaxValue() {
        return 99;
    }

    @Override
    public int getDifficultyDegree() {
        return 120;
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
