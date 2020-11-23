package top.fallenangel.springboot.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import top.fallenangel.springboot.p2p.service.IBidInfoService;
import top.fallenangel.springboot.p2p.service.ILoanInfoService;
import top.fallenangel.springboot.p2p.service.IUserService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    @Reference(interfaceClass = ILoanInfoService.class, version = "1.0.0", timeout = 15000)
    private ILoanInfoService loanInfoService;

    @Reference(interfaceClass = IUserService.class, version = "1.0.0", timeout = 15000)
    private IUserService userService;

    @Reference(interfaceClass = IBidInfoService.class, version = "1.0.0", timeout = 15000)
    private IBidInfoService bidInfoService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("avgRate", loanInfoService.queryAvgRate());
        model.addAttribute("totalUser", userService.queryTotalUser());
        model.addAttribute("totalDealMoney", bidInfoService.queryTotalDealMoney());

        Map<String, Object> param = new HashMap<>();
        // 新手宝(产品类型，查询数量)
        param.put("new", 0);
        param.put("newNum", 1);
        // 优选
        param.put("pro", 1);
        param.put("proNum", 4);
        // 散标
        param.put("all", 2);
        param.put("allNum", 8);
        model.addAttribute("productInfo", loanInfoService.queryProductInfo(param));
        return "index";
    }
}
