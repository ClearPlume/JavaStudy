package top.fallenangel.crm.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.DigestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.fallenangel.crm.model.entity.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Util {
    public static String dateFormat(Date date, String pattern) {
        return date == null ? "" : new SimpleDateFormat(pattern).format(date);
    }

    public static String md5(String src) {
        return DigestUtils.md5DigestAsHex(src.getBytes());
    }

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static void putObjectInSession(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static void removeObjectFromSession(String key) {
        getSession().removeAttribute(key);
    }

    public static Employee getEmployeeFromSession() {
        return (Employee) getSession().getAttribute(Constants.LOGIN_EMPLOYEE);
    }

    public static Integer getEmployeeIdFromSession() {
        return getEmployeeFromSession().getEmployeeId();
    }

    public static ServletContext getServletContext() {
        return getRequest().getServletContext();
    }

    public static Map<DictionaryType, Map<Integer, Dictionary>> getDictionariesFromApplication() {
        //noinspection unchecked
        return (Map<DictionaryType, Map<Integer, Dictionary>>) getServletContext().getAttribute(Constants.DICTIONARIES_IN_APPLICATION);
    }

    public static DictionaryType getDictionaryTypeFromApplication(int type) {
        Map<DictionaryType, Map<Integer, Dictionary>> dictionaries = getDictionariesFromApplication();
        DictionaryType dt = new DictionaryType();

        for (DictionaryType dictionaryType : dictionaries.keySet()) {
            if (dictionaryType.getDictionaryTypeId() == type) {
                dt = dictionaryType;
                break;
            }
        }
        return dt;
    }

    public static Map<Integer, Dictionary> getDictionariesByTypeCodeFromApplication(String code) {
        Map<DictionaryType, Map<Integer, Dictionary>> dictionaries = getDictionariesFromApplication();
        DictionaryType dt = new DictionaryType();

        for (DictionaryType dictionaryType : dictionaries.keySet()) {
            if (dictionaryType.getDictionaryTypeCode().equals(code)) {
                dt = dictionaryType;
                break;
            }
        }
        return dictionaries.get(dt);
    }

    public static Map<Integer, Dictionary> getDictionariesFromApplicationByType(int dictionaryTypeId) {
        Map<DictionaryType, Map<Integer, Dictionary>> dictionaries = getDictionariesFromApplication();
        @SuppressWarnings("unchecked") final Map<Integer, Dictionary>[] dictionaryMap = new Map[]{new LinkedHashMap<>()};

        AtomicBoolean found = new AtomicBoolean(false);
        dictionaries.forEach((dt, d) -> {
            if (!found.get()) {
                if (dt.getDictionaryTypeId() == dictionaryTypeId) {
                    dictionaryMap[0] = dictionaries.get(dt);
                    found.set(true);
                }
            }
        });
        return dictionaryMap[0];
    }

    public static Dictionary getDictionaryFromApplicationById(int id) {
        Map<DictionaryType, Map<Integer, Dictionary>> dictionaries = getDictionariesFromApplication();
        Dictionary dictionary = new Dictionary();

        for (DictionaryType dictionaryType : dictionaries.keySet()) {
            Map<Integer, Dictionary> dictionaryMap = getDictionariesFromApplicationByType(dictionaryType.getDictionaryTypeId());

            if (dictionaryMap.containsKey(id)) {
                dictionary = dictionaryMap.get(id);
                break;
            }
        }
        return dictionary;
    }

    public static Map<Integer, Dept> getDeptsFromApplication() {
        //noinspection unchecked
        return (Map<Integer, Dept>) getServletContext().getAttribute(Constants.DEPTS_IN_APPLICATION);
    }

    public static String getDealNo() {
        //noinspection SpellCheckingInspection
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return format.format(new Date()) + randNum(15);
    }

    public static String randNum(int n) {
        StringBuilder num = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            num.append(random.nextInt(10));
        }

        return num.toString();
    }

    public static DealStage getCurrStage(Deal deal) {
        DealStage curr = null;

        for (DealStage dealStage : deal.getDealStages()) {
            if (dealStage.getStageCurrent()) {
                curr = dealStage;
                break;
            }
        }
        return curr;
    }

    public static String parseJSON(Object obj) {
        String json = "";
        try {
            json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}