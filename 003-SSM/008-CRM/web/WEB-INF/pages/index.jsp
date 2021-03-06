<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-17 下午 7:50
--%>
<%--@elvariable id="LOGIN_EMPLOYEE" type="top.fallenangel.crm.model.entity.Employee"--%>
<%--@elvariable id="DEPTS_IN_APPLICATION" type="java.util.Map<java.lang.String, top.fallenangel.crm.model.entity.Dept>"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>欢迎</title>
        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/css/bootstrap.min.css"
              type="text/css" rel="stylesheet"/>
        <style type="text/css">
            .required {
                font-size: 15px;
                color: red;
            }
        </style>

        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.1-min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/bs_alert.js"></script>

        <script type="text/javascript">
            //页面加载完毕
            $(function () {
                //导航中所有文本颜色为黑色
                $(".liClass > a").css("color", "black");

                //默认选中导航菜单中的第一个菜单项
                $(".liClass:first").addClass("active");

                //第一个菜单项的文字变成白色
                $(".liClass:first > a").css("color", "white");

                //给所有的菜单项注册鼠标单击事件
                $(".liClass").click(function () {
                    //移除所有菜单项的激活状态
                    $(".liClass").removeClass("active");
                    //导航中所有文本颜色为黑色
                    $(".liClass > a").css("color", "black");
                    //当前项目被选中
                    $(this).addClass("active");
                    //当前项目颜色变成白色
                    $(this).children("a").css("color", "white");
                });

                window.open("${pageContext.request.contextPath}/home", "workareaFrame");
            });
        </script>
    </head>
    <body>
        <!-- 我的资料 -->
        <div class="modal fade" id="myInformation" role="dialog">
            <div class="modal-dialog" role="document" style="width: 30%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title">我的资料</h4>
                    </div>
                    <div class="modal-body">
                        <div style="position: relative; left: 40px;">
                            姓名：<b>${LOGIN_EMPLOYEE.employeeName}</b><br><br>
                            登录帐号：<b>${LOGIN_EMPLOYEE.employeeNo}</b><br><br>
                            组织机构：<b>${DEPTS_IN_APPLICATION[LOGIN_EMPLOYEE.dept.deptId].deptName}</b><br><br>
                            邮箱：<b>${LOGIN_EMPLOYEE.employeeMail}</b><br><br>
                            失效时间：<b><fmt:formatDate value="${LOGIN_EMPLOYEE.employeeExpireTime}"
                                                    pattern="yyyy-MM-dd HH:mm:ss"/></b><br><br>
                            允许访问IP：<b>${LOGIN_EMPLOYEE.employeeAllowedIps}</b>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- 修改密码的模态窗口 -->
        <div class="modal fade" id="editPwd" role="dialog">
            <div class="modal-dialog" role="document" style="width: 40%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title">修改密码</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="oldPwd" class="col-sm-2 control-label">原密码<span
                                        class="required">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="password" class="form-control" id="oldPwd" style="width: 200%;">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="newPwd" class="col-sm-2 control-label">新密码<span
                                        class="required">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="password" class="form-control" id="newPwd" style="width: 200%;">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="confirmPwd" class="col-sm-2 control-label">确认密码<span
                                        class="required">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="password" class="form-control" id="confirmPwd" style="width: 200%;">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" id="update-pwd-btn">更新</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- 退出系统的模态窗口 -->
        <div class="modal fade" id="logout" role="dialog">
            <div class="modal-dialog" role="document" style="width: 30%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title">离开</h4>
                    </div>
                    <div class="modal-body">
                        <p>您确定要退出系统吗？</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" data-dismiss="modal"
                                onclick="location.href = '${pageContext.request.contextPath}/logout'">确定
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <!-- 顶部 -->
        <div id="top" style="height: 50px; background-color: #3C3C3C; width: 100%;">
            <div style="position: absolute; top: 5px; left: 0; font-size: 30px; font-weight: 400; color: white; font-family: 'times new roman', serif">
                CRM &nbsp;<span style="font-size: 12px;">&copy;2017&nbsp;动力节点</span>
            </div>
            <div style="position: absolute; top: 15px; right: 15px;">
                <ul>
                    <li class="dropdown user-dropdown">
                        <a id="information-dropdown-a" href="javascript:void(0)"
                           style="text-decoration: none; color: white;"
                           class="dropdown-toggle" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-user"></span>&nbsp;${LOGIN_EMPLOYEE.employeeName}(${LOGIN_EMPLOYEE.employeeNo})&nbsp;<span
                                class="caret"></span>
                        </a>
                        <ul id="information-dropdown-menu" class="dropdown-menu dropdown-menu-right">
                            <li><a href="javascript:void(0)" data-toggle="modal" data-target="#myInformation"><span
                                    class="glyphicon glyphicon-file"></span>&nbsp;我的资料</a></li>
                            <li><a href="javascript:void(0)" data-toggle="modal" data-target="#editPwd"><span
                                    class="glyphicon glyphicon-edit"></span>&nbsp;修改密码</a></li>
                            <li><a href="javascript:void(0)" data-toggle="modal" data-target="#logout"><span
                                    class="glyphicon glyphicon-off"></span>&nbsp;退出</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>

        <!-- 中间 -->
        <div id="center" style="position: absolute;top: 50px; bottom: 30px; left: 0; right: 0;">
            <!-- 导航 -->
            <div id="navigation" style="left: 0; width: 18%; position: relative; height: 100%; overflow:auto;">
                <ul id="no1" class="nav nav-pills nav-stacked">
                    <li class="liClass"><a href="${pageContext.request.contextPath}/home"
                                           target="workareaFrame"><span
                            class="glyphicon glyphicon-home"></span> 工作台</a></li>
                    <li class="liClass"><a href="${pageContext.request.contextPath}/dept/list"
                                           target="workareaFrame"><span
                            class="glyphicon glyphicon-align-right"></span> 部门</a></li>
                    <li class="liClass"><a href="${pageContext.request.contextPath}/employee/list"
                                           target="workareaFrame"><span
                            class="glyphicon glyphicon-user"></span> 员工</a></li>
                    <li class="liClass"><a href="${pageContext.request.contextPath}/dictionaryType/list"
                                           target="workareaFrame"><span
                            class="glyphicon glyphicon-book"></span> 数据字典</a></li>
                    <li class="liClass"><a href="${pageContext.request.contextPath}/activity/list"
                                           target="workareaFrame"><span
                            class="glyphicon glyphicon-play-circle"></span> 市场活动</a></li>
                    <li class="liClass"><a href="${pageContext.request.contextPath}/deal/list"
                                           target="workareaFrame"><span class="glyphicon glyphicon-usd"></span>
                        交易（商机）</a></li>
                    <li class="liClass">
                        <a href="#no2" class="collapsed" data-toggle="collapse"><span
                                class="glyphicon glyphicon-stats"></span> 统计图表</a>
                        <ul id="no2" class="nav nav-pills nav-stacked collapse">
                            <li class="liClass"><a href="${pageContext.request.contextPath}/echarts/activity"
                                                   target="workareaFrame">&nbsp;&nbsp;&nbsp;
                                <span class="glyphicon glyphicon-chevron-right"></span> 市场活动统计图表</a></li>
                            <li class="liClass"><a href="${pageContext.request.contextPath}/echarts/deal"
                                                   target="workareaFrame">&nbsp;&nbsp;&nbsp;
                                <span class="glyphicon glyphicon-chevron-right"></span> 交易统计图表</a></li>
                        </ul>
                    </li>
                </ul>
                <!-- 分割线 -->
                <div id="divider1"
                     style="position: absolute; top : 0; right: 0; width: 1px; height: 100% ; background-color: #B3B3B3;"></div>
            </div>
            <!-- 工作区 -->
            <div id="workarea" style="position: absolute; top : 0; left: 18%; width: 82%; height: 100%;">
                <iframe style="border-width: 0; width: 100%; height: 100%;" name="workareaFrame"></iframe>
            </div>
        </div>
        <div id="divider2"
             style="height: 1px; width: 100%; position: absolute;bottom: 30px; background-color: #B3B3B3;"></div>
        <!-- 底部 -->
        <div id="down" style="height: 30px; width: 100%; position: absolute;bottom: 0;"></div>

        <script type="text/javascript">
            let hoveredElement

            $(document).mouseover(event, function (event) {
                hoveredElement = event.target
            })

            $("#information-dropdown-a").blur(function () {
                let informationMenu = $("#information-dropdown-menu")

                if ($(hoveredElement).parents("ul[id='information-dropdown-menu']")[0] !== informationMenu[0]) {
                    informationMenu.parent().removeClass("open")
                }
            })

            $("#update-pwd-btn").click(function () {
                let editPwd = $("#editPwd")
                let oldPwd = $("#oldPwd")
                let newPwd = $("#newPwd")
                let confirmPwd = $("#confirmPwd")
                $.post(
                    "${pageContext.request.contextPath}/employee/modifyPwd",
                    {
                        oldPwd: oldPwd.val(),
                        newPwd: newPwd.val()
                    },
                    function (data) {
                        oldPwd.val("")
                        newPwd.val("")
                        confirmPwd.val("")
                        if (data.success) {
                            bs_alert("密码修改成功！", "提示", 15)
                            editPwd.modal("hide")
                        } else {
                            bs_alert(data.msg, "提示", 20)
                        }
                    }, "json"
                )
            })
        </script>
    </body>
</html>