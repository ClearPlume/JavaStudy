package top.fallenangel.spring.mvc.model.service;

import top.fallenangel.spring.mvc.entity.Area;

import java.util.List;

public interface IAreaService {
    List<Area> list();

    void delete(Integer[] areaId);

    void modify(Area area);

    Area get(int areaId);

    void save(Area area);
}