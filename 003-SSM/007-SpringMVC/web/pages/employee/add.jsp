<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-09-29 上午 11:24
--%>
<%--@elvariable id="depts" type="java.util.List<top.fallenangel.spring.mvc.entity.Dept>"--%>
<%--@elvariable id="dept" type="top.fallenangel.spring.mvc.entity.Dept"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>添加员工</title>
    </head>
    <body style="text-align: center">
        <form action="${pageContext.request.contextPath}/employee/save" method="post">
            <label><input type="text" name="empName" placeholder="员工姓名" style="width: 175px"></label>
            <br/>
            <label>
                <select name="dept.deptId" id="dept-select" style="width: 175px">
                    <c:forEach var="dept" items="${depts}">
                        <option value="${dept.deptId}">${dept.deptName}</option>
                    </c:forEach>
                </select>
            </label>
            <br/>
            <label>
                <input type="submit" value="添加">
            </label>
        </form>
    </body>
</html>
