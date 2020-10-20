package top.fallenangel.crm.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.crm.model.dao.IDeptDao;
import top.fallenangel.crm.model.entity.Dept;
import top.fallenangel.crm.service.IDeptService;

import java.util.List;

@Service
public class DeptService implements IDeptService {
    private final IDeptDao deptDao;

    public DeptService(IDeptDao deptDao) {
        this.deptDao = deptDao;
    }

    @Override
    public List<Dept> list() {
        return deptDao.selectAll();
    }
}