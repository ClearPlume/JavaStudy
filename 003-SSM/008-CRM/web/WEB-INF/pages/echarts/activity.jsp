<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-11-01 下午 12:01
--%>
<%--@elvariable id="integerList" type="java.util.List<java.lang.Integer>"--%>
<%--@elvariable id="statistic" type="java.lang.Integer"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>市场活动统计图表</title>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.1-min.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                let dealEChartsBar = echarts.init($("#activityEChartsBar")[0])
                let dealEChartsLine = echarts.init($("#activityEChartsLine")[0])

                dealEChartsBar.setOption({
                    title: {
                        text: "市场活动统计图表"
                    },
                    legend: {
                        data: ["销量"]
                    },
                    tooltip: {},
                    xAxis: {
                        data: [
                            <c:forEach items="${integerList}" varStatus="vs">
                            "${vs.count}月"${vs.last ? "" : ","}
                            </c:forEach>
                        ]
                    },
                    yAxis: {
                        minInterval: 1
                    },
                    series: [{
                        name: "销量",
                        type: "bar",
                        data: [
                            <c:forEach items="${integerList}" var="statistic" varStatus="vs">
                            Number.parseInt("${statistic}")${vs.last ? "" : ","}
                            </c:forEach>
                        ]
                    }]
                })

                dealEChartsLine.setOption({
                    title: {
                        text: "市场活动统计图表"
                    },
                    legend: {
                        data: ["销量"]
                    },
                    tooltip: {},
                    xAxis: {
                        data: [
                            <c:forEach items="${integerList}" varStatus="vs">
                            "${vs.count}月"${vs.last ? "" : ","}
                            </c:forEach>
                        ]
                    },
                    yAxis: {
                        minInterval: 1
                    },
                    series: [{
                        name: "销量",
                        type: "line",
                        data: [
                            <c:forEach items="${integerList}" var="statistic" varStatus="vs">
                            Number.parseInt("${statistic}")${vs.last ? "" : ","}
                            </c:forEach>
                        ]
                    }]
                })
            })
        </script>
    </head>
    <body>
        <div id="activityEChartsBar" style="width: 80%; height: 40%"></div>
        <div id="activityEChartsLine" style="width: 80%; height: 40%"></div>
    </body>
</html>