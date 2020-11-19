package top.fallenangel.springboot.p2p.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public final class JsonUtil {
    private final ObjectMapper mapper;
    private JsonNode node;

    private JsonUtil(ObjectMapper mapper) {
        this.mapper = mapper;
        node = null;
    }

    /**
     * 解析JSON字符串
     *
     * @param data JSON字符串
     * @throws Exception JSON解析出错时
     */
    public void parseJson(String data) throws Exception {
        node = mapper.readTree(data);
    }

    /**
     * 从Json字符串中获取String变量
     *
     * @param fieldName 变量名
     * @return 变量值。若不存在，则返回空字符串
     */
    public String getString(String fieldName) {
        return node.path(fieldName).asText();
    }
}
