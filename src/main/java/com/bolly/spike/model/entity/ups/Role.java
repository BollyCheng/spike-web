package com.bolly.spike.model.entity.ups;

import com.bolly.spike.model.entity.BaseEntity;

/**
 * 角色基本信息
 * Author   : Bolly
 * CreateAt : 2018/05/11 18:55:07
 */
public class Role extends BaseEntity {

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
