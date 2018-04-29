package com.bolly.spike.model.vo;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;
import java.util.Vector;

/**
 * Author   : Bolly
 * CreateAt : 2018/04/29 10:42:08
 */
public class ComboTreeVo {

    private Long id;
    private String text;
    private Object data;
    private List<ComboTreeVo> children;

    public ComboTreeVo(Long id, String text, Object data) {
        this.id = id;
        this.text = text;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<ComboTreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<ComboTreeVo> children) {
        this.children = children;
    }

    public ComboTreeVo getChildById(Long id) {
        if (children == null) {
            return null;
        }
        ComboTreeVo result = null;
        for (ComboTreeVo child : children) {
            if (NumberUtils.compare(id, child.id) == 0) {
                result = child;
                break;
            }
            result = child.getChildById(id);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    public void addChild(ComboTreeVo child) {
        if (children == null) {
            children = new Vector<>();
        }
        children.add(child);
    }

    @Override
    public String toString() {
        return "ComboTreeVo{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", data=" + data +
                ", children=" + children +
                '}';
    }
}
