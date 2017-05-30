package com.bolly.spike.entity.ups;

import com.bolly.spike.entity.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 用户
 * Author   : Bolly
 * CreateAt : 2017/04/23 17:05:39
 */
public class User extends BaseEntity {

    private String username;//用户名
    private String password;//密码
    private String nickname;//显示名
    private Department department;//所属部门

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
