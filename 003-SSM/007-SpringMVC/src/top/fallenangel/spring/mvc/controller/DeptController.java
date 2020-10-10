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

    @RequestMapping("edit")
    public Dept edit(Integer deptId, Map<String, Object> param) {
        Dept dept;

        if (deptId == null) {
            dept = new Dept();
        } else {
            dept = deptService.get(deptId);
        }
        param.put("areas", areaService.list());

        return dept;
    }

    @RequestMapping("save")
    public String save(Dept dept) {
        if (dept.getDeptId() == null) {
            deptService.save(dept);
        } else {
            deptService.modify(dept);
        }
        return "redirect:/dept/list";
    }

    @RequestMapping("delete")
    public String delete(Integer[] deptId) {
        deptService.delete(deptId);
        return "redirect:/dept/list";
    }
}