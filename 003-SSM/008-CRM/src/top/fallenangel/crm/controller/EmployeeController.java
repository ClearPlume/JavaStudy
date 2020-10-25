package top.fallenangel.crm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.crm.model.entity.AjaxResult;
import top.fallenangel.crm.model.entity.Employee;
import top.fallenangel.crm.service.IEmployeeService;
import top.fallenangel.crm.template.ITemplateService;
import top.fallenangel.crm.template.impl.TemplateController;
import top.fallenangel.crm.util.Util;

@Controller
@RequestMapping("employee")
public class EmployeeController extends TemplateController<Employee> {
    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public ITemplateService<Employee> getService() {
        return employeeService;
    }

    @Override
    public Employee getInstance() {
        return new Employee();
    }

    @Override
    public Integer getInstanceId(Employee entity) {
        return entity.getEmployeeId();
    }

    @RequestMapping("list")
    public PageInfo<Employee> list(Employee employee, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return PageInfo.of(employeeService.list(employee));
    }

    @RequestMapping("detail")
    public Employee detail(int employeeId) {
        return super.view(employeeId);
    }

    @RequestMapping("update")
    public String update(Employee employee) {
        employeeService.update(employee);
        return "redirect:/employee/list";
    }

    @Override
    @RequestMapping("save")
    public String save(Employee employee) {
        return super.save(employee);
    }

    @RequestMapping("lock")
    public String lock(int[] employeeId) {
        employeeService.lock(employeeId);
        return "redirect:/employee/list";
    }

    @RequestMapping("unlock")
    public String unlock(int[] employeeId) {
        employeeService.unlock(employeeId);
        return "redirect:/employee/list";
    }

    @ResponseBody
    @RequestMapping("modifyPwd")
    public AjaxResult modifyPwd(String oldPwd, String newPwd) {
        oldPwd = Util.md5(oldPwd);
        newPwd = Util.md5(newPwd);
        AjaxResult result = new AjaxResult();
        int employeeId = Util.getEmployeeIdFromSession();
        boolean pwdCorrect = employeeService.checkPwd(employeeId, oldPwd);

        if (pwdCorrect) {
            result.setSuccess(true);
            employeeService.updatePwd(employeeId, newPwd);
        } else {
            result.setSuccess(false);
            result.setMsg("密码修改失败，检查旧密码！");
        }
        return result;
    }
}