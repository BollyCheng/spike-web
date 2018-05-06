package com.bolly.spike.service.ups;

import com.bolly.spike.model.entity.ups.User;

import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2017/05/25 22:29:28
 */
public interface UserService {

    void insert(User user);

    void update(User user);

    User loadUserForLogin(String username);

    User loadById(Long id);

    User loadByUsername(String username);

    List<User> list();

}
