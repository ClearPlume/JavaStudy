package top.fallenangel.springboot.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import top.fallenangel.springboot.p2p.common.Constants;
import top.fallenangel.springboot.p2p.config.AlipayConfig;
import top.fallenangel.springboot.p2p.model.entity.FinanceAccount;
import top.fallenangel.springboot.p2p.model.entity.RechargeRecord;
import top.fallenangel.springboot.p2p.model.entity.User;
import top.fallenangel.springboot.p2p.service.IFinanceAccountService;
import top.fallenangel.springboot.p2p.service.IRechargeService;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RechargeController {
    @Reference(interfaceClass = IRechargeService.class, version = "1.0.0", timeout = 15000)
    private IRechargeService rechargeService;

    @Reference(interfaceClass = IFinanceAccountService.class, version = "1.0.0", timeout = 15000)
    private IFinanceAccountService financeAccountService;

    @GetMapping("loan/page/toRecharge")
    public String toRecharge() {
        return "toRecharge";
    }

    @GetMapping("newWindow")
    public void newWindowForRecharge() { }

    @PostMapping("loan/page/alipay")
    public String alipay(HttpServletRequest request, Model model, Double rechargeMoney) {
        /*
         * 支付宝支付流程：
         *   1、用户选择支付宝
         *   2、生成订单，插入数据库
         *   3、携带参数(订单编号、订单名称、付款金额、商品描述、销售产品码)请求支付宝alipay.trade.page.pay接口
         *   4、接收返回结果，将用户重定向到支付登录界面
         *   5、用户支付结束，支付宝以GET方式请求return_url，返回同步返回参数
         *   6、调用支付宝alipay.trade.query接口(订单编号)，获取交易及支付信息
         */
        User user = (User) request.getSession().getAttribute(Constants.LOGIN_USER);
        RechargeRecord rechargeRecord = rechargeService.generateRechargeRecord(user.getId(), rechargeMoney);
        model.addAttribute("rechargeRecord", rechargeRecord);
        return "toAlipay";
    }

    @GetMapping("pay/alipayBack")
    public String alipayBack(HttpServletRequest request, Model model) throws Exception {
        //获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (String name : requestParams.keySet()) {
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            valueStr = new String(valueStr.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            params.put(name, valueStr);
        }
        // 调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        boolean success = false;
        if (signVerified) {
            // 初始化AlipayClient
            AlipayClient alipay = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

            // 设置请求参数
            AlipayTradeQueryRequest queryRequest = new AlipayTradeQueryRequest();
            String outTradeNo = new String(request.getParameter("out_trade_no").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            queryRequest.setBizContent("{\"out_trade_no\":\"" + outTradeNo + "\"}");

            // 交易以及支付信息
            AlipayTradeQueryResponse queryResponse = alipay.execute(queryRequest);
            model.addAttribute("queryResponse", queryResponse);

            RechargeRecord record = rechargeService.getRechargeRecordByNo(outTradeNo);

            if (queryResponse.getCode().equals("10000")) {
                if (queryResponse.getTradeStatus().equals("TRADE_SUCCESS")) {
                    success = true;
                    record.setRechargeStatus("1");

                    User user = (User) request.getSession().getAttribute(Constants.LOGIN_USER);
                    FinanceAccount financeAccount = financeAccountService.queryFinanceAccount(user.getId());
                    financeAccount.setAvailableMoney(financeAccount.getAvailableMoney() + Double.parseDouble(request.getParameter("total_amount")));
                    int num = financeAccountService.updateFinanceAccount(financeAccount);
                    if (num < 1) {
                        success = false;
                    }
                }
            }
            record.setRechargeStatus(success ? "1" : "2");
            int num = rechargeService.updateRecharge(record);
            if (num < 1) {
                success = false;
            }
        }
        model.addAttribute("success", success);
        return "alipayBack";
    }

    @GetMapping("pay/ailipay/refund")
    public String alipayRefund(Model model, String rechargeNo) {
        // 查询订单信息
        RechargeRecord rechargeRecord = rechargeService.getRechargeRecordByNo(rechargeNo);

        // 初始化AlipayClient
        AlipayClient alipay = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        // 设置请求参数
        AlipayTradeRefundRequest refundRequest = new AlipayTradeRefundRequest();
        refundRequest.setBizContent("{\"out_trade_no\":\"" + rechargeNo + "\"," +
                "\"refund_amount\":\"" + rechargeRecord.getRechargeMoney() + "\"" +
                "}");

        // 退款信息
        AlipayTradeRefundResponse refundResponse;
        boolean refundSuccess = false;
        try {
            refundResponse = alipay.execute(refundRequest);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            model.addAttribute("success", false);
            return "alipayRefundResult";
        }
        if (refundResponse.isSuccess()) {
            if (refundResponse.getFundChange().equals("Y")) {
                AlipayTradeFastpayRefundQueryRequest refundQueryRequest = new AlipayTradeFastpayRefundQueryRequest();
                refundQueryRequest.setBizContent("{\"out_trade_no\":\"" + rechargeNo + "\"," +
                        "\"out_request_no\":\"" + rechargeNo + "\""
                        + "}");
                AlipayTradeFastpayRefundQueryResponse refundQueryResponse;
                try {
                    refundQueryResponse = alipay.execute(refundQueryRequest);
                } catch (AlipayApiException e) {
                    e.printStackTrace();
                    model.addAttribute("success", false);
                    return "alipayRefundResult";
                }
                if (refundQueryResponse.isSuccess()) {
                    if (refundQueryResponse.getCode().equals("10000")) {
                        String refundStatus = refundQueryResponse.getRefundStatus();
                        if (refundStatus == null || refundStatus.equals("REFUND_SUCCESS")) {
                            refundSuccess = true;

                            // 更新帐户余额
                            FinanceAccount financeAccount = financeAccountService.queryFinanceAccount(rechargeRecord.getUid());
                            financeAccount.setAvailableMoney(financeAccount.getAvailableMoney() - rechargeRecord.getRechargeMoney());
                            financeAccountService.updateFinanceAccount(financeAccount);
                        }
                    }
                }
            }
        }
        model.addAttribute("success", refundSuccess);
        return "alipayRefundResult";
    }

    @PostMapping("loan/page/weixinpay")
    public String weixinpay() {
        return "toRecharge";
    }

    @GetMapping("loan/myRecharge")
    public String myRecharge(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(Constants.LOGIN_USER);
        model.addAttribute("recharges", rechargeService.queryLastRecharges(user.getId(), 10));
        return "myRecharge";
    }
}
