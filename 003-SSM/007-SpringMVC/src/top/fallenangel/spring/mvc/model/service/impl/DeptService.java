package top.fallenangel.spring.mvc.model.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.spring.mvc.entity.Dept;
import top.fallenangel.spring.mvc.model.dao.IDeptDao;
import top.fallenangel.spring.mvc.model.service.IDeptService;

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

    @Override
    public void save(Dept dept) {
        deptDao.insert(dept);
    }

    @Override
    public boolean exists(int deptId) {
        return deptDao.selectByPrimaryKey(deptId) != null;
    }

    @Override
    public Dept get(int deptId) {
        return deptDao.selectByPrimaryKey(deptId);
    }

    @Override
    public void modify(Dept dept) {
        deptDao.updateByPrimaryKey(dept);
    }

    @Override
    public void delete(Integer[] deptId) {
        deptDao.deleteAll(deptId);
    }

    @Override
    public int count() {
        return deptDao.count();
    }
}