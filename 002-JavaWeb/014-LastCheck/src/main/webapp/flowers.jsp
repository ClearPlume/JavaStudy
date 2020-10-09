<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-09-19 上午 9:25
--%>
<%--@elvariable id="page" type="int"--%>
<%--@elvariable id="pages" type="int"--%>
<%--@elvariable id="curPage" type="int"--%>
<%--@elvariable id="flowerVO" type="top.fallenangel.bean.FlowerVO"--%>
<%--@elvariable id="classifies" type="java.util.List<top.fallenangel.bean.Classify>"--%>
<%--@elvariable id="flowers" type="java.util.List<java.util.Map<java.lang.String, java.lang.Object>>"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
        <meta name="renderer" content="webkit">
        <title></title>
        <link href="css/pintuer.css" rel="stylesheet">
        <link href="css/admin.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/amazeui.min.css" rel="stylesheet">
        <link href="css/admin1.css" rel="stylesheet">
        <link href="css/app.css" rel="stylesheet">
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/pintuer.js" type="text/javascript"></script>
        <script src="js/amazeui.min.js" type="text/javascript"></script>
        <script src="js/app.js" type="text/javascript"></script>
        <script src="js/plugs.js" type="text/javascript"></script>
        <style type="text/css">
            ul li {
                display: inline;
            }
        </style>
    </head>
    <body>
        <div class="panel admin-panel" style="border: 1px solid #ddd;">
            <div class="panel-head"><span class="icon-magic"><strong>鲜花管理</strong></span></div>
            <div class="padding border-bottom">
                <ul class="search">
                    <li>
                        <button class="btn btn-success" id="insert-emp" type="button">添加鲜花</button>
                        <button class="btn btn-danger" id="delete-selected-emp" type="button">批量删除</button>
                    </li>
                    <li>
                        <form action="${pageContext.request.contextPath}/flower?action=list&page=${curPage}"
                              method="post">
                            <div class="am-u-sm-12 am-u-md-3" style="position: absolute; right:220px; top:65px">
                                <label>
                                    <select class="input w50" id="c_id" name="c_id" style=" width: 200px">
                                        <option value="-1">请选择查找类型</option>
                                        <c:forEach items="${classifies}" var="classify">
                                            <option value="${classify.c_id}">${classify.c_name}</option>
                                        </c:forEach>
                                    </select>
                                    <script type="text/javascript">
                                        if ("${flowerVO.c_id}" !== "-1") {
                                            $("#c_id").val(${flowerVO.c_id})
                                        }
                                    </script>
                                </label>
                            </div>

                            <div class="am-u-sm-12 am-u-md-3" style="position: absolute; right:10px; top:67px">
                                <div class="am-input-group am-input-group-sm">
                                    <label>
                                        <input class="am-form-field" id="f_name" name="f_name" placeholder="请输入鲜花名称"
                                               type="text">
                                    </label>
                                    <script type="text/javascript">
                                        $("#f_name").val("${flowerVO.f_name}")
                                    </script>
                                    <div class="am-input-group-btn">
                                        <button type="submit" class="btn btn-primary"
                                                style="position: relative; top: -3px; left: -150px">查询
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </li>
                </ul>
            </div>
            <table class="table table-hover text-center">
                <tr>
                    <th>
                        <label>
                            <input type="checkbox" id="all-select"/>全选
                        </label>
                        /
                        <button class="btn btn-primary" id="inv-select" type="button">反选</button>
                    </th>
                    <th>序号</th>
                    <th>鲜花名称</th>
                    <th>价格</th>
                    <th>用途分类</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${flowers}" var="flower">
                    <tr>
                        <td>
                            <label>
                                <input type="checkbox" operaterow="true" value="${flower.f_id}"/>
                            </label>
                        </td>
                        <td>${flower.f_id}</td>
                        <td>${flower.f_name}</td>
                        <td>${flower.f_price}</td>
                        <td>${flower.c_name}</td>
                        <td>
                            <button class="btn btn-info" type="button" value="${flower.f_id}">修改</button>
                            <button class="btn btn-warning" type="button" value="${flower.f_id}">删除</button>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="8">
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <li>
                                    <button class="btn btn-primary"
                                            <c:if test="${curPage == 1}">
                                                disabled
                                            </c:if>
                                            onclick="pageChange(${curPage}, -1)"
                                            type="button">
                                        &laquo;
                                    </button>
                                </li>
                                <c:forEach begin="1" end="${pages}" var="page">
                                    <li>
                                        <button class="btn btn-link"
                                                <c:if test="${page == curPage}">
                                                    style="color: #095f8a; font-weight: bold"
                                                </c:if>
                                                onclick="pageChange(${page})"
                                                type="button">
                                            &nbsp;${page}&nbsp;
                                        </button>
                                    </li>
                                </c:forEach>
                                <li>
                                    <button class="btn btn-primary"
                                            <c:if test="${curPage == pages}">
                                                disabled
                                            </c:if>
                                            onclick="pageChange(${curPage}, 1)"
                                            type="button">
                                        &raquo;
                                    </button>
                                </li>
                            </ul>
                        </nav>
                    </td>
                </tr>
            </table>
        </div>
    </body>
    <script type="text/javascript">
        let selectAll = $("#all-select")
        let selects = $("input[operateRow='true']")

        selectAll.click(function () {
            selects.each(function () {
                this.checked = selectAll.prop("checked")
            })
        })

        selects.click(function () {
            selectAll.prop("checked", selects.length === getSelectedCount())
        })

        function getSelectedCount() {
            let selectCount = 0

            selects.each(function () {
                if (this.checked) {
                    selectCount++
                }
            })

            return selectCount
        }

        $("#inv-select").click(function () {
            selects.each(function () {
                this.checked = !this.checked
            })
        })

        let modifyBtn = $(".btn-info")
        modifyBtn.click(function () {
            location.href = "/014_LastCheck/flower?action=queryBeforeModify&f_id=" + this.value
        })

        let deleteBtn = $(".btn-warning")
        deleteBtn.click(function () {
            if (confirm("确认删除数据行？")) {
                location.href = "/014_LastCheck/flower?action=delete&f_id=" + this.value
            }
        })

        $("#insert-emp").click(function () {
            location.href = "/014_LastCheck/flower?action=queryBeforeInsert"
        })

        $("#delete-selected-emp").click(function () {
            let selectedRow = $("input:checked[operateRow='true']");
            if (selectedRow.length === 0) {
                alert("未选中数据行！")
            } else {
                if (confirm("确认删除选中数据行？")) {
                    let data = ""

                    selectedRow.each(function (index) {
                        data = data + "f_id=" + this.value
                        if (index < selectedRow.length - 1) {
                            data = data + "&"
                        }
                    })

                    location.href = "/014_LastCheck/flower?action=delete&" + data
                }
            }
        })

        /**
         * 点击按钮翻页
         * @param {number} page 目标页码
         * @param {number} offset 偏移量(-1, 0, 1)
         */
        function pageChange(page, offset = 0) {
            let finalPage = page + offset
            location.href = "${pageContext.request.contextPath}/flower?action=list&page=" + finalPage + "&c_id=" + $("#c_id").val() + "&f_name" +
                $("#f_name").val()
        }
    </script>
</html>