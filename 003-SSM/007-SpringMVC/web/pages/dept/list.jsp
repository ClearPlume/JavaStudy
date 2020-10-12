<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-09-28 上午 10:50
--%>
<%--@elvariable id="deptList" type="java.util.List<top.fallenangel.spring.mvc.entity.Dept>"--%>
<%--@elvariable id="dept" type="top.fallenangel.spring.mvc.entity.Dept"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>部门列表</title>
    </head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/list_table.css">
    <body>
        <a href="${pageContext.request.contextPath}">首页</a>
        <table>
            <caption><h2>部门表</h2></caption>
            <thead>
                <tr>
                    <td>
                        <button id="add-btn">添加部门</button>
                    </td>
                    <td>
                        <button id="delete-selection-btn">删除选择</button>
                    </td>
                </tr>
            </thead>
            <tr>
                <th>
                    <label>
                        <input type="checkbox" id="select-all-checkbox">
                    </label>
                    /
                    <button id="invert-selection-btn">反选</button>
                </th>
                <th>部门ID</th>
                <th>部门名称</th>
                <th>部门位置</th>
                <th style="width: 120px">操作</th>
            </tr>
            <c:forEach items="${deptList}" var="dept">
                <tr>
                    <td>
                        <label>
                            <input type="checkbox" class="single-selection-checkbox"
                                   value="${dept.deptId}">
                        </label>
                    </td>
                    <td>${dept.deptId}</td>
                    <td>${dept.deptName}</td>
                    <td>${dept.area.areaName}</td>
                    <td>
                        <button class="modify-btn" value="${dept.deptId}">修改</button>
                        <button class="delete-btn" value="${dept.deptId}">删除</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
    <script type="text/javascript">
        document.querySelector("#add-btn").onclick = function () {
            location.href = "${pageContext.request.contextPath}/dept/edit"
        }
        document.querySelector("#delete-selection-btn").onclick = function () {
            let selectedSelections = document.querySelectorAll("input[type='checkbox']")
            let data = ""

            selectedSelections.forEach(function (selection, index) {
                if (selection.checked) {
                    data += "deptId=" + selection.value
                }
                if (selection.checked && index <= selectedSelections.length) {
                    data += "&"
                }
            })

            if (data === "") {
                alert("未选中数据！")
            } else {
                if (confirm("是否确认删除选中数据？")) {
                    location.href = "${pageContext.request.contextPath}/dept/delete?" + data
                }
            }
        }

        document.querySelectorAll(".modify-btn").forEach(function (btn) {
            btn.onclick = function () {
                location.href = "${pageContext.request.contextPath}/dept/edit?deptId=" + btn.value
            }
        })

        document.querySelectorAll(".delete-btn").forEach(function (btn) {
            btn.onclick = function () {
                if (confirm("是否确认删除选中数据？")) {
                    location.href = "${pageContext.request.contextPath}/dept/delete?deptId=" + btn.value
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
    </script>
</html>
