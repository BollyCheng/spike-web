package com.bolly.spike.service.math.gen.options;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractOptionsGen {

    protected static final int OPTION_NUMBER = 4;

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

}
