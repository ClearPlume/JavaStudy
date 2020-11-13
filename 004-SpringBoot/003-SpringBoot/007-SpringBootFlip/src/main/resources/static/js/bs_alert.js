"use strict"

/*******************************/
/* 完全基于bootstrap的一组消息弹窗 */
/*******************************/

let alertBox = $("<div class='modal fade' role='dialog'></div>")
let alertDialog = $("<div class='modal-dialog' role='document' style='width: 30%'></div>")
let alertContent = $("<div class='modal-content'></div>")
let alertHeader = $("<div class='modal-header'></div>")
let alertCloseBtn = $("<button class='close' type='button' data-dismiss='modal'></button>")
let alertCloseBtnSpan = $("<span aria-hidden='true'>x</span>")
let alertTitle = $("<h4 class='modal-title'>提示</h4>")
let alertBody = $("<div class='modal-body'></div>")
let alertFooter = $("<div class='modal-footer'></div>")
let alertCancelBtn = $("<button class='btn btn-primary'>取消</button>")
let alertConfirmBtn = $("<button class='btn'>确认</button>")

alertCloseBtn.append(alertCloseBtnSpan)

alertHeader.append(alertCloseBtn)
alertHeader.append(alertTitle)

alertContent.append(alertHeader)
alertContent.append(alertBody)
alertContent.append(alertFooter)

alertDialog.append(alertContent)

alertBox.append(alertDialog)

$("body").append(alertBox)

/**
 * 消息提示框
 */
window.bs_alert = function (msg, title, widthPercent) {
    alertBody.text(msg)

    if (title) {
        alertTitle.text(title)
    }
    if (widthPercent) {
        alertDialog.css("width", widthPercent + "%")
    }

    alertConfirmBtn.addClass("btn-primary")

    alertConfirmBtn.click(function () {
        alertBox.modal("hide")
        setTimeout(function () {
            alertFooter.empty()
            alertConfirmBtn.removeClass("btn-primary")
        }, 500)
    })

    alertFooter.append(alertConfirmBtn)

    alertBox.modal("show")
}

/**
 * 确认请求框
 */
window.bs_confirm = function (msg, title, widthPercent, callback) {
    alertBody.text(msg)

    if (title) {
        alertTitle.text(title)
    }
    if (widthPercent) {
        alertDialog.css("width", widthPercent + "%")
    }

    alertCancelBtn.click(function () {
        alertBox.modal("hide")
        setTimeout(function () {
            alertFooter.empty()
            alertConfirmBtn.removeClass("btn-danger")
        }, 500)
    })

    alertConfirmBtn.addClass("btn-danger")

    alertConfirmBtn.click(function () {
        alertBox.modal("hide")
        setTimeout(function () {
            alertFooter.empty()
            alertConfirmBtn.removeClass("btn-danger")
            callback()
        }, 500)
    })

    alertFooter.append(alertCancelBtn)
    alertFooter.append(alertConfirmBtn)

    alertBox.modal("show")
}