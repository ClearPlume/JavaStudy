<%--@elvariable id="errorType" type="top.fallenangel._07servlet.servlet.RegisterServlet"--%>
<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Date: 2020-09-06
  Time: 下午 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>登录失败</title>
    </head>
    <body>
        ${errorType}，三秒后返回登录界面...
    </body>
    <script type="text/javascript">
        onload = function () {
            setTimeout(function () {
                location.href = "/007_Servlet/login.html"
            }, 3000)
        }
    </script>
</html>
