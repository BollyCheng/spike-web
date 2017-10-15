package com.bolly.spike.entity;

import com.bolly.spike.entity.ups.User;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    protected static final String DEFAULT_STRING_VALUE = "";
    protected static final Integer DEFAULT_INT_VALUE = 0;

    private Long Id;//主键

    private User creator;//创建人
    private Date createAt;//创建时间
    private User lastEditBy;//最后更新人
    private Date lastEditAt;//最后更新时间

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
        if (createAt == null)
            return null;
        return (Date) createAt.clone();
    }

    public void setCreateAt(Date createAt) {
        this.createAt = (Date) createAt.clone();
    }

    public User getLastEditBy() {
        return lastEditBy;
    }

    public void setLastEditBy(User lastEditBy) {
        this.lastEditBy = lastEditBy;
    }

    public Date getLastEditAt() {
        if (lastEditAt == null)
            return null;
        return (Date) lastEditAt.clone();
    }

    public void setLastEditAt(Date lastEditAt) {
        this.lastEditAt = (Date) lastEditAt.clone();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
