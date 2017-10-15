package com.bolly.spike.util;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author   : Bolly
 * CreateAt : 2017/09/24 20:04:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-application.xml")
public class TestApplicaionUtils {

    @Test
    public void testGetApplicationRootDir(){
        String rootDir = ApplicationUtils.getApplicationRootDir();
        Assert.assertNotNull(rootDir);
    }

}
