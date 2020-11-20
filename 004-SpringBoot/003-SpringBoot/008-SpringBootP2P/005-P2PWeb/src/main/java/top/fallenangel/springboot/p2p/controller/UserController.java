package top.fallenangel.springboot.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.springboot.p2p.common.Constants;
import top.fallenangel.springboot.p2p.common.Result;
import top.fallenangel.springboot.p2p.model.entity.User;
import top.fallenangel.springboot.p2p.service.IBidInfoService;
import top.fallenangel.springboot.p2p.service.IFinanceAccountService;
import top.fallenangel.springboot.p2p.service.IUserService;
import top.fallenangel.springboot.p2p.util.JsonUtil;
import top.fallenangel.springboot.p2p.util.RandomUtil;
import top.fallenangel.springboot.p2p.util.RedisUtil;
import top.fallenangel.springboot.p2p.util.XmlUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
@Controller
@RequestMapping("loan")
public class UserController {
    @Reference(interfaceClass = IUserService.class, version = "1.0.0", timeout = 15000)
    private IUserService userService;

    @Reference(interfaceClass = IBidInfoService.class, version = "1.0.0", timeout = 15000)
    private IBidInfoService bidInfoService;

    @Reference(interfaceClass = IFinanceAccountService.class, version = "1.0.0", timeout = 15000)
    private IFinanceAccountService financeAccountService;

    private final JsonUtil json;
    private final XmlUtil xml;
    private final RedisUtil redis;

    public UserController(JsonUtil json, XmlUtil xml, RedisUtil redis) {
        this.json = json;
        this.xml = xml;
        this.redis = redis;
    }

    // 跳转登录页面
    @GetMapping("page/register")
    public String register() {
        return "register";
    }

    // 检查手机号是否可用
    @ResponseBody
    @GetMapping("page/checkPhoneAvailable")
    public Object checkPhoneAvailable(String phone) {
        if (userService.queryPhoneNum(phone) == 0) {
            return Result.success();
        } else {
            return Result.error("手机号已被占用！");
        }
    }

    // 提交注册
    @ResponseBody
    @GetMapping("page/registerSubmit")
    public Object registerSubmit(String phone, String pwd, String authCode, HttpServletRequest request) {
        if (!authCode.equals(redis.getValue(phone))) {
            return Result.error("验证码填写有误！");
        }
        User user = userService.register(phone, pwd);
        request.getSession().setAttribute(Constants.LOGIN_USER, user);
        if (user == null) {
            return Result.error("注册失败，请稍候再试...");
        } else {
            return Result.success();
        }
    }

    // 发送短信验证码
    @ResponseBody
    @GetMapping("page/checkNum")
    public Object checkNum(String phone, HttpServletRequest request) {
        String authCode = RandomUtil.num(6);
        redis.setValue(phone, authCode, 1, TimeUnit.MINUTES);
        String content = "【凯信通】您的验证码是：" + authCode;

        Map<String, Object> param = new HashMap<>();
        // param.put("mobile", phone);
        // param.put("content", content);
        // param.put("appkey", "cd5b89522646433fad8e1c667b95b5d9");

        String data;
        // data = HttpClientUtil.doPost("https://way.jd.com/kaixintong/kaixintong", param);
        data = "{\n" +
                "    \"code\": \"10000\",\n" +
                "    \"charge\": false,\n" +
                "    \"remain\": 0,\n" +
                "    \"msg\": \"查询成功\",\n" +
                "    \"result\": \"<?xml version=\\\"1.0\\\" encoding=\\\"utf-8\\\" ?><returnsms>\\n <returnstatus>Success</returnstatus>\\n <message>ok</message>\\n <remainpoint>-1111611</remainpoint>\\n <taskID>101609164</taskID>\\n <successCounts>1</successCounts></returnsms>\"\n" +
                "}";
        try {
            json.parseJson(data);
            xml.parseXml(json.getString("result"));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("系统维护中，请稍候再试");
        }
        String code = json.getString("code");
        if (!"10000".equals(code)) {
            return Result.error("网络波动，请稍候再试...");
        }
        String status = xml.getElementText("/returnsms/returnstatus");
        if (!"Success".equals(status)) {
            return Result.error("网络波动，请稍候再试...");
        }
        return Result.success(authCode);
    }

    // 跳转实名认证页面
    @GetMapping("page/realName")
    public String realName(Model model, @RequestParam(required = false) String returnUrl) {
        model.addAttribute("returnUrl", returnUrl);
        return "realName";
    }

    // 提交实名认证
    @ResponseBody
    @GetMapping("page/realNameSubmit")
    public Object realNameSubmit(String phone, String authCode, String idCard, String realName, HttpServletRequest request) {
        if (!authCode.equals(redis.getValue(phone))) {
            return Result.error("验证码填写有误！");
        }
        Map<String, Object> param = new HashMap<>();
        // param.put("cardNo", idCard);
        // param.put("realName", realName);
        // param.put("appkey", "cd5b89522646433fad8e1c667b95b5d9");

        String data;
        // data = HttpClientUtil.doPost("https://way.jd.com/youhuoBeijing/test", param);
        data = "{\n" +
                "    \"code\": \"10000\",\n" +
                "    \"charge\": false,\n" +
                "    \"remain\": 1305,\n" +
                "    \"msg\": \"查询成功\",\n" +
                "    \"result\": {\n" +
                "        \"error_code\": 0,\n" +
                "        \"reason\": \"成功\",\n" +
                "        \"result\": {\n" +
                "            \"realname\": \"乐天磊\",\n" +
                "            \"idcard\": \"350721197702134399\",\n" +
                "            \"isok\": true\n" +
                "        }\n" +
                "    }\n" +
                "}";
        try {
            json.parseJson(data);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("系统维护中，请稍候再试");
        }
        String code = json.getString("code");
        if (!"10000".equals(code)) {
            return Result.error("网络波动，请稍候再试...");
        }
        boolean isOk = json.getJson("result").getJson("result").getBoolean("isok");
        if (!isOk) {
            return Result.error("实名认证失败，检查身份信息！");
        }
        User user = (User) request.getSession().getAttribute(Constants.LOGIN_USER);
        user.setIdCard(idCard);
        user.setName(realName);
        userService.modify(user);
        return Result.success();
    }

    // 跳转登录界面
    @GetMapping("page/login")
    public String login(Model model, @RequestParam(required = false) String returnUrl) {
        model.addAttribute("totalUser", userService.queryTotalUser());
        model.addAttribute("totalDealMoney", bidInfoService.queryTotalDealMoney());
        model.addAttribute("returnUrl", returnUrl);
        return "login";
    }

    // 提交登录
    @ResponseBody
    @GetMapping("page/loginSubmit")
    public Object loginSubmit(String phone, String pwd, String authCode, HttpServletRequest request) {
        if (!authCode.equals(redis.getValue(phone))) {
            return Result.error("验证码填写有误！");
        }
        User user = userService.login(phone, pwd);

        if (user == null) {
            return Result.error("用户名或密码错误！");
        } else {
            request.getSession().setAttribute(Constants.LOGIN_USER, user);
            return Result.success();
        }
    }

    // 退出登录
    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(Constants.LOGIN_USER);
        user.setLastLoginTime(new Date());
        userService.modify(user);
        request.getSession().removeAttribute(Constants.LOGIN_USER);
        return "redirect:/";
    }

    // 跳转“我的小金库”
    @GetMapping("myCenter")
    public String myCenter(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(Constants.LOGIN_USER);
        model.addAttribute("financeAccount", financeAccountService.queryFinanceAccount(user.getId()));
        return "myCenter";
    }
}
