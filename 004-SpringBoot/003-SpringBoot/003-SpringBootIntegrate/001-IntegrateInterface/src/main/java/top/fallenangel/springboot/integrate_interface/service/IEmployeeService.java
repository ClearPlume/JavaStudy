package top.fallenangel.springboot.integrate_interface.service;

import top.fallenangel.springboot.integrate_interface.model.entity.Employee;

public interface IEmployeeService {
    Employee view(int id);

    int count();
}
