package com.bolly.spike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author   : Bolly
 * CreateAt : 2017/4/21
 */
@Controller
public class HomeController {

    @GetMapping(value = "/home")
    public String home() {
//        return "home";
        return "redirect:/math/main";
        // return "redirect:/ups/user/page";
    }

    @GetMapping(value = "/icon/page")
    public String iconDemo() {
        return "iconDemo";
    }

}
