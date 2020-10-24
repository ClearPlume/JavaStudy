<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-22 下午 9:51
--%>
<%--@elvariable id="dept" type="top.fallenangel.crm.model.entity.Dept"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>修改部门</title>
        <meta charset="UTF-8">

        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
              rel="stylesheet"/>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.1-min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div style="position:  relative; left: 30px;">
            <h3>修改部门</h3>
            <div style="position: relative; top: -40px; left: 70%;">
                <button type="button" class="btn btn-primary" id="save-btn">保存</button>
                <button type="button" class="btn btn-default" id="cancel-btn">取消</button>
            </div>
            <hr style="position: relative; top: -40px;">
        </div>
        <form:form cssClass="form-horizontal" role="form" modelAttribute="dept" action="save">
            <form:hidden path="deptId"/>
            <div class="form-group">
                <label for="deptName" class="col-sm-2 control-label">
                    名称<span style="font-size: 15px; color: red">*</span>
                </label>
                <div class="col-sm-10" style="width: 300px">
                    <form:input class="form-control" path="deptName" style="width: 200%"/>
                </div>
            </div>
            <div class="form-group">
                <label for="deptCode" class="col-sm-2 control-label">
                    编码<span style="font-size: 15px; color: red">*</span>
                </label>
                <div class="col-sm-10" style="width: 300px">
                    <form:input class="form-control" path="deptCode" style="width: 200%"
                                placeholder="这个类型的名称，可以为任意字符"/>
                </div>
            </div>
            <div class="form-group">
                <label for="deptStatus" class="col-sm-2 control-label">
                    状态<span style="font-size: 15px; color: red">*</span>
                </label>
                <div class="col-sm-10" style="width: 300px">
                    <form:select class="form-control" path="deptStatus" style="width: 200%">
                        <form:option value="" label="请选择"/>
                        <form:option value="1" label="启用"/>
                        <form:option value="0" label="禁用"/>
                    </form:select>
                </div>
            </div>
        </form:form>
        <div style="height: 200px;"></div>

        <script type="text/javascript">
            $("#save-btn").click(function () {
                $("#dept").submit()
            })

            $("#cancel-btn").click(function () {
                location.href = "${pageContext.request.contextPath}/dept/list"
            })
        </script>
    </body>
</html>