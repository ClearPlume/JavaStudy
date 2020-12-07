package top.fallenangel.session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping("login")
    public String login(HttpSession session) {

        session.setAttribute("loginUser", "坠天使");

        return "redirect:/";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {

        session.removeAttribute("loginUser");

        return "redirect:/";
    }
}
