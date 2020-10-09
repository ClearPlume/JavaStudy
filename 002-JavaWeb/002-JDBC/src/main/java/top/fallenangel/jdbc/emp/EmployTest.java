package top.fallenangel.jdbc.emp;

import top.fallenangel.util.DBUtil;
import top.fallenangel.util.NormalUtil;

import java.util.List;

public class EmployTest {
    public static void main(String[] args) {
        DBUtil.connection("db_bjpowernode.properties", EmployTest.class.getClassLoader());

        /*List<Employ> employs = DBUtil.query(Employ.class, "SELECT * FROM emp");
        NormalUtil.showDataList(employs);

        int result = DBUtil.update("INSERT INTO emp (EMPNO, ENAME, SAL, JOB, HIREDATE) VALUES (?, ?, ?, ?, ?)", 101, "Fallen", 11000, "程序员", "2020-08-22");
        System.out.println("影响记录数 = " + result);*/

        List<Employ> employs = DBUtil.query(Employ.class, "SELECT * FROM emp");
        NormalUtil.showDataList(employs);

        DBUtil.begin();
        try {
            int result = DBUtil.update("DELETE FROM emp WHERE EMPNO = ?", 101);
            DBUtil.commit();
            System.out.println("影响记录数 = " + result);
        } catch (Exception e) {
            DBUtil.rollback();
            e.printStackTrace();
        }

        employs = DBUtil.query(Employ.class, "SELECT * FROM emp");
        NormalUtil.showDataList(employs);
        DBUtil.close();
    }
}