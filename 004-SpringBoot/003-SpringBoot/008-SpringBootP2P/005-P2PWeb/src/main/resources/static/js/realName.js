//错误提示
function showError(id, msg) {
    let errSign = $("#" + id + "Err")
    let okSign = $("#" + id + "Ok")

    okSign.hide()
    errSign.html("<i></i><p>" + msg + "</p>")
    errSign.show()
    $("#" + id).addClass("input-red")
}

//错误隐藏
function hideError(id) {
    let errSign = $("#" + id + "Err")

    errSign.html("")
    errSign.hide()
    $("#" + id).removeClass("input-red")
}

//显示成功
function showSuccess(id) {
    let errSign = $("#" + id + "Err")

    errSign.html("")
    errSign.hide()
    $("#" + id + "Ok").show()
    $("#" + id).removeClass("input-red")
}

//打开注册协议弹层
function alertBox(maskId, agreeId) {
    $("#" + maskId).show()
    $("#" + agreeId).show()
}

//关闭注册协议弹层
function closeBox(maskId, agreeId) {
    $("#" + maskId).hide()
    $("#" + agreeId).hide()
}

$(function () {
    // 输入的信息是否正确
    let phoneOK = false
    let realNameOK = false
    let idCardOK = false
    let authCodeOK = false

    // 是否已经点击获取验证码
    let clickedGetMessage = false

    // 输入的实名信息
    let phone
    let realName
    let idCard
    let authCode

    //同意实名认证协议
    $("#agree").click(function () {
        let btnAuth = $("#btnAuth")
        let isCheck = document.getElementById("agree").checked

        if (isCheck) {
            btnAuth.attr("disabled", false)
            btnAuth.removeClass("fail")
        } else {
            btnAuth.attr("disabled", "disabled")
            btnAuth.addClass("fail")
        }
    })

    // 手机号输入框失去焦点
    $("#phone").blur(function () {
        phone = this.value.trim()
        hideError("phone")

        if (phone.length !== 11) {
            showError("phone", "手机号长度为11位！")
            phoneOK = false
            return
        }

        if (!/^1\d{10}$/.test(phone)) {
            showError("phone", "手机号格式不正确！")
            phoneOK = false
            return
        }
        phoneOK = true
        showSuccess("phone")
    })

    // 姓名输入框失去焦点
    $("#realName").blur(function () {
        realName = this.value.trim()
        hideError("realName")

        if (realName.length === 0) {
            showError("realName", "姓名不能为空！")
            realNameOK = false
            return
        }

        if (!/^[\u4e00-\u9fa5]+$/.test(realName)) {
            showError("realName", "姓名必须为中文！")
            realNameOK = false
            return
        }
        realNameOK = true
        showSuccess("realName")
    })

    // 身份证输入框失去焦点
    $("#idCard").blur(function () {
        idCard = this.value.trim()
        hideError("idCard")

        if (idCard.length === 0) {
            showError("idCard", "身份证不能为空！")
            idCardOK = false
            return
        }

        if (!(idCard.length === 15 || idCard.length === 18)) {
            showError("idCard", "身份证长度为15或18位！")
            idCardOK = false
            return
        }

        if (!/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(idCard)) {
            showError("idCard", "身份证格式不正确！")
            idCardOK = false
            return
        }
        idCardOK = true
        showSuccess("idCard")
    })

    // 验证码输入框失去焦点
    $("#messageCode").blur(function () {
        authCode = this.value.trim()
        hideError("messageCode")

        if (authCode.length !== 6) {
            authCodeOK = false
            showError("messageCode", "验证码长度必须为6！")
            return
        }
        if (!/\d{6}/.test(authCode)) {
            showError("messageCode", "验证码为6位数字！")
            authCodeOK = false
            return
        }
        showSuccess("messageCode")
        authCodeOK = true
    })

    // 点击验证码按钮
    $("#messageCodeBtn").click(function () {
        if (!clickedGetMessage) {
            clickedGetMessage = true
            if (phoneOK && realNameOK && idCardOK) {
                let _this = $(this)

                if (!_this.hasClass("on")) {
                    $.ajax({
                        "data": {
                            "phone": phone
                        },
                        "url": "/P2PWeb/loan/page/checkNum",
                        "success": function (data) {
                            if (data.success) {
                                clickedGetMessage = false
                                $.leftTime(60, function (data) {
                                    if (data.status) {
                                        _this.html((data.s === "00" ? "60" : data.s) + "秒后重新获取")
                                        _this.addClass("on")
                                    } else {
                                        _this.removeClass("on")
                                        _this.html("获取验证码")
                                    }
                                })
                                // FIXME 这个只是测试时获取生成的验证码
                                alert(data.msg)
                            } else {
                                alert(data.msg)
                            }
                        },
                        "error": function () {
                            alert("系统维护中...")
                        }
                    })
                }
            } else {
                showError("messageCodeBtn", "请正确填写信息！")
                setTimeout(function () {
                    hideError("messageCodeBtn")
                }, 2000)
            }
        }
    })

    // 点击认证按钮
    $("#btnAuth").click(function () {
        if (phoneOK && realNameOK && idCardOK && authCodeOK) {
            $.ajax({
                "url": "/P2PWeb/loan/page/realNameSubmit",
                "data": {
                    "phone": phone,
                    "authCode": authCode,
                    "realName": realName,
                    "idCard": idCard
                },
                "success": function (data) {
                    let prevPageURL = $("#prevPageURL")

                    if (data.success) {
                        if (prevPageURL.val() === '') {
                            location.href = "/P2PWeb/"
                        } else {
                            location.href = prevPageURL.val()
                        }
                    } else {
                        alert(data.msg)
                    }
                },
                "error": function () {
                    alert("系统维护中...")
                }
            })
        } else {
            showError("btnRegister", "输入信息有误，请检查！")
            setTimeout(function () {
                hideError("btnRegister")
            }, 2000)
        }
    })
})
