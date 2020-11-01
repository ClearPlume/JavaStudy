<%--
  Created by IntelliJ IDEA.
  User: FallenAngel
  Time: 2020-10-27 下午 5:36
--%>
<%--@elvariable id="deal" type="top.fallenangel.crm.model.entity.Deal"--%>
<%--@elvariable id="dictionaryEntry" type="java.util.Map.Entry<java.lang.Integer, top.fallenangel.crm.model.entity.Dictionary>"--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" uri="http://fallenangel.top/util/functions" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>编辑交易</title>

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
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/deal_stage.js"></script>
        <script type="text/javascript"
                src="${pageContext.request.contextPath}/js/jquery/bs_typeahead/bootstrap3-typeahead.min.js"></script>
    </head>
    <body>
        <%--查找线索--%>
        <div class="modal fade" id="findClue" role="dialog">
            <div class="modal-dialog" role="document" style="width: 60%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title">查找线索</h4>
                    </div>
                    <div class="modal-body">
                        <div class="btn-group" style="position: relative; top: 18%; left: 8px;">
                            <form class="form-inline" role="form">
                                <div class="form-group has-feedback">
                                    <label for="clueTitleSearchInput"></label>
                                    <input id="clueTitleSearchInput" type="text" class="form-control"
                                           style="width: 300px;"
                                           placeholder="请输入线索名称，支持模糊查询">
                                </div>
                            </form>
                        </div>
                        <table class="table table-hover" style="width: 900px; position: relative;top: 10px;">
                            <thead>
                                <tr style="color: #B3B3B3;">
                                    <td></td>
                                    <td>名称</td>
                                    <td>市场活动</td>
                                    <td>意向人</td>
                                    <td>提供人</td>
                                    <td>日期</td>
                                </tr>
                            </thead>
                            <tbody id="clueTableBody"></tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <%--添加/修改交易表单--%>
        <form:form action="save" modelAttribute="deal" cssClass="form-horizontal" role="form">
            <div style="position:  relative; left: 30px;">
                <h3 style="position: relative; top: 10px">
                    <c:choose>
                        <c:when test="${empty deal.dealId}">
                            创建交易
                        </c:when>
                        <c:otherwise>
                            修改交易【${deal.dealNo}】
                        </c:otherwise>
                    </c:choose>
                </h3>
                <div style="position: relative; top: -30px; left: 70%;">
                    <button type="submit" class="btn btn-primary">保存</button>
                    <a href="${pageContext.request.contextPath}/deal/list" class="btn btn-default">取消</a>
                </div>
                <hr style="position: relative; top: -15px; margin-bottom: 30px">
                <div class="form-group">
                    <form:hidden path="dealId"/>
                    <form:label class="col-sm-2 control-label"
                                path="dealName">名称<span style="font-size: 15px; color: red">*</span>
                    </form:label>
                    <div class="col-sm-10" style="width: 300px">
                        <form:input path="dealName" cssClass="form-control"/>
                    </div>
                    <form:label class="col-sm-2 control-label"
                                path="dealAmount">金额<span style="font-size: 15px; color: red">*</span>
                    </form:label>
                    <div class="col-sm-10" style="width: 300px">
                        <form:input path="dealAmount" cssClass="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="customerName">客户名称<span
                            style="font-size: 15px; color:red">*</span>
                    </label>
                    <div class="col-sm-10" style="width: 300px">
                        <form:hidden path="linkman.customer.customerId"/>
                        <form:input path="linkman.customer.customerName" id="customerName" cssClass="form-control"
                                    autocomplete="off"/>
                    </div>
                    <label class="col-sm-2 control-label" for="linkmanIdSelect">联系人<span
                            style="font-size: 15px; color:red">*</span>
                    </label>
                    <div class="col-sm-10" style="width: 300px">
                        <select id="linkmanIdSelect" class="form-control">
                            <option value="">请选择联系人</option>
                        </select>
                        <input type="hidden" id="linkmanId" name="linkman.linkmanId" value="${deal.linkman.linkmanId}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="dealPlanTime">预计成交日期<span
                            style="font-size: 15px; color:red">*</span>
                    </label>
                    <div class="col-sm-10" style="width: 300px">
                        <fmt:formatDate value="${deal.dealPlanTime}" pattern="yyyy-MM-dd HH:mm:ss" var="dealPlanTime"/>
                        <input id="dealPlanTime" name="dealPlanTime" class="form-control datetime" type="text"
                               value="${dealPlanTime}"/>
                    </div>
                    <label class="col-sm-2 control-label" for="dealActualTime">实际成交日期<span
                            style="font-size: 15px; color:red">*</span>
                    </label>
                    <div class="col-sm-10" style="width: 300px">
                        <fmt:formatDate value="${deal.dealActualTime}" pattern="yyyy-MM-dd HH:mm:ss"
                                        var="dealActualTime"/>
                        <input id="dealActualTime" name="dealActualTime" class="form-control datetime" type="text"
                               value="${dealActualTime}"/>
                    </div>
                </div>
                <hr style="width:80%"/>
                    <%--交易阶段开始--%>
                <div id="dealStageDiv"></div>
                <hr style="width:80%"/>
                <div class="form-group">
                    <label class="col-sm-2 control-label">交易类型<span
                            style="font-size: 15px; color:red">*</span>
                    </label>
                    <div class="col-sm-10" style="width: 300px">
                        <form:select path="dealType" cssClass="form-control">
                            <form:option value="" label="请选择类型"/>
                            <form:options items="${u:getTypesByCode('dealType')}" itemLabel="dictionaryValue"/>
                        </form:select>
                    </div>
                    <label class="col-sm-2 control-label">交易方式<span
                            style="font-size: 15px; color:red">*</span>
                    </label>
                    <div class="col-sm-10" style="width: 300px">
                        <form:select path="dealWay" cssClass="form-control">
                            <form:option value="" label="请选择来源"/>
                            <form:options items="${u:getTypesByCode('dealWay')}" itemLabel="dictionaryValue"/>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">交易来源<span
                            style="font-size: 15px; color:red">*</span>
                    </label>
                    <div class="col-sm-10" style="width: 300px">
                        <form:select path="dealSource" cssClass="form-control">
                            <form:option value="" label="请选择来源"/>
                            <form:options items="${u:getTypesByCode('source')}" itemLabel="dictionaryValue"/>
                        </form:select>
                    </div>
                    <label for="clue.clueTitle" class="col-sm-2 control-label">线索源<span
                            style="font-size: 15px; color:red">*</span>
                    </label>
                    <div class="col-sm-10" style="width: 300px;">
                        <form:input id="clueTitle" path="clue.clueTitle" cssClass="form-control" autocomplete="off"/>
                        <form:hidden id="clueId" path="clue.clueId"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="dealContent" class="col-sm-2 control-label">交易内容</label>
                    <div class="col-sm-10" style="width: 54.5%;">
                        <form:textarea path="dealContent" cssClass="form-control"/>
                    </div>
                </div>
            </div>
        </form:form>

        <script type="text/javascript">
            let dealStageDiv = $("#dealStageDiv")
            let linkmanIdSelect = $("#linkmanIdSelect")

            $(document).ready(function () {
                <c:choose>
                <c:when test="${empty deal.dealId}">
                dealStageDiv.append(newStage())
                resetStageOrder()
                </c:when>
                <c:otherwise>
                let stageJSON = JSON.parse(`${u:parseJSON(deal.dealStages)}`)
                for (let stageIndex = 0; stageIndex < stageJSON.length; stageIndex++) {
                    dealStageDiv.append(newStage())
                    $("#stageName" + (stageIndex + 1)).val(stageJSON[stageIndex].stageName)
                    $("#stageAmount" + (stageIndex + 1)).val(stageJSON[stageIndex].stageAmount)
                    $("#stagePlanTime" + (stageIndex + 1)).val(stageJSON[stageIndex].stagePlanTime)
                    $("#stageCurrent" + (stageIndex + 1)).prop("checked", stageJSON[stageIndex].stageCurrent)
                }
                </c:otherwise>
                </c:choose>
                resetStageOrder()
                initialDatetimeInput()

                dealStageDiv.on("click", ".addStageBtn", function () {
                    $(this).parents(".stageDiv").after(newStage())
                    resetStageOrder()
                    initialDatetimeInput()
                })

                dealStageDiv.on("click", ".delStageBtn", function () {
                    $(this).parents(".stageDiv").remove()
                    resetStageOrder()
                })

                $("#customerName").typeahead({
                        source: function (value, process) {
                            $.post(
                                "${pageContext.request.contextPath}/customer/relatedCustomer",
                                {"customerKey": value},
                                function (data) {
                                    process(data)
                                }, "json")
                        },
                        displayText: function (item) {
                            return item.customer_name
                        },
                        afterSelect: function (item) {
                            getLinkmanByCustomerId(item.customer_id)
                            return this.$element.val(item.customer_name)
                        }
                    }
                )

                { // 查找线索的弹出框
                    let clueTitleSearchInput = $("#clueTitleSearchInput")
                    let typingChinese = false

                    clueTitleSearchInput.on("compositionstart", function () {
                        typingChinese = true
                    })

                    clueTitleSearchInput.on("compositionend", function () {
                        typingChinese = false
                    })

                    clueTitleSearchInput.on("input", function () {
                        if (!typingChinese && this.value.trim() !== '') {
                            $.post(
                                "${pageContext.request.contextPath}/clue/fuzzySearch",
                                {"key": this.value},
                                function (clues) {
                                    let clueTableBody = $("#clueTableBody")
                                    clueTableBody.empty()

                                    for (let clue of clues) {
                                        let clueRow = $(`<tr ondblclick="insertClue(\${clue.clueId}, '\${clue.clueTitle}')"></tr>`)

                                        let radioTd = $(`<td><label><input type="radio" value="\${clue.clueId}" onclick="insertClue(\${clue.clueId}, '\${clue.clueTitle}')"/></label></td>`)
                                        let titleTd = $(`<td>\${clue.clueTitle}</td>`)
                                        let activityTd = $(`<td><c:choose><c:when test="clue.activity != null and clue.activity.activityName != null and clue.activity.activityName != ''">\${clue.activity.activityName}</c:when><c:otherwise>无活动来源</c:otherwise></c:choose></td>`)
                                        let intentionTd = $(`<td>\${clue.clueIntentionPerson}</td>`)
                                        let providerTd = $(`<td>\${clue.clueProviderName}</td>`)
                                        let dateTd = $(`<td>\${clue.updateTime}</td>`)

                                        clueRow.append(radioTd)
                                        clueRow.append(titleTd)
                                        clueRow.append(activityTd)
                                        clueRow.append(intentionTd)
                                        clueRow.append(providerTd)
                                        clueRow.append(dateTd)

                                        clueTableBody.append(clueRow)
                                    }
                                }, "json")
                        }
                    })
                }

                linkmanIdSelect.change(function () {
                    $("#linkmanId").val(this.value)
                })

                $("#clueTitle").focus(function () {
                    $("#findClue").modal("show")
                })

                <c:if test="${not empty deal.dealId}">
                {
                    getLinkmanByCustomerId(${deal.linkman.customer.customerId})
                }
                </c:if>
            })

            function getLinkmanByCustomerId(customerId) {
                $.post(
                    "${pageContext.request.contextPath}/linkman/relatedLinkman",
                    {"customerId": customerId},
                    function (data) {
                        let linkmanId = linkmanIdSelect

                        linkmanId.children(":not(:first)").remove()

                        for (let linkman of data) {
                            linkmanId.append(new Option(linkman.linkman_name, linkman.linkman_id))
                        }

                        <c:if test="${not empty deal.dealId}">
                        {
                            linkmanIdSelect.val(${deal.linkman.linkmanId})
                        }
                        </c:if>
                    }, "json")
            }

            function initialDatetimeInput() {
                $(".datetime").datetimepicker({
                    language: "zh-CN",
                    autoclose: true,
                    format: 'yyyy-mm-dd hh:ii:00',
                    todayBtn: true
                })
            }

            function insertClue(clueId, clueTitle) {
                $("#clueId").val(clueId)
                $("#clueTitle").val(clueTitle)
                $("#findClue").modal("hide")
            }
        </script>
    </body>
</html>