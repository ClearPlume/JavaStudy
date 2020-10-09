package top.fallenangel.web;

import top.fallenangel.bean.Employee;
import top.fallenangel.service.IEmployeeService;
import top.fallenangel.service.impl.EmployeeServiceImpl;
import top.fallenangel.util.BeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employeeAction")
public class EmployeeServlet extends BaseServlet {
    private final IEmployeeService employeeService = new EmployeeServiceImpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageSize = 5;

        String pageStr = req.getParameter("page");
        int page = Integer.parseInt(pageStr == null ? "1" : pageStr);
        int pages = employeeService.count() / pageSize + (employeeService.count() % pageSize == 0 ? 0 : 1);
        int pageStart = (page - 1) * pageSize;

        List<Map<String, Object>> employees = employeeService.getEmployeesWithPage(pageStart, pageSize);
        req.getSession().setAttribute("pages", pages);
        req.getSession().setAttribute("employees", employees);
        req.getSession().setAttribute("curPage", page);
        resp.sendRedirect("/013_LastSummary/employee.jsp");
    }

    protected void queryBeforeModify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int empNo = Integer.parseInt(req.getParameter("emp-no"));

        Employee employee = employeeService.query(empNo);
        List<Map<String, Object>> jobs = employeeService.jobs();

        req.getSession().setAttribute("employee", employee);
        req.getSession().setAttribute("jobs", jobs);
        resp.getWriter().write("OK");
        resp.getWriter().flush();
    }

    protected void queryBeforeInsert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Map<String, Object>> jobs = employeeService.jobs();
        req.getSession().setAttribute("jobs", jobs);
        resp.sendRedirect("/012_Mybatis/insert_emp.jsp");
    }

    protected void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = BeanUtil.formToBean(Employee.class, req.getParameterMap());
        employeeService.insert(employee);
        req.getRequestDispatcher("/employeeAction?action=list").forward(req, resp);
    }

    protected void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = BeanUtil.formToBean(Employee.class, req.getParameterMap());
        employeeService.modify(employee);
        req.getRequestDispatcher("/employeeAction?action=list").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] nos = req.getParameterValues("emp-no");
        int[] empNo = new int[nos.length];
        for (int i = 0; i < nos.length; i++) {
            empNo[i] = Integer.parseInt(nos[i]);
        }
        employeeService.delete(empNo);
        resp.getWriter().write("OK");
        resp.getWriter().flush();
    }
}