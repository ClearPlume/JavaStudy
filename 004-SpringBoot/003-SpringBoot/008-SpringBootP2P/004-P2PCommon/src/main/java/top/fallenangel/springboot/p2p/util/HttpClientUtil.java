package top.fallenangel.springboot.p2p.util;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    private static final CloseableHttpClient client;
    private static CloseableHttpResponse response;

    static {
        client = HttpClients.createDefault();
        response = null;
    }

    /**
     * 发送Get请求
     *
     * @param url 请求地址
     * @return 响应结果
     */
    public static String doGet(String url) throws IOException {
        HttpGet get = new HttpGet(url);
        response = client.execute(get);
        return EntityUtils.toString(response.getEntity());
    }

    /**
     * 发送Post请求
     *
     * @param url   请求地址
     * @param param 请求参数
     * @return 响应结果
     */
    public static String doPost(String url, Map<String, Object> param) throws IOException {
        HttpPost post = new HttpPost(url);
        setParam(post, param);
        response = client.execute(post);
        return EntityUtils.toString(response.getEntity());
    }

    /**
     * 为请求设置参数
     *
     * @param request 请求
     * @param param   参数
     */
    private static void setParam(HttpEntityEnclosingRequest request, Map<String, Object> param) {
        if (param != null && param.size() > 0) {
            List<NameValuePair> pairList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : param.entrySet()) {
                pairList.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }
            request.setEntity(new UrlEncodedFormEntity(pairList, StandardCharsets.UTF_8));
        }
    }
}
