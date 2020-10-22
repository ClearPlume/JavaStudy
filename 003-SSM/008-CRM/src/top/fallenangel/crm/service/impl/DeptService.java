package top.fallenangel.crm.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.crm.model.dao.IDeptDao;
import top.fallenangel.crm.model.entity.Dept;
import top.fallenangel.crm.service.IDeptService;
import top.fallenangel.crm.template.ITemplateDao;
import top.fallenangel.crm.template.impl.TemplateService;

@Service
public class DeptService extends TemplateService<Dept> implements IDeptService {
    private final IDeptDao<Dept> deptDao;

    public DeptService(IDeptDao<Dept> deptDao) {
        this.deptDao = deptDao;
    }

    @Override
    public ITemplateDao<Dept> getDao() {
        return deptDao;
    }
}