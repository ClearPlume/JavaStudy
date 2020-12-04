package com.bjpowernode.controller;

import com.bjpowernode.model.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController
{
    @RequestMapping("login")
    void login() { }

    @RequestMapping("saveLogin")
    String saveLogin(Model model, User user, @RequestParam(defaultValue = "false") Boolean remember)
    {
        UsernamePasswordToken loginToken = new UsernamePasswordToken(user.getUserName(), user.getUserPwd());
        loginToken.setRememberMe(remember);

        try
        {
            SecurityUtils.getSubject().login(loginToken);
        }
        catch (AuthenticationException e)
        {
            e.printStackTrace();

            model.addAttribute("user", user);
            user.setMsg("登录失败请检查用户名或密码！");

            return "login";
        }
        return "redirect:index";
    }

    @RequestMapping("logout")
    String logout()
    {
        SecurityUtils.getSubject().logout();
        return "login";
    }
}
