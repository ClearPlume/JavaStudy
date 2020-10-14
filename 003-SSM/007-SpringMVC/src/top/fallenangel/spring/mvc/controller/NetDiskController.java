package top.fallenangel.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("netDisk")
public class NetDiskController {
    @RequestMapping("list")
    public void list() { }
}