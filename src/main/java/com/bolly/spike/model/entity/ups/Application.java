package com.bolly.spike.model.entity.ups;

import com.bolly.spike.model.entity.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 应用
 * <p>
 * Author   : Bolly
 * CreateAt : 2017/05/25 22:08:14
 */
public class Application extends BaseEntity {

    private String name;//应用名称
    private String description;//应用描述

    public Application() {
    }

    public Application(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
