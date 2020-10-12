<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-09-28 上午 10:50
--%>
<%--@elvariable id="employeeList" type="java.util.List<top.fallenangel.spring.mvc.entity.Employee>"--%>
<%--@elvariable id="employee" type="top.fallenangel.spring.mvc.entity.Employee"--%>
<%--@elvariable id="pager" type="top.fallenangel.spring.mvc.util.Pager"--%>
<%--@elvariable id="depts" type="java.util.List<top.fallenangel.spring.mvc.entity.Dept>"--%>
<%--@elvariable id="areas" type="java.util.List<top.fallenangel.spring.mvc.entity.Area>"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <title>员工列表</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/list_table.css">
        <style type="text/css">
            .page-num {
                display: inline;
            }

            .input-box {
                width: 120px;
            }
        </style>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    </head>
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
                    <form:form action="list?page=${pager.page}&pageSize=${pager.pageSize}" modelAttribute="employee"
                               cssStyle="display: inline">
                        <form:input path="empName" placeholder="员工姓名" cssClass="input-box"/>
                        <form:select path="dept.deptId" cssClass="input-box">
                            <form:option value="-1" label="请选择员工部门"/>
                            <form:options items="${depts}" itemValue="deptId" itemLabel="deptName"/>
                        </form:select>
                        <form:select path="dept.area.areaId" cssClass="input-box">
                            <form:option value="-1" label="请选择部门位置"/>
                            <form:options items="${areas}" itemValue="areaId" itemLabel="areaName"/>
                        </form:select>
                        <form:button type="submit">搜索</form:button>
                    </form:form>
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
                            <button onclick="pageChange(1, 0)"
                            ${pager.hasPrev ? "" : "disabled='disabled'"}>
                                首页
                            </button>
                        </li>
                        <li class="page-num">
                            <button onclick="pageChange(${pager.page}, -1)"
                            ${pager.hasPrev ? "" : "disabled='disabled'"}>
                                上一页
                            </button>
                        </li>
                        <li class="page-num">
                            <label>
                                <select onchange="pageChange(Number(this.value), 0)">
                                    <c:forEach begin="1" end="${pager.pages}" var="pageInList">
                                        <option value="${pageInList}" ${pageInList == pager.page ? "selected='selected'" : ""}>${pageInList}</option>
                                    </c:forEach>
                                </select>
                            </label>
                        </li>
                        <li class="page-num">
                            <button onclick="pageChange(${pager.page}, 1)"
                            ${pager.hasNext ? "" : "disabled='disabled'"}>
                                下一页
                            </button>
                        </li>
                        <li class="page-num">
                            <button onclick="pageChange(${pager.pages}, 0)"
                            ${pager.hasNext ? "" : "disabled='disabled'"}>
                                尾页
                            </button>
                        </li>
                        <li class="page-num">
                            每页
                            <label>
                                <select id="page-size-select" onchange="pageChange(${pager.page}, 0)">
                                    <option value="5" ${pager.pageSize == 5 ? "selected='selected'" : ""}>5</option>
                                    <option value="10" ${pager.pageSize == 10 ? "selected='selected'" : ""}>10</option>
                                    <option value="15" ${pager.pageSize == 15 ? "selected='selected'" : ""}>15</option>
                                    <option value="20" ${pager.pageSize == 20 ? "selected='selected'" : ""}>20</option>
                                    <option value="25" ${pager.pageSize == 25 ? "selected='selected'" : ""}>25</option>
                                </select>
                            </label>
                            条
                        </li>
                        <li class="page-num">
                            共 <span style="color: #095f8a; font-weight: bold">${pager.totalRecord}</span> 条
                        </li>
                    </ul>
                </td>
            </tr>
        </table>
        <script type="text/javascript">
            $("#add-btn").click(function () {
                location.href = "${pageContext.request.contextPath}/employee/edit"
            })

            $("#delete-selection-btn").click(function () {
                let selectedSelections = $(":checkbox:checked")
                let data = ""

                selectedSelections.each(function (index, selection) {
                    if (selection.id !== "select-all-checkbox" && selection.checked) {
                        data += "empId=" + selection.value

                        if (index < selectedSelections.length - 1) {
                            data += "&"
                        }
                    }
                })

                if (data === "") {
                    alert("未选中数据！")
                } else {
                    if (confirm("是否确认删除选中数据？")) {
                        location.href = "${pageContext.request.contextPath}/employee/delete?" + data
                    }
                }
            })

            $(".modify-btn").each(function (index, btn) {
                btn.onclick = function () {
                    location.href = "${pageContext.request.contextPath}/employee/edit?empId=" + btn.value
                }
            })

            $(".delete-btn").each(function (index, btn) {
                btn.onclick = function () {
                    if (confirm("是否确认删除选中数据？")) {
                        location.href = "${pageContext.request.contextPath}/employee/delete?empId=" + btn.value
                    }
                }
            })

            let singleSelectionList = $(".single-selection-checkbox")
            let selectAllCheckbox = $("#select-all-checkbox")[0]

            $("#invert-selection-btn").click(function () {
                singleSelectionList.each(function (index, selection) {
                    selection.checked = !selection.checked
                })

                selectAllCheckbox.checked = getSelectedCount() === singleSelectionList.length
            })

            selectAllCheckbox.onchange = function () {
                let allSelect = this.checked
                singleSelectionList.each(function (index, selection) {
                    selection.checked = allSelect
                })
            }

            singleSelectionList.each(function (index, selection) {
                selection.onchange = function () {
                    selectAllCheckbox.checked = getSelectedCount() === singleSelectionList.length
                }
            })

            /**
             * 获取选中的复选框数量
             */
            function getSelectedCount() {
                let selectedCount = 0

                singleSelectionList.each(function (index, selection) {
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
            function pageChange(page, offset) {
                let actualPage = page + offset
                let searchForm = $("#employee")[0]

                searchForm.action = "${pageContext.request.contextPath}/employee/list?page=" + actualPage + "&pageSize=" + $("#page-size-select").val()
                searchForm.submit()
            }
        </script>
    </body>
</html>