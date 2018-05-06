package com.bolly.spike.controller.ups;

import com.bolly.spike.model.entity.ups.Module;
import com.bolly.spike.service.ups.ModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2018/04/07 21:36:32
 */
@Controller
@RequestMapping("/ups/module")
public class ModuleController {

    @Resource
    private ModuleService moduleService;

    @GetMapping(value = {"/page"})
    public String userPage() {
        return "ups.module.page";
    }

    @PostMapping(value = "/list")
    @ResponseBody
    public List<Module> list() {
        return moduleService.list();
    }


}
