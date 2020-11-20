//错误提示
function showError(id, msg) {
    let okSign = $("#" + id + "Ok")
    let errSign = $("#" + id + "Err")

    okSign.hide()
    errSign.html("<i></i><p>" + msg + "</p>")
    errSign.show()
    $("#" + id).addClass("input-red")
}

//错误隐藏
function hideError(id) {
    let errSign = $("#" + id + "Err")

    errSign.hide()
    errSign.html("")
    $("#" + id).removeClass("input-red")
}

//显示成功
function showSuccess(id) {
    let errSign = $("#" + id + "Err")

    errSign.hide()
    errSign.html("")
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
    let pwdOK = false
    let authCodeOK = false

    // 是否已经点击获取验证码
    let clickedGetMessage = false

    // 输入的注册信息
    let phone
    let pwd
    let authCode

    // 注册协议确认
    $("#agree").click(function () {
        let isCheck = document.getElementById("agree").checked
        let btnRegister = $("#btnRegister")

        if (isCheck) {
            btnRegister.attr("disabled", false)
            btnRegister.removeClass("fail")
        } else {
            btnRegister.attr("disabled", "disabled")
            btnRegister.addClass("fail")
        }
    })

    // 手机号输入框失去焦点
    $("#phone").blur(function () {
        hideError("phone")
        phone = this.value.trim()

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

        $.getJSON(
            "/P2PWeb/loan/page/checkPhoneAvailable",
            {
                "phone": phone
            },
            function (data) {
                if (data.success) {
                    phoneOK = true
                    showSuccess("phone")
                } else {
                    showError("phone", data.msg)
                    phoneOK = false
                }
            }
        )
    })

    // 密码输入框失去焦点
    $("#loginPassword").blur(function () {
        hideError("loginPassword")
        pwd = this.value.trim()

        if (pwd.length < 6 || pwd.length > 20) {
            showError("loginPassword", "密码长度为6-20位！")
            pwdOK = false
            return
        }
        /*
         * 正则：(?!<正则>)：预言该位置之后不符合<正则>
         */
        if (!/^(?!\d+$)(?![a-zA-Z]+$)[0-9a-zA-Z]{6,20}$/.test(pwd)) {
            showError("loginPassword", "密码必须包含数字和字母！")
            pwdOK = false
            return
        }
        showSuccess("loginPassword")
        pwdOK = true
    })

    // 验证码输入框失去焦点
    $("#messageCode").blur(function () {
        hideError("messageCode")
        authCode = this.value.trim()

        if (authCode.length !== 6) {
            showError("messageCode", "验证码长度必须为6！")
            authCodeOK = false
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
            if (phoneOK && pwdOK) {
                let _this = $(this)

                if (!_this.hasClass("on")) {
                    $.ajax({
                        "url": "/P2PWeb/loan/page/checkNum",
                        "data": {
                            "phone": phone
                        },
                        "success": function (data) {
                            if (data.success) {
                                clickedGetMessage = false
                                $.leftTime(60, function (data) {
                                    if (data.status) {
                                        _this.addClass("on")
                                        _this.html((data.s === "00" ? "60" : data.s) + "秒后重新获取")
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

    // 点击注册按钮
    $("#btnRegister").click(function () {
        if (phoneOK && pwdOK && authCodeOK) {
            $.ajax({
                "url": "/P2PWeb/loan/page/registerSubmit",
                "data": {
                    "phone": phone,
                    "pwd": $.md5(pwd),
                    "authCode": authCode
                },
                "success": function (data) {
                    if (data.success) {
                        location.href = "/P2PWeb/loan/page/realName"
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
