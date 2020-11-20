// 显示错误信息
function showError(msg) {
    $("#showErrLi").text(msg)
}

// 隐藏错误信息
function hideError() {
    $("#showErrLi").html("&nbsp;")
}

$(document).ready(function () {
    // 输入的信息是否正确
    let phoneOK = false
    let pwdOK = false
    let authCodeOK = false

    // 输入的登录信息
    let phone
    let pwd
    let authCode

    // 手机号输入框失去焦点
    $("#phone").blur(function () {
        hideError()
        phone = this.value.trim()

        if (phone.length === 0) {
            showError("手机号不能为空！")
            phoneOK = false
            return
        }
        phoneOK = true
    })

    // 密码输入框失去焦点
    $("#loginPassword").blur(function () {
        hideError()
        pwd = this.value.trim()

        if (pwd.length === 0) {
            showError("密码不能为空！")
            pwdOK = false
            return
        }
        pwdOK = true
    })

    // 验证码输入框失去焦点
    $("#messageCode").blur(function () {
        hideError()
        authCode = this.value.trim()

        if (!authCode.length === 6) {
            authCodeOK = false
            showError("messageCode", "验证码长度必须为6！")
            return
        }
        if (!/\d{6}/.test(authCode)) {
            showError("messageCode", "验证码为6位数字！")
            authCodeOK = false
            return
        }
        authCodeOK = true
    })

    // 点击验证码按钮
    $("#messageCodeBtn").click(function () {
        if (phoneOK && pwdOK) {
            let $this = $(this)

            if (!$this.hasClass("on")) {
                $.ajax({
                    "url": "/P2PWeb/loan/page/checkNum",
                    "data": {
                        "phone": phone
                    },
                    "success": function (data) {
                        if (data.success) {
                            $.leftTime(60, function (data) {
                                if (data.status) {
                                    $this.addClass("on")
                                    $this.html((data.s === "00" ? "60" : data.s) + "秒后重新获取")
                                } else {
                                    $this.removeClass("on")
                                    $this.html("获取验证码")
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
            showError("请正确填写信息！")
        }
    })

    // 点击登录按钮
    $("#loginBtn").click(function () {
        if (phoneOK && pwdOK && authCodeOK) {
            $.ajax({
                "url": "/P2PWeb/loan/page/loginSubmit",
                "data": {
                    "phone": phone,
                    "pwd": $.md5(pwd),
                    "authCode": authCode
                },
                "success": function (data) {
                    let prevPageURL = $("#prevPageURL")

                    if (data.success) {
                        if (prevPageURL === '') {
                            location.href = "/P2PWeb/index"
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
            showError("输入信息有误，请检查！")
        }
    })
})
