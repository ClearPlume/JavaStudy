package top.fallenangel.crm.template.impl;

import top.fallenangel.crm.template.ITemplateService;

import java.util.List;

public abstract class TemplateService<T> implements ITemplateService<T> {
    @Override
    public int save(T record) {
        return getDao().insertSelective(record);
    }

    @Override
    public int delete(Integer[] id) {
        return getDao().deleteByPrimaryKey(id);
    }

    @Override
    public int update(T record) {
        return getDao().updateByPrimaryKeySelective(record);
    }

    @Override
    public T get(Integer id) {
        return getDao().selectByPrimaryKey(id);
    }

    @Override
    public List<T> list() {
        return getDao().selectAll();
    }
}