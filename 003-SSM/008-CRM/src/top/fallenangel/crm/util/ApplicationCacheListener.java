package top.fallenangel.crm.util;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import top.fallenangel.crm.model.entity.Dept;
import top.fallenangel.crm.service.IDeptService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ApplicationCacheListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 获取Application
        ServletContext servletContext = sce.getServletContext();

        // 获取IOC容器
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        assert applicationContext != null;

        /*
         * 获取数据
         */
        // 获取Service
        IDeptService deptService = applicationContext.getBean(IDeptService.class);

        // 查询数据
        List<Dept> depts = deptService.list();
        Map<Integer, Dept> deptMap = new LinkedHashMap<>();

        for (Dept dept : depts) {
            deptMap.put(dept.getDeptId(), dept);
        }

        // 将数据存入Application
        servletContext.setAttribute(Constants.DEPTS_IN_APPLICATION, deptMap);
    }
}