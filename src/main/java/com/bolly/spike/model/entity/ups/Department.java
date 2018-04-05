package com.bolly.spike.model.entity.ups;

import com.bolly.spike.model.entity.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 部门
 * 存在以下约束：
 * 1、名称不能相同
 * 2、同一个上级部门下，子部门的排序不能相同(即使是已经被标记为删除的部门)
 * <p>
 * Author   : Bolly
 * CreateAt : 2017/05/20 11:54:20
 */
public class Department extends BaseEntity {

    public static final Integer LEVEL_ROOT = 1;//顶级
    public static final Integer DELETE_TRUE = 1;//已删除
    public static final Integer DELETE_FALSE = 2;//未删除

    public static final Department DEPARTMENT_ROOT = new Department(1L);

    private String name;//部门名称
    private Integer level;//级别 顶级为1
    private Department parent;//上级部门
    private Integer order;//排序
    private Integer delete; //是否删除

    public Department() {
    }

    private Department(Long id) {
        this.setId(id);
        this.level = LEVEL_ROOT;
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

    public Long getParentId() {
        return parent == null ? null : parent.getId();
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getTreeNodeHtml() {
        return "";
    }

}
