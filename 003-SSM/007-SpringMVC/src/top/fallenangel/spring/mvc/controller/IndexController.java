package top.fallenangel.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

@Controller
public class IndexController {
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setView(new InternalResourceView("/index.jsp"));
        return view;
    }
}