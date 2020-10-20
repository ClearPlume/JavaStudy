package top.fallenangel.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("index")
    public String index() {
        return "workbench/index";
    }

    @RequestMapping("mainIndex")
    public String mainIndex() {
        return "workbench/main/index";
    }
}