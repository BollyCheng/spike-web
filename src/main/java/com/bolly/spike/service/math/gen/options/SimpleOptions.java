package com.bolly.spike.service.math.gen.options;

import java.util.Random;

/**
 * 简单的选项. 选项是连续的
 */
public class SimpleOptions extends AbstractOptionsGen {

    public SimpleOptions(int rightValue, int minValue, int maxValue) {
        super(rightValue, minValue, maxValue);
        int offset = 0;
        if (rightValue < OPTION_NUMBER) {
            offset = OPTION_NUMBER - rightValue;
        } else if (rightValue > maxValue - OPTION_NUMBER) {
            offset = maxValue - OPTION_NUMBER - rightValue;
        }

        int rndNum = OPTION_NUMBER - Math.abs(offset);
        int optRndIndex = OPTION_NUMBER;
        if (rndNum > 0) {
            optRndIndex = new Random().nextInt(rndNum) + 1 + (offset < 0 ? 0 : offset);
        }
        for (int i = 0; i < OPTION_NUMBER; i++) {
            options.add(i, rightValue + i - (OPTION_NUMBER - optRndIndex));
        }
    }

}
