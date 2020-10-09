<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Date: 2020-09-10
  Time: 下午 8:13
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>员工管理</title>
        <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
        <style type="text/css">
            input[type="checkbox"] {
                outline: darkmagenta solid 2px;
            }

            table, tr, td, th {
                border: solid darkcyan 3px;
                border-collapse: collapse;
                padding: 3px 10px;
            }

            tr, td, th {
                width: 100px;
                text-align: center;
            }
        </style>
    </head>
    <body style="display: flex; flex-direction: column; align-items: center">
        <%--@elvariable id="user" type="top.fallenangel._09mvc.bean.User"--%>
        <h1 style="font-style: normal">${user.name}，欢迎！</h1>
        <div style="display: flex; flex-direction: column; align-items: start">
            <div>
                <button id="insert-emp">添加员工</button>
                &nbsp;
                <button id="delete-selected-emp">删除员工</button>
            </div>
            <table id="tb_stu">
                <tr>
                    <th><label><input id="all-select" type="checkbox"/></label></th>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>工作</th>
                    <th>领导</th>
                    <th>入职日期</th>
                    <th>薪水</th>
                    <th>奖金</th>
                    <th>部门</th>
                    <th style="width: 170px">操作</th>
                </tr>
                <%--@elvariable id="employees" type="java.util.List"--%>
                <c:forEach items="${employees}" var="employee">
                    <tr>
                        <td>
                            <label>
                                <input type="checkbox" operaterow="true">
                            </label>
                        </td>
                        <td>${employee.getEMPNO()}</td>
                        <td>${employee.getENAME()}</td>
                        <td>${employee.getJOB()}</td>
                        <td>${employee.getMGR()}</td>
                        <td>
                            <fmt:formatDate value="${employee.getHIREDATE()}" pattern="yyyy-MM-HH"/>
                        </td>
                        <td>${employee.getSAL()}</td>
                        <td>${employee.getCOMM()}</td>
                        <td>${employee.getDEPTNO()}</td>
                        <td>
                            <button class="modify-employee-btn">修改</button>
                            <button class="delete-employee-btn">删除</button>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="10">
                        <c:forEach begin="1" end="${pages}" var="page">
                            <a href="/009_MVC/employee?page=${page}">&nbsp;${page}&nbsp;</a>
                            <c:if test="${page < pages}">
                                &nbsp;
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
            </table>
        </div>
    </body>
    <script type="text/javascript">
        $(document).ready(function () {
            let selectAll = $("#all-select");

            selectAll.click(function () {
                $("input[operateRow='true']").each(function () {
                    this.checked = selectAll.prop("checked");
                });
            });

            let selects = $("input[operateRow='true']")

            selects.click(function () {
                selectAll.prop("checked", selects.length === getSelectedCount());
            });

            let btnStyle = {"font-size": "16px", "padding": "0 20px"};
            let modifyBtn = $(".modify-employee-btn");
            modifyBtn.css(btnStyle);
            modifyBtn.click(function () {
                $.post("/009_MVC/queryEmp", {
                    "emp-no": $(this).parent().parent().children()[1].innerText
                }, function (data) {
                    if (data === "OK") {
                        location.href = "/009_MVC/modify_emp.jsp"
                    }
                })
            });
            let deleteBtn = $(".delete-employee-btn");
            deleteBtn.css(btnStyle);
            deleteBtn.click(function () {
                if (confirm("确认删除数据行？")) {
                    $.get("/009_MVC/deleteEmp", {
                        "emp-no": $(this).parent().parent().children()[1].innerText
                    }, function (data) {
                        if (data === "OK") {
                            location.href = "/009_MVC/operate_ok.jsp?operate=删除"
                        }
                    })
                }
            });

            $("#insert-emp").click(function () {
                location.href = "/009_MVC/queryJob"
            });

            $("#delete-selected-emp").click(function () {
                let selectedRow = $("input:checked[operateRow='true']");
                if (selectedRow.length === 0) {
                    alert("未选中数据行！")
                } else {
                    if (confirm("确认删除选中数据行？")) {
                        let data = ""

                        selectedRow.each(function (index) {
                            data = data + "emp-no=" + $(this).parent().parent().parent().children()[1].innerText
                            if (index < selectedRow.length - 1) {
                                data = data + "&"
                            }
                        })

                        $.get("/009_MVC/deleteEmp?" + data, function (data) {
                            if (data === "OK") {
                                location.href = "/009_MVC/operate_ok.jsp?operate=批量删除"
                            }
                        })
                    }
                }
            })
        });

        function getSelectedCount() {
            let selectCount = 0;

            $("input[operateRow='true']").each(function () {
                if (this.checked) {
                    selectCount++;
                }
            });

            return selectCount;
        }
    </script>
</html>