package top.fallenangel.springboot.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.springboot.p2p.common.Constants;
import top.fallenangel.springboot.p2p.common.Result;
import top.fallenangel.springboot.p2p.model.entity.User;
import top.fallenangel.springboot.p2p.service.IUserService;
import top.fallenangel.springboot.p2p.util.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
@Controller
@RequestMapping("loan/page")
public class UserController {
    @Reference(interfaceClass = IUserService.class, version = "1.0.0", timeout = 15000)
    private IUserService userService;

    private final JsonUtil json;
    private final XmlUtil xml;
    private final RedisUtil redis;

    public UserController(JsonUtil json, XmlUtil xml, RedisUtil redis) {
        this.json = json;
        this.xml = xml;
        this.redis = redis;
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @ResponseBody
    @GetMapping("checkPhoneAvailable")
    public Object checkPhoneAvailable(String phone) {
        if (userService.queryPhoneNum(phone) == 0) {
            return Result.success();
        } else {
            return Result.error("手机号已被占用！");
        }
    }

    @ResponseBody
    @GetMapping("registerSubmit")
    public Object registerSubmit(String phone, String pwd, String authCode, HttpServletRequest request) {
        if (!authCode.equals(redis.getValue(phone))) {
            return Result.error("验证码填写错误！");
        }
        User user = userService.register(phone, pwd);
        request.getSession().setAttribute(Constants.LOGIN_USER, user);
        if (user == null) {
            return Result.error("注册失败，请稍候再试...");
        } else {
            return Result.success();
        }
    }

    @ResponseBody
    @GetMapping("checkNum")
    public Object checkNum(String phone, HttpServletRequest request) {
        String authCode = RandomUtil.num(6);
        redis.setValue(phone, authCode, 1, TimeUnit.MINUTES);
        String content = "【凯信通】您的验证码是：" + authCode;

        Map<String, Object> param = new HashMap<>();
        // param.put("mobile", phone);
        // param.put("content", content);
        // param.put("appkey", "cd5b89522646433fad8e1c667b95b5d9");

        String data;
        try {
            data = HttpClientUtil.doPost("https://way.jd.com/kaixintong/kaixintong", param);
            data = "{\n" +
                    "    \"code\": \"10000\",\n" +
                    "    \"charge\": false,\n" +
                    "    \"remain\": 0,\n" +
                    "    \"msg\": \"查询成功\",\n" +
                    "    \"result\": \"<?xml version=\\\"1.0\\\" encoding=\\\"utf-8\\\" ?><returnsms>\\n <returnstatus>Success</returnstatus>\\n <message>ok</message>\\n <remainpoint>-1111611</remainpoint>\\n <taskID>101609164</taskID>\\n <successCounts>1</successCounts></returnsms>\"\n" +
                    "}";
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("网络波动，请稍候再试...");
        }
        try {
            json.parseJson(data);
            xml.parseXml(json.getString("result"));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("系统维护中，请稍候再试");
        }
        String code = json.getString("code");
        String status = xml.getElementText("/returnsms/returnstatus");
        System.out.println("phone = " + phone);
        System.out.println("code = " + code);
        System.out.println("status = " + status);
        return Result.success(authCode);
    }
}
