<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-11-04 下午 5:14
--%>
<%--@elvariable id="order" type="top.fallenangel.dubbo.improve.entity.Order"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>商品信息</title>
    </head>
    <body>
        <h1>您的订单已经生成：</h1>
        <h3>订单编号：${order.id}</h3>
        <h3>订单金额：${order.price}</h3>
        <h3>商品名称：${order.name}</h3>
        <h3>商品数量：${order.amount}</h3>
    </body>
</html>