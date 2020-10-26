<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-24 下午 5:00
--%>
<%--@elvariable id="pageInfo" type="com.github.pagehelper.PageInfo<top.fallenangel.crm.model.entity.MarketActivity>"--%>
<%--@elvariable id="marketActivity" type="top.fallenangel.crm.model.entity.MarketActivity"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" uri="http://fallenangel.top/util/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>市场活动列表</title>

        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
              rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css"
              type="text/css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/js/jquery/bs_pagination/jquery.bs_pagination.min.css"
              type="text/css" rel="stylesheet"/>

        <style type="text/css">
            .glyphicon-remove {
                cursor: pointer;
            }
        </style>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.1-min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bs_alert.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bs_pagination/zh-CN.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bs_pagination/jquery.bs_pagination.min.js"></script>
    </head>
    <body>
        <%--创建市场活动的模态窗口--%>
        <div class="modal fade" id="createActivityModal" role="dialog">
            <div class="modal-dialog" role="document" style="width: 70%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel1">创建市场活动</h4>
                    </div>
                    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/activity/save"
                          method="post">
                        <div class="modal-body">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">活动名称<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <label style="width: 81%;">
                                        <input type="text" class="form-control" name="activityName">
                                    </label>
                                </div>
                                <label class="col-sm-2 control-label">参与对象<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <label style="width: 81%;">
                                        <input type="text" class="form-control" name="activityPerson">
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">举办地点<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <label style="width: 81%;">
                                        <input type="text" class="form-control" name="activityPlace">
                                    </label>
                                </div>
                                <label class="col-sm-2 control-label">活动成本<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <label style="width: 81%;">
                                        <input type="text" class="form-control" name="activityCost">
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">开始日期<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <label style="width: 81%;">
                                        <input type="text" class="form-control datetime" name="activityStartTime">
                                    </label>
                                </div>
                                <label class="col-sm-2 control-label">结束日期<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <label style="width: 81%;">
                                        <input type="text" class="form-control datetime" name="activityEndTime">
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">活动内容<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10">
                                    <label style="width: 81%;">
                                        <textarea class="form-control" rows="3" name="activityContent"></textarea>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="submit" class="btn btn-primary">保存</button>
                        </div>
                    </form>
                </div>
            </div>
            <%--创建市场的模态框结束--%>
        </div>
        <div>
            <div style="position: relative; left: 10px; top: -10px;">
                <div class="page-header">
                    <h3>市场活动列表</h3>
                </div>
            </div>
        </div>
        <div style="position: relative; top: -20px; left: 0; width: 100%; height: 100%;">
            <div style="width: 100%; position: absolute;top: 5px; left: 10px;">
                <%--搜索市场条件--%>
                <form:form modelAttribute="marketActivity" role="form"
                           action="list?page=${pageInfo.pageNum}&pageSize=${pageInfo.pageSize}" cssClass="form-inline"
                           cssStyle="position: relative; top: 8%; left: 5px;">
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">名称</div>
                            <form:input path="activityName" cssClass="form-control"/>
                        </div>
                    </div>
                    &nbsp;&nbsp;
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">举办地点</div>
                            <form:input path="activityPlace" cssClass="form-control"/>
                        </div>
                    </div>
                    &nbsp;&nbsp;
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">参与对象</div>
                            <form:input path="activityPerson" cssClass="form-control"/>
                        </div>
                    </div>
                    &nbsp;&nbsp;
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">开始时间</div>
                            <label for="c"></label>
                            <input class="form-control datetime" type="text" id="c" name="activityStartTime"
                                   value="${u:dateFormat(marketActivity.activityStartTime, "yyyy-MM-dd HH:mm:ss")}"/>
                            <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-remove"></span>
                             </span>
                        </div>
                    </div>
                    &nbsp;&nbsp;
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">结束时间</div>
                            <label for="d"></label>
                            <input class="form-control datetime" type="text" id="d" name="activityEndTime"
                                   value="${u:dateFormat(marketActivity.activityEndTime, "yyyy-MM-dd HH:mm:ss")}">
                            <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-remove"></span>
                            </span>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-default">查询</button>
                </form:form>
                <div class="btn-toolbar" role="toolbar"
                     style="background-color: #F7F7F7; height: 50px; position: relative;top: 5px;">
                    <div class="btn-group" style="position: relative; top: 18%;">
                        <button type="button" class="btn btn-primary" data-toggle="modal"
                                data-target="#createActivityModal"><span class="glyphicon glyphicon-plus"></span> 创建
                        </button>
                    </div>
                </div>
                <%--市场活动列表--%>
                <div style="position: relative;top: 10px;">
                    <table class="table table-hover">
                        <thead>
                            <tr style="color: #B3B3B3;">
                                <td><label>
                                    <input type="checkbox"/>
                                </label></td>
                                <td>名称</td>
                                <td>举办地点</td>
                                <td>参与对象</td>
                                <td>创建人</td>
                                <td>开始日期</td>
                                <td>结束日期</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${pageInfo.list}" var="marketActivity">
                                <tr class="active">
                                    <td>
                                        <label>
                                            <input name="id" type="checkbox" value="${marketActivity.activityId}"/>
                                        </label>
                                    </td>
                                    <td>
                                        <a style="text-decoration: none; cursor: pointer;"
                                           onclick="location.href='${pageContext.request.contextPath}/activity/edit?id=${marketActivity.activityId}'">
                                                ${marketActivity.activityName}
                                        </a>
                                    </td>
                                    <td>${marketActivity.activityPlace}</td>
                                    <td>${marketActivity.activityPerson}</td>
                                    <td>${marketActivity.creator.employeeName}(${marketActivity.creator.employeeNo})</td>
                                    <td>${u:dateFormat(marketActivity.activityStartTime, "yyyy-MM-dd HH:mm:ss")}</td>
                                    <td>${u:dateFormat(marketActivity.activityEndTime, "yyyy-MM-dd HH:mm:ss")}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div id="pagination" style="position: relative;top: 30px;"></div>
            </div>
        </div>

        <script type="text/javascript">
            let datetimepickerSettings = {
                language: "zh-CN",
                autoclose: true,
                format: 'yyyy-mm-dd hh:ii:00',
                todayBtn: true
            }

            $(".datetime").datetimepicker(datetimepickerSettings)

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
                    let searchForm = $("#marketActivity")[0]
                    searchForm.action = "/activity/list?page=" + data.currentPage + "&pageSize=" + data.rowsPerPage
                    searchForm.submit()
                }
            })

            $(".glyphicon-remove").click(function () {
                $(this).parent().prev().val("")
            })
        </script>
    </body>
</html>