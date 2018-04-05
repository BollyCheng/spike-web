package com.bolly.spike.model.entity.its;

import com.bolly.spike.model.entity.BaseEntity;

/**
 * 问题分类
 * Author   : Bolly
 * CreateAt : 2017/04/23 17:01:19
 */
public class IssueCategory extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
