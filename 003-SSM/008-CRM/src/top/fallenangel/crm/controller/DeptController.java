package top.fallenangel.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.crm.model.entity.Dept;
import top.fallenangel.crm.service.IDeptService;
import top.fallenangel.crm.template.ITemplateService;
import top.fallenangel.crm.template.impl.TemplateController;

@Controller
@RequestMapping("dept")
public class DeptController extends TemplateController<Dept> {
    private final IDeptService deptService;

    public DeptController(IDeptService deptService) {
        this.deptService = deptService;
    }

    @Override
    public ITemplateService<Dept> getService() {
        return deptService;
    }

    @RequestMapping("list")
    public void list(Object flag) { }
}