package top.fallenangel.springboot.p2p.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.springboot.p2p.config.AlipayConfig;
import top.fallenangel.springboot.p2p.model.entity.RechargeRecord;
import top.fallenangel.springboot.p2p.util.HttpClientUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("pay/wxQRCode")
    @ResponseBody
    public Object wxQRCode(RechargeRecord record) throws Exception {
        Map<String, String> param = new HashMap<>();

        param.put("appid", "wx8a3fcf509313fd74");
        param.put("mch_id", "1361137902");
        param.put("nonce_str", WXPayUtil.generateNonceStr());
        param.put("body", "动力金融网 - 余额充值");
        param.put("out_trade_no", record.getRechargeNo());
        BigDecimal feeDecimal = BigDecimal.valueOf(record.getRechargeMoney());
        param.put("total_fee", String.valueOf(feeDecimal.multiply(new BigDecimal(100)).intValue()));
        param.put("spbill_create_ip", "127.0.0.1");
        param.put("notify_url", "fallenangel.top");
        param.put("trade_type", "NATIVE");
        param.put("product_id", record.getRechargeNo());
        param.put("sign", WXPayUtil.generateSignature(param, "367151c5fd0d50f1e34a68a802d6bbca"));

        String xmlParam = WXPayUtil.mapToXml(param);
        return WXPayUtil.xmlToMap(HttpClientUtil.doPost("https://api.mch.weixin.qq.com/pay/unifiedorder", xmlParam));
    }
}
