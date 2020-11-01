package top.fallenangel.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("home")
    public String home() {
        return "home";
    }
}