//微信二维码关闭界面
function closeEwm(divId) {
    document.getElementById(divId).style.display = 'none'
    document.getElementById('dialog').style.display = 'none'
}

//微信二维码弹出界面
function displayEwm(divId) {
    document.getElementById('dialog').style.display = 'block'
    document.getElementById(divId).style.display = 'block'
}

/**
 * 媒体,公告，关于我们，联系我们等左侧菜单
 * @param cc 需要到div的id
 * @param selected 选中的菜单id
 */
function getLeftMenuXmlHttpAjax(cc, selected) {
    // noinspection JSUnresolvedFunction
    let xmlHttp = getRequest()
    xmlHttp.open("POST", "../index/leftMenu.jsp", false)
    xmlHttp.setRequestHeader("content-type", "application/x-www-form-urlencoded")
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState === 4) {
            if (xmlHttp.status === 200) {
                let responseText = xmlHttp.responseText
                let finance = document.getElementById(cc)
                if (finance != null && responseText.length !== 0) {
                    finance.innerHTML = responseText
                    $("#" + selected).addClass("current")
                }
            }
        }
    }
    xmlHttp.send(null)
}

function getMessage(url, name, code) {
    let showMsg = ""
    $.ajax({
        url: "" + url,
        dataType: "text",
        async: false,
        data: "name=" + name + "&code=" + code,
        success: function (msg) {
            showMsg = msg
        },
        error: function () {
            showMsg = "错误"
        }
    })
    return showMsg
}

//登录后个人信息提示
function firstLogin() {
    let userPhone = $(".user-phone").text()
    let reg = new RegExp("(^| )isConfirmed_" + userPhone + "=([^;]*)(;|$)")
    let arr = document.cookie.match(reg)
    let arr2
    let body = $('body')

    if (window.localStorage) {
        arr2 = window.localStorage.getItem("isConfirmed_" + userPhone)
    }
    if ((arr == null || arr[2] !== 'isConfirmed') && arr2 !== 'isConfirmed') {
        body.addClass('personal-prompt')
        $('.personal-prompt .userinfo-up').show()
    }
    body.click(function () {
        body.removeClass('personal-prompt')
        document.cookie = "isConfirmed_" + userPhone + "=isConfirmed;path=/;domain=jinxin99.cn;expires=Fri, 31 Dec 9999 23:59:59 GMT"
        if (window.localStorage) {
            window.localStorage.setItem("isConfirmed_" + userPhone, "isConfirmed")
        }
    })
}

//头部账户效果
$(function () {
    let userPhone = $(".user-phone")

    if (userPhone.text() != null && userPhone.text() !== '') {
        firstLogin()
    }
    //getAccount()
    //页头页脚用到的js,程序写页面时无需在此页面加载下面的js，只需在页头页脚独立文件加载即可
    //手机客户端下拉层
    $(".phone-ewm").hover(function () {
        $(this).addClass('phone-ewm-hover')
    }, function () {
        $(this).removeClass('phone-ewm-hover')
    })
    //个人信息下拉
    $(".logged").hover(function () {
        // 获取账号余额
        $.getJSON(
            "/P2PWeb/finance/accountAmount",
            function (amount) {
                $("#frame_top").text(amount)
            }
        )
        $(this).addClass("logged-hover")
        $(".userinfo-drop-down", this).stop().animate({height: '205px'}, 300)
    }, function () {
        $(".userinfo-drop-down", this).stop().animate({height: '0'}, 300)
        $(".logged").removeClass("logged-hover")
    })
    //二维码弹出层显示隐藏
    $(".head-weixin").click(function () {
        $("#dialog,#ewm").fadeIn()
    })
    $("#ewm .close").click(function () {
        $(this).parent().fadeOut()
        $("#dialog").fadeOut()
    })
    //页脚友情链接
    let linkList = $(".links-list")
    let linkListHeight = linkList.innerHeight()

    linkList.css({height: '30px'})
    $("#links-down").click(function () {
        if ($(this).hasClass('links-up')) {
            $(this).removeClass("links-up")
            $(this).prev().stop().animate({height: '30px'}, 500)
        } else {
            $(this).addClass("links-up")
            $(this).prev().stop().animate({height: linkListHeight}, 500)
        }
    })
    //关闭温馨提示
    $(".footer-hint .hint-close").click(function () {
        $(this).parent().fadeOut()
    })
    //返回顶部
    $(window).scroll(function () {
        if ($(window).scrollTop() > 100) {
            $("#back-to-top").fadeIn(1500)
        } else {
            $("#back-to-top").fadeOut(1500)
        }
    })
    //当点击跳转链接后，回到页面顶部位置
    $("#back-to-top").click(function () {
        $('body,html').animate({scrollTop: 0}, 100)
        return false
    })

    //getMessageNum()
    let userName_userPhone = $('.user_name,.user-phone').html()

    if (userName_userPhone != null && userName_userPhone !== "" && (location.href.indexOf("/account/") === 0 || location.href.indexOf("/cashBox/") === 0)) {
        let url = $(".urlPath").val()
        $.ajax({
            type: "POST",
            url: url + "/user/getMember.do?myTime=" + new Date(),
            dataType: "text",
            async: false,
            success: function (msg) {
                if (msg != null && msg !== '') {
                    let json = eval('(' + msg + ')')
                    if (json.level === "0") {
                        $('#member,#member_over').html("普通会员")
                    } else if (json.level === "1") {
                        $('#member,#member_over').html("VIP1")
                    } else if (json.level === "2") {
                        $('#member,#member_over').html("VIP2")
                    } else if (json.level === "3") {
                        $('#member,#member_over').html("VIP3")
                    } else if (json.level === "4") {
                        $('#member,#member_over').html("VIP4")
                    }
                } else {
                    $('#member,#member_over').html("普通会员")
                }
            },
            error: function () {
                //alert("页面加载失败，请重试！")
            }
        })
    }

})

