package top.fallenangel.web;

import top.fallenangel.bean.Classify;
import top.fallenangel.bean.Flower;
import top.fallenangel.bean.FlowerVO;
import top.fallenangel.service.IFlowerService;
import top.fallenangel.service.impl.FlowerServiceImpl;
import top.fallenangel.util.BeanUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FlowerServlet", urlPatterns = "/flower")
public class FlowerServlet extends BaseServlet {
    private final IFlowerService flowerService = new FlowerServiceImpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int pageSize = 3;
        String pageStr = req.getParameter("page");
        FlowerVO flowerVO = BeanUtil.formToBean(FlowerVO.class, req.getParameterMap());

        int page = Integer.parseInt(pageStr == null ? "1" : pageStr);
        int pages = flowerService.count(flowerVO) / pageSize + (flowerService.count(flowerVO) % pageSize == 0 ? 0 : 1);
        if (page > pages) {
            page = pages;
        }
        int pageStart = (page - 1) * pageSize;
        flowerVO.setPageStart(pageStart);
        flowerVO.setPageSize(pageSize);
        List<Map<String, Object>> flowers = flowerService.list(flowerVO);
        List<Classify> classifies = flowerService.classifies();

        req.getSession().setAttribute("flowerVO", flowerVO);
        req.getSession().setAttribute("pages", pages);
        req.getSession().setAttribute("flowers", flowers);
        req.getSession().setAttribute("curPage", page);
        req.getSession().setAttribute("classifies", classifies);

        resp.sendRedirect("/014_LastCheck/flowers.jsp");
    }

    protected void queryBeforeModify(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int f_id = Integer.parseInt(req.getParameter("f_id"));

        Map<String, Object> flower = flowerService.query(f_id);
        List<Classify> classifies = flowerService.classifies();

        req.getSession().setAttribute("flower", flower);
        req.getSession().setAttribute("classifies", classifies);

        resp.sendRedirect("/014_LastCheck/modify_flower.jsp");
    }

    protected void modify(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Flower flower = BeanUtil.formToBean(Flower.class, req.getParameterMap());

        flowerService.modify(flower);

        resp.sendRedirect("/014_LastCheck/flower?action=list");
    }

    protected void queryBeforeInsert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Classify> classifies = flowerService.classifies();

        req.getSession().setAttribute("classifies", classifies);

        resp.sendRedirect("/014_LastCheck/add_flower.jsp");
    }

    protected void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Flower flower = BeanUtil.formToBean(Flower.class, req.getParameterMap());

        flowerService.insert(flower);

        resp.sendRedirect("/014_LastCheck/flower?action=list");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] f_id = req.getParameterValues("f_id");
        int[] f_ids = new int[f_id.length];

        for (int i = 0; i < f_id.length; i++) {
            f_ids[i] = Integer.parseInt(f_id[i]);
        }
        flowerService.delete(f_ids);
        flowerService.resetF_id("tb_flower");

        String operate = URLEncoder.encode("删除", StandardCharsets.UTF_8);
        resp.sendRedirect("/014_LastCheck/operate_ok.jsp?operate=" + operate);
    }
}