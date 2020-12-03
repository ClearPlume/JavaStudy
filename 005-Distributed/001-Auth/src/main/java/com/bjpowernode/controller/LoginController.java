package com.bjpowernode.controller;

import com.bjpowernode.entity.User;
import com.bjpowernode.model.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private final IUserService userService;

    public LoginController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("login")
    void login() { }

    @RequestMapping("saveLogin")
    String saveLogin(Model model, User user, HttpSession session) {
        model.addAttribute("user", user);

        User userDB = userService.login(user);

        if (userDB != null) {
            session.setAttribute("loginUser", userDB);
            return "redirect:/index";
        } else {
            user.setMsg("登录失败请检查用户名或密码！");
            return "login";
        }
    }

    @RequestMapping("logout")
    String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return "login";
    }
}
