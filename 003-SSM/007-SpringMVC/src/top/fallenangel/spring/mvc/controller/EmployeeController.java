package top.fallenangel.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.spring.mvc.entity.Employee;
import top.fallenangel.spring.mvc.model.service.IAreaService;
import top.fallenangel.spring.mvc.model.service.IDeptService;
import top.fallenangel.spring.mvc.model.service.IEmployeeService;
import top.fallenangel.spring.mvc.util.Pager;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    private final IEmployeeService employeeService;
    private final IDeptService deptService;
    private final IAreaService areaService;

    public EmployeeController(IEmployeeService employeeService, IDeptService deptService, IAreaService areaService) {
        this.employeeService = employeeService;
        this.deptService = deptService;
        this.areaService = areaService;
    }

    @RequestMapping("list")
    public List<Employee> list(Map<String, Object> params, Pager pager, Employee employee) {
        params.put("depts", deptService.list());
        params.put("areas", areaService.list());

        return employeeService.list(employee, pager);
    }

    @RequestMapping("edit")
    public Employee edit(Integer empId, Map<String, Object> param) {
        Employee employee;

        if (empId == null) {
            employee = new Employee();
        } else {
            employee = employeeService.get(empId);
        }
        param.put("depts", deptService.list());

        return employee;
    }

    @RequestMapping("save")
    public String save(Employee employee) {
        if (employee.getEmpId() == null) {
            employeeService.save(employee);
        } else {
            employeeService.modify(employee);
        }
        return "redirect:/employee/list";
    }

    @RequestMapping("delete")
    public String delete(Integer[] empId) {
        employeeService.delete(empId);
        return "redirect:/employee/list";
    }

    @RequestMapping("view")
    public Employee view(Integer empId) {
        return employeeService.get(empId);
    }
}