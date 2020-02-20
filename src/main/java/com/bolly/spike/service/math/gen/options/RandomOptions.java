package com.bolly.spike.service.math.gen.options;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * 除正确选项外，其它选项是随机产生的。
 */
public class RandomOptions extends AbstractOptionsGen {

    public static final Logger LOGGER = LoggerFactory.getLogger(RandomOptions.class);

    public RandomOptions(int rightValue, int minValue, int maxValue) {
        super(rightValue, minValue, maxValue);
        LOGGER.info("rightValue={}, minValue={}, maxValue={}", rightValue, minValue, maxValue);

        options.add(rightValue);
        for (int i = 1; i < OPTION_NUMBER; i++) {
            int value = generateRandomNum(minValue, maxValue - i);

            for (int j = 0; j < i; j++) {
                if (!options.contains(value)) {
                    break;
                }
                value++;
            }
            options.add(value);
        }

        LOGGER.info("options=[{}]", StringUtils.join(options, ","));
    }

}
