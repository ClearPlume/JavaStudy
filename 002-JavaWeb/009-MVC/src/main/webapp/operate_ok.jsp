<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Date: 2020-09-11
  Time: 下午 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>操作成功</title>
    </head>
    <body style="text-align: center">
        <%=request.getParameter("operate")%>成功！3秒后返回...
    </body>
    <script type="text/javascript">
        onload = function () {
            setTimeout(function () {
                location.href = "/009_MVC/employee"
            }, 3000)
        }
    </script>
</html>
