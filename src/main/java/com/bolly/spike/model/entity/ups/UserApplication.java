package com.bolly.spike.model.entity.ups;

import com.bolly.spike.model.entity.BaseEntity;

/**
 * 用户应用信息(授权后)
 * Author   : Bolly
 * CreateAt : 2018/05/11 18:55:55
 */
public class UserApplication extends BaseEntity {

    private User user;
    private Application application;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
