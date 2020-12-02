package com.bjpowernode.controller;

import com.bjpowernode.entity.Role;
import com.bjpowernode.model.service.IRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("activity")
public class ActivityController {


    @RequestMapping("list")
    void list(){
    }

    @RequestMapping("add")
    String add(){

        return "activity/edit";
    }

    @RequestMapping("save")
    String save(){

        return "redirect:list";
    }

    @RequestMapping("update")
    String update(){

        return "activity/edit";
    }

    @RequestMapping("saveUpdate")
    String saveUpdate(){

        return "redirect:list";
    }

    @RequestMapping("delete")
    String delete(){

        return "redirect:list";
    }

}
