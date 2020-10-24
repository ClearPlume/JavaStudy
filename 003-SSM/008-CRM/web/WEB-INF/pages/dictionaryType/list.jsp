<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-22 下午 8:36
--%>
<%--@elvariable id="DICTIONARIES_IN_APPLICATION" type="java.util.Map<top.fallenangel.crm.model.entity.DictionaryType, java.util.Map<java.lang.Integer, top.fallenangel.crm.model.entity.Dictionary>>"--%>
<%--@elvariable id="dictionaryTypeEntry" type="java.util.Map.Entry<top.fallenangel.crm.model.entity.DictionaryType, java.util.Map<java.lang.Integer, top.fallenangel.crm.model.entity.Dictionary>>"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>字典类型列表</title>
        <meta charset="UTF-8">

        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
              rel="stylesheet"/>

        <style type="text/css">
            a:hover {
                text-decoration: none;
            }

            .table > tbody > tr > td {
                vertical-align: middle;
            }
        </style>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.1-min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bs_alert.js"></script>
    </head>
    <body>
        <div>
            <div style="position: relative; left: 30px; top: -10px;">
                <div class="page-header">
                    <h3>字典类型列表</h3>
                </div>
            </div>
        </div>
        <div class="btn-toolbar" role="toolbar"
             style="background-color: #F7F7F7; height: 50px; position: relative;left: 30px;">
            <div class="btn-group" style="position: relative; top: 18%;">
                <button type="button" class="btn btn-primary"
                        onclick="location.href='${pageContext.request.contextPath}/dictionaryType/edit'">
                    <span class="glyphicon glyphicon-plus"></span> 创建
                </button>
                <button type="button" class="btn btn-warning"
                        onclick="location.href='${pageContext.request.contextPath}/dictionaryType/updateCache'">
                    <span class="glyphicon glyphicon-refresh"></span> 更新缓存
                </button>
            </div>
        </div>
        <div style="position: relative; left: 30px; top: 20px;">
            <table class="table table-hover">
                <thead>
                    <tr style="color: #B3B3B3;">
                        <td></td>
                        <td>序号</td>
                        <td>名称</td>
                        <td>编码</td>
                        <td>状态</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${DICTIONARIES_IN_APPLICATION}" var="dictionaryTypeEntry" varStatus="vs">
                        <tr class="active">
                            <td style="width: 0">
                                <button type="button" class="btn btn-info edit-dictionary-type-btn"
                                        value="${dictionaryTypeEntry.key.dictionaryTypeId}">
                                    <span class="glyphicon glyphicon-edit"></span>
                                </button>
                            </td>
                            <td>${vs.count}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/dictionary/list?dictionaryTypeId=${dictionaryTypeEntry.key.dictionaryTypeId}">
                                        ${dictionaryTypeEntry.key.dictionaryTypeName}
                                </a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/dictionary/list?dictionaryTypeId=${dictionaryTypeEntry.key.dictionaryTypeId}">
                                        ${dictionaryTypeEntry.key.dictionaryTypeCode}
                                </a>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${dictionaryTypeEntry.key.dictionaryTypeStatus}">
                                        <span style="color: green">启用</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span style="color: red">禁用</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <script type="text/javascript">
            $(".edit-dictionary-type-btn").click(function () {
                location.href = `${pageContext.request.contextPath}/dictionaryType/edit?id=\${this.value}`
            })
        </script>
    </body>
</html>