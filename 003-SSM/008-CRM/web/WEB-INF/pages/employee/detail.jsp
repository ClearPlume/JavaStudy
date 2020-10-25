<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-20 下午 3:54
--%>
<%--@elvariable id="employee" type="top.fallenangel.crm.model.entity.Employee"--%>
<%--@elvariable id="DEPTS_IN_APPLICATION" type="java.util.Map<java.lang.String, top.fallenangel.crm.model.entity.Dept>"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>员工详情</title>

        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
              rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css"
              type="text/css" rel="stylesheet"/>
        <style type="text/css">
            .required {
                font-size: 15px;
                color: red;
            }

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
    </head>
    <body>
        <div class="modal fade" id="editEmployeeModal" role="dialog">
            <div class="modal-dialog" role="document" style="width: 75%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel">修改员工</h4>
                    </div>
                    <form:form action="${pageContext.request.contextPath}/employee/update" modelAttribute="employee"
                               cssClass="form-horizontal" role="form">
                        <div class="modal-body">
                            <form:hidden path="employeeId"/>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">登录帐号<span class="required">*</span></label>
                                <div class="col-sm-10" style="width: 300px">
                                    <form:input path="employeeNo" cssClass="form-control"/>
                                </div>
                                <label class="col-sm-2 control-label">员工姓名<span class="required">*</span></label>
                                <div class="col-sm-10" style="width: 300px">
                                    <form:input path="employeeName" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">邮箱<span class="required">*</span></label>
                                <div class="col-sm-10" style="width: 300px">
                                    <form:input path="employeeMail" cssClass="form-control"/>
                                </div>
                                <label class="col-sm-2 control-label">失效时间<span class="required"
                                                                                style="opacity: 0">*</span></label>
                                <div class="col-sm-10 input-group" style="width: 270px; left: 15px">
                                    <form:input path="employeeExpireTime" cssClass="form-control"/>
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-remove"></span>
                                     </span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">锁定状态<span class="required">*</span></label>
                                <div class="col-sm-10" style="width: 300px">
                                    <form:select path="employeeStatus" cssClass="form-control">
                                        <form:option value="" label="请选择" cssStyle="color: rgb(85, 85, 85)"/>
                                        <form:option value="1" label="启用" cssStyle="color: green"/>
                                        <form:option value="0" label="禁用" cssStyle="color: red"/>
                                    </form:select>
                                </div>
                                <label class="col-sm-2 control-label">所在部门<span class="required">*</span></label>
                                <div class="col-sm-10 input-group" style="width: 270px; left: 15px">
                                    <form:select path="dept.deptId" cssClass="form-control">
                                        <form:option value="" label="请选择部门"/>
                                        <form:options items="${DEPTS_IN_APPLICATION.entrySet()}"
                                                      itemValue="value.deptId"
                                                      itemLabel="value.deptName"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">允许访问的IP<span class="required"
                                                                                   style="opacity: 0">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <form:input path="employeeAllowedIps" cssClass="form-control" cssStyle="width: 284%"
                                                placeholder="多个用逗号隔开"/>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="submit" class="btn btn-primary">更新</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>

        <div>
            <div style="position: relative; left: 30px; top: -10px;">
                <div class="page-header">
                    <h3>员工明细&nbsp;<small>${employee.employeeName}</small></h3>
                </div>
                <div style="position: relative; height: 50px; width: 250px;  top: -72px; left: 80%;">
                    <button type="button" class="btn btn-default" id="back-btn">
                        <span class="glyphicon glyphicon-arrow-left"></span>&nbsp;返回
                    </button>
                </div>
            </div>
        </div>

        <div style="position: relative; left: 60px; top: -50px;">
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade in active" id="role-info">
                    <div style="position: relative; top: 20px; left: -30px;">
                        <div style="position: relative; left: 40px; height: 30px; top: 20px;">
                            <div style="width: 300px; color: gray;">登录帐号</div>
                            <div style="width: 500px;position: relative; left: 200px; top: -20px;">
                                <b>${employee.employeeNo}</b>
                            </div>
                            <div style="height: 1px; width: 600px; background: #D5D5D5; position: relative; top: -20px;"></div>
                        </div>
                        <div style="position: relative; left: 40px; height: 30px; top: 40px;">
                            <div style="width: 300px; color: gray;">员工姓名</div>
                            <div style="width: 500px;position: relative; left: 200px; top: -20px;">
                                <b>${employee.employeeName}</b>
                            </div>
                            <div style="height: 1px; width: 600px; background: #D5D5D5; position: relative; top: -20px;"></div>
                        </div>
                        <div style="position: relative; left: 40px; height: 30px; top: 60px;">
                            <div style="width: 300px; color: gray;">邮箱</div>
                            <div style="width: 500px;position: relative; left: 200px; top: -20px;">
                                <b>${employee.employeeMail}</b>
                            </div>
                            <div style="height: 1px; width: 600px; background: #D5D5D5; position: relative; top: -20px;"></div>
                        </div>
                        <div style="position: relative; left: 40px; height: 30px; top: 80px;">
                            <div style="width: 300px; color: gray;">失效时间</div>
                            <div style="width: 500px;position: relative; left: 200px; top: -20px;">
                                <b>
                                    <fmt:formatDate value="${employee.employeeExpireTime}"
                                                    pattern="yyyy-MM-dd HH:mm:ss"/>
                                </b>
                            </div>
                            <div style="height: 1px; width: 600px; background: #D5D5D5; position: relative; top: -20px;"></div>
                        </div>
                        <div style="position: relative; left: 40px; height: 30px; top: 100px;">
                            <div style="width: 300px; color: gray;">允许访问IP</div>
                            <div style="width: 500px;position: relative; left: 200px; top: -20px;">
                                <b>${empty employee.employeeAllowedIps ? "不限制IP" : "employee.employeeAllowedIps"}</b>
                            </div>
                            <div style="height: 1px; width: 600px; background: #D5D5D5; position: relative; top: -20px;"></div>
                        </div>
                        <div style="position: relative; left: 40px; height: 30px; top: 120px;">
                            <div style="width: 300px; color: gray;">锁定状态</div>
                            <div style="width: 500px;position: relative; left: 200px; top: -20px;">
                                <c:choose>
                                    <c:when test="${employee.employeeStatus == 0}">
                                        <b style="color: red">禁用</b>
                                    </c:when>
                                    <c:otherwise>
                                        <b style="color: green">启用</b>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div style="height: 1px; width: 600px; background: #D5D5D5; position: relative; top: -20px;"></div>
                        </div>
                        <div style="position: relative; left: 40px; height: 30px; top: 140px;">
                            <div style="width: 300px; color: gray;">部门名称</div>
                            <div style="width: 500px;position: relative; left: 200px; top: -20px;">
                                <b>${DEPTS_IN_APPLICATION[employee.dept.deptId].deptName}</b>
                            </div>
                            <div style="height: 1px; width: 600px; background: #D5D5D5; position: relative; top: -20px;"></div>
                            <button style="position: relative; left: 76%; top: -40px;" type="button"
                                    class="btn btn-default" data-toggle="modal" data-target="#editEmployeeModal">
                                <span class="glyphicon glyphicon-edit"></span>&nbsp;编辑
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            let employeeStatusSelect

            $(document).ready(function () {
                employeeStatusSelect = $("#employeeStatus")
                employeeStatusSelect.change(checkStatusColor)
                employeeStatusSelect.change()
            })

            $("#back-btn").click(function () {
                location.href = "${pageContext.request.contextPath}/employee/list"
            })

            let datetimepickerSettings = {
                language: "zh-CN",
                autoclose: true,
                format: 'yyyy-mm-dd hh:ii:00',
                todayBtn: true
            }

            $("#employeeExpireTime").datetimepicker(datetimepickerSettings)

            $(".glyphicon-remove").click(function () {
                $(this).parent().prev().val("")
            })

            function checkStatusColor() {
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
                employeeStatusSelect.css("color", color)
            }
        </script>
    </body>
</html>