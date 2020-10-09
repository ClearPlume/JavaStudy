package top.fallenangel.jdbc.employeemanager;

import java.util.Objects;

public class Employee {
    private int no;
    private String name;
    private String pwd;
    private double sal;

    private boolean showPwd = false;

    public Employee() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public void setShowPwd(boolean showPwd) {
        this.showPwd = showPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return no == employee.no && Objects.equals(name, employee.name) && Objects.equals(pwd, employee.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name, pwd);
    }

    @Override
    public String toString() {
        return "雇员：[" + "编号：" + no + ", 姓名：'" + name + '\'' + (showPwd ? ", 密码：'" + pwd + '\'' : "") + ", 薪水：" + sal + ']';
    }
}