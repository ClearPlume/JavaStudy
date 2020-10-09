<%--suppress SpellCheckingInspection--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-09-11 下午 4:42
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>修改员工信息</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="js/jquery-1.8.3.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="form-div">
            <h2 class="title">修改信息</h2>
            <form action="${pageContext.request.contextPath}/employeeAction?action=modify" id="modify-form" method="post">
                <div class="div">
                    <div class="input">
                        <div class="input-tip">
                            编号：
                        </div>
                        <div class="input-input">
                            <%--@elvariable id="employee" type="top.fallenangel.bean.Employee"--%>
                            <label><input class="input-normal" name="EMPNO" type="text" disabled="disabled"
                                          value="${employee.EMPNO}"></label>
                        </div>
                    </div>
                    <div class="input">
                        <div class="input-tip">
                            姓名：
                        </div>
                        <div class="input-input">
                            <label><input class="input-normal" name="ENAME" type="text"
                                          value="${employee.ENAME}"></label>
                        </div>
                    </div>
                    <div class="input">
                        <div class="input-tip">
                            工作：
                        </div>
                        <div class="input-input">
                            <label>
                                <select id="JOB" name="JOB">
                                    <%--@elvariable id="jobs" type="java.util.List<java.util.Map<java.lang.String, java.lang.Object>>"--%>
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
                            <label><input class="input-normal" name="MGR" type="text"
                                          value="${employee.MGR}"></label>
                        </div>
                    </div>
                    <div class="input">
                        <div class="input-tip">
                            入职日期：
                        </div>
                        <div class="input-input">
                            <label><input class="input-normal" name="HIREDATE" type="date"
                                          value="${employee.HIREDATE}"></label>
                        </div>
                    </div>
                    <div class="input">
                        <div class="input-tip">
                            薪水：
                        </div>
                        <div class="input-input">
                            <label><input class="input-normal" name="SAL" type="text"
                                          value="${employee.SAL}"></label>
                        </div>
                    </div>
                    <div class="input">
                        <div class="input-tip">
                            奖金：
                        </div>
                        <div class="input-input">
                            <label><input class="input-normal" name="COMM" type="text"
                                          value="${employee.COMM}"></label>
                        </div>
                    </div>
                    <div class="input">
                        <div class="input-tip">
                            部门：
                        </div>
                        <div class="input-input">
                            <label><input class="input-normal" name="DEPTNO" type="text"
                                          value="${employee.DEPTNO}"></label>
                        </div>
                    </div>
                    <div class="valid-code">
                        <div class="valid-code-tip">验证码：</div>
                        <div class="valid-code-input">
                            <label>
                                <input class="input-normal" name="valid-code" type="text">
                            </label>
                        </div>
                        <div class="valid-code-img">
                            <a id="refresh-valid-code-img-a" href="javascript:void(0)">
                                <img alt="点此刷新" src="" title="看不清？点击刷新">
                            </a>
                        </div>
                    </div>
                    <div class="btn">
                        <button type="submit">修改</button>
                    </div>
                    <div class="back-employee">
                        <a href="${pageContext.request.contextPath}/employeeAction?action=list">返回管理界面</a>
                    </div>
                </div>
            </form>
        </div>
    </body>
    <script type="text/javascript">
        $("#modify-form").submit(function () {
            $("input[name='EMPNO']").prop("disabled", false)
            return true
        })

        $("#refresh-valid-code-img-a").click(function () {
            $("#refresh-valid-code-img-a img").prop("src", "/012_Mybatis/validCode?" + new Date().getMilliseconds())
        })

        $("#JOB").val("${employee.JOB}")
    </script>
</html>