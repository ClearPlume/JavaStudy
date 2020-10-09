package top.fallenangel.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.spring.mvc.entity.Dept;
import top.fallenangel.spring.mvc.model.service.IAreaService;
import top.fallenangel.spring.mvc.model.service.IDeptService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("dept")
public class DeptController {
    private final IDeptService deptService;
    private final IAreaService areaService;

    public DeptController(IDeptService deptService, IAreaService areaService) {
        this.deptService = deptService;
        this.areaService = areaService;
    }

    @RequestMapping("list")
    public List<Dept> list() {
        return deptService.list();
    }

    @RequestMapping("add")
    public void add(Map<String, Object> areas) {
        areas.put("areas", areaService.list());
    }

    @RequestMapping("save")
    public String save(Dept dept) {
        deptService.save(dept);
        return "redirect:/dept/list";
    }

    @RequestMapping("gai")
    public Dept gai(int deptId, Map<String, Object> deptArea) {
        deptArea.put("areas", areaService.list());
        return deptService.get(deptId);
    }

    @RequestMapping("modify")
    public String modify(Dept dept) {
        deptService.modify(dept);
        return "redirect:/dept/list";
    }

    @RequestMapping("delete")
    public String delete(Integer[] deptId) {
        deptService.delete(deptId);
        return "redirect:/dept/list";
    }
}