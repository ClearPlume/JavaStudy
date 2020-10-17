package top.fallenangel.spring.mvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.spring.mvc.entity.Dept;
import top.fallenangel.spring.mvc.entity.Employee;
import top.fallenangel.spring.mvc.model.service.IAreaService;
import top.fallenangel.spring.mvc.model.service.IDeptService;
import top.fallenangel.spring.mvc.model.service.IEmployeeService;

import javax.validation.Valid;
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
    public PageInfo<Employee> list(Map<String, Object> params, Employee employee, @RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) {
        params.put("depts", deptService.list());
        params.put("areas", areaService.list());

        PageHelper.startPage(page, pageSize);
        return PageInfo.of(employeeService.list(employee));
    }

    @RequestMapping("edit")
    public Employee edit(Integer empId) {
        Employee employee;

        if (empId == null) {
            employee = new Employee();
        } else {
            employee = employeeService.get(empId);
        }
        return employee;
    }

    @RequestMapping("save")
    public String save(@Valid Employee employee, Errors errors) {
        Integer deptId = employee.getDept().getDeptId();

        if (deptId == null || deptId <= 0 && deptId != -1 || deptId > deptService.count()) {
            errors.rejectValue("dept.deptId", "", "必须选择部门！");
        } else if (deptId == -1) {
            errors.rejectValue("dept.deptId", "", "请选择部门");
        }

        if (errors.hasErrors()) {
            return "employee/edit";
        }

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