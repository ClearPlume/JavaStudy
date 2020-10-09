<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Date: 2020-09-07
  Time: 上午 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>欢迎</title>
        <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    </head>
    <body style="text-align: center">
        <%
            String lastLoginTime = request.getSession().getAttribute("lastLoginTime").toString().replace('_', ' ');
        %>

        ${user.getName()}，欢迎！您上次登录时间为 <%=lastLoginTime %>
        <br/>
        <button id="logout-btn">退出登录</button>
    </body>
    <script type="text/javascript">
        $("#logout-btn").click(function () {
            location.href = "/007_Servlet/logout?user=${user.getName()}"
        })
    </script>
</html>