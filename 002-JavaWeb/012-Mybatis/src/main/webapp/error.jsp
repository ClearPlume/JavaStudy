<%--@elvariable id="targetURI" type="top.fallenangel.service.impl.ValidCodeServiceImpl"--%>
<%--@elvariable id="errorType" type="top.fallenangel.service.impl.ValidCodeServiceImpl"--%>
<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Date: 2020-09-17
  Time: 上午 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>错误</title>
    </head>
    <body style="text-align: center">
        ${errorType}，将返回！
    </body>
    <script type="text/javascript">
        setTimeout(function () {
            location.href = "${targetURI}"
        }, 3000)
    </script>
</html>
