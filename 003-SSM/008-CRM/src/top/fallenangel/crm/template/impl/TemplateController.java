package top.fallenangel.crm.template.impl;

import top.fallenangel.crm.template.ITemplateService;

import java.util.List;

public abstract class TemplateController<T> {
    public abstract ITemplateService<T> getService();

    void edit(Integer id) {}

    String save(T entity) {
        return "redirect:list";
    }

    public String delete(Integer[] id) {
        getService().delete(id);
        return "redirect:list";
    }

    public List<T> list() {
        return getService().list();
    }
}