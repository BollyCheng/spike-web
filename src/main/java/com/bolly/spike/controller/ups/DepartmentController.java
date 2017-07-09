package com.bolly.spike.controller.ups;

import com.alibaba.fastjson.JSON;
import com.bolly.spike.entity.ups.Department;
import com.bolly.spike.service.ups.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2017/07/08 22:18:56
 */
@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String listAll() {
        List<Department> departments = departmentService.getAllDepartment();
        return JSON.toJSONString(departments);
    }

    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    public String demo() {
        return "[\n" +
                "\t\t\t{ id:1, pId:0, name:\"父节点1 - 展开\", open:true},\n" +
                "\t\t\t{ id:11, pId:1, name:\"父节点11 - 折叠\"},\n" +
                "\t\t\t{ id:111, pId:11, name:\"叶子节点111\"},\n" +
                "\t\t\t{ id:112, pId:11, name:\"叶子节点112\"},\n" +
                "\t\t\t{ id:113, pId:11, name:\"叶子节点113\"},\n" +
                "\t\t\t{ id:114, pId:11, name:\"叶子节点114\"},\n" +
                "\t\t\t{ id:12, pId:1, name:\"父节点12 - 折叠\"},\n" +
                "\t\t\t{ id:121, pId:12, name:\"叶子节点121\"},\n" +
                "\t\t\t{ id:122, pId:12, name:\"叶子节点122\"},\n" +
                "\t\t\t{ id:123, pId:12, name:\"叶子节点123\"},\n" +
                "\t\t\t{ id:124, pId:12, name:\"叶子节点124\"},\n" +
                "\t\t\t{ id:13, pId:1, name:\"父节点13 - 没有子节点\", isParent:true},\n" +
                "\t\t\t{ id:2, pId:0, name:\"父节点2 - 折叠\"},\n" +
                "\t\t\t{ id:21, pId:2, name:\"父节点21 - 展开\", open:true},\n" +
                "\t\t\t{ id:211, pId:21, name:\"叶子节点211\"},\n" +
                "\t\t\t{ id:212, pId:21, name:\"叶子节点212\"},\n" +
                "\t\t\t{ id:213, pId:21, name:\"叶子节点213\"},\n" +
                "\t\t\t{ id:214, pId:21, name:\"叶子节点214\"},\n" +
                "\t\t\t{ id:22, pId:2, name:\"父节点22 - 折叠\"},\n" +
                "\t\t\t{ id:221, pId:22, name:\"叶子节点221\"},\n" +
                "\t\t\t{ id:222, pId:22, name:\"叶子节点222\"},\n" +
                "\t\t\t{ id:223, pId:22, name:\"叶子节点223\"},\n" +
                "\t\t\t{ id:224, pId:22, name:\"叶子节点224\"},\n" +
                "\t\t\t{ id:23, pId:2, name:\"父节点23 - 折叠\"},\n" +
                "\t\t\t{ id:231, pId:23, name:\"叶子节点231\"},\n" +
                "\t\t\t{ id:232, pId:23, name:\"叶子节点232\"},\n" +
                "\t\t\t{ id:233, pId:23, name:\"叶子节点233\"},\n" +
                "\t\t\t{ id:234, pId:23, name:\"叶子节点234\"},\n" +
                "\t\t\t{ id:3, pId:0, name:\"父节点3 - 没有子节点\", isParent:true}\n" +
                "\t\t]";
    }

}
