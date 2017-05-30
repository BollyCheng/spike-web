package com.bolly.spike.mapper.ups;

import com.bolly.spike.entity.ups.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表的相关操作
 *
 * Author   : Bolly
 * CreateAt : 2017/05/25 22:24:03
 */
@Repository
public interface UserMapper {

    /**
     * 向数据库中添加一个用户
     *
     * @param user 添加的用户
     * @Exception 用户名不得相同
     */
    void insert(User user);

    /**
     * 更新用户数据
     *
     * @param user 更新后的用户数据
     */
    void update(User user);

    /**
     * 从数据库中删除一个用户(逻辑删除)
     *
     * @param id 用户的ID
     */
    void delete(Long id);

    /**
     * 通过用户ID查找用户
     *
     * @param id 用户ID
     * @return 查找到的用户，为查找到则返回null
     */
    User loadById(Long id);

    /**
     * 通过用户ID查找用户
     *
     * @param username 用户名
     * @return 查找到的用户，为查找到则返回null
     */
    User loadByUsername(String username);

    /**
     * 从数据库中查找所有未删除的用户
     *
     * @return 所有未删除的用户数据
     */
    List<User> list();

}
