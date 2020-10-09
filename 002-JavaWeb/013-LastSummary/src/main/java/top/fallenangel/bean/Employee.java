package top.fallenangel.bean;

import java.sql.Date;

public class Employee {
    private int EMPNO;
    private String ENAME;
    private String JOB;
    private int MGR;
    private Date HIREDATE;
    private double SAL;
    private double COMM;
    private int DEPTNO;

    public Employee() {
    }

    public int getEMPNO() {
        return EMPNO;
    }

    public void setEMPNO(int EMPNO) {
        this.EMPNO = EMPNO;
    }

    public String getENAME() {
        return ENAME;
    }

    public void setENAME(String ENAME) {
        this.ENAME = ENAME;
    }

    public String getJOB() {
        return JOB;
    }

    public void setJOB(String JOB) {
        this.JOB = JOB;
    }

    public int getMGR() {
        return MGR;
    }

    public void setMGR(int MGR) {
        this.MGR = MGR;
    }

    public Date getHIREDATE() {
        return HIREDATE;
    }

    public void setHIREDATE(Date HIREDATE) {
        this.HIREDATE = HIREDATE;
    }

    public double getSAL() {
        return SAL;
    }

    public void setSAL(double SAL) {
        this.SAL = SAL;
    }

    public double getCOMM() {
        return COMM;
    }

    public void setCOMM(double COMM) {
        this.COMM = COMM;
    }

    public int getDEPTNO() {
        return DEPTNO;
    }

    public void setDEPTNO(int DEPTNO) {
        this.DEPTNO = DEPTNO;
    }
}