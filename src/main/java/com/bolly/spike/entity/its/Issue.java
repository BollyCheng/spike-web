package com.bolly.spike.entity.its;

import com.bolly.spike.entity.BaseEntity;

/**
 * 问题
 * Author   : Bolly
 * CreateAt : 2017/04/23 16:22:01
 */
public class Issue extends BaseEntity {

    private String title; //标题
    private String description; //问题描述
    private IssueCategory category; //问题分类


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IssueCategory getCategory() {
        return category;
    }

    public void setCategory(IssueCategory category) {
        this.category = category;
    }

}
