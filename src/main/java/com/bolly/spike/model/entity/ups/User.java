package com.bolly.spike.model.entity.ups;

import com.alibaba.fastjson.annotation.JSONField;
import com.bolly.spike.model.entity.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * 用户基本信息
 * Author   : Bolly
 * CreateAt : 2017/04/23 17:05:39
 */
public class User extends BaseEntity {

    private String username;//用户名
    private String password;//密码
    private String nickname;//昵称
    private String name;//姓名
    private String sex;//性别
    private String email;//邮箱
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;//生日
    @JSONField(format = "yyyy-MM-dd")
    private Date hireDate;//入职日期
    @JSONField(format = "yyyy-MM-dd")
    private Date leaveDate;//离职日期
    private String state;//状态
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getDepartmentName() {
        return department == null ? DEFAULT_STRING_VALUE : department.getName();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
