package top.fallenangel.jdbc.emp;

import java.sql.Date;
import java.util.Objects;

public class Employ {
    private int EMPNO;
    private String ENAME;
    private String JOB;
    private int MGR;
    private Date HIREDATE;
    private double SAL;
    private double COMM;
    private int DEPTNO;

    public Employ() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employ employ = (Employ) o;
        return EMPNO == employ.EMPNO && MGR == employ.MGR && Double.compare(employ.SAL, SAL) == 0 && Double.compare(employ.COMM, COMM) == 0 && DEPTNO == employ.DEPTNO && Objects.equals(ENAME, employ.ENAME) && Objects.equals(JOB, employ.JOB) && Objects.equals(HIREDATE, employ.HIREDATE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO);
    }

    @Override
    public String toString() {
        return "Employ{" + "EMPNO=" + EMPNO + ", ENAME='" + ENAME + '\'' + ", JOB='" + JOB + '\'' + ", MGR=" + MGR + ", HIREDATE='" + HIREDATE + '\'' + ", SAL=" + SAL + ", COMM=" + COMM + ", DEPTNO=" + DEPTNO + '}';
    }
}