<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-09-28 上午 10:50
--%>
<%--@elvariable id="employeeList" type="java.util.List<top.fallenangel.spring.mvc.entity.Employee>"--%>
<%--@elvariable id="employee" type="top.fallenangel.spring.mvc.entity.Employee"--%>
<%--@elvariable id="page" type="java.lang.Integer"--%>
<%--@elvariable id="pages" type="java.lang.Integer"--%>
<%--@elvariable id="curPage" type="java.lang.Integer"--%>
<%--@elvariable id="depts" type="java.util.List<top.fallenangel.spring.mvc.entity.Dept>"--%>
<%--@elvariable id="areas" type="java.util.List<top.fallenangel.spring.mvc.entity.Area>"--%>
<%--@elvariable id="employeeVO" type="top.fallenangel.spring.mvc.entity.EmployeeVO"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>员工列表</title>
    </head>
    <style type="text/css">
        tbody td, th {
            border-color: blueviolet;
            border-width: 3px;
            border-collapse: collapse;
            border-style: solid;
            width: 100px;
            height: 30px;
        }

        table {
            text-align: center;
            border-collapse: collapse;
            margin: 0 auto;
        }

        caption h2 {
            font-weight: normal;
        }

        .page-num {
            display: inline;
        }
    </style>
    <body>
        <a href="${pageContext.request.contextPath}">首页</a>
        <table>
            <caption><h2>员工表</h2></caption>
            <thead>
                <tr>
                    <td>
                        <button id="add-btn">添加员工</button>
                    </td>
                    <td>
                        <button id="delete-selection-btn">删除选择</button>
                    </td>
                </tr>
            </thead>
            <tr>
                <td colspan="6">
                    <form action="${pageContext.request.contextPath}/employee/list?page=${curPage}" id="search-form"
                          method="post"
                          style="display: inline">
                        <label>
                            <input id="empName" name="empName" placeholder="员工姓名" type="text">
                        </label>
                        <label>
                            <select name="deptId" id="deptId">
                                <option value="-1">请选择员工部门</option>
                                <c:forEach items="${depts}" var="dept">
                                    <option value="${dept.deptId}">${dept.deptName}</option>
                                </c:forEach>
                            </select>
                        </label>
                        <label>
                            <select name="areaId" id="areaId">
                                <option value="-1">请选择部门位置</option>
                                <c:forEach items="${areas}" var="area">
                                    <option value="${area.areaId}">${area.areaName}</option>
                                </c:forEach>
                            </select>
                        </label>
                        <button type="submit">搜索</button>
                        <button type="reset">重置</button>
                    </form>
                </td>
            </tr>
            <tr>
                <th>
                    <label>
                        <input type="checkbox" id="select-all-checkbox">
                    </label>
                    /
                    <button id="invert-selection-btn">反选</button>
                </th>
                <th>员工ID</th>
                <th>员工姓名</th>
                <th>员工部门</th>
                <th>部门位置</th>
                <th style="width: 120px">操作</th>
            </tr>
            <c:forEach items="${employeeList}" var="employee">
                <tr>
                    <td>
                        <label>
                            <input type="checkbox" class="single-selection-checkbox"
                                   value="${employee.empId}">
                        </label>
                    </td>
                    <td>${employee.empId}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/employee/view?empId=${employee.empId}">${employee.empName}</a>
                    </td>
                    <td>${employee.dept.deptName}</td>
                    <td>${employee.dept.area.areaName}</td>
                    <td>
                        <button class="modify-btn" value="${employee.empId}">修改</button>
                        <button class="delete-btn" value="${employee.empId}">删除</button>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="6">
                    <ul style="list-style-type: none; margin: 0 auto">
                        <li class="page-num">
                            <button onclick="pageChange(${curPage}, -1)"
                                    <c:if test="${curPage == 1 || pages == 0}">
                                        disabled="disabled"
                                    </c:if>>
                                &laquo;
                            </button>
                        </li>
                        <c:forEach begin="1" end="${pages}" var="page">
                            <li class="page-num">
                                <button onclick="pageChange(${page})"
                                        <c:if test="${page == curPage}">
                                            style="color: #095f8a; font-weight: bold"
                                        </c:if>>
                                    &nbsp;${page}&nbsp;
                                </button>
                            </li>
                        </c:forEach>
                        <li class="page-num">
                            <button onclick="pageChange(${curPage}, 1)"
                                    <c:if test="${curPage == pages}">
                                        disabled="disabled"
                                    </c:if>>
                                &raquo;
                            </button>
                        </li>
                    </ul>
                </td>
            </tr>
        </table>
    </body>
    <script type="text/javascript">
        let searchForm

        searchForm = document.querySelector("#search-form")

        document.querySelector("#empName").value = "${employeeVO.empName}"

        document.querySelector("#deptId").value = Number.parseInt("${employeeVO.deptId}")

        document.querySelector("#areaId").value = Number.parseInt("${employeeVO.areaId}")

        document.querySelector("#add-btn").onclick = function () {
            location.href = "${pageContext.request.contextPath}/employee/edit"
        }

        document.querySelector("#delete-selection-btn").onclick = function () {
            let selectedSelections = document.querySelectorAll("td input[type='checkbox']")
            let data = ""

            selectedSelections.forEach(function (selection, index) {
                if (selection.checked) {
                    data += "empId=" + selection.value
                }
                if (selection.checked && index < selectedSelections.length - 1) {
                    data += "&"
                }
            })

            if (data === "") {
                alert("未选中数据！")
            } else {
                if (confirm("是否确认删除选中数据？")) {
                    location.href = "${pageContext.request.contextPath}/employee/delete?" + data
                }
            }
        }

        document.querySelectorAll(".modify-btn").forEach(function (btn) {
            btn.onclick = function () {
                location.href = "${pageContext.request.contextPath}/employee/edit?empId=" + btn.value
            }
        })

        document.querySelectorAll(".delete-btn").forEach(function (btn) {
            btn.onclick = function () {
                if (confirm("是否确认删除选中数据？")) {
                    location.href = "${pageContext.request.contextPath}/employee/delete?empId=" + btn.value
                }
            }
        })

        document.querySelector("#invert-selection-btn").onclick = function () {
            singleSelectionList.forEach(function (selection) {
                selection.checked = !selection.checked
            })

            selectAllCheckbox.checked = getSelectedCount() === singleSelectionList.length
        }

        let singleSelectionList = document.querySelectorAll(".single-selection-checkbox")
        let selectAllCheckbox = document.querySelector("#select-all-checkbox");

        selectAllCheckbox.onchange = function () {
            let allSelect = this.checked
            singleSelectionList.forEach(function (selection) {
                selection.checked = allSelect
            })
        }

        singleSelectionList.forEach(function (selection) {
            selection.onchange = function () {
                selectAllCheckbox.checked = getSelectedCount() === singleSelectionList.length
            }
        })

        /**
         * 获取选中的复选框数量
         */
        function getSelectedCount() {
            let selectedCount = 0

            singleSelectionList.forEach(function (selection) {
                if (selection.checked) {
                    selectedCount++
                }
            })

            return selectedCount
        }

        /**
         * 点击按钮翻页
         * @param {number} page 目标页码
         * @param {number} offset 偏移量(-1, 0, 1)
         */
        function pageChange(page, offset = 0) {
            let finalPage = page + offset
            searchForm.action = "${pageContext.request.contextPath}/employee/list?page=" + finalPage
            searchForm.submit()
        }
    </script>
</html>
