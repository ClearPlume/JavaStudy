package top.fallenangel.employee;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.fallenangel.employee.controller.EmployeeController;
import top.fallenangel.employee.model.bean.Area;
import top.fallenangel.employee.model.bean.Dept;
import top.fallenangel.employee.model.bean.Employee;

import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-employee.xml");
        EmployeeController employeeController = xmlApplicationContext.getBean(EmployeeController.class);

        Area area = new Area();
        area.setAreaId(5);

        Dept dept = new Dept();
        dept.setDeptId(2);
        dept.setArea(area);

        Employee newEmployee = new Employee();
        newEmployee.setEmpId(1);
        newEmployee.setEmpName("张三");
        newEmployee.setDept(dept);

        employeeController.modify(newEmployee);

        List<Employee> employees = employeeController.list();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}