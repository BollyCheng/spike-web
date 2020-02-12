package com.bolly.spike.service.math.gen.options;

import java.util.Random;

/**
 * 除正确选项外，其它选项是随机产生的。
 */
public class RandomOptions extends AbstractOptionsGen {

    public RandomOptions(int rightValue, int minValue, int maxValue) {
        super(rightValue, minValue, maxValue);
        options.add(rightValue);

        Random random = new Random();
        int rndNum = maxValue - minValue;
        for (int i = 1; i < OPTION_NUMBER; i++) {
            int value;
            do {
                value = random.nextInt(rndNum) + minValue;
            } while (options.contains(value));
            options.add(value);
        }
    }

}
