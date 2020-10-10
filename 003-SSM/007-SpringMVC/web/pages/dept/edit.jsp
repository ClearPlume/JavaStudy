<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-09 下午 9:56
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="dept" type="top.fallenangel.spring.mvc.entity.Dept"--%>
<%--@elvariable id="areas" type="java.util.List<top.fallenangel.spring.mvc.entity.Area>"--%>
<html>
    <head>
        <title>${empty dept ? "新增" : "编辑"}部门</title>
        <style type="text/css">
            .input-box {
                width: 175px;
            }
        </style>
    </head>
    <body style="text-align: center">
        <form:form action="save" modelAttribute="dept">
            <form:hidden path="deptId"/>
            <br/>
            <form:input path="deptName" cssClass="input-box" placeholder="部门名称"/>
            <br/>
            <form:select path="area.areaId" cssClass="input-box">
                <c:if test="${dept.deptId == null}">
                    <form:option value="-1" label="请选择部门位置"/>
                </c:if>
                <form:options items="${areas}" itemValue="areaId" itemLabel="areaName"/>
            </form:select>
            <br/>
            <form:button>${empty dept.deptId ? "添加" : "修改"}</form:button>
        </form:form>
    </body>
</html>