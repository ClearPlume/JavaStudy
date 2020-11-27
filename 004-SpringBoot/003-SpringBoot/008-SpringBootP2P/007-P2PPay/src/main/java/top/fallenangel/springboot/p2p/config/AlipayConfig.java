package top.fallenangel.springboot.p2p.config;

/**
 * 类名：AlipayConfig
 * 功能：基础配置类
 * 详细：设置帐户有关信息及返回路径
 * 修改日期：2017-04-05
 * 说明：
 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016110200787482";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCIQgTZduRox6KnllMheJgrxet/Stn9wwCGEqjuPZ5akoY0Fv8u45/tnUgjidpn+m2QdwLQqs7sRHrBNgrpYDSe75pqBp0nbiKS0XCRFLzP68hrYyiqGb/9mCfVFX+bUzf4wlU9suAU168PpBGFi+18zggiV2DcN20ThioJpzITfddPFK33vDs8pxHgvZKiVHEVE3D9tHLbnFm5Rbh5SWmdYZVYBzvW4fH6CZqgyROpKQSjGl2RagBHkPSVm0CRHmUBjkbxR2UD7mGJkNSyWTCNOus1HNNQEGlYZVbW/eonztAyeq61i91ruD7E4Z+vpWD63pt+IuRZV57norHWDKRhAgMBAAECggEAF4sww1KjzOcR19tFqfbodEfSlUAdwpc7M+9teRz0i7ndrop6tWNncutGV72uG2FOJTQrLFsXPgPnIhNwdzrEXOIR0FgsN2/0UWIXDTqEFXksPEH5+MpSPkNYPp1kWzZZ6YXKrMqHpZJPEWjMDkNLWdFP3n8yoVqCYmlAQkK9iFhmaeDd/Oya9SM4fR203Db6FzbvFHZV4xDk+MoB6l21Gnrd2wGPicDFlW6wk6tVxusBZhxDSfia4EiC1kSzISsHnNHMsybHMs84tAF+RsymAIuw0QWmi71EYQ7iKr+RXYoOr/3kAukl6uUz5WfjYQBIjb/P1XMd5BcggCeUkGm1AQKBgQD/iiSZj1rrdzuVyWIgf07sy9mjWBSmszAqUdzzPA6KPGkv1xQJ6TchpTMqH2N5hlOgdFBp+IQxJOUUfA+C+Y2Qs6BWZ2h0ZI+/kkgjkxHbB5+C2frEzN4CxUToHf5tzA3jiIiKkkUoMuRxcZaoQLWkx2fQvMhEy0LFUMAKAhHeaQKBgQCIgNy7NK/8crhPrwt2nV+e6Z7wkMs9bogJNJy0gG0SYCg5mqUCG5jsldlJqKT1gdrmdqQfCtawR5RiV8U4h/aiB7nRrmpTbH6nritAWkL5tgmywvp1kX0XTse9oP7Zp4t6C8Z284Ea86uW1D9Infdi5zm3vKztVytDOY/9GetHOQKBgB6qvHO1UYr6lysFrQILZTRjzm2c73WGAZzCkEqchX4ve8wi+qOp2lTuV3KRq8V0ympyKwhcq7ieHePUc6QbQNMBy5cy98UoIFw0OPYT+0uW4Zy5fi/KCka41+knWFZi67PHueMvZJ9LZED9CcCNa38n8xyI21vuLMgzRait0OkpAoGAceLBRldA9OhpqeGrOL04CAd2GdNUHd7YFIYWr+nuFkSvis/hF48a2Vh0PyY66rH6hgk6CMQsNkqiHCKKYw3c0XaMq8pO32dHjHKdl0U3V8tu7/wIpopJyWZq82Uc+07z6VFltdyXPHtMD7zpR5azzYqI9yitRh9R8vZVkZ9MUtECgYEAxBxM3I8tnzXjV4z9VVWBx1fXCuF3hnJok40xUi0+iAERx2NXQXcZWt/aEV6l2CuM1MRRSA8+rH7SZN0k9EhLLamTPiSbDNAFm6SKhiEQUJY2Di4B9ScEVbOHjj4FQJh7U55CMFKtP/e7VcuKGEXNth0B+CX7tWYIMb6e7dpAsuc=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAo+hlwJXl64fgZgF1oncO1sbMwy3AXPSLTrjxLZ1owuomnRgxFihxn1lsMv1Un/sqwocAGuoz8lbVJrydJMjBaDIor+ctH16MXIZKPeiUMi6pAPz8Jc9/62wMUZCyvScl4XOxjt8iZ/6+5m2yi+DtlsSZ0Ede6Y9cLdu4fOZTUEsHBjL0UjIGkgWsN3JeMfuZeCQkOi0LiMfW/JVMerKEJ3lCHXRQ+zb8j9327le0Nke3/y/zxLGOiDJJgg2JoE2Vdpxe0Xvwg8UGPMvXehXwiHDFATtg4sVNDa75ybIPDvHhccyae6O45mMlUDdZzcfZ3IZ7bUv7KHc64VsoPW+/2QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // public static String notify_url = "http://localhost:10961/alipay_war_exploded/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:18081/P2PWeb/pay/alipayBack";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
}
