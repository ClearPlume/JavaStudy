<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-11-04 下午 5:14
--%>
<%--@elvariable id="addressList" type="java.util.List<top.fallenangel.dubbo.improve.entity.Address>"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>地址信息</title>
    </head>
    <body>
        <h1>收货人地址如下：</h1>
        <c:forEach items="${addressList}" var="address" varStatus="vs">
            <h3>收货人姓名：${address.name}</h3>
            <h3>收货人城市：${address.city}</h3>
            <h3>收货人街道：${address.street}</h3>
            <c:if test="${!vs.last}">
                <div>---------------------------------</div>
            </c:if>
        </c:forEach>
    </body>
</html>