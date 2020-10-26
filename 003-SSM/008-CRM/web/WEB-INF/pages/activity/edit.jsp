<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-24 下午 5:17
--%>
<%--@elvariable id="marketActivity" type="top.fallenangel.crm.model.entity.MarketActivity"--%>
<%--@elvariable id="activityRemarkList" type="java.util.List<top.fallenangel.crm.model.entity.ActivityRemark>"--%>
<%--@elvariable id="activityRemark" type="top.fallenangel.crm.model.entity.ActivityRemark"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="u" uri="http://fallenangel.top/util/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>编辑市场活动</title>

        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
              rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/js/jquery/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css"
              type="text/css" rel="stylesheet"/>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.1-min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bs_alert.js"></script>
    </head>
    <body>
        <%--修改备注模态框--%>
        <div class="modal fade" id="editRemarkModal" role="dialog">
            <input type="hidden" id="remarkId">
            <div class="modal-dialog" role="document" style="width: 40%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title">修改备注</h4>
                    </div>
                    <form class="form-horizontal" role="form" method="post"
                          action="${pageContext.request.contextPath}/remark/save">
                        <input type="hidden" name="remarkId" id="modifyRemarkId">
                        <input type="hidden" name="activityId" id="modifyRemarkActivityId">
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="modifyRemarkTitle" class="col-sm-2 control-label">内容</label>
                                <div class="col-sm-10" style="width: 81%;">
                                    <input class="form-control" id="modifyRemarkTitle" name="remarkTitle"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="modifyRemarkContent" class="col-sm-2 control-label">内容</label>
                                <div class="col-sm-10" style="width: 81%;">
                                    <textarea class="form-control" rows="3" id="modifyRemarkContent"
                                              name="remarkContent"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="submit" class="btn btn-primary">更新</button>
                        </div>
                    </form>
                </div>
            </div>
            <%--修改备注模态结束--%>
        </div>
        <%--修改市场活动模态框--%>
        <div class="modal fade" id="editActivityModal" role="dialog">
            <div class="modal-dialog" role="document" style="width: 85%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title">修改市场活动</h4>
                    </div>
                    <form:form class="form-horizontal" role="form" modelAttribute="marketActivity" action="save">
                        <form:hidden path="activityId"/>
                        <div class="modal-body">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">活动名称<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <label style="width: 81%;">
                                        <form:input path="activityName" cssClass="form-control"/>
                                    </label>
                                </div>
                                <label class="col-sm-2 control-label">参与对象<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <label style="width: 81%;">
                                        <form:input path="activityPerson" cssClass="form-control"/>
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">举办地点<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <label style="width: 81%;">
                                        <form:input path="activityPlace" cssClass="form-control"/>
                                    </label>
                                </div>
                                <label class="col-sm-2 control-label">活动成本<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <label style="width: 81%;">
                                        <form:input path="activityCost" cssClass="form-control"/>
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">开始日期<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <label style="width: 81%;">
                                        <input type="text" class="form-control datetime" name="activityStartTime"
                                               value="${u:dateFormat(marketActivity.activityStartTime, "yyyy-MM-dd HH:mm:ss")}">
                                    </label>
                                </div>
                                <label class="col-sm-2 control-label">结束日期<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <label style="width: 81%;">
                                        <input type="text" class="form-control datetime" name="activityEndTime"
                                               value="${u:dateFormat(marketActivity.activityEndTime, "yyyy-MM-dd HH:mm:ss")}">
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">活动内容<span
                                        style="font-size: 15px; color: red;">*</span></label>
                                <div class="col-sm-10">
                                    <label style="width: 81%;">
                                        <form:textarea path="activityContent" cssClass="form-control" rows="3"/>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="submit" class="btn btn-primary">保存</button>
                        </div>
                    </form:form>
                </div>
            </div>
            <%--修改市场活动模态框结束--%>
        </div>
        <%--返回按钮--%>
        <div style="position: relative; top: 35px; left: 10px;">
            <a href="${pageContext.request.contextPath}/activity/list"><span class="glyphicon glyphicon-arrow-left"
                                                                             style="font-size: 20px; color: #DDDDDD"></span></a>
        </div>
        <%--页面主标题--%>
        <div style="position: relative; left: 40px; top: -30px;">
            <div class="page-header">
                <h3>${marketActivity.activityName}
                    <small>${u:dateFormat(marketActivity.activityStartTime, "yyyy-MM-dd HH:mm:ss")}
                        ~ ${u:dateFormat(marketActivity.activityStartTime, "yyyy-MM-dd HH:mm:ss")}</small>
                </h3>
            </div>
            <div style="position: relative; height: 50px; width: 250px;  top: -72px; left: 700px;">
                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#editActivityModal"><span
                        class="glyphicon glyphicon-edit"></span> 编辑
                </button>
                <button onclick="deleteActivity(${marketActivity.activityId})" type="button"
                        class="btn btn-danger"><span class="glyphicon glyphicon-minus"></span> 删除
                </button>
            </div>
        </div>
        <%--页面主内容--%>
        <div style="position: relative; top: -70px; margin-bottom: 90px">
            <div style="position: relative; left: 40px; height: 30px;">
                <div style="width: 300px; color: gray;">参与对象</div>
                <div style="width: 300px;position: relative; left: 200px; top: -20px;">
                    <b>${marketActivity.activityPerson}</b></div>
                <div style="width: 300px;position: relative; left: 450px; top: -40px; color: gray;">举办地点</div>
                <div style="width: 300px;position: relative; left: 650px; top: -60px;">
                    <b>${marketActivity.activityPlace}</b></div>
                <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px;"></div>
                <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px; left: 450px;"></div>
            </div>
            <div style="position: relative; left: 40px; height: 30px; top: 10px;">
                <div style="width: 300px; color: gray;">开始日期</div>
                <div style="width: 300px;position: relative; left: 200px; top: -20px;">
                    <b>${u:dateFormat(marketActivity.activityStartTime, "yyyy-MM-dd HH:mm:ss")}</b></div>
                <div style="width: 300px;position: relative; left: 450px; top: -40px; color: gray;">结束日期</div>
                <div style="width: 300px;position: relative; left: 650px; top: -60px;">
                    <b>${u:dateFormat(marketActivity.activityStartTime, "yyyy-MM-dd HH:mm:ss")}</b></div>
                <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px;"></div>
                <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px; left: 450px;"></div>
            </div>
            <div style="position: relative; left: 40px; height: 30px; top: 20px;">
                <div style="width: 300px; color: gray;">成本</div>
                <div style="width: 300px;position: relative; left: 200px; top: -20px;"><b><fmt:formatNumber
                        value="${marketActivity.activityCost}" pattern=".00"/></b></div>
                <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -20px;"></div>
            </div>
            <div style="position: relative; left: 40px; height: 30px; top: 30px;">
                <div style="width: 300px; color: gray;">创建人</div>
                <div style="width: 500px;position: relative; left: 200px; top: -20px;">
                    <b>${marketActivity.creator.employeeName}(${marketActivity.creator.employeeNo})&nbsp;&nbsp;</b><small
                        style="font-size: 10px; color: gray;">${u:dateFormat(marketActivity.createTime, "yyyy-MM-dd HH:mm:ss")}</small>
                </div>
                <div style="height: 1px; width: 550px; background: #D5D5D5; position: relative; top: -20px;"></div>
            </div>
            <div style="position: relative; left: 40px; height: 30px; top: 40px;">
                <div style="width: 300px; color: gray;">修改人</div>
                <div style="width: 500px;position: relative; left: 200px; top: -20px;">
                    <b>${marketActivity.updater.employeeName}(${marketActivity.updater.employeeNo})&nbsp;&nbsp;</b><small
                        style="font-size: 10px; color: gray;">${u:dateFormat(marketActivity.updateTime, "yyyy-MM-dd HH:mm:ss")}</small>
                </div>
                <div style="height: 1px; width: 550px; background: #D5D5D5; position: relative; top: -20px;"></div>
            </div>
            <div style="position: relative; left: 40px; height: 30px; top: 50px;">
                <div style="width: 300px; color: gray;">内容</div>
                <div style="width: 630px;position: relative; left: 200px; top: -20px;">
                    <b>${marketActivity.activityContent}</b>
                </div>
                <div style="height: 1px; width: 850px; background: #D5D5D5; position: relative; top: -20px;"></div>
            </div>
            <%--页面主内容结束--%>
        </div>
        <%--备注模块--%>
        <div style="position: relative; left: 40px;">
            <div class="page-header">
                <h4>备注</h4>
            </div>
            <%--备注列表--%>
            <c:forEach items="${activityRemarkList}" var="activityRemark">
                <div class="remarkDiv" id="remarkDiv${activityRemark.remarkId}" style="height: 60px;">
                    <div style="position: relative; left: 40px;">
                        <h5>${activityRemark.remarkContent}</h5>
                        <span style="color: gray">${marketActivity.activityName} - <b
                                style="color: black">${activityRemark.remarkTitle}</b> <small>${u:dateFormat(activityRemark.updateTime, "yyyy-MM-dd HH:mm:ss")} 由 ${activityRemark.updater.employeeName}(${activityRemark.updater.employeeNo})</small></span>
                        <div style="position: relative; left: 750px; top: -30px; height: 30px; width: 100px; display: none;">
                            <a class="remarkBtn" href="javascript:void(0)"
                               onclick="editRemark(${activityRemark.remarkId})"><span
                                    class="glyphicon glyphicon-edit"
                                    style="font-size: 20px; color: #E6E6E6;"></span></a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a class="remarkBtn" onclick="deleteRemark(${activityRemark.remarkId})"
                               href="javascript:void(0)"><span
                                    class="glyphicon glyphicon-remove"
                                    style="font-size: 20px; color: #E6E6E6;"></span></a>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <%--新增备注--%>
            <div id="insertRemarkDiv"
                 style="background-color: #E6E6E6; width: 870px; height: 130px; position: relative; top: 10px">
                <form role="form" style="position: relative;top: 5px; left: 10px;" method="post"
                      action="${pageContext.request.contextPath}/remark/save">
                    <input type="hidden" name="activityId" value="${marketActivity.activityId}"/>
                    <label for="insertRemarkTitle"></label>
                    <input id="insertRemarkTitle" type="text" class="form-control" style="width: 850px; resize: none"
                           placeholder="备注标题" name="remarkTitle">
                    <label for="insertRemarkContent"></label>
                    <textarea id="insertRemarkContent" class="form-control" style="width: 850px; resize : none;"
                              rows="2" name="remarkContent"
                              placeholder="添加备注..."></textarea>
                    <div id="cancelAndSaveBtn" style="position: relative;left: 737px; top: 10px; display: none;">
                        <button class="btn btn-default" id="cancelBtn" type="button">取消</button>
                        <button class="btn btn-primary" type="submit">保存</button>
                    </div>
                </form>
            </div>
        </div>
        <div style="height: 200px;"></div>

        <script type="text/javascript">
            let datetimepickerSettings = {
                language: "zh-CN",
                autoclose: true,
                format: 'yyyy-mm-dd hh:ii:00',
                todayBtn: true
            }

            $(".datetime").datetimepicker(datetimepickerSettings)

            let cancelAndSaveBtnDefault = true

            $(function () {
                let insertRemarkContent = $("#insertRemarkContent");

                insertRemarkContent.focus(function () {
                    if (cancelAndSaveBtnDefault) {
                        $("#cancelAndSaveBtn").show(500)
                        $("#insertRemarkDiv").animate({height: 175}, 500)
                        cancelAndSaveBtnDefault = false
                    }
                })

                insertRemarkContent.blur(function () {
                    if (this.value === "") {
                        hideCancelAndSaveBtn()
                    }
                })

                $("#cancelBtn").click(hideCancelAndSaveBtn)

                let remarkDiv = $(".remarkDiv")

                remarkDiv.mouseover(function () {
                    $(this).children("div").children("div").show()
                })

                remarkDiv.mouseout(function () {
                    $(this).children("div").children("div").hide()
                })

                let remarkBtn = $(".remarkBtn")

                remarkBtn.mouseover(function () {
                    $(this).children("span").css("color", "red")
                })

                remarkBtn.mouseout(function () {
                    $(this).children("span").css("color", "#E6E6E6")
                })
            })

            function hideCancelAndSaveBtn() {
                $("#cancelAndSaveBtn").hide(500)
                $("#insertRemarkDiv").animate({height: 130}, 500)
                cancelAndSaveBtnDefault = true
            }

            function editRemark(remarkId) {
                $.getJSON(
                    "${pageContext.request.contextPath}/remark/edit",
                    {"id": remarkId},
                    function (data) {
                        $("#modifyRemarkId").val(data.remarkId)
                        $("#modifyRemarkActivityId").val(data.activityId)
                        $("#modifyRemarkTitle").val(data.remarkTitle)
                        $("#modifyRemarkContent").val(data.remarkContent)
                        $("#editRemarkModal").modal("show")
                    })
            }

            function deleteRemark(remarkId) {
                $.getJSON(
                    "${pageContext.request.contextPath}/remark/delete",
                    {"id": remarkId},
                    function (data) {
                        if (data.success) {
                            $("#remarkDiv" + remarkId).remove()
                        }
                    }
                )
            }

            function deleteActivity(activityId) {
                bs_confirm("确认删除数据？这将无法撤回！", "警告", 25, function () {
                    location.href = "${pageContext.request.contextPath}/activity/delete?id=" + activityId
                })
            }
        </script>
    </body>
</html>