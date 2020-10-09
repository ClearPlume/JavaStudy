package top.fallenangel.jdbc;

import java.util.Objects;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class Dept {
    private int DEPTNO;
    private String DNAME;
    private String LOC;

    public Dept() {
    }

    public int getDEPTNO() {
        return DEPTNO;
    }

    public void setDEPTNO(int DEPTNO) {
        this.DEPTNO = DEPTNO;
    }

    public String getDNAME() {
        return DNAME;
    }

    public void setDNAME(String DNAME) {
        this.DNAME = DNAME;
    }

    public String getLOC() {
        return LOC;
    }

    public void setLOC(String LOC) {
        this.LOC = LOC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dept dept = (Dept) o;
        return DEPTNO == dept.DEPTNO && Objects.equals(DNAME, dept.DNAME) && Objects.equals(LOC, dept.LOC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DEPTNO, DNAME, LOC);
    }

    @Override
    public String toString() {
        return "部门：[" + "编号=" + DEPTNO + ", 名称='" + DNAME + '\'' + ", 位置='" + LOC + '\'' + ']';
    }
}