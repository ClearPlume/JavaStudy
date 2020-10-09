package top.fallenangel.spring.mvc.model.service;

import top.fallenangel.spring.mvc.entity.Dept;

import java.util.List;

public interface IDeptService {
    List<Dept> list();

    void save(Dept dept);

    Dept get(int deptId);

    void modify(Dept dept);

    void delete(Integer[] deptId);

    int count();
}