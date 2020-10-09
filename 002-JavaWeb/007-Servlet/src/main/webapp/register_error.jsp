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
        <title>注册失败</title>
    </head>
    <body>
        注册失败，${errorType}，三秒后返回注册界面...
    </body>
    <script type="text/javascript">
        onload = function () {
            setTimeout(function () {
                location.href = "/007_Servlet/register.html"
            }, 3000)
        }
    </script>
</html>
