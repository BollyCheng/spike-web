package com.bolly.spike.model.util;

import com.bolly.spike.mapper.ups.DepartmentMapper;
import com.bolly.spike.model.entity.ups.Department;
import com.bolly.spike.model.vo.ComboTreeVo;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2018/04/29 11:45:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-application.xml")
public class TestModelConvertUtil {

    @Resource
    DepartmentMapper departmentMapper;

    @Test
    public void testConvert() {
        List<Department> departments = departmentMapper.list(new Department());
        List<ComboTreeVo> comboTreeVoList = ModelConvertUtil.convert(departments, Department.class, "id", "name");

        Assert.assertNotNull(CollectionUtils.isNotEmpty(comboTreeVoList));
    }

}
