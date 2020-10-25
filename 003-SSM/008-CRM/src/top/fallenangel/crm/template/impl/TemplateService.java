package top.fallenangel.crm.template.impl;

import top.fallenangel.crm.template.ITemplateService;
import top.fallenangel.crm.util.Util;

import java.util.Date;
import java.util.List;

public abstract class TemplateService<T extends BaseEntity> implements ITemplateService<T> {
    @Override
    public int save(T record) {
        record.setCreator(Util.getEmployeeFromSession());
        record.setCreateTime(new Date());
        record.setUpdater(Util.getEmployeeFromSession());
        record.setUpdateTime(new Date());

        return getDao().insertSelective(record);
    }

    @Override
    public int delete(Integer[] id) {
        return getDao().deleteByPrimaryKey(id);
    }

    @Override
    public int update(T record) {
        record.setUpdater(Util.getEmployeeFromSession());
        record.setUpdateTime(new Date());

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