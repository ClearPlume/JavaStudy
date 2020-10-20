<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-19 上午 9:14
--%>
<%--@elvariable id="deptList" type="java.util.List<top.fallenangel.crm.model.entity.Dept>"--%>
<%--@elvariable id="dept" type="top.fallenangel.crm.model.entity.Dept"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>部门</title>
        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
              rel="stylesheet"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.1-min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <!-- 创建部门的模态窗口 -->
        <div class="modal fade" id="createDeptModal" role="dialog">
            <div class="modal-dialog" role="document" style="width: 80%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-plus"></span> 新增部门
                        </h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="create-code" class="col-sm-2 control-label">编号<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="create-code" style="width: 200%;"
                                           placeholder="编号不能为空，具有唯一性">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="create-name" class="col-sm-2 control-label">名称</label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="create-name" style="width: 200%;">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="create-manager" class="col-sm-2 control-label">负责人</label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="create-manager" style="width: 200%;">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="create-phone" class="col-sm-2 control-label">电话</label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="create-phone" style="width: 200%;">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="create-describe" class="col-sm-2 control-label">描述</label>
                                <div class="col-sm-10" style="width: 55%;">
                                    <textarea class="form-control" rows="3" id="create-describe"></textarea>
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

        <!-- 修改部门的模态窗口 -->
        <div class="modal fade" id="editDeptModal" role="dialog">
            <div class="modal-dialog" role="document" style="width: 80%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-edit"></span> 编辑部门
                        </h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="create-code" class="col-sm-2 control-label">编号<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="create-code" style="width: 200%;"
                                           placeholder="不能为空，具有唯一性" value="1110">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="create-name" class="col-sm-2 control-label">名称</label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="create-name" style="width: 200%;"
                                           value="财务部">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="create-manager" class="col-sm-2 control-label">负责人</label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="create-manager" style="width: 200%;"
                                           value="张飞">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="create-phone" class="col-sm-2 control-label">电话</label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="create-phone" style="width: 200%;"
                                           value="010-84846004">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="create-describe" class="col-sm-2 control-label">描述</label>
                                <div class="col-sm-10" style="width: 55%;">
                                    <textarea class="form-control" rows="3"
                                              id="create-describe">description info</textarea>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" data-dismiss="modal">更新</button>
                    </div>
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
                    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#editDeptModal"><span
                            class="glyphicon glyphicon-edit"></span> 编辑
                    </button>
                    <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-minus"></span> 删除
                    </button>
                </div>
            </div>
            <div style="position: relative; left: 30px; top: -10px;">
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
                        <c:forEach items="${deptList}" var="dept">
                            <tr class="active">
                                <td>
                                    <label>
                                        <input type="checkbox" value="${dept.deptId}"/>
                                    </label>
                                </td>
                                <td>${dept.deptName}</td>
                                <td>${dept.deptCode}</td>
                                <td>${dept.deptStatusStr}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div style="height: 50px; position: relative;top: 0; left:30px;">
                <div>
                    <button type="button" class="btn btn-default" style="cursor: default;">共<b>50</b>条记录</button>
                </div>
                <div class="btn-group" style="position: relative;top: -34px; left: 110px;">
                    <button type="button" class="btn btn-default" style="cursor: default;">显示</button>
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            10
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">20</a></li>
                            <li><a href="#">30</a></li>
                        </ul>
                    </div>
                    <button type="button" class="btn btn-default" style="cursor: default;">条/页</button>
                </div>
                <div style="position: relative;top: -88px; left: 285px;">
                    <nav>
                        <ul class="pagination">
                            <li class="disabled"><a href="#">首页</a></li>
                            <li class="disabled"><a href="#">上一页</a></li>
                            <li><a href="#">下一页</a></li>
                            <li class="disabled"><a href="#">末页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </body>
</html>