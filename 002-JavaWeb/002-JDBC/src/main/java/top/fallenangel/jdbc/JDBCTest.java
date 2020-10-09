package top.fallenangel.jdbc;

import org.junit.Test;
import top.fallenangel.util.DBUtil;


import java.util.List;
import java.util.ResourceBundle;

public class JDBCTest {
    @Test
    public void testConnection() {
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        List<Dept> dept = DBUtil.query(Dept.class, "SELECT DEPTNO, DNAME, LOC FROM dept");
        showResultSet(dept);
        DBUtil.close();
    }

    public <T> void showResultSet(List<T> list) {
        for (T t : list) {
            System.out.println(t);
        }
    }

    @Test
    public void testTransAction() {
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        DBUtil.begin();
        try {
            DBUtil.update("UPDATE t_employee SET sal = sal - 500 WHERE no = 101");
            int i = 1 / 0;
            DBUtil.update("UPDATE t_employee SET sal = sal + 500 WHERE no = 102");
            DBUtil.commit();
        } catch (Exception e) {
            DBUtil.rollback();
            e.printStackTrace();
        }
        DBUtil.close();
    }
}