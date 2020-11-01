<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-30 上午 8:57
--%>
<%--@elvariable id="shoppingList" type="java.util.List<top.fallenangel.shoppingmanagement.model.entity.Shopping>"--%>
<%--@elvariable id="shopping" type="top.fallenangel.shoppingmanagement.model.entity.Shopping"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>商品管理系统</title>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $(".click").click(function () {
                    $(".tip").fadeIn(200);
                });

                $(".tiptop a").click(function () {
                    $(".tip").fadeOut(200);
                });

                $(".sure").click(function () {
                    $(".tip").fadeOut(100);
                });

                $(".cancel").click(function () {
                    $(".tip").fadeOut(100);
                });

                $('.tablelist tbody tr:odd').addClass('odd');
            });

            function toAdd() {
                location.href = "${pageContext.request.contextPath}/shopping/edit"
            }

            function toEdit(id) {
                location.href = "${pageContext.request.contextPath}/shopping/edit?id=" + id
            }

            function del() {
                let deleteBatch = $("#delete-batch")

                if ($(".delete-checkbox:checked").length === 0) {
                    alert("请至少选择一条数据！")
                } else {
                    deleteBatch.submit()
                }
            }
        </script>
    </head>
    <body>
        <div class="place">
            <span>位置：</span>
            <ul class="placeul">
                <li>商品管理</li>
            </ul>
        </div>
        <div class="rightinfo">
            <div class="tools">
                <ul class="toolbar">
                    <li class="click" onclick="toAdd()"><span><img src="${pageContext.request.contextPath}/img/t01.png"
                                                                   alt=""/></span>
                    </li>
                    <li class="click" onclick="del()"><span><img src="${pageContext.request.contextPath}/img/t03.png"
                                                                 alt=""/></span>
                    </li>
                </ul>
            </div>
            <table class="tablelist">
                <thead>
                    <tr>
                        <th></th>
                        <th>编号</th>
                        <th>商品名称</th>
                        <th>规格</th>
                        <th>价格（元）</th>
                        <th>产地</th>
                        <th>上架时间</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <form id="delete-batch" action="${pageContext.request.contextPath}/shopping/delete" method="post">
                        <c:forEach items="${shoppingList}" var="shopping">
                            <tr>
                                <td>
                                    <label>
                                        <input type="checkbox" name="id" class="delete-checkbox"
                                               value="${shopping.shoppingId}"/>
                                    </label>
                                </td>
                                <td>${shopping.shoppingNo}</td>
                                <td>${shopping.shoppingName}</td>
                                <td>${shopping.shoppingSpec}</td>
                                <td>${shopping.shoppingPrice}</td>
                                <td>${shopping.shoppingOrigin}</td>
                                <td><fmt:formatDate value="${shopping.shoppingShelfDate}" pattern="yyyy-MM-dd"/></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${shopping.shoppingStatus}">
                                            <span style="color: green">上架</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span style="color: red">下架</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/shopping/edit?id=${shopping.shoppingId}"
                                       class="tablelink">修改</a>
                                    <a href="${pageContext.request.contextPath}/shopping/delete?id=${shopping.shoppingId}"
                                       class="tablelink">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </form>
                </tbody>
            </table>
        </div>
    </body>
</html>