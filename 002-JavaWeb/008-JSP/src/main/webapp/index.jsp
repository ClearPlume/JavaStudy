<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Date: 2020-09-07
  Time: 下午 3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>$Title$</title>
    </head>
    <body>
        <c:forEach items="${users}" var="user">
            ${user.name}
            ${user.age}
            ${user.sex}
            ${user.hobbies}
            ${user.phone}
            ${user.email}
        </c:forEach>
    </body>
</html>