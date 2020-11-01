<%--suppress JSConsecutiveCommasInArrayLiteral --%>
<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-11-01 下午 12:01
--%>
<%--@elvariable id="dealTypeSet" type="java.util.Set<java.lang.String>"--%>
<%--@elvariable id="dataList" type="java.util.List<java.util.List<java.lang.Integer>>"--%>
<%--@elvariable id="data" type="java.util.List<java.lang.Integer>"--%>
<%--@elvariable id="" type=""--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>交易统计图表</title>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.1-min.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                let dealECharts = echarts.init($("#dealECharts")[0])

                dealECharts.setOption({
                    title: {
                        text: "交易统计图表"
                    },
                    tooltip: {},
                    legend: {},
                    dataset: {
                        source: [
                            ${dealTypeSet},
                            <c:forEach items="${dataList}" var="data" varStatus="dataListVS">
                            ['${dataListVS.count}月',
                                <c:forEach items="${data}" var="count" varStatus="dataVS">
                                ${count}${dataVS.last ? "" : ","}
                                </c:forEach>
                            ]${dataListVS.last ? "" : ","}
                            </c:forEach>
                        ]
                    },
                    xAxis: {
                        type: 'category'
                    },
                    yAxis: {
                        minInterval: 1
                    },
                    series: [
                        {type: 'bar'},
                        {type: 'bar'}
                    ]
                })
            })
        </script>
    </head>
    <body>
        <div id="dealECharts" style="width: 80%; height: 80%"></div>
    </body>
</html>