package com.bolly.spike.mapper.ups;

import com.bolly.spike.model.entity.ups.Module;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2018/04/07 22:21:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-application.xml")
public class TestModuleMapper {

    @Resource
    private ModuleMapper moduleMapper;

    @Test
    public void testList() {
        List<Module> modules = moduleMapper.list();
        Assert.assertNotNull(modules);
    }
}
