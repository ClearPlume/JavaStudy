package top.fallenangel.springtransaction.controller;

import top.fallenangel.util.DBUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/deleteEmp")
public class DeleteEmpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] nos = req.getParameterValues("emp-no");
        int[] empNo = new int[nos.length];
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        DBUtil.begin();
        StringBuilder deletingNo = new StringBuilder();
        for (int i = 0; i < nos.length; i++) {
            empNo[i] = Integer.parseInt(nos[i]);
            deletingNo.append('?');
            if (i < nos.length - 1) {
                deletingNo.append(',');
            }
        }
        DBUtil.update("DELETE FROM emp WHERE EMPNO IN (" + deletingNo.toString() + ")", empNo);
        DBUtil.commit();
        DBUtil.close();
        resp.getWriter().write("OK");
        resp.getWriter().flush();
    }
}