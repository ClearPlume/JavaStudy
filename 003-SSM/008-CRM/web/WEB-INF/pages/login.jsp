<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-21 下午 4:36
--%>
<%--@elvariable id="employee" type="top.fallenangel.crm.model.entity.Employee"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>登录</title>
        <meta charset="UTF-8">

        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
              rel="stylesheet"/>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.1-min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div style="position: absolute; top: 0; left: 0; width: 60%;">
            <img alt="" src="${pageContext.request.contextPath}/img/IMG_7114.JPG"
                 style="width: 100%; position: relative; top: 50px;">
        </div>
        <div id="top" style="height: 50px; background-color: #3C3C3C; width: 100%;">
            <div style="position: absolute; top: 5px; left: 0; font-size: 30px; font-weight: 400; color: white; font-family: 'times new roman', serif">
                CRM &nbsp;<span style="font-size: 12px;">&copy;2020&nbsp;动力节点</span></div>
        </div>

        <div style="position: absolute; top: 120px; right: 100px;width:450px;height:400px;border:1px solid #D5D5D5">
            <div style="position: absolute; top: 0; right: 60px;">
                <div class="page-header">
                    <h1>登录</h1>
                </div>
                <form action="${pageContext.request.contextPath}/login" method="post" class="form-horizontal"
                      role="form">
                    <div class="form-group form-group-lg">
                        <label for="text"></label>
                        <div style="width: 350px;">
                            <input class="form-control" id="text" name="employeeNo" placeholder="用户名" type="text"
                                   value="${employee.employeeNo}"/>
                        </div>
                        <label for="password"></label>
                        <div style="width: 350px; position: relative;top: 20px;">
                            <input id="password" type="password" name="employeePwd" placeholder="密码"
                                   class="form-control"/>
                        </div>
                        <div class="checkbox" style="position: relative;top: 30px; left: 10px;">
                            <span id="msg" style="color: red; font-size: 16px">
                                ${empty employee.msg ? "" : employee.msg}
                            </span>
                        </div>
                        <button type="submit" class="btn btn-primary btn-lg btn-block"
                                style="width: 350px; position: relative;top: 45px;">登录
                        </button>
                    </div>
                </form>
            </div>
        </div>

        <script type="text/javascript">
            if (top.location.href !== location.href) {
                top.location.href = location.href
            }
        </script>
    </body>
</html>