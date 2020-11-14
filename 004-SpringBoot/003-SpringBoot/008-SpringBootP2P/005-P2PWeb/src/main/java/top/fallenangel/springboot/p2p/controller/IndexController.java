package top.fallenangel.springboot.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("avgRate", 13.85);
        return "index";
    }
}
