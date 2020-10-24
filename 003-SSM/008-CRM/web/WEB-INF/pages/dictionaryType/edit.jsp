<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-22 下午 9:51
--%>
<%--@elvariable id="dictionaryType" type="top.fallenangel.crm.model.entity.DictionaryType"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>编辑字典类型</title>
        <meta charset="UTF-8">

        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
              rel="stylesheet"/>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.1-min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div style="position:  relative; left: 30px;">
            <h3>${empty dictionaryType.dictionaryTypeId ? "新增" : "修改"}字典类型</h3>
            <div style="position: relative; top: -40px; left: 70%;">
                <button type="button" class="btn btn-primary" id="save-btn">保存</button>
                <button type="button" class="btn btn-default" id="cancel-btn">取消</button>
            </div>
            <hr style="position: relative; top: -40px;">
        </div>
        <form:form cssClass="form-horizontal" role="form" modelAttribute="dictionaryType" action="save">
            <form:hidden path="dictionaryTypeId"/>
            <div class="form-group">
                <label for="dictionaryTypeCode" class="col-sm-2 control-label">
                    编码<span style="font-size: 15px; color: red">*</span>
                </label>
                <div class="col-sm-10" style="width: 300px">
                    <form:input class="form-control" path="dictionaryTypeCode" style="width: 200%"
                                placeholder="这个类型的编码，只能用英文书写"/>
                </div>
            </div>
            <div class="form-group">
                <label for="dictionaryTypeName" class="col-sm-2 control-label">
                    名称<span style="font-size: 15px; color: red">*</span>
                </label>
                <div class="col-sm-10" style="width: 300px">
                    <form:input class="form-control" path="dictionaryTypeName" style="width: 200%"
                                placeholder="这个类型的名称，可以为任意字符"/>
                </div>
            </div>
            <div class="form-group">
                <label for="dictionaryTypeStatus" class="col-sm-2 control-label">
                    状态<span style="font-size: 15px; color: red">*</span>
                </label>
                <div class="col-sm-10" style="width: 300px">
                    <form:select class="form-control" path="dictionaryTypeStatus" style="width: 200%">
                        <form:option value="" label="请选择"/>
                        <form:option value="true" label="启用"/>
                        <form:option value="false" label="禁用"/>
                    </form:select>
                </div>
            </div>
        </form:form>
        <div style="height: 200px;"></div>

        <script type="text/javascript">
            $("#save-btn").click(function () {
                $("#dictionaryType").submit()
            })

            $("#cancel-btn").click(function () {
                location.href = "${pageContext.request.contextPath}/dictionaryType/list"
            })
        </script>
    </body>
</html>