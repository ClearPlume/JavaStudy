<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-09 下午 9:56
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="area" type="top.fallenangel.spring.mvc.entity.Area"--%>
<html>
    <head>
        <title>${empty area ? "新增" : "编辑"}区域</title>
        <style type="text/css">
            .input-box {
                width: 175px;
            }
        </style>
    </head>
    <body style="text-align: center">
        <form:form action="save" modelAttribute="area">
            <form:hidden path="areaId"/>
            <br/>
            <form:input path="areaName" cssClass="input-box" placeholder="部门位置"/>
            <br/>
            <form:button>${empty area.areaId ? "添加" : "修改"}</form:button>
        </form:form>
    </body>
</html>