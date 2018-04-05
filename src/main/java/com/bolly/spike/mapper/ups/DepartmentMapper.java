package com.bolly.spike.mapper.ups;

import com.bolly.spike.model.entity.ups.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2017/05/30 20:59:05
 */
@Repository
public interface DepartmentMapper {

    void insert(Department department);

    void deleteById(Department department);

    void update(Department department);

    Department loadById(Long id);

    List<Department> list(Department department);

}
