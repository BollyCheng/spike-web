package com.bolly.spike.entity;

import com.bolly.spike.entity.ups.User;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 * 所有实体对象均继承此类。包含基本属性：
 * 1、实体id
 * 2、创建人
 * 3、创建时间
 * 4、最后更新人
 * 5、最后更新时间
 * <p>
 * Author   : Bolly
 * CreateAt : 2017/05/20 11:54:37
 */
public abstract class BaseEntity implements Serializable {

    private Long Id;//主键

    private User creator;//创建人
    private Date createAt;//创建时间
    private User lastUpdateBy;//最后更新人
    private Date lastUpdateAt;//最后更新时间

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public User getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(User lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateAt() {
        return lastUpdateAt;
    }

    public void setLastUpdateAt(Date lastUpdateAt) {
        this.lastUpdateAt = lastUpdateAt;
    }

}
