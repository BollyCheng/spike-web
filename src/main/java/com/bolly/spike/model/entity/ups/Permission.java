package com.bolly.spike.model.entity.ups;

import com.bolly.spike.model.entity.BaseEntity;

/**
 * 权限信息
 * Author   : Bolly
 * CreateAt : 2018/05/11 18:55:40
 */
public class Permission extends BaseEntity {

    private String name;
    private String permission;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
