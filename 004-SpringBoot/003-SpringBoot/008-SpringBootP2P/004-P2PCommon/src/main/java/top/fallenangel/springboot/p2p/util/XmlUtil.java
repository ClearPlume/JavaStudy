package top.fallenangel.springboot.p2p.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.intellij.lang.annotations.Language;
import org.springframework.stereotype.Component;

@Component
public final class XmlUtil {
    private Document document;

    /**
     * 解析XML字符串
     *
     * @param data 字符串
     * @throws Exception XML解析出错时
     */
    public void parseXml(String data) throws Exception {
        document = DocumentHelper.parseText(data);
    }

    /**
     * 获取匹配规则的单个节点的文本
     *
     * @param xpathExpression 规则
     * @return 节点
     */
    public String getElementText(@Language("XPath") String xpathExpression) {
        return document.selectSingleNode(xpathExpression).getText();
    }
}
