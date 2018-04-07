package com.bolly.spike.controller.ups;

import com.bolly.spike.model.entity.ups.Application;
import com.bolly.spike.service.ups.ApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2018/04/07 21:37:00
 */
@Controller
@RequestMapping("/ups/application")
public class ApplicationController {

    @Resource
    private ApplicationService applicationService;

    @PostMapping(value = "/list")
    @ResponseBody
    public List<Application> list(){
        return applicationService.list();
    }

}
