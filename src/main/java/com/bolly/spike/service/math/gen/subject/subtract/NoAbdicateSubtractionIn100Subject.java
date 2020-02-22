package com.bolly.spike.service.math.gen.subject.subtract;

import com.bolly.spike.service.math.gen.options.AbstractOptionsGen;
import com.bolly.spike.service.math.gen.options.RandomOptions;
import com.bolly.spike.service.math.gen.options.SimpleOptions;

/**
 * 100以内不退位减法
 */
public class NoAbdicateSubtractionIn100Subject extends SimpleSubtractSubject {

    public NoAbdicateSubtractionIn100Subject() {
        int unitDigit = generateRandomNum(1, 9);
        int tensDigit = generateRandomNum(1, 9);
        num1 = tensDigit * 10 + unitDigit;

        unitDigit = generateRandomNum(0, unitDigit);
        tensDigit = generateRandomNum(0, tensDigit);
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
