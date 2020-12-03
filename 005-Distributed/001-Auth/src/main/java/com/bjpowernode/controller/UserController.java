package com.bjpowernode.controller;

import com.bjpowernode.entity.Role;
import com.bjpowernode.entity.User;
import com.bjpowernode.model.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserService userService;//用户服务

    @Autowired
    IAuthService authService;//权限服务

    @Autowired
    IRoleService roleService;//角色服务

    @Autowired
    IUserAuthService userAuthService;//用户权限服务

    @Autowired
    IUserRoleService userRoleService;//用户角色服务

    @GetMapping("list")
    String list(Model model) {
        List<User> userList = userService.list();
        model.addAttribute("userList", userList);
        return "user/list";
    }

    @GetMapping("add")
    String add(Model model, User user) {
        model.addAttribute("user", user);
        return "user/edit";
    }

    @GetMapping("modify")
    String modify(Model model, User user) {
        BeanUtils.copyProperties(userService.get(user.getUserId()), user);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @PostMapping("save")
    String save(User user) {
        if (user.getUserId() == null) {
            userService.save(user);
        } else {
            userService.update(user);
        }
        return "redirect:list";
    }

    @PostMapping("delete")
    String delete(int[] userId) {
        userService.delete(userId);
        return "redirect:list";
    }

    @GetMapping("auth")
    String auth(Model model, User user) {
        model.addAttribute("user", user);

        // 获取用户信息
        BeanUtils.copyProperties(userService.get(user.getUserId()), user);

        // 获取用户权限
        user.setAuthIds(authService.listByUser(user.getUserId()));

        // 获取用户角色
        List<Role> roleList = roleService.listByUser(user.getUserId());
        List<Integer> roleIdList = new ArrayList<>();

        for (Role role : roleList) {
            roleIdList.add(role.getRoleId());
        }
        user.setRoleIds(roleIdList);

        // 获取全部权限
        model.addAttribute("authList", authService.list());

        // 获取全部角色
        model.addAttribute("roleList", roleService.list());

        return "user/auth";
    }

    @RequestMapping("saveAuth")
    String saveAuth(User user, int[] authIds, int[] roleIds) {
        // 保存用户
        userService.update(user);

        // 保存用户权限
        userAuthService.update(user.getUserId(), authIds);

        // 保存用户角色
        userRoleService.update(user.getUserId(), roleIds);
        return "redirect:list";
    }
}
