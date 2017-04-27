package com.bolly.spike.controller.ups;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author   : Bolly
 * CreateAt : 2017/4/21 0021
 */
@Controller
@RequestMapping("/ups/user")
public class UserController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String list() {
        return "/ups/user/list";
    }

}
