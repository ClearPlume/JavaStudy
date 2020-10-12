<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-09-28 上午 10:50
--%>
<%--@elvariable id="pageInfo" type="com.github.pagehelper.PageInfo<top.fallenangel.spring.mvc.entity.Employee>"--%>
<%--@elvariable id="employee" type="top.fallenangel.spring.mvc.entity.Employee"--%>
<%--@elvariable id="depts" type="java.util.List<top.fallenangel.spring.mvc.entity.Dept>"--%>
<%--@elvariable id="areas" type="java.util.List<top.fallenangel.spring.mvc.entity.Area>"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <title>员工列表</title>
        <link href="${pageContext.request.contextPath}/css/list_table.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/js/pagination/pagination.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            .input-box {
                width: 120px;
            }

            .pagination-div {
                display: flex;
                justify-content: center;
            }
        </style>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/pagination/common/jquery.min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/pagination/jquery.pagination.js"></script>
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
                    <form:form action="list?page=${pageInfo.pageNum}&pageSize=${pageInfo.pageSize}"
                               modelAttribute="employee"
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
            <form id="delete-batch-form" action="${pageContext.request.contextPath}/employee/delete" method="post">
                <c:forEach items="${pageInfo.list}" var="employee">
                    <tr>
                        <td>
                            <label>
                                <input class="single-selection-checkbox" name="empId"
                                       type="checkbox" value="${employee.empId}">
                            </label>
                        </td>
                        <td>${employee.empId}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/employee/view?empId=${employee.empId}">${employee.empName}</a>
                        </td>
                        <td>${employee.dept.deptName}</td>
                        <td>${employee.dept.area.areaName}</td>
                        <td>
                            <button class="modify-btn" type="button" value="${employee.empId}">修改</button>
                            <button class="delete-btn" type="button" value="${employee.empId}">删除</button>
                        </td>
                    </tr>
                </c:forEach>
            </form>
            <tr>
                <td colspan="6" style="border-width: 0">
                    <div class="m-style pagination-div"></div>
                    每页
                    <label>
                        <select id="page-size-select" onchange="pageChange(1, 0)">
                            <option value="5" ${pageInfo.pageSize == 5 ? "selected='selected'" : ""}>5</option>
                            <option value="10" ${pageInfo.pageSize == 10 ? "selected='selected'" : ""}>10</option>
                            <option value="15" ${pageInfo.pageSize == 15 ? "selected='selected'" : ""}>15</option>
                            <option value="20" ${pageInfo.pageSize == 20 ? "selected='selected'" : ""}>20</option>
                            <option value="25" ${pageInfo.pageSize == 25 ? "selected='selected'" : ""}>25</option>
                        </select>
                    </label>
                    条
                </td>
            </tr>
        </table>
        <script type="text/javascript">
            $("#add-btn").click(function () {
                location.href = "${pageContext.request.contextPath}/employee/edit"
            })

            $("#delete-selection-btn").click(function () {
                if ($(":checkbox:checked").length === 0) {
                    alert("未选中数据！")
                } else {
                    if (confirm("是否确认删除选中数据？")) {
                        $("#delete-batch-form").submit()
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

            let singleSelectionList = $(":checkbox[id!='select-all-checkbox']")
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

            let searchForm = $("#employee")[0]

            $(".pagination-div").pagination({
                totalData: ${pageInfo.total},
                showData: ${pageInfo.pageSize},
                coping: true,
                homePage: "首页",
                current: ${pageInfo.pageNum},
                endPage: "末页",
                count: 1,
                jump: true,
                jumpIptCls: "pagination-jump-input",
                callback: function (api) {
                    searchForm.action = "${pageContext.request.contextPath}/employee/list?page=" + api.getCurrent() + "&pageSize=${pageInfo.pageSize}"
                    searchForm.submit()
                }
            })

            function pageChange(page, offset) {
                searchForm.action = "${pageContext.request.contextPath}/employee/list?page=" + (page + offset) + "&pageSize=" + $("#page-size-select").val()
                searchForm.submit()
            }
        </script>
    </body>
</html>