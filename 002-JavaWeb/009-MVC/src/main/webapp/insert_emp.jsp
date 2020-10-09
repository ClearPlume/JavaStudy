<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Date: 2020-09-11
  Time: 下午 4:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>添加员工</title>
        <link rel="stylesheet" type="text/css" href="css/insert_emp.css">
        <script src="js/jquery-1.8.3.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="insert-emp-form-div">
            <h2 class="insert-emp-title">添加员工</h2>
            <form action="/009_MVC/insertEmp" id="insert-form" method="post">
                <div class="insert-emp-div">
                    <div class="input">
                        <div class="input-tip">
                            编号：
                        </div>
                        <div class="input-input">
                            <label><input class="insert-emp-input-normal" name="EMPNO" type="text"></label>
                        </div>
                    </div>
                    <div class="input">
                        <div class="input-tip">
                            姓名：
                        </div>
                        <div class="input-input">
                            <label><input class="insert-emp-input-normal" name="ENAME" type="text"></label>
                        </div>
                    </div>
                    <div class="input">
                        <div class="input-tip">
                            工作：
                        </div>
                        <div class="input-input">
                            <label>
                                <select name="JOB">
                                    <c:forEach items="${jobs}" var="job">
                                        <option value="${job.JOB}">${job.JOB}</option>
                                    </c:forEach>
                                </select>
                            </label>
                        </div>
                    </div>
                    <div class="input">
                        <div class="input-tip">
                            领导：
                        </div>
                        <div class="input-input">
                            <label><input class="insert-emp-input-normal" name="MGR" type="text"></label>
                        </div>
                    </div>
                    <div class="input">
                        <div class="input-tip">
                            入职日期：
                        </div>
                        <div class="input-input">
                            <label><input class="insert-emp-input-normal" name="HIREDATE" type="date"></label>
                        </div>
                    </div>
                    <div class="input">
                        <div class="input-tip">
                            薪水：
                        </div>
                        <div class="input-input">
                            <label><input class="insert-emp-input-normal" name="SAL" type="text"></label>
                        </div>
                    </div>
                    <div class="input">
                        <div class="input-tip">
                            奖金：
                        </div>
                        <div class="input-input">
                            <label><input class="insert-emp-input-normal" name="COMM" type="text"></label>
                        </div>
                    </div>
                    <div class="input">
                        <div class="input-tip">
                            部门：
                        </div>
                        <div class="input-input">
                            <label><input class="insert-emp-input-normal" name="DEPTNO" type="text"></label>
                        </div>
                    </div>
                    <div class="valid-code">
                        <div class="valid-code-tip">验证码：</div>
                        <div class="valid-code-input">
                            <label>
                                <input class="insert-emp-input-normal" name="valid-code" type="text">
                            </label>
                        </div>
                        <div class="valid-code-img">
                            <a id="refresh-valid-code-img-a" href="javascript:void(0)">
                                <img alt="点此刷新" src="" title="看不清？点击刷新">
                            </a>
                        </div>
                    </div>
                    <div class="insert-emp-btn">
                        <button type="submit">添加</button>
                    </div>
                    <div class="back-employee">
                        <a href="/009_MVC/employee.jsp">返回管理界面</a>
                    </div>
                </div>
            </form>
        </div>
    </body>
    <script type="text/javascript">
        $("#refresh-valid-code-img-a").click(function () {
            $("#refresh-valid-code-img-a img").prop("src", "/009_MVC/validCode?" + new Date().getMilliseconds())
        })
    </script>
</html>