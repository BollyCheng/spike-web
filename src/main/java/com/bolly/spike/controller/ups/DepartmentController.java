package com.bolly.spike.controller.ups;

import com.bolly.spike.model.entity.ups.Department;
import com.bolly.spike.service.ups.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2017/07/08 22:18:56
 */
@RestController
@RequestMapping(value = "/ups/department")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @PostMapping(value = "/list")
    @ResponseBody
    public List<Department> listAll() {
        return departmentService.getAllDepartment();
    }

}
