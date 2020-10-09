<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-09-11 下午 10:14
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
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
                location.href = "/012_Mybatis/employeeAction?action=list"
            }, 3000)
        }
    </script>
</html>
