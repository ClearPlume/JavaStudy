package top.fallenangel.springboot.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.springboot.p2p.common.Constants;
import top.fallenangel.springboot.p2p.model.entity.User;
import top.fallenangel.springboot.p2p.service.IFinanceAccountService;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unused")
@Controller
@RequestMapping("finance")
public class FinanceAccountController {
    @Reference(interfaceClass = IFinanceAccountService.class, version = "1.0.0", timeout = 15000)
    private IFinanceAccountService financeAccountService;

    @ResponseBody
    @GetMapping("accountAmount")
    public Object accountAmount(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(Constants.LOGIN_USER);
        return financeAccountService.queryAccountAmount(user.getId());
    }
}
