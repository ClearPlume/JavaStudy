<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-09-29 上午 11:24
--%>
<%--@elvariable id="areas" type="java.util.List<top.fallenangel.spring.mvc.entity.Area>"--%>
<%--@elvariable id="area" type="top.fallenangel.spring.mvc.entity.Area"--%>
<%--@elvariable id="dept" type="top.fallenangel.spring.mvc.entity.Dept"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>修改部门</title>
    </head>
    <body style="text-align: center">
        <form action="${pageContext.request.contextPath}/dept/modify" method="post">
            <label><input type="text" name="deptId" value="${dept.deptId}" hidden></label>
            <br/>
            <label><input type="text" name="deptName" value="${dept.deptName}" placeholder="部门名称" style="width: 175px"></label>
            <br/>
            <label>
                <select name="area.areaId" id="area-select" style="width: 175px">
                    <c:forEach var="area" items="${areas}">
                        <option value="${area.areaId}">${area.areaName}</option>
                    </c:forEach>
                </select>
            </label>
            <br/>
            <label>
                <input type="submit" value="修改">
            </label>
        </form>
    </body>
    <script type="text/javascript">
        document.querySelector("#area-select").value =
        ${area.areaName}
    </script>
</html>
