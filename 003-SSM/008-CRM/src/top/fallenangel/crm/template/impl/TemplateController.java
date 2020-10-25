package top.fallenangel.crm.template.impl;

import top.fallenangel.crm.template.ITemplateService;

import java.util.List;

public abstract class TemplateController<T extends BaseEntity> {
    public abstract ITemplateService<T> getService();

    public abstract T getInstance();

    public abstract Integer getInstanceId(T entity);

    public T edit(Integer id) {
        T t;

        if (id == null) {
            t = getInstance();
        } else {
            t = getService().get(id);
        }
        return t;
    }

    public String save(T entity) {
        if (getInstanceId(entity) == null) {
            getService().save(entity);
        } else {
            getService().update(entity);
        }
        return "redirect:list";
    }

    public String delete(Integer[] id) {
        getService().delete(id);
        return "redirect:list";
    }

    public List<T> list() {
        return getService().list();
    }

    public T view(Integer id) {
        return getService().get(id);
    }
}