<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-13 下午 2:08
--%>
<%--@elvariable id="user" type="top.fallenangel.spring.mvc.entity.User"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>用户登录</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    </head>
    <body style="text-align:center">
        <c:if test="${not empty user.msg}">
            <div style="color: red">${user.msg}</div>
        </c:if>
        <form action="${pageContext.request.contextPath}/user/login" method="post">
            <label>
                <input name="userName" placeholder="用户名" type="text"/>
            </label>
            <br/>
            <label>
                <input name="userPwd" placeholder="密码" type="password"/>
            </label>
            <br/>
            <button id="back-welcome-btn" type="button">返回</button>
            <input type="submit" value="登录"/>
        </form>

        <script type="text/javascript">
            $("#back-welcome-btn").click(function () {
                location.href = "${pageContext.request.contextPath}"
            })
        </script>
    </body>
</html>
