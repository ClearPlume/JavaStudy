package top.fallenangel.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.crm.model.entity.Dept;
import top.fallenangel.crm.service.IDeptService;
import top.fallenangel.crm.template.ITemplateService;
import top.fallenangel.crm.template.impl.TemplateController;
import top.fallenangel.crm.util.ApplicationCacheListener;
import top.fallenangel.crm.util.Util;

import java.util.Map;

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

    @Override
    public Dept getInstance() {
        return new Dept();
    }

    @Override
    public Integer getInstanceId(Dept entity) {
        return entity.getDeptId();
    }

    @RequestMapping("list")
    public void listEntry() { }

    @RequestMapping("updateCache")
    public String updateCache() {
        ApplicationCacheListener.loadDeptsIntoApplication(Util.getServletContext());
        return "redirect:/dept/list";
    }

    @Override
    @RequestMapping("delete")
    public String delete(Integer[] id) {
        deptService.delete(id);
        Map<Integer, Dept> deptMap = Util.getDeptsFromApplication();

        for (Integer i : id) {
            deptMap.remove(i);
        }
        return "redirect:/dept/list";
    }

    @Override
    @RequestMapping("edit")
    public Dept edit(Integer id) {
        return super.edit(id);
    }

    @Override
    @RequestMapping("save")
    public String save(Dept entity) {
        Map<Integer, Dept> deptMap = Util.getDeptsFromApplication();
        if (entity.getDeptId() == null) {
            deptService.save(entity);
            deptMap.put(entity.getDeptId(), entity);
        } else {
            deptService.update(entity);
            deptMap.replace(entity.getDeptId(), entity);
        }
        return "redirect:/dept/list";
    }
}