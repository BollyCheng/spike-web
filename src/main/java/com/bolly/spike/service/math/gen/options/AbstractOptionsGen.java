package com.bolly.spike.service.math.gen.options;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public abstract class AbstractOptionsGen {

    protected static final int OPTION_NUMBER = 4;

    protected Random random = new Random();

    protected final int rightValue;
    protected final int minValue;
    protected final int maxValue;
    protected List options = new ArrayList(OPTION_NUMBER);

    public AbstractOptionsGen(int rightValue, int minValue, int maxValue) {
        this.rightValue = rightValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public String getOptions() {
        Collections.shuffle(options);
        String[] strOptions = new String[4];
        for (int i = 0; i < OPTION_NUMBER; i++) {
            strOptions[i] = (char) ('A' + i) + "." + options.get(i);
        }
        return StringUtils.join(strOptions, ";");
    }

    /**
     * 在数值范围内生成随机数
     *
     * @param minValue 最小值
     * @param maxValue 最大值
     * @return 随机数
     */
    protected int generateRandomNum(int minValue, int maxValue) {
        int rndNum = maxValue - minValue;
        if (rndNum <= 0) {
            return minValue;
        }
        return random.nextInt(rndNum) + minValue;
    }

}
