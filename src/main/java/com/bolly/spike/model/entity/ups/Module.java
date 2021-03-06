package com.bolly.spike.model.entity.ups;

import com.bolly.spike.model.entity.TreeEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 模块
 * <p>
 * Author   : Bolly
 * CreateAt : 2017/05/25 22:12:15
 */
public class Module extends TreeEntity<Module> {

    public static final int LEVEL_ROOT = 1;//根级别

    private String name;//模块名称
    private String url;//模块的地址
    private Integer level;//模块级别
    private String order;//模块顺序
    private Application application;//所属应用

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getApplicationName() {
        return application == null ? DEFAULT_STRING_VALUE : application.getName();
    }

    @Override
    public void setParentId(Long parentId) {
        if (parent == null) {
            parent = new Module();
        }
        parent.setId(parentId);
    }

    public String getParentModuleName() {
        return parent == null ? DEFAULT_STRING_VALUE : parent.getName();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
