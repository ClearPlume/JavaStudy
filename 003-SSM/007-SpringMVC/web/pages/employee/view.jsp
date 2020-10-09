<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-09 上午 11:31
--%>
<%--@elvariable id="employee" type="top.fallenangel.spring.mvc.entity.Employee"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>员工详情</title>
        <style type="text/css">
            table {
                text-align: center;
                margin: 0 auto;
                border-collapse: collapse;
            }

            caption h2 {
                font-weight: normal;
            }

            tbody td, th {
                border-color: blueviolet;
                border-width: 3px;
                border-collapse: collapse;
                border-style: solid;
                width: 100px;
                height: 30px;
            }
        </style>
    </head>
    <body>
        <table>
            <caption><h2>员工详情</h2></caption>
            <tr>
                <th>员工姓名</th>
                <td>${employee.empName}</td>
            </tr>
            <tr>
                <th>员工部门</th>
                <td>${employee.dept.deptName}</td>
            </tr>
            <tr>
                <th>员工位置</th>
                <td>${employee.dept.area.areaName}</td>
            </tr>
            <tr>
                <td colspan="2">
                    <button id="back-btn">返回</button>
                </td>
            </tr>
        </table>
    </body>
    <script type="text/javascript">
        document.querySelector("#back-btn").onclick = function () {
            history.back()
        }
    </script>
</html>