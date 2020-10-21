<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-19 上午 9:24
--%>
<%--@elvariable id="pageInfo" type="com.github.pagehelper.PageInfo<top.fallenangel.crm.model.entity.Employee>"--%>
<%--@elvariable id="employee" type="top.fallenangel.crm.model.entity.Employee"--%>
<%--@elvariable id="DEPTS_IN_APPLICATION" type="java.util.Map<java.lang.String, top.fallenangel.crm.model.entity.Dept>"--%>
<%--@elvariable id="deptEntry" type="java.util.Map.Entry<java.lang.String, top.fallenangel.crm.model.entity.Dept>"--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="u" uri="http://fallenangel.top/util/functions" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>员工</title>
        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
              rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/js/jquery/bs_pagination/jquery.bs_pagination.min.css"
              type="text/css"
              rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css"
              type="text/css" rel="stylesheet"/>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.1-min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bs_pagination/zh-CN.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bs_pagination/jquery.bs_pagination.min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>

        <style type="text/css">
            .glyphicon-remove {
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <!-- 创建用户的模态窗口 -->
        <div class="modal fade" id="createUserModal" role="dialog">
            <div class="modal-dialog" role="document" style="width: 90%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel">新增用户</h4>
                    </div>
                    <div class="modal-body">

                        <form class="form-horizontal" role="form">

                            <div class="form-group">
                                <label for="create-loginActNo" class="col-sm-2 control-label">登录帐号<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="create-loginActNo">
                                </div>
                                <label for="create-username" class="col-sm-2 control-label">用户姓名</label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="create-username">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="create-loginPwd" class="col-sm-2 control-label">登录密码<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="password" class="form-control" id="create-loginPwd">
                                </div>
                                <label for="create-confirmPwd" class="col-sm-2 control-label">确认密码<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="password" class="form-control" id="create-confirmPwd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="create-email" class="col-sm-2 control-label">邮箱</label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="create-email">
                                </div>
                                <label for="create-expireTime" class="col-sm-2 control-label">失效时间</label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="create-expireTime">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="create-lockStatus" class="col-sm-2 control-label">锁定状态</label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <select class="form-control" id="create-lockStatus">
                                        <option></option>
                                        <option>启用</option>
                                        <option>锁定</option>
                                    </select>
                                </div>
                                <label for="create-dept" class="col-sm-2 control-label">部门</label>
                                <span style="font-size: 15px; color: red;">*</span>
                                <div class="col-sm-10" style="width: 300px;">
                                    <select class="form-control" id="create-dept">
                                        <option></option>
                                        <option>市场部</option>
                                        <option>策划部</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="create-allowIps" class="col-sm-2 control-label">允许访问的IP</label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="create-allowIps" style="width: 280%"
                                           placeholder="多个用逗号隔开">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" data-dismiss="modal">保存</button>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <div style="position: relative; left: 30px; top: -10px;">
                <div class="page-header">
                    <h3>用户列表</h3>
                </div>
            </div>
        </div>
        <div class="btn-toolbar" role="toolbar" style="position: relative; height: 80px; left: 30px; top: -10px;">
            <form:form modelAttribute="employee" cssClass="form-inline" role="form"
                       action="${pageContext.request.contextPath}/employee/list">
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">员工姓名</div>
                        <form:input path="employeeName" cssClass="form-control"/>
                    </div>
                </div>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">部门名称</div>
                        <form:select path="deptId" cssClass="form-control" cssStyle="width: 170px">
                            <form:option value="" label="请选择部门"/>
                            <form:options items="${DEPTS_IN_APPLICATION.entrySet()}" itemValue="value.deptId"
                                          itemLabel="value.deptName"/>
                        </form:select>
                    </div>
                </div>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">锁定状态</div>
                        <form:select path="employeeStatus" cssClass="form-control lock-status-select"
                                     cssStyle="width: 170px">
                            <form:option value="" label="请选择" cssStyle="color: rgb(85, 85, 85)"/>
                            <form:option value="1" label="启用" cssStyle="color: green"/>
                            <form:option value="0" label="禁用" cssStyle="color: red"/>
                        </form:select>
                    </div>
                </div>
                <br/>
                <br/>
                <div class="form-group">
                    <div class="input-group" style="width: 251px;">
                        <div class="input-group-addon">失效时间</div>
                        <label for="startTime"></label>
                        <input class="form-control" type="text" id="startTime" name="startTime"
                               value="${u:dateFormat(employee.startTime, "yyyy-MM-dd HH:mm:ss")}"/>
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-remove"></span>
                        </span>
                    </div>
                </div>
                &nbsp;~&nbsp;
                <div class="form-group">
                    <div class="input-group" style="width: 170px">
                        <label for="endTime"></label>
                        <input class="form-control" type="text" id="endTime" name="endTime"
                               value="${u:dateFormat(employee.endTime, "yyyy-MM-dd HH:mm:ss")}"/>
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-remove"></span>
                        </span>
                    </div>
                </div>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <button type="submit" class="btn btn-default">查询</button>
            </form:form>
        </div>

        <div class="btn-toolbar" role="toolbar"
             style="background-color: #F7F7F7; height: 50px; position: relative;left: 30px; width: 110%; top: 20px;">
            <div class="btn-group" style="position: relative; top: 18%;">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addEmployeeModal">
                    <span class="glyphicon glyphicon-plus"></span>&nbsp;创建
                </button>
                <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-minus"></span>&nbsp;删除
                </button>
            </div>
        </div>

        <div style="position: relative; left: 30px; top: 40px; width: 110%">
            <table class="table table-hover">
                <thead>
                    <tr style="color: #B3B3B3;">
                        <td>
                            <label>
                                <input type="checkbox"/>
                            </label>
                        </td>
                        <td>序号</td>
                        <td>登录帐号</td>
                        <td>用户姓名</td>
                        <td>部门名称</td>
                        <td>邮箱</td>
                        <td>失效时间</td>
                        <td>允许访问IP</td>
                        <td>锁定状态</td>
                        <td>创建者</td>
                        <td>创建时间</td>
                        <td>修改者</td>
                        <td>修改时间</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pageInfo.list}" var="employee" varStatus="vs">
                        <tr class="active">
                            <td><label>
                                <input type="checkbox"/>
                            </label></td>
                            <td>${vs.count}</td>
                            <td><a href="../settings/qx/user/detail.html">${employee.employeeNo}</a></td>
                            <td>${employee.employeeName}</td>
                            <td>${DEPTS_IN_APPLICATION[employee.deptId].deptName}</td>
                            <td>${employee.employeeMail}</td>
                            <td><fmt:formatDate value="${employee.employeeExpireTime}"
                                                pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>${employee.employeeAllowedIps}</td>
                            <td>${employee.employeeStatus == 0 ? "<span style='color: red'>禁用</span>" : "<span style='color: green'>启用</span>"}</td>
                            <td>${employee.creator}</td>
                            <td><fmt:formatDate value="${employee.createTime}"
                                                pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>${employee.updater}</td>
                            <td><fmt:formatDate value="${employee.updateTime}"
                                                pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div id="pagination" style="position: relative;top: 30px; left: 30px;"></div>

        <script>
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
                    let searchForm = $("#employee")[0]
                    searchForm.action = searchForm.action + "?page=" + data.currentPage + "&pageSize=" + data.rowsPerPage
                    searchForm.submit()
                }
            });

            let datetimepickerSettings = {
                language: "zh-CN",
                autoclose: true,
                format: 'yyyy-mm-dd hh:ii:00',
                todayBtn: true
            }

            $("#startTime").datetimepicker(datetimepickerSettings)

            $("#endTime").datetimepicker(datetimepickerSettings)

            $(".glyphicon-remove").click(function () {
                $(this).parent().prev().val("")
            })

            $(".lock-status-select").change(function () {
                let color

                switch (this.value) {
                    case "0":
                        color = "red"
                        break
                    case "1":
                        color = "green"
                        break
                    default:
                        color = "rgb(85, 85, 85)"
                }
                $(this).css("color", color)
            })
        </script>
    </body>
</html>