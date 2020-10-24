"use strict"

let msgBox = $("<div class='modal fade' role='dialog'></div>")
let msgDialog = $("<div class='modal-dialog' role='document' style='width: 30%'></div>")
let msgContent = $("<div class='modal-content'></div>")
let msgHeader = $("<div class='modal-header'></div>")
let msgCloseBtn = $("<button class='close' type='button' data-dismiss='modal'></button>")
let msgCloseBtnSpan = $("<span aria-hidden='true'>x</span>")
let msgTitle = $("<h4 class='modal-title'>提示</h4>")
let msgBody = $("<div class='modal-body'></div>")
let msgFooter = $("<div class='modal-footer'></div>")
let msgConfirmBtn = $("<button class='btn btn-primary' data-dismiss='modal'>确认</button>")

window.bs_alert = function (msg, title, widthPercent) {
    msgBody.text(msg)

    if (title) {
        msgTitle.text(title)
    }
    if (widthPercent) {
        msgDialog.css("width", widthPercent + "%")
    }
    msgCloseBtn.append(msgCloseBtnSpan)

    msgHeader.append(msgCloseBtn)
    msgHeader.append(msgTitle)

    msgFooter.append(msgConfirmBtn)

    msgContent.append(msgHeader)
    msgContent.append(msgBody)
    msgContent.append(msgFooter)

    msgDialog.append(msgContent)

    msgBox.append(msgDialog)

    $("body").append(msgBox)

    msgBox.modal("show")
}