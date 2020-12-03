package com.bjpowernode.controller;

import com.bjpowernode.entity.Auth;
import com.bjpowernode.model.service.IAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("auth")
public class AuthController {

    @Autowired
    IAuthService authService;

    @RequestMapping("list")
    String list(Model model) {
        List<Auth> authList = authService.list();
        model.addAttribute("authList", authList);
        return "auth/list";
    }

    @GetMapping("edit")
    String edit(Model model, Auth auth) {
        if (auth.getAuthId() == null) {
            auth.setAuthStatus(1);
        } else {
            BeanUtils.copyProperties(authService.get(auth.getAuthId()), auth);
        }
        model.addAttribute("auth", auth);
        return "auth/edit";
    }

    @PostMapping("save")
    String save(Auth auth) {
        if (auth.getAuthId() == null) {
            authService.save(auth);
        } else {
            authService.update(auth);
        }
        return "redirect:list";
    }

    @RequestMapping("delete")
    String delete(int[] authId) {
        authService.delete(authId);
        return "redirect:list";
    }

    @RequestMapping("auth")
    Auth auth(int authId) {
        return authService.get(authId);
    }
}
