package top.fallenangel.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
    @RequestMapping("jsp")
    public String jsp(Model model) {
        model.addAttribute("name", "张三");
        return "index";
    }
}