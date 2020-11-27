package top.fallenangel.springboot.p2p;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import top.fallenangel.springboot.p2p.config.AlipayConfig;
import top.fallenangel.springboot.p2p.model.entity.RechargeRecord;

@Controller
public class PayController {
    @PostMapping("pay/alipay")
    public String alipay(RechargeRecord rechargeRecord, Model model) throws Exception {
        // 初始化AlipayClient
        AlipayClient alipay = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        // 设置请求参数
        AlipayTradePagePayRequest queryRequest = new AlipayTradePagePayRequest();
        queryRequest.setReturnUrl(AlipayConfig.return_url);
        queryRequest.setBizContent("{\"out_trade_no\":\"" + rechargeRecord.getRechargeNo() + "\","
                + "\"subject\":\"" + rechargeRecord.getRechargeNo() + "\","
                + "\"total_amount\":\"" + rechargeRecord.getRechargeMoney() + "\","
                + "\"body\":\"" + rechargeRecord.getRechargeDesc() + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        // 发起请求
        String redirectToAlipay = alipay.pageExecute(queryRequest).getBody();
        model.addAttribute("alipay", redirectToAlipay);
        return "toAlipay";
    }
}
