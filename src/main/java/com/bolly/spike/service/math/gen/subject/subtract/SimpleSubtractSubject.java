package com.bolly.spike.service.math.gen.subject.subtract;

import com.bolly.spike.service.math.gen.subject.AbstractSubjectGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 简单减法
 */
public abstract class SimpleSubtractSubject extends AbstractSubjectGen {

    public static final Logger LOGGER = LoggerFactory.getLogger(SimpleSubtractSubject.class);

    protected int num1, num2;

    public SimpleSubtractSubject() {
        int maxValue = getMaxValue();
        int minValue = getMinValue();

        num1 = generateRandomNum(minValue, maxValue);
        num2 = generateRandomNum(0, num1);
        rightAnswer = num1 - num2;
        LOGGER.info("subject=[{}]", getSubject());
    }

    public abstract int getMinValue();

    public abstract int getMaxValue();

    @Override
    public String getSubject() {
        return num1 + " - " + num2 + " = ?";
    }

}
