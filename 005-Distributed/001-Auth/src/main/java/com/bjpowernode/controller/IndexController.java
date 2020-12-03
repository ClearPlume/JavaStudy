package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    /**
     * 映射首页
     */
    @RequestMapping({"/", "index"})
    String index() {
        return "index";
    }

    /**
     * 映射首页的右边
     */
    @RequestMapping("/right")
    void right() { }

    /**
     * 权限不足页面
     */
    @RequestMapping("/no_auth")
    void noAuth() { }
}
