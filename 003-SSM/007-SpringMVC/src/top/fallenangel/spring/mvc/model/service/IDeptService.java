package top.fallenangel.spring.mvc.model.service;

import top.fallenangel.spring.mvc.entity.Dept;

import java.util.List;

public interface IDeptService {
    List<Dept> list();

    int count();

    void save(Dept dept);

    boolean exists(int deptId);

    Dept get(int deptId);

    void modify(Dept dept);

    void delete(Integer[] deptId);
}