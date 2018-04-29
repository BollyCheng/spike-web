package com.bolly.spike.service.ups.impl;

import com.bolly.spike.model.entity.ups.Department;
import com.bolly.spike.mapper.ups.DepartmentMapper;
import com.bolly.spike.service.ups.DepartmentService;
import org.apache.commons.collections4.CollectionUtils;
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
    public Department insert(Department department) {
        List<Department> brothers = listByParentId(department.getParentId());
        if (CollectionUtils.isNotEmpty(brothers)) {
            Department lastBrother = brothers.get(brothers.size() - 1);
            department.setLevel(lastBrother.getLevel());
            department.setOrder(lastBrother.getOrder() + 1);
        } else {
            Department parent = loadById(department.getParentId());
            if (parent == null) {
                department.setLevel(Department.LEVEL_ROOT);
            } else {
                department.setLevel(parent.getLevel() + 1);
            }
            department.setOrder(1);
        }
        departmentMapper.insert(department);
        return department;
    }

    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }

    public Department loadById(Long id) {
        return departmentMapper.loadById(id);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentMapper.list(new Department());
    }

    public List<Department> listByParentId(Long parentId) {
        Department department = new Department();
        department.setParentId(parentId);
        return departmentMapper.list(department);
    }
}
