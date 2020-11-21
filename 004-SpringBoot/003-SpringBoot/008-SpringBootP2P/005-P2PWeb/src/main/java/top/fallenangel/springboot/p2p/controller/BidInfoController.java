package top.fallenangel.springboot.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.springboot.p2p.common.Constants;
import top.fallenangel.springboot.p2p.common.Result;
import top.fallenangel.springboot.p2p.model.entity.User;
import top.fallenangel.springboot.p2p.service.IBidInfoService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@SuppressWarnings("unused")
@Controller
@RequestMapping("bid")
public class BidInfoController {
    @Reference(interfaceClass = IBidInfoService.class, version = "1.0.0", timeout = 15000)
    private IBidInfoService bidInfoService;

    // 用户投资
    @ResponseBody
    @PostMapping("invest")
    public Map<String, Object> invest(HttpServletRequest request, int loanId, double bidMoney) {
        User user = (User) request.getSession().getAttribute(Constants.LOGIN_USER);

        // 是否已经登录
        if (user == null) {
            return Result.error(1, "请登录后再投资！");
        }
        return bidInfoService.invest(user.getId(), loanId, bidMoney);
    }
}
