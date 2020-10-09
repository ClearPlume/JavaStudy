package top.fallenangel.dao.impl;

import top.fallenangel.bean.Employee;
import top.fallenangel.dao.IEmployeeDao;
import top.fallenangel.util.DBUtil;

import java.util.List;
import java.util.Map;

public class EmployeeDaoImpl implements IEmployeeDao {
    @Override
    public List<Employee> getEmployees() {
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        List<Employee> employees = DBUtil.query(Employee.class, "SELECT * FROM emp");
        DBUtil.close();
        return employees;
    }

    @Override
    public List<Employee> getEmployeesWithPage(int pageStart, int pageSize) {
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        List<Employee> employees = DBUtil.query(Employee.class, "SELECT * FROM emp limit ?, ?", pageStart, pageSize);
        DBUtil.close();
        return employees;
    }

    @Override
    public int count() {
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        int recordNum = DBUtil.queryRecordNum("SELECT count(*) FROM emp");
        DBUtil.close();
        return recordNum;
    }

    @Override
    public void insertEmployee(Employee employee) {
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        DBUtil.begin();
        DBUtil.update("INSERT INTO emp(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", employee.getEMPNO(), employee.getENAME(), employee.getJOB(), employee.getMGR(), employee.getHIREDATE(), employee.getSAL(), employee.getCOMM(), employee.getDEPTNO());
        DBUtil.commit();
        DBUtil.close();
    }

    @Override
    public void modifyEmployee(Employee employee) {
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        DBUtil.begin();
        DBUtil.update("UPDATE emp SET ENAME=?, JOB=?, MGR=?, HIREDATE=?, SAL=?, COMM=?, DEPTNO=? WHERE EMPNO=?", employee.getENAME(), employee.getJOB(), employee.getMGR(), employee.getHIREDATE(), employee.getSAL(), employee.getCOMM(), employee.getDEPTNO(), employee.getEMPNO());
        DBUtil.commit();
        DBUtil.close();
    }

    @Override
    public Employee queryEmployeeByNo(int empNo) {
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        Employee employee = DBUtil.querySingleRecord(Employee.class, "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM emp WHERE EMPNO=?", empNo);
        DBUtil.close();
        return employee;
    }

    @Override
    public List<Map<String, Object>> queryJob() {
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        List<Map<String, Object>> jobs = DBUtil.query("SELECT DISTINCT JOB FROM emp");
        DBUtil.close();
        return jobs;
    }
}