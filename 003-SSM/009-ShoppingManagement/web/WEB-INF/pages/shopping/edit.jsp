<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-30 上午 8:59
--%>
<%--@elvariable id="shopping" type="top.fallenangel.shoppingmanagement.model.entity.Shopping"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>商品${empty shopping.shoppingId ? "添加" : "修改"}</title>

        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="place">
            <span>位置：</span>
            <ul class="placeul">
                <li><a href="${pageContext.request.contextPath}/shopping/list">商品管理</a></li>
                <li>商品添加</li>
            </ul>
        </div>
        <div class="formbody">
            <div class="formtitle"><span>商品信息</span></div>
            <ul class="forminfo">
                <form:form modelAttribute="shopping" action="save">
                    <form:hidden path="shoppingId"/>
                    <li>
                        <label>商品名称</label><form:input path="shoppingName" cssClass="dfinput"/>
                    </li>
                    <li>
                        <label>规格</label><form:input path="shoppingSpec" cssClass="dfinput"/>
                    </li>
                    <li>
                        <label>价格(元)</label><form:input path="shoppingPrice" cssClass="dfinput"/>
                    </li>
                    <li>
                        <label>产地</label><form:input path="shoppingOrigin" cssClass="dfinput"/>
                    </li>
                    <li>
                        <fmt:formatDate value="${shopping.shoppingShelfDate}" pattern="yyyy-MM-dd"
                                        var="shoppingShelfDate"/>
                        <label for="shoppingShelfDate">上架时间</label>
                        <input id="shoppingShelfDate" name="shoppingShelfDate" type="text" class="dfinput"
                               value="${shoppingShelfDate}" placeholder="yyyy-MM-dd：2020-01-30"/>
                    </li>
                    <li>
                        <label>状态</label>
                        <cite>
                            <label style="position: relative; top: -10px">
                                <input name="shoppingStatus" type="radio"
                                       value="true" ${shopping.shoppingStatus ? "checked='checked'" : ""}/>
                                <span style="color:green"> 上架</span>
                            </label>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <label style="position: relative; top: -10px">
                                <input name="shoppingStatus" type="radio"
                                       value="false" ${shopping.shoppingStatus ? "" : empty shopping.shoppingId ? "" : "checked='checked'"}/>
                                <span style="color:red"> 下架</span>
                            </label>
                        </cite>
                    </li>
                    <li>
                        <label>&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <input type="submit" class="dfinput" style="cursor: pointer" value="保存"/>
                    </li>
                </form:form>
            </ul>
        </div>
    </body>
</html>