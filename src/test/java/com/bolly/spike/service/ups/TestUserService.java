package com.bolly.spike.service.ups;

import com.bolly.spike.model.entity.ups.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2017/09/24 22:56:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-application.xml")
public class TestUserService {

    @Resource
    private UserService userService;

    @Test
    public void testGetAll() {
        List<User> users = userService.list();
        Assert.assertTrue(users.size() > 0);
    }

}
