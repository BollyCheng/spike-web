package com.bolly.spike.service.ups.impl;

import com.bolly.spike.model.entity.ups.Department;
import com.bolly.spike.mapper.ups.DepartmentMapper;
import com.bolly.spike.service.ups.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2017/07/08 22:13:44
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public void insert(Department department) {
        departmentMapper.insert(department);
    }

    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentMapper.list(new Department());
    }

}