/*function getAccount(){
	let url = $(".urlPath").val()
	$.post(url+"/account/getAvailableMoney.do",function(data){
		$("#frame_top").html(data)
		$("#frame_top").show()
		$("#frame_top").next('img').hide()
	},"text")
}*/
function getMessageNum() {
    let url = $(".urlPath").val()
    if (url === undefined) {
        return
    }
    $.post(url + "/account/getMessageNum.do", function (data) {
        if (0 < data) {
            let messageNum = $(".messageNum")
            if (data > 99) {
                data = 9 + "+"
            }
            $(".head_message").removeClass("no_message")
            messageNum.html(data)
            messageNum.show()
        }
    }, "text")
}

//实名认证  交易密码  start
function popupComplete(path, conpath, type) {
    $.ajax({
        type: "POST",
        url: conpath + "/ssl/completePopup.do?type=" + type, //查看用户欲往操作   0投 1充 2提  3绑卡 4好易联充值
        dataType: "text",
        async: false,
        success: function (data) {
            if (data === 'complete') {
                if (type === '4') {
                } else {
                    window.location.href = path
                }
            } else if (data === 'login') {
                window.location.href = "../../webPage/ssl/login.html"
            } else {
                popupCompleteMsg(data, 0, conpath, type)
            }
        },
        error: function () {
            //alert("页面加载失败，请重试！")
        }
    })
}

//实名认证  交易密码  start
function popupCompleteIndex(path, conpath, type) {
    $.ajax({
        type: "POST",
        url: conpath + "/ssl/completePopup.do?type=" + type, //查看用户欲往操作   0投 1充 2提  3绑卡 4好易联充值
        dataType: "text",
        async: false,
        success: function (data) {
            if (data != null && data === 'complete') {
                if (type === '4') {
                } else {
                    window.location.href = path
                }
            } else if (data != null && data === 'login') {
                window.location.href = "../ssl/login.html"
            } else {
                popupCompleteMsg(data, 0, conpath, type)
            }
        },
        error: function () {
            //alert("页面加载失败，请重试！")
        }
    })
}

function popupCompleteMsg(type, status, conpath, msg) {
    //type 是实名认证还是交易密码    status 成功还是尚未开始   msg 0投 1充 2提 3绑卡  4好易联充值
    let myTime = new Date().getTime()
    $.ajax({
        type: "POST",
        url: conpath + "/ssl/completeMsg.do?msg=" + msg, //
        dataType: "text",
        async: false,
        success: function (data) {
            let earnMaskMsg = $("#earnMaskMsg")
            $('body').append(data)
            earnMaskMsg.show()
            let type = $("#" + type)
            type.show()
            let vHeight = type.innerHeight()
            type.css({"marginTop": -vHeight / 2})

            $(".queding").click(function () {
                earnMaskMsg.remove()
                $("#earnMsg").remove()
                if (msg === "4" && status !== "1") {
                    //重新跳转到充值页面
                    window.location.href = "../../ssl/cashBox/getRecharge.do?myTime=" + myTime
                } else if (status === "1") {
                    window.location.href = "../../ssl/cashBox/AccountSet.do?myTime=" + myTime
                }
            })
            if (msg === "0") {
                $(".dobeforething").attr("href", "../../webPage/invest/wytz.html")
            } else if (msg === "1") {
                $(".dobeforething").attr("href", "../../ssl/cashBox/getRecharge.do?myTime=" + myTime)
            } else if (msg === "2") {
                $(".dobeforething").attr("href", "../../ssl/cashBox/getBankAccountlist.do?myTime=" + myTime)
            } else if (msg === "3") {
                $(".dobeforething").attr("href", "../../ssl/cashBox/getBankAccountlist.do?mybank=true&myTime=" + myTime)
            } else if (msg === "4") {
                $(".dobeforething").attr("href", "../../ssl/cashBox/getRecharge.do?myTime=" + myTime)
            } else if (msg === "5") {
                $(".dobeforething").attr("href", "../../webPage/goldtip/jinzhi.html")
            } else if (msg === "6") {//散标投资
                $(".dobeforething").attr("href", "../../webPage/invest/standard_list.html")
            } else if (msg === "7") {
                // $(".dobeforething").attr("href","../../")
                $(".dobeforething").attr("href", "../../webPage/index/index.html")
            } else {
                earnMaskMsg.remove()
                $("#earnMsg").remove()
            }
        },
        error: function () {
            //alert("页面加载失败，请重试！")
        }
    })
}