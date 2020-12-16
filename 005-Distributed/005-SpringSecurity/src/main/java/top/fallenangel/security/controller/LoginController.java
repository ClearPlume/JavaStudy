package top.fallenangel.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.security.model.entity.User;
import top.fallenangel.security.service.IUserService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping("login")
    void login() { }

    @RequestMapping("saveLogin")
    String saveLogin(Model model, User user, HttpSession session) {

        User dbUser = userService.login(user);

        if (dbUser == null) {
            model.addAttribute("user", user);
            user.setMsg("登录失败请检查用户名或密码！");
            return "login";
        }

        model.addAttribute("user", dbUser);
        session.setAttribute("user", dbUser);
        return "redirect:index";
    }

    @RequestMapping("logout")
    String logout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }
}
