package top.fallenangel.bean;

import java.sql.Date;

public class EmployeeVo {
    private int pageStart;
    private int pageSize;
    private int EMPNO;
    private String ENAME;
    private String JOB;
    private double SAL;
    private Date HIREDATE;
    private String MGR;
    private String DNAME;

    public EmployeeVo() {
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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

    public double getSAL() {
        return SAL;
    }

    public void setSAL(double SAL) {
        this.SAL = SAL;
    }

    public Date getHIREDATE() {
        return HIREDATE;
    }

    public void setHIREDATE(Date HIREDATE) {
        this.HIREDATE = HIREDATE;
    }

    public String getMGR() {
        return MGR;
    }

    public void setMGR(String MGR) {
        this.MGR = MGR;
    }

    public String getDNAME() {
        return DNAME;
    }

    public void setDNAME(String DNAME) {
        this.DNAME = DNAME;
    }

    @Override
    public String toString() {
        return "EmployeeVo{" +
                "pageStart=" + pageStart +
                ", pageSize=" + pageSize +
                ", EMPNO=" + EMPNO +
                ", ENAME='" + ENAME + '\'' +
                ", JOB='" + JOB + '\'' +
                ", SAL=" + SAL +
                ", HIREDATE=" + HIREDATE +
                ", MGR='" + MGR + '\'' +
                ", DNAME='" + DNAME + '\'' +
                '}';
    }
}