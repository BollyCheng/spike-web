package com.bolly.spike.controller.ups;

import com.bolly.spike.entity.ups.User;
import com.bolly.spike.service.ups.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author   : Bolly
 * CreateAt : 2017/4/21 0021
 */
@Controller
@RequestMapping("/ups/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = {"", "/", "/page"})
    public String userPage() {
        return "ups.user.page";
    }

    @PostMapping(value = "/list")
    @ResponseBody
    public List<User> list() {
        return userService.list();
    }

}
