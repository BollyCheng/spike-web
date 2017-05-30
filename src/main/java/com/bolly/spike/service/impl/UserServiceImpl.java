package com.bolly.spike.service.impl;

import com.bolly.spike.entity.ups.User;
import com.bolly.spike.mapper.ups.UserMapper;
import com.bolly.spike.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author   : Bolly
 * CreateAt : 2017/05/25 22:30:33
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

}
