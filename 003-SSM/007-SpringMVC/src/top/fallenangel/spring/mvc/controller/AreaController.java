package top.fallenangel.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.spring.mvc.entity.Area;
import top.fallenangel.spring.mvc.model.service.IAreaService;

import java.util.List;

@Controller
@RequestMapping("area")
public class AreaController {
    private final IAreaService areaService;

    public AreaController(IAreaService areaService) {
        this.areaService = areaService;
    }

    @RequestMapping("list")
    public List<Area> list() {
        return areaService.list();
    }

    @RequestMapping("add")
    public void add() { }

    @RequestMapping("save")
    public String save(Area area) {
        areaService.save(area);
        return "redirect:/area/list";
    }

    @RequestMapping("gai")
    public Area gai(int areaId) {
        return areaService.get(areaId);
    }

    @RequestMapping("modify")
    public String modify(Area area) {
        areaService.modify(area);
        return "redirect:/area/list";
    }

    @RequestMapping("delete")
    public String delete(Integer[] areaId) {
        areaService.delete(areaId);
        return "redirect:/area/list";
    }
}