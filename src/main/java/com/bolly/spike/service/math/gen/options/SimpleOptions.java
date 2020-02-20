package com.bolly.spike.service.math.gen.options;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * 简单的选项. 选项是连续的
 */
public class SimpleOptions extends AbstractOptionsGen {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleOptions.class);

    public SimpleOptions(int rightValue, int minValue, int maxValue) {
        super(rightValue, minValue, maxValue);
        LOGGER.info("rightValue={}, minValue={}, maxValue={}", rightValue, minValue, maxValue);

        int rndMinValue = 0;
        int rndMaxValue = OPTION_NUMBER - 1;
        if (rightValue - minValue < OPTION_NUMBER) {
            rndMinValue += (OPTION_NUMBER - 1 - (rightValue - minValue));
        }
        if (OPTION_NUMBER > maxValue - rightValue) {
            rndMaxValue -= (OPTION_NUMBER - 1 - (maxValue - rightValue));
        }

        int optRndIndex = generateRandomNum(rndMinValue, rndMaxValue);
        LOGGER.info("rndIndex={}, rndMinValue={}, rndMaxValue={}", optRndIndex, rndMinValue, rndMaxValue);

        for (int i = 0; i < OPTION_NUMBER; i++) {
            options.add(i, rightValue + i - (OPTION_NUMBER - optRndIndex - 1));
        }
        LOGGER.info("options=[{}]", StringUtils.join(options, ","));
        if (!options.contains(rightValue)) {
            LOGGER.error("=================== Error options ==================");
        }
    }

}
