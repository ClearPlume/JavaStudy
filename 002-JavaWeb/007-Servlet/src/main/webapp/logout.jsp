<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Date: 2020-09-07
  Time: 上午 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>退出登录</title>
        <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    </head>
    <body>
        ${user}，欢迎下次再来！
        <br/>
        即将返回登录界面...
    </body>
    <script type="text/javascript">
        $(document).ready(function () {
            setTimeout(function () {
                location.href = "/007_Servlet/login.html"
            }, 3000)
        })
    </script>
</html>
