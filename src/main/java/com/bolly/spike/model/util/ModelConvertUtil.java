package com.bolly.spike.model.util;

import com.bolly.spike.model.entity.TreeEntity;
import com.bolly.spike.model.vo.ComboTreeVo;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Vector;

/**
 * 模型转换工具
 * Author   : Bolly
 * CreateAt : 2018/04/29 10:45:34
 */
public class ModelConvertUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModelConvertUtil.class);

    /**
     * 将列表转为化树形结构，为easyui-tree的通用模型
     *
     * @param list          列表数据
     * @param clazz         数据的数据类型，必须是TreeEntity的子类
     * @param idFieldName   id字段
     * @param textFieldName text字段
     * @return 树形数据
     */
    public static List<ComboTreeVo> convert(List<?> list, Class<?> clazz, String idFieldName, String textFieldName) {
        List<ComboTreeVo> comboTreeVoList = new Vector<>();
        if (list == null) {
            return comboTreeVoList;
        }

        Field idField = ReflectionUtils.findField(clazz, idFieldName);
        if (!idField.isAccessible())
            idField.setAccessible(true);
        Field textField = ReflectionUtils.findField(clazz, textFieldName);
        if (!textField.isAccessible())
            textField.setAccessible(true);

        for (Object object : list) {
            if (object == null || !(object instanceof TreeEntity)) {
                LOGGER.warn("data is null or class is not TreeEntity. data = {}.", object);
                continue;
            }
            TreeEntity treeEntity = (TreeEntity) object;

            //初始化对象模型
            Long id = (Long) ReflectionUtils.getField(idField, treeEntity);
            String text = (String) ReflectionUtils.getField(textField, treeEntity);
            ComboTreeVo treeVo = new ComboTreeVo(id, text, treeEntity);

            //
            boolean flag = false;
            Long parentId = treeEntity.getParentId();
            //根节点追加到当前列表中
            if (parentId == null || parentId == 0L) {
                comboTreeVoList.add(treeVo);
                continue;
            }

            for (ComboTreeVo comboTreeVo : comboTreeVoList) {
                //一级节点追加到根节点下
                if (NumberUtils.compare(comboTreeVo.getId(), parentId) == 0) {
                    comboTreeVo.addChild(treeVo);
                    flag = true;
                    break;
                }

                //多级节点追加到子节点下
                ComboTreeVo child = comboTreeVo.getChildById(parentId);
                if (child != null) {
                    child.addChild(treeVo);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                LOGGER.warn("un handle data. data=" + treeVo);
            }
        }
        return comboTreeVoList;
    }

}
