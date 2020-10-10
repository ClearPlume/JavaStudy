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

    @RequestMapping("edit")
    public Area edit(Integer areaId) {
        Area area;

        if (areaId == null) {
            area = new Area();
        } else {
            area = areaService.get(areaId);
        }

        return area;
    }

    @RequestMapping("save")
    public String save(Area area) {
        if (area.getAreaId() == null) {
            areaService.save(area);
        } else {
            areaService.modify(area);
        }
        return "redirect:/area/list";
    }

    @RequestMapping("delete")
    public String delete(Integer[] areaId) {
        areaService.delete(areaId);
        return "redirect:/area/list";
    }
}