package com.bolly.spike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author   : Bolly
 * CreateAt : 2017/4/21
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "redirect:/ups/module/page";
    }

    @RequestMapping(value = {"/demo", "/icon"}, method = RequestMethod.GET)
    public String iconDemo() {
        return "iconDemo";
    }


}
