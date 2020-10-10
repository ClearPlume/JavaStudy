<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-09-28 上午 10:50
--%>
<%--@elvariable id="areaList" type="java.util.List<top.fallenangel.spring.mvc.entity.Area>"--%>
<%--@elvariable id="area" type="top.fallenangel.spring.mvc.entity.Area"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>区域列表</title>
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
    </style>
    <body>
        <a href="${pageContext.request.contextPath}">首页</a>
        <table>
            <caption><h2>区域表</h2></caption>
            <thead>
                <tr>
                    <td>
                        <button id="add-btn">添加区域</button>
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
                <th>区域ID</th>
                <th>区域名称</th>
                <th style="width: 120px">操作</th>
            </tr>
            <c:forEach items="${areaList}" var="area">
                <tr>
                    <td>
                        <label>
                            <input type="checkbox" class="single-selection-checkbox"
                                   value="${area.areaId}">
                        </label>
                    </td>
                    <td>${area.areaId}</td>
                    <td>${area.areaName}</td>
                    <td>
                        <button class="modify-btn" value="${area.areaId}">修改</button>
                        <button class="delete-btn" value="${area.areaId}">删除</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
    <script type="text/javascript">
        document.querySelector("#add-btn").onclick = function () {
            location.href = "${pageContext.request.contextPath}/area/edit"
        }
        document.querySelector("#delete-selection-btn").onclick = function () {
            let selectedSelections = document.querySelectorAll("input[type='checkbox']")
            let data = ""

            selectedSelections.forEach(function (selection, index) {
                if (selection.checked) {
                    data += "areaId=" + selection.value
                }
                if (selection.checked && index <= selectedSelections.length) {
                    data += "&"
                }
            })

            if (data === "") {
                alert("未选中数据！")
            } else {
                if (confirm("是否确认删除选中数据？")) {
                    location.href = "${pageContext.request.contextPath}/area/delete?" + data
                }
            }
        }

        document.querySelectorAll(".modify-btn").forEach(function (btn) {
            btn.onclick = function () {
                location.href = "${pageContext.request.contextPath}/area/edit?areaId=" + btn.value
            }
        })

        document.querySelectorAll(".delete-btn").forEach(function (btn) {
            btn.onclick = function () {
                if (confirm("是否确认删除选中数据？")) {
                    location.href = "${pageContext.request.contextPath}/area/delete?areaId=" + btn.value
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
