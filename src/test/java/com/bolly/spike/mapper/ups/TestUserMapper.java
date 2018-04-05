package com.bolly.spike.mapper.ups;

import com.bolly.spike.model.entity.ups.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Author   : Bolly
 * CreateAt : 2017/05/30 21:20:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-application.xml")
public class TestUserMapper {

    @Resource
    UserMapper userMapper;

    @Test
    public void testLoadById() {
        User user = userMapper.loadById(1L);
        Assert.assertEquals("F1223464", user.getUsername());
    }

    @Test
    public void testLoadByUsername() {
        User user = userMapper.loadByUsername("F1223464");
        Assert.assertEquals("Bolly", user.getNickname());
    }

}
