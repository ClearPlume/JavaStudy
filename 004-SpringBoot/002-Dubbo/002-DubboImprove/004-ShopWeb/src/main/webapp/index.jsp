<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
    <head>
        <title>商品信息展示</title>

        <script type="text/javascript">
            let URL_PREFIX = "${pageContext.request.contextPath}"

            function buyGoods(userId, name, price, amount) {
                location.href = URL_PREFIX + "/shop/buy?userId=" + userId
                    + "&name=" + name
                    + "&price=" + price
                    + "&amount=" + amount
            }

            function showAddress() {
                location.href = URL_PREFIX + "/shop/addresses"
            }
        </script>
    </head>
    <body>
        <div style="margin-left:400px">
            <table style="width: 60%">
                <caption>商品列表</caption>
                <tr>
                    <td>iphone11</td>
                    <td>5000</td>
                    <td>8</td>
                    <td>
                        <a href="javascript:void(0)" onClick="buyGoods(1,'iphone11','5000','8')">购买</a>
                    </td>
                </tr>

                <tr>
                    <td>电视</td>
                    <td>2000</td>
                    <td>2</td>
                    <td>
                        <a href="javascript:void(0)" onClick="buyGoods(2,'电视','2000','2')">购买</a>
                    </td>
                </tr>

            </table>
        </div>
        <div style="margin-left:450px">
            <a href="javascript:void(0)" onClick="showAddress()">我的收件地址</a>
        </div>
    </body>
</html>