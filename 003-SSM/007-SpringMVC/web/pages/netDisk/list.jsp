<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-14 下午 9:56
--%>
<%--@elvariable id="LOGIN_USER" type="top.fallenangel.spring.mvc.entity.User"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>个人网盘</title>
    </head>
    <body>
        ${LOGIN_USER.userName}，欢迎！
    </body>
</html>
