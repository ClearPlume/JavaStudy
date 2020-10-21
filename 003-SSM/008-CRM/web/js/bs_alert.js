"use strict"

let initialized = false
let msgBox
let msgDialog = $("<div class='modal-dialog' role='document' style='width: 30%'></div>")
let msgContent = $("<div class='modal-content'></div>")
let msgHeader = $("<div class='modal-header'></div>")
let msgCloseBtn = $("<button class='close' type='button' data-dismiss='modal'></button>")
let msgCloseBtnSpan = $("<span aria-hidden='true'>x</span>")
let msgTitle = $("<h4 class='modal-title'>提示</h4>")
let msgBody = $("<div class='modal-body'></div>")
let msgFooter = $("<div class='modal-footer'></div>")
let msgConfirmBtn = $("<button class='btn btn-primary' data-dismiss='modal'>确认</button>")

jQuery.fn.bs_alert = function (initializedData) {
    if (initialized) {
        msgBody.text(initializedData.msg)

        if (initializedData.title) {
            msgTitle.text(initializedData.title)
        }
        if (initializedData.widthPercent) {
            msgDialog.css("width", initializedData.widthPercent + "%")
        }

        msgBox.modal().show()
    } else {
        msgBox = this

        msgBox.addClass("modal fade")
        msgBox.attr("role", "dialog")

        msgCloseBtn.append(msgCloseBtnSpan)

        msgHeader.append(msgCloseBtn)
        msgHeader.append(msgTitle)

        msgFooter.append(msgConfirmBtn)

        msgContent.append(msgHeader)
        msgContent.append(msgBody)
        msgContent.append(msgFooter)

        msgDialog.append(msgContent)

        msgBox.append(msgDialog)

        initialized = true
    }
}

window.bs_alert = function (msg, title, widthPercent) {
    $().bs_alert({
        msg: msg,
        title: title,
        widthPercent: widthPercent
    })
}
