<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-13 下午 2:08
--%>
<%--@elvariable id="user" type="top.fallenangel.spring.mvc.entity.User"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>用户注册</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/user/register" method="post">
            <label>
                <input id="userName" name="userName" placeholder="用户名" type="text"/><span id="user-name-tip"></span>
            </label>
            <br/>
            <label>
                <input name="userPwd" placeholder="密码" type="password"/>
            </label>
            <br/>
            <label>
                <input placeholder="确认密码" type="password"/>
            </label>
            <br/>
            <button id="back-welcome-btn" type="button">返回</button>
            <button id="register-btn" type="submit">注册</button>
        </form>

        <script type="text/javascript">
            $("#back-welcome-btn").click(function () {
                location.href = "${pageContext.request.contextPath}"
            })

            $("#userName").change(function () {
                $.ajax({
                    "url": "${pageContext.request.contextPath}/user/checkUserExists",
                    "type": "post",
                    "data": {
                        "userName": $(this).val()
                    },
                    "dataType": "json",
                    "success": function (exists) {
                        let userNameTip = $("#user-name-tip")
                        let loginBtn = $("#register-btn")

                        if (exists.exists) {
                            userNameTip.css("color", "red")
                            userNameTip.text("用户名已存在")
                            loginBtn.prop("disabled", true)
                        } else {
                            userNameTip.css("color", "green")
                            userNameTip.text("用户名可用")
                            loginBtn.prop("disabled", false)
                        }
                    }
                })
            })
        </script>
    </body>
</html>
