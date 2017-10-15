package com.bolly.spike.util;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Author   : Bolly
 * CreateAt : 2017/09/24 20:01:19
 */
public class ApplicationUtils {

    private static String rootDir;

    static {
        rootDir = ApplicationUtils.class.getClassLoader().getResource("").getPath();
    }

    public static String getApplicationRootDir() {
        return rootDir;
    }

}
