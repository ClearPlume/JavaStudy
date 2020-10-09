<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-09-29 上午 11:24
--%>
<%--@elvariable id="areas" type="java.util.List<top.fallenangel.spring.mvc.entity.Area>"--%>
<%--@elvariable id="area" type="top.fallenangel.spring.mvc.entity.Area"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>添加部门</title>
    </head>
    <body style="text-align: center">
        <form action="${pageContext.request.contextPath}/dept/save" method="post">
            <label><input type="text" name="deptName" placeholder="部门名称" style="width: 175px"></label><br/>
            <label>
                <select name="area.areaId" id="dept-select" style="width: 175px">
                    <c:forEach var="area" items="${areas}">
                        <option value="${area.areaId}">${area.areaName}</option>
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
