package com.bolly.spike.service.math.gen.subject;

import com.bolly.spike.service.math.gen.options.AbstractOptionsGen;

import java.util.Random;

public abstract class AbstractSubjectGen {

    protected Random random = new Random();

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

    protected int rightAnswer;

    public int getDifficultyDegree() {
        return 100;
    }

    public abstract String getSubject();

    public int getRightAnswer() {
        return rightAnswer;
    }

    public abstract AbstractOptionsGen getOptionsGen();

    public String getOptions() {
        return getOptionsGen().getOptions();
    }

}
