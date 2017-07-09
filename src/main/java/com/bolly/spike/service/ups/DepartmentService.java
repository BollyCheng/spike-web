package com.bolly.spike.service.ups;

import com.bolly.spike.entity.ups.Department;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2017/07/08 22:13:27
 */
public interface DepartmentService {

    void insert(Department department);

    void update(Department department);

    List<Department> getAllDepartment();

}
