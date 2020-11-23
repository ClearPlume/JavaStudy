package top.fallenangel.springboot.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RechargeController {
    @GetMapping("loan/page/toRecharge")
    public String toRecharge() {
        return "toRecharge";
    }

    @PostMapping("loan/page/alipay")
    public String alipay() {
        System.out.println("-----alipay-----");
        return "toRecharge";
    }

    @PostMapping("loan/page/weixinpay")
    public String weixinpay() {
        System.out.println("-----weixinpay-----");
        return "toRecharge";
    }
}
