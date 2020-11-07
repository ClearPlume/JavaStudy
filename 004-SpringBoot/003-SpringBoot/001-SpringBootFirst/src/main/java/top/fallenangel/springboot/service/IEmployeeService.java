package top.fallenangel.springboot.service;

import top.fallenangel.springboot.model.entity.Employee;

public interface IEmployeeService {
    Employee get(int id);

    int count();
}