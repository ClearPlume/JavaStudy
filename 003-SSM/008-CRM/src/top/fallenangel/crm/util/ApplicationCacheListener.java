package top.fallenangel.crm.util;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import top.fallenangel.crm.model.entity.Dept;
import top.fallenangel.crm.model.entity.Dictionary;
import top.fallenangel.crm.model.entity.DictionaryType;
import top.fallenangel.crm.service.IDeptService;
import top.fallenangel.crm.service.IDictionaryService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ApplicationCacheListener implements ServletContextListener {
    private static WebApplicationContext applicationContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 获取Application
        ServletContext servletContext = sce.getServletContext();
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        loadDeptsIntoApplication(servletContext);
        loadDictionariesMapIntoApplication(servletContext);
    }

    public static void loadDeptsIntoApplication(ServletContext servletContext) {
        IDeptService deptService = applicationContext.getBean(IDeptService.class);

        List<Dept> depts = deptService.list();
        Map<Integer, Dept> deptMap = new LinkedHashMap<>();

        for (Dept dept : depts) {
            deptMap.put(dept.getDeptId(), dept);
        }

        servletContext.setAttribute(Constants.DEPTS_IN_APPLICATION, deptMap);
    }

    public static void loadDictionariesMapIntoApplication(ServletContext servletContext) {
        IDictionaryService dictionaryService = applicationContext.getBean(IDictionaryService.class);
        List<Dictionary> dictionaries = dictionaryService.list();
        Map<DictionaryType, Map<Integer, Dictionary>> dictionaryMap = new HashMap<>();

        for (Dictionary dictionary : dictionaries) {
            DictionaryType dictionaryType = dictionary.getDictionaryType();
            Map<Integer, Dictionary> dictionaryTypeMap;

            if (dictionaryMap.containsKey(dictionaryType)) {
                dictionaryTypeMap = dictionaryMap.get(dictionaryType);
            } else {
                dictionaryTypeMap = new LinkedHashMap<>();
                dictionaryMap.put(dictionaryType, dictionaryTypeMap);
            }

            if (dictionary.getDictionaryId() != null) {
                dictionaryTypeMap.put(dictionary.getDictionaryId(), dictionary);
            }
        }

        servletContext.setAttribute(Constants.DICTIONARIES_IN_APPLICATION, dictionaryMap);
    }
}