package com.bolly.spike.entity.ups;

import com.bolly.spike.entity.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 部门
 * <p>
 * Author   : Bolly
 * CreateAt : 2017/05/20 11:54:20
 */
public class Department extends BaseEntity {

    public static final Integer LEVEL_ROOT = 1;//顶级

    private String name;//部门名称
    private Integer level;//级别 顶级为1
    private Department parent;//上级部门

    public Department() {
    }

    public Department(String name, Integer level, Department parent) {
        this.name = name;
        this.level = level;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
