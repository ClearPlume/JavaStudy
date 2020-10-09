<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-09-29 上午 11:24
--%>
<%--@elvariable id="depts" type="java.util.List<top.fallenangel.spring.mvc.entity.Dept>"--%>
<%--@elvariable id="dept" type="top.fallenangel.spring.mvc.entity.Dept"--%>
<%--@elvariable id="employee" type="top.fallenangel.spring.mvc.entity.Employee"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>修改员工</title>
    </head>
    <body style="text-align: center">
        <form:form action="modify" modelAttribute="employee">
            <form:hidden path="empId"/>
            <br/>
            <form:input path="empName" style="width: 175px"/>
            <br/>
            <form:select path="dept.deptId" items="${depts}" itemLabel="deptName" itemValue="deptId"
                         cssStyle="width: 175px"/>
            <br/>
            <form:button>修改</form:button>
        </form:form>
    </body>
</html>
