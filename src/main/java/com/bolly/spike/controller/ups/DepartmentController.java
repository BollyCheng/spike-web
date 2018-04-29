package com.bolly.spike.controller.ups;

import com.bolly.spike.model.dto.SpikeRestfulResult;
import com.bolly.spike.model.entity.ups.Department;
import com.bolly.spike.model.util.ModelConvertUtil;
import com.bolly.spike.model.vo.ComboTreeVo;
import com.bolly.spike.service.ups.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Resource
    private DepartmentService departmentService;

    @PostMapping(value = "/list")
    @ResponseBody
    public List<Department> listAll() {
        return departmentService.getAllDepartment();
    }

    @PostMapping(value = "/combotree")
    @ResponseBody
    public List<ComboTreeVo> getDepartmentTree() {
        List<Department> departments = departmentService.getAllDepartment();
        return ModelConvertUtil.convert(departments, Department.class, "id", "name");
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public SpikeRestfulResult newDepartment(Department department) {
        Department data = departmentService.insert(department);
        return new SpikeRestfulResult(data);
    }

}
