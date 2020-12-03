package com.bjpowernode.controller;

import com.bjpowernode.model.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("login")
    void login() { }

    @RequestMapping("saveLogin")
    String saveLogin(User user) {
        UsernamePasswordToken loginToken = new UsernamePasswordToken(user.getUserName(), user.getUserPwd());

        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(loginToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            user.setMsg("登录失败请检查用户名或密码！");
            return "login";
        }
        return "redirect:index";
    }

    @RequestMapping("logout")
    String logout() {
        SecurityUtils.getSubject().logout();
        return "login";
    }
}
