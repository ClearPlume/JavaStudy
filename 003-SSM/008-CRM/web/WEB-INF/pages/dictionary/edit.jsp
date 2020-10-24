<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-23 下午 8:56
--%>
<%--@elvariable id="dictionary" type="top.fallenangel.crm.model.entity.Dictionary"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>编辑字典值</title>

        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
              rel="stylesheet"/>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.1-min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div style="position:  relative; left: 30px;">
            <h3>${empty dictionary.dictionaryId ? "新增" : "修改"}字典值(${dictionary.dictionaryType.dictionaryTypeName})</h3>
            <div style="position: relative; top: -40px; left: 70%;">
                <button type="button" class="btn btn-primary" id="save-btn">保存</button>
                <button type="button" class="btn btn-default" id="cancel-btn"
                        value="${dictionary.dictionaryType.dictionaryTypeId}">取消
                </button>
            </div>
            <hr style="position: relative; top: -40px;">
        </div>
        <form:form cssClass="form-horizontal" role="form" modelAttribute="dictionary" action="save">
            <form:hidden path="dictionaryId"/>
            <form:hidden path="dictionaryType.dictionaryTypeId"/>
            <div class="form-group">
                <label for="dictionaryValue" class="col-sm-2 control-label">
                    字典值<span style="font-size: 15px; color: red">*</span>
                </label>
                <div class="col-sm-10" style="width: 300px">
                    <form:input class="form-control" path="dictionaryValue" style="width: 200%"
                                placeholder="字典值"/>
                </div>
            </div>
            <div class="form-group">
                <label for="dictionaryOrder" class="col-sm-2 control-label">
                    排序号<span style="font-size: 15px; color: red">*</span>
                </label>
                <div class="col-sm-10" style="width: 300px">
                    <form:input class="form-control" path="dictionaryOrder" style="width: 200%"
                                value="${empty dictionary.dictionaryOrder ? '' : dictionary.dictionaryOrder}"
                                placeholder="这个值在所有这个类型的值中的顺序，是数字"/>
                </div>
            </div>
            <div class="form-group">
                <label for="dictionaryStatus" class="col-sm-2 control-label">
                    状态<span style="font-size: 15px; color: red">*</span>
                </label>
                <div class="col-sm-10" style="width: 300px">
                    <form:select class="form-control" path="dictionaryStatus" style="width: 200%">
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
                $("#dictionary").submit()
            })

            $("#cancel-btn").click(function () {
                location.href = `${pageContext.request.contextPath}/dictionary/list?dictionaryTypeId=\${this.value}`
            })
        </script>
    </body>
</html>