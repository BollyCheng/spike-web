package com.bolly.spike.mapper.ups;

import com.bolly.spike.model.entity.ups.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2018/04/07 22:18:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-application.xml")
public class TestApplicationMapper {

    @Resource
    private ApplicationMapper applicationMapper;

    @Test
    public void testList() {
        List<Application> applications = applicationMapper.list();
        Assert.assertNotNull(applications);
    }

}
