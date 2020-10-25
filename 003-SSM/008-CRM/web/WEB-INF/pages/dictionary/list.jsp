<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-22 下午 9:16
--%>
<%--@elvariable id="dictionaryList" type="java.util.List<top.fallenangel.crm.model.entity.Dictionary>"--%>
<%--@elvariable id="dictionary" type="top.fallenangel.crm.model.entity.Dictionary"--%>
<%--@elvariable id="dictionaryType" type="top.fallenangel.crm.model.entity.DictionaryType"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>字典值列表</title>
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
    </head>
    <body>
        <div>
            <div style="position: relative; left: 30px; top: -10px;">
                <div class="page-header">
                    <h3>字典值列表(${dictionaryType.dictionaryTypeName})</h3>
                </div>
            </div>
        </div>
        <div class="btn-toolbar" role="toolbar"
             style="background-color: #F7F7F7; height: 50px; position: relative;left: 30px;">
            <div class="btn-group" style="position: relative; top: 18%;">
                <button type="button" class="btn btn-primary"
                        onclick="location.href='${pageContext.request.contextPath}/dictionary/edit?type=${dictionaryType.dictionaryTypeId}&order=${dictionaryList.size() + 1}'"><span
                        class="glyphicon glyphicon-plus"></span> 创建
                </button>
                <button type="button" class="btn btn-default"
                        onclick="window.location.href='${pageContext.request.contextPath}/dictionaryType/list'"><span
                        class="glyphicon glyphicon-edit"></span> 返回
                </button>
                <button type="button" class="btn btn-warning"
                        onclick="location.href='${pageContext.request.contextPath}/dictionary/updateCache?dictionaryTypeId=${dictionaryType.dictionaryTypeId}'">
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
                        <td>字典值</td>
                        <td>排序号</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${dictionaryList}" var="dictionary" varStatus="vs">
                        <tr class="active">
                            <td></td>
                            <td>${vs.count}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/dictionary/edit?id=${dictionary.dictionaryId}">${dictionary.dictionaryValue}</a>
                            </td>
                            <td>${dictionary.dictionaryOrder}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>