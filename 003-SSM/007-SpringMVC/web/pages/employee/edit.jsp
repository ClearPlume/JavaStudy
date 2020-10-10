<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-09 下午 9:56
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="employee" type="top.fallenangel.spring.mvc.entity.Employee"--%>
<%--@elvariable id="depts" type="java.util.List<top.fallenangel.spring.mvc.entity.Dept>"--%>
<html>
    <head>
        <title>${empty employee ? "新增" : "编辑"}员工</title>
        <style type="text/css">
            .input-box {
                width: 175px;
            }
        </style>
    </head>
    <body style="text-align: center">
        <form:form action="save" modelAttribute="employee">
            <form:hidden path="empId"/>
            <br/>
            <form:input path="empName" cssClass="input-box" placeholder="员工姓名"/>
            <br/>
            <form:select path="dept.deptId" cssClass="input-box">
                <c:if test="${employee.empId == null}">
                    <form:option value="-1" label="请选择部门"/>
                </c:if>
                <form:options items="${depts}" itemValue="deptId" itemLabel="deptName"/>
            </form:select>
            <br/>
            <form:button>${empty employee.empId ? "添加" : "修改"}</form:button>
        </form:form>
    </body>
</html>