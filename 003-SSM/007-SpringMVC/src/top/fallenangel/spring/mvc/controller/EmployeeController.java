package top.fallenangel.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.spring.mvc.entity.Area;
import top.fallenangel.spring.mvc.entity.Dept;
import top.fallenangel.spring.mvc.entity.Employee;
import top.fallenangel.spring.mvc.entity.EmployeeVO;
import top.fallenangel.spring.mvc.model.service.IAreaService;
import top.fallenangel.spring.mvc.model.service.IDeptService;
import top.fallenangel.spring.mvc.model.service.IEmployeeService;

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
    public List<Employee> list(Map<String, Object> params, Integer page, EmployeeVO employeeVO) {
        if (null == page) {
            page = 1;
        }
        int pageSize = 3;
        int pages = employeeService.count(employeeVO) / pageSize + (employeeService.count(employeeVO) % pageSize == 0 ? 0 : 1);
        if (page > pages) {
            page = pages;
        }
        int pageStart = page == 0 ? 0 : (page - 1) * pageSize;

        List<Dept> depts = deptService.list();
        List<Area> areas = areaService.list();

        employeeVO.setPageStart(pageStart);
        employeeVO.setPageSize(pageSize);
        if (employeeVO.getDeptId() == null) {
            employeeVO.setDeptId(-1);
        }
        if (employeeVO.getAreaId() == null) {
            employeeVO.setAreaId(-1);
        }

        params.put("depts", depts);
        params.put("areas", areas);
        params.put("employeeVO", employeeVO);
        params.put("pages", pages);
        params.put("curPage", page);

        return employeeService.list(employeeVO);
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