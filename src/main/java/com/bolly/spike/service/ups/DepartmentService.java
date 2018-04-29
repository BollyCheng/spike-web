package com.bolly.spike.service.ups;

import com.bolly.spike.model.entity.ups.Department;

import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2017/07/08 22:13:27
 */
public interface DepartmentService {

    Department insert(Department department);

    void update(Department department);

    Department loadById(Long id);

    List<Department> getAllDepartment();

}
