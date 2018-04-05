package com.bolly.spike.mapper.ups;

import com.bolly.spike.model.entity.ups.Department;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2017/07/03 22:27:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-application.xml")
public class TestDepartmentMapper {

    @Resource
    DepartmentMapper departmentMapper;

    @Test
    public void testAdd() {
        Department department = new Department("HR", 2, Department.DEPARTMENT_ROOT);
        departmentMapper.insert(department);

        Assert.assertTrue(department.getId() > 0);
    }

    @Test
    public void testDeleteById() {
        Department department = new Department();
        department.setId(2L);
        departmentMapper.deleteById(department);
    }

    @Test
    public void testUpdate() {
        Department department = new Department("IT", 2, Department.DEPARTMENT_ROOT);
        department.setId(4L);
        departmentMapper.update(department);
    }

    @Test
    public void testLoadById() {
        Department department = departmentMapper.loadById(2L);

        Assert.assertEquals("HR", department.getName());
    }

    @Test
    public void testListAll() {
        Department department = new Department();

        List<Department> departments = departmentMapper.list(department);

        Assert.assertTrue(departments.size() > 0);
    }

    @Test
    public void testListByName(){
        Department department = new Department();
        department.setName("h");

        List<Department> departments = departmentMapper.list(department);

        Assert.assertTrue(departments.size() > 0);
    }

}
