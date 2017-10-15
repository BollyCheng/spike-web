package com.bolly.spike.report.ups;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Author   : Bolly
 * CreateAt : 2017/09/24 19:57:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-application.xml")
public class TestUserReport {

    @Resource
    UserReport userReport;

    @Test
    public void testExport() throws Exception {
        //UserReport userReport = new UserReport();

        userReport.export();
    }


}
