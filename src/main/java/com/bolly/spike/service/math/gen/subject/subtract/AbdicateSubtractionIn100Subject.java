package com.bolly.spike.service.math.gen.subject.subtract;

import com.bolly.spike.service.math.gen.options.AbstractOptionsGen;
import com.bolly.spike.service.math.gen.options.RandomOptions;
import com.bolly.spike.service.math.gen.options.SimpleOptions;

/**
 * 100以内退位减法
 */
public class AbdicateSubtractionIn100Subject extends SimpleSubtractSubject {

    public AbdicateSubtractionIn100Subject() {
        int unitDigit = generateRandomNum(1, 8);
        int tensDigit = generateRandomNum(1, 9);
        num1 = tensDigit * 10 + unitDigit;

        unitDigit = generateRandomNum(unitDigit + 1, 9);
        tensDigit = generateRandomNum(0, tensDigit - 1);
        num2 = tensDigit * 10 + unitDigit;

        rightAnswer = num1 - num2;
        LOGGER.info("subject=[{}]", getSubject());
    }

    @Override
    public int getMinValue() {
        return 0;
    }

    @Override
    public int getMaxValue() {
        return 99;
    }

    @Override
    public int getDifficultyDegree() {
        return 150;
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
