<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-09-19 上午 10:43
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
        <meta name="renderer" content="webkit">
        <title>修改鲜花</title>
        <link rel="stylesheet" href="css/pintuer.css">
        <link rel="stylesheet" href="css/admin.css">
        <script src="js/jquery.js"></script>
        <script src="js/pintuer.js"></script>
    </head>
    <body>
        <div class="panel admin-panel">
            <div class="panel-head" id="add"><span class="icon-magic"><strong>修改鲜花</strong></span></div>
            <div class="body-content">
                <form method="post" class="form-x" action="${pageContext.request.contextPath}/flower?action=modify&f_id=${flower.f_id}">
                    <div class="form-group">
                        <div class="label">
                            <label>鲜花名称：</label>
                        </div>
                        <div class="field">
                            <label>
                                <input class="input w50" name="f_name" type="text" value="${flower.f_name}"/>
                            </label>
                            <span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label>价格：</label>
                        </div>
                        <div class="field">
                            <label>
                                <input class="input w50" name="f_price" type="text" value="${flower.f_price}"/>
                            </label>
                            <span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label>鲜花种类：</label>
                        </div>
                        <div class="field">
                            <label>
                                <select id="c_id" name="c_id" class="input w50">
                                    <%--@elvariable id="classifies" type="java.util.List<top.fallenangel.bean.Classify>"--%>
                                    <c:forEach items="${classifies}" var="classify">
                                        <option value="${classify.c_id}">${classify.c_name}</option>
                                    </c:forEach>
                                    <script type="text/javascript">
                                        $("#c_id").val(${flower.c_id})
                                    </script>
                                </select>
                            </label>
                            <span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label></label>
                        </div>
                        <div class="field">
                            <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                            <button type="button" style="width: 110px;" class="button bg-green" id="back-flower-list">
                                返回
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
    <script type="text/javascript">
        $("#back-flower-list").click(function () {
            location.href = "/014_LastCheck/flower?action=list"
        })
    </script>
</html>