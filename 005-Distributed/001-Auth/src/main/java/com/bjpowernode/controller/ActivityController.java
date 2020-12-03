package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("activity")
public class ActivityController {
    @RequestMapping("list")
    void list() { }

    @RequestMapping("add")
    String add() {
        return "activity/edit";
    }

    @RequestMapping("save")
    String save() {
        return "redirect:/activity/list";
    }

    @RequestMapping("update")
    String update() {
        return "activity/edit";
    }

    @RequestMapping("saveUpdate")
    String saveUpdate() {
        return "redirect:/activity/list";
    }

    @RequestMapping("delete")
    String delete() {
        return "redirect:/activity/list";
    }
}
