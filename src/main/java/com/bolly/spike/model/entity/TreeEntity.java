package com.bolly.spike.model.entity;

/**
 * 树形结构模型
 * Author   : Bolly
 * CreateAt : 2018/04/29 10:48:02
 */
public abstract class TreeEntity<T extends TreeEntity> extends BaseEntity {

    protected T parent; //父节点

    public T getParent() {
        return this.parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }

    public Long getParentId() {
        return parent == null ? null : parent.getId();
    }

    public abstract void setParentId(Long parentId);

}
