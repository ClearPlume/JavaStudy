<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-09-28 上午 9:31
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>欢迎</title>
    </head>
    <body style="text-align: center">
        <a href="${pageContext.request.contextPath}/employee/list">员工管理</a>
        <br/>
        <a href="${pageContext.request.contextPath}/dept/list">部门管理</a>
        <br/>
        <a href="${pageContext.request.contextPath}/area/list">区域管理</a>
    </body>
</html>