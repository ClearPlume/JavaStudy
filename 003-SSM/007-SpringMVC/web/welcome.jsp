<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-09-28 上午 9:31
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%--@elvariable id="LOGIN_USER" type="top.fallenangel.spring.mvc.entity.User"--%>
<html>
    <head>
        <title>欢迎</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    </head>
    <body style="text-align: center">
        <c:if test="${empty LOGIN_USER}">
            <button id="register-btn" type="button">注册</button>
            <button id="login-btn" type="button">登录</button>
            <br/>
        </c:if>
        <c:if test="${not empty LOGIN_USER}">
            欢迎，${LOGIN_USER.userName}！
            <button id="logout-btn" type="button">退出登录</button>
            <br/>
            <a href="${pageContext.request.contextPath}/employee/list">员工管理</a>
            <br/>
            <a href="${pageContext.request.contextPath}/dept/list">部门管理</a>
            <br/>
            <a href="${pageContext.request.contextPath}/area/list">区域管理</a>
            <br/>
            <a href="${pageContext.request.contextPath}/netDisk/list">网盘</a>
        </c:if>

        <script type="text/javascript">
            $("#register-btn").click(function () {
                location.href = "${pageContext.request.contextPath}/user/registerPage"
            })

            $("#login-btn").click(function () {
                location.href = "${pageContext.request.contextPath}/user/loginPage"
            })

            $("#logout-btn").click(function () {
                location.href = "${pageContext.request.contextPath}/user/logout"
            })
        </script>
    </body>
</html>