package top.fallenangel.springboot.p2p.util;

import org.intellij.lang.annotations.Language;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则工具类
 *
 * @author FallenAngel
 */
public class RegexpUtil {
    /**
     * 使用正则表达式从字符串中截取匹配的第1个子串
     *
     * @param input 字符串
     * @param regex 正则表达式
     * @return 匹配结果。无匹配则返回null
     */
    public static String regex(String input, @Language("RegExp") String regex) {
        return regex(input, regex, 1);
    }
    /**
     * 使用正则表达式从字符串中截取匹配的第n个子串
     *
     * @param input 字符串
     * @param regex 正则表达式
     * @param num   从1起的计数
     * @return 匹配结果。无匹配则返回null
     */
    public static String regex(String input, @Language("RegExp") String regex, int num) {
        Matcher matcher = Pattern.compile(regex).matcher(input);
        if (matcher.find(0)) {
            return matcher.group(num - 1);
        }
        return null;
    }
}
