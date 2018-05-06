package com.bolly.spike.controller;

import com.bolly.spike.model.dto.SpikeRestfulResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author   : Bolly
 * CreateAt : 2018/05/05 11:20:08
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public String login() {
        LOGGER.info("show login page.");
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public SpikeRestfulResult login(String username, String password) {
        LOGGER.info("receive login request of post. username={}", username);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        return new SpikeRestfulResult("login success.");
    }

    @GetMapping("/logout")
    public String logout() {
        LOGGER.info("logout");
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }

}
