package top.fallenangel.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.security.model.entity.User;

@Controller
public class LoginController {

    @RequestMapping("login")
    String login(Model model, User user) {

        model.addAttribute("user", user);
        return "login";
    }

    @RequestMapping("logout")
    String logout() {
        return "login";
    }
}
