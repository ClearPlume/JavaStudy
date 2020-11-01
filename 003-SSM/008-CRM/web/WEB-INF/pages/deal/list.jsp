<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-27 下午 4:48
--%>
<%--@elvariable id="pageInfo" type="com.github.pagehelper.PageInfo<top.fallenangel.crm.model.entity.Deal>"--%>
<%--@elvariable id="deal" type="top.fallenangel.crm.model.entity.Deal"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" uri="http://fallenangel.top/util/functions" %>
<html>
    <head>
        <title>交易列表</title>
        <meta charset="UTF-8">

        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
              rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css"
              type="text/css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/js/jquery/bs_pagination/jquery.bs_pagination.min.css"
              type="text/css" rel="stylesheet"/>

        <style type="text/css">
            .table > tbody > tr > td {
                vertical-align: middle;
            }
        </style>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.1-min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bs_pagination/zh-CN.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bs_pagination/jquery.bs_pagination.min.js"></script>
    </head>
    <body>
        <div>
            <div style="position: relative; left: 10px; top: -10px;">
                <div class="page-header">
                    <h3>交易列表</h3>
                </div>
            </div>
        </div>
        <div style="position: relative; top: -20px; left: 0; width: 100%; height: 100%;">
            <div style="width: 100%; position: absolute;top: 5px; left: 10px;">
                <%--搜索条件--%>
                <div class="btn-toolbar" role="toolbar">
                    <form:form cssClass="form-inline" role="form" cssStyle="position: relative;top: 8%; left: 5px;"
                               modelAttribute="deal" action="?page=${pageInfo.pageNum}&pageSize=${pageInfo.pageSize}">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">交易名称</div>
                                <form:input path="dealName" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">客户名称</div>
                                <form:input path="linkman.customer.customerName" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">交易阶段</div>
                                <form:input path="dealStage" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">交易类型</div>
                                <form:select path="dealType" cssClass="form-control">
                                    <form:option value="" label="请选择类型"/>
                                    <form:options items="${u:getTypesByCode('dealType')}" itemLabel="dictionaryValue"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">交易来源</div>
                                <form:select path="dealSource" cssClass="form-control">
                                    <form:option value="" label="请选择来源"/>
                                    <form:options items="${u:getTypesByCode('source')}" itemLabel="dictionaryValue"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">联系人名称</div>
                                <form:input path="linkman.linkmanName" cssClass="form-control"/>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">查询</button>
                    </form:form>
                </div>
                <%--工具按钮--%>
                <div class="btn-toolbar" role="toolbar" style="background-color: #F7F7F7; height: 50px">
                    <div class="btn-group" style="position: relative; top: 18%;">
                        <button type="button" class="btn btn-primary"
                                onclick="location.href='${pageContext.request.contextPath}/deal/edit'"><span
                                class="glyphicon glyphicon-plus"></span> 创建
                        </button>
                    </div>
                </div>
                <%--交易列表--%>
                <div>
                    <table class="table table-hover">
                        <thead>
                            <tr style="color: #B3B3B3;">
                                <td></td>
                                <td>交易名称</td>
                                <td>客户名称</td>
                                <td>交易阶段</td>
                                <td>交易类型</td>
                                <td>交易来源</td>
                                <td>联系人名称</td>
                                <td>预计交易时间</td>
                                <td>实际交易时间</td>
                                <td>创建者</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${pageInfo.list}" var="deal">
                                <tr class="active">
                                    <td style="width: 0">
                                        <button onclick="location.href='${pageContext.request.contextPath}/deal/edit?id=${deal.dealId}'"
                                                class="btn btn-info">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </td>
                                    <td>${deal.dealName}</td>
                                    <td>${deal.linkman.customer.customerName}</td>
                                    <td>${u:getCurrStage(deal).stageName}</td>
                                    <td>${u:getTypesByCode("dealType").get(deal.dealType).dictionaryValue}</td>
                                    <td>${u:getTypesByCode("source").get(deal.dealSource).dictionaryValue}</td>
                                    <td>${deal.linkman.linkmanName}</td>
                                    <td>${u:dateFormat(deal.dealPlanTime, "yyyy-MM-dd")}</td>
                                    <td>${u:dateFormat(deal.dealActualTime, "yyyy-MM-dd")}</td>
                                    <td>${deal.creator.employeeName}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <%--翻页--%>
                <div id="pagination" style="position: relative;top: 20px;"></div>
            </div>
        </div>

        <script type="text/javascript">
            $("#pagination").bs_pagination({
                currentPage:${pageInfo.pageNum},//当前页号
                rowsPerPage: ${pageInfo.pageSize},//每页记录数
                totalPages:${pageInfo.pages},//总共页号
                totalRows: ${pageInfo.total},//总记录数
                visiblePageLinks: 5,//页码导航标签个数
                showGoToPage: true,//是否显示直接去多少页的跳转
                showRowsPerPage: true,//是否显示每页记录数
                showRowsInfo: true,//是否显示行记录信息
                onChangePage: function (event, data) {
                    let searchForm = $("#deal")[0]
                    searchForm.action = "/deal/list?page=" + data.currentPage + "&pageSize=" + data.rowsPerPage
                    searchForm.submit()
                }
            })
        </script>
    </body>
</html>