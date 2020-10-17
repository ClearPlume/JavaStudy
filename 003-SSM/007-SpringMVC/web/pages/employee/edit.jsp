<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-09 下午 9:56
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="employee" type="top.fallenangel.spring.mvc.entity.Employee"--%>
<%--@elvariable id="depts" type="java.util.List<top.fallenangel.spring.mvc.entity.Dept>"--%>
<html>
    <head>
        <title>${empty employee ? "新增" : "编辑"}员工</title>
        <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
        <script src="${pageContext.request.contextPath}/js/jQuery-File-Upload/js/vendor/jquery.ui.widget.js"></script>
        <script src="${pageContext.request.contextPath}/js/jQuery-File-Upload/js/jquery.iframe-transport.js"></script>
        <script src="${pageContext.request.contextPath}/js/jQuery-File-Upload/js/jquery.fileupload.js"></script>
        <script src="${pageContext.request.contextPath}/js/jQuery-File-Upload/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/js/jQuery-File-Upload/css/bootstrap.min.css">
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/js/jQuery-File-Upload/css/jquery.fileupload.css">
        <style type="text/css">
            .input-box {
                width: 175px;
            }
        </style>
    </head>
    <body style="text-align: center">
        <form:form action="save" modelAttribute="employee" enctype="multipart/form-data">
            <form:hidden path="empId"/>
            <br/>
            <form:input path="empName" cssClass="input-box" placeholder="员工姓名"/>
            <form:errors path="empName" cssStyle="color: red"/>
            <br/>
            <form:select path="dept.deptId" cssClass="input-box">
                <c:if test="${employee.empId == null}">
                    <form:option value="-1" label="请选择部门"/>
                </c:if>
                <form:options items="${depts}" itemValue="deptId" itemLabel="deptName"/>
            </form:select>
            <form:errors path="dept.deptId" cssStyle="color: red"/>
            <br/>
            <c:if test="${not empty employee.empId}">
                <span class="btn btn-success fileinput-button">
                <i class="glyphicon glyphicon-plus"></i>
                <span>选择头像...</span>
                <input id="avatarUpload" type="file" name="image">
                </span>
                <br/>
                <form:hidden path="empAvatar"/>
                <img id="avatarImg" src="/upload/img/${employee.empAvatar}" alt="员工头像"/>
                <br/>
            </c:if>
            <button id="back-btn" type="button">返回</button>
            <form:button>${empty employee.empId ? "添加" : "修改"}</form:button>
        </form:form>

        <script type="text/javascript">
            $.post(
                "${pageContext.request.contextPath}/dept/depts",
                function (data) {
                    for (let dept of data) {
                        $("select[class='input-box']").append("<option value='" + dept.deptId + "'>" + dept.deptName + "</option>")
                    }
                }
            )

            $("#back-btn").click(function () {
                location.href = "${pageContext.request.contextPath}/employee/list"
            })

            let empAvatar = $("#empAvatar")

            $("#avatarUpload").fileupload({
                "url": "${pageContext.request.contextPath}/uploadImage?empId=${employee.empAvatar}",
                "dataType": "json",
                "done": function (e, data) {
                    let result = data.result;
                    if (result.success) {
                        $("#avatarImg").attr("src", result.path + "/" + result.fileRealName)
                        $("#empAvatar").val(result.fileRealName)
                    } else {
                        alert("头像上传失败")
                    }
                }
            })
        </script>
    </body>
</html>