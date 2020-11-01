"use strict"

let stageCount = 0

window.newStage = function () {
    stageCount++

    // 每一个阶段的div
    let curStageDiv = $("<div class='stageDiv'></div>")

    // 阶段名、金额的formGroupGiv
    let stageFormGroup1 = $("<div class='form-group'></div>")

    let stageStageLabel = $(`<label for='stageName${stageCount}' class='col-sm-2 control-label'><span class="stageOrderLabel">阶段</span><span style='font-size=15px; color: red'>*</span></label>`)
    let stageStageInput = $(`<div class='col-sm-10' style='width: 300px'><input type='text' id='stageName${stageCount}' name='' class='form-control stageOrderInput'></div>`)
    let stageAmountLabel = $(`<label for='stageAmount${stageCount}' class='col-sm-2 control-label'>金额<span style='font-size=15px; color: red'>*</span></label>`)
    let stageAmountInput = $(`<div class='col-sm-10' style='width: 300px'><input type='text' id='stageAmount${stageCount}' name='' class='form-control stageOrderAmount'></div>`)

    stageFormGroup1.append(stageStageLabel)
    stageFormGroup1.append(stageStageInput)
    stageFormGroup1.append(stageAmountLabel)
    stageFormGroup1.append(stageAmountInput)

    // 预计成交日期、是否现阶段的formGroupGiv
    let stageFormGroup2 = $("<div class='form-group'></div>")

    let stagePlanLabel = $(`<label for='stagePlanTime${stageCount}' class='col-sm-2 control-label'>预计成交日期<span style='font-size=15px; color: red'>*</span></label>`)
    let stagePlanInput = $(`<div class='col-sm-10' style='width: 300px'><input type='text' id='stagePlanTime${stageCount}' name='' class='form-control stageOrderPlan datetime'/></div>`)
    let stageCurrLabel = $(`<label for='stageCurrent${stageCount}' class='col-sm-2 control-label'>当前阶段 ？<span style='font-size=15px; color: red'>*</span></label>`)
    let stageCurrRadio = $(`<div class='col-sm-10' style='width: 300px'><input type='radio' id='stageCurrent${stageCount}' name='' class='form-control stageOrderCurr' value="true" onclick="resetCurrStageRadio(this)"/></div>`)

    stageFormGroup2.append(stagePlanLabel)
    stageFormGroup2.append(stagePlanInput)
    stageFormGroup2.append(stageCurrLabel)
    stageFormGroup2.append(stageCurrRadio)

    // 新增、删除stage按钮的formGroupGiv
    let stageFormGroup3 = $("<div class='form-group'></div>")

    let stageBtnDiv = $("<div class='col-sm-10'></div>")
    let stageBtnLabel = $("<label class='col-sm-2 control-label'></label>")
    let stageAddBtn = $("<button type='button' class='btn btn-primary addStageBtn' title='在此位置插入新阶段'><span class='glyphicon glyphicon-plus'></span></button>")
    let stageDelBtnDiv = $("<div class='delBtnDiv' style='display: inline-block'></div>")
    let stageDelBtn = $("<button type='button' class='btn btn-danger delStageBtn' title='删除阶段'><span class='glyphicon glyphicon-remove'></span></button>")

    stageBtnDiv.append(stageAddBtn)
    stageDelBtnDiv.append("&nbsp;")
    stageDelBtnDiv.append(stageDelBtn)
    if (stageCount > 1) {
        stageBtnDiv.append(stageDelBtnDiv)
    }

    stageFormGroup3.append(stageBtnLabel)
    stageFormGroup3.append(stageBtnDiv)

    curStageDiv.append(stageFormGroup1)
    curStageDiv.append(stageFormGroup2)
    curStageDiv.append(stageFormGroup3)

    return curStageDiv
}

function resetStageOrder() {
    $(".stageOrderLabel").each(function (index) {
        this.innerText = `阶段${index + 1}`
    })

    $(".stageOrderInput").each(function (index) {
        this.name = `dealStages[${index}].stageName`
    })

    $(".stageOrderAmount").each(function (index) {
        this.name = `dealStages[${index}].stageAmount`
    })

    $(".stageOrderPlan").each(function (index) {
        this.name = `dealStages[${index}].stagePlanTime`
    })

    $(".stageOrderCurr").each(function (index) {
        this.name = `dealStages[${index}].stageCurrent`
    })
}

function resetCurrStageRadio(radio) {
    $(".stageOrderCurr").each(function (index, item) {
        item.checked = false
    })

    radio.checked = true
}