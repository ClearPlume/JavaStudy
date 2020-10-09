package top.fallenangel.spring.mvc.model.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.spring.mvc.entity.Area;
import top.fallenangel.spring.mvc.model.dao.IAreaDao;
import top.fallenangel.spring.mvc.model.service.IAreaService;

import java.util.List;

@Service
public class AreaService implements IAreaService {
    private final IAreaDao areaDao;

    public AreaService(IAreaDao areaDao) {
        this.areaDao = areaDao;
    }

    @Override
    public List<Area> list() {
        return areaDao.selectAll();
    }

    @Override
    public void delete(Integer[] areaId) {
        areaDao.deleteAll(areaId);
    }

    @Override
    public void modify(Area area) {
        areaDao.updateByPrimaryKey(area);
    }

    @Override
    public Area get(int areaId) {
        return areaDao.selectByPrimaryKey(areaId);
    }

    @Override
    public void save(Area area) {
        areaDao.insert(area);
    }
}