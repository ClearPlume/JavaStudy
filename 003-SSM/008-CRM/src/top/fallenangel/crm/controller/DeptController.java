package top.fallenangel.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.crm.service.IDeptService;

@Controller
@RequestMapping("dept")
public class DeptController {
    private final IDeptService deptService;

    public DeptController(IDeptService deptService) {
        this.deptService = deptService;
    }

    @RequestMapping("list")
    public void list() { }
}