<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-19 上午 9:14
--%>
<%--@elvariable id="DEPTS_IN_APPLICATION" type="java.util.LinkedHashMap<java.lang.Integer, top.fallenangel.crm.model.entity.Dept>"--%>
<%--@elvariable id="deptEntry" type="java.util.Map.Entry<java.lang.Integer, top.fallenangel.crm.model.entity.Dept>"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>部门</title>
        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
              rel="stylesheet"/>

        <style type="text/css">
            a:hover {
                text-decoration: none;
            }
        </style>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.1-min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bs_alert.js"></script>
    </head>
    <body>
        <div class="modal fade" id="createDeptModal" role="dialog">
            <div class="modal-dialog" role="document" style="width: 35%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-plus"></span> 新增部门
                        </h4>
                    </div>
                    <form action="${pageContext.request.contextPath}/dept/save" class="form-horizontal" role="form"
                          method="post">
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="deptName" class="col-sm-2 control-label">名称<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="deptName" name="deptName"
                                           style="width: 150%;">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptCode" class="col-sm-2 control-label">编号<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="deptCode" name="deptCode"
                                           style="width: 150%;">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">状态<span
                                        style="font-size: 15px; color: red;">*</span>
                                </label>
                                <div class="col-sm-10" style="width: 300px">
                                    <label>
                                        <select name="deptStatus" class="form-control lock-status-select"
                                                style="width: 405px">
                                            <option value="" style="color: rgb(85, 85, 85)">请选择</option>
                                            <option value="1" style="color: green">启用</option>
                                            <option value="0" style="color: red">禁用</option>
                                        </select>
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
        </div>
        <div style="width: 95%">
            <div>
                <div style="position: relative; left: 30px; top: -10px;">
                    <div class="page-header">
                        <h3>部门列表</h3>
                    </div>
                </div>
            </div>
            <div class="btn-toolbar" role="toolbar"
                 style="background-color: #F7F7F7; height: 50px; position: relative;left: 30px; top:-30px;">
                <div class="btn-group" style="position: relative; top: 18%;">
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createDeptModal">
                        <span class="glyphicon glyphicon-plus"></span> 创建
                    </button>
                    <button id="delete-btn" type="button" class="btn btn-danger"><span
                            class="glyphicon glyphicon-minus"></span> 删除
                    </button>
                    <button type="button" class="btn btn-warning"
                            onclick="location.href='${pageContext.request.contextPath}/dept/updateCache'">
                        <span class="glyphicon glyphicon-refresh"></span> 更新缓存
                    </button>
                </div>
            </div>
            <div style="position: relative; left: 30px; top: -10px;">
                <form id="delete-form" action="${pageContext.request.contextPath}/dept/delete" method="post">
                    <table class="table table-hover">
                        <thead>
                            <tr style="color: #B3B3B3;">
                                <td>
                                    <label>
                                        <input type="checkbox"/>
                                    </label>
                                </td>
                                <td>名称</td>
                                <td>编号</td>
                                <td>状态</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${DEPTS_IN_APPLICATION.entrySet()}" var="deptEntry">
                                <tr class="active">
                                    <td>
                                        <label>
                                            <input name="id" type="checkbox" value="${deptEntry.key}"/>
                                        </label>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/dept/edit?id=${deptEntry.key}">
                                                ${deptEntry.value.deptName}
                                        </a>
                                    </td>
                                    <td>${deptEntry.value.deptCode}</td>
                                    <td>${deptEntry.value.deptStatusStr}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

        <script type="text/javascript">
            $("#delete-btn").click(function () {
                if ($("[name='id']:checked").length) {
                    bs_confirm("确认删除数据？这将无法撤回！", "警告", 25, function () {
                        $("#delete-form").submit()
                    })
                } else {
                    bs_alert("请选择要删除的部门", "提示", 25)
                }
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