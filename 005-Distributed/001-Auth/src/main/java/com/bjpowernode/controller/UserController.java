package com.bjpowernode.controller;

import com.bjpowernode.model.entity.Role;
import com.bjpowernode.model.entity.User;
import com.bjpowernode.service.*;
import org.springframework.beans.BeanUtils;
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
    // 用户服务
    private final IUserService userService;

    // 权限服务
    private final IAuthService authService;

    // 角色服务
    private final IRoleService roleService;

    // 用户权限服务
    private final IUserAuthService userAuthService;

    // 用户角色服务
    private final IUserRoleService userRoleService;

    public UserController(IUserService userService, IAuthService authService, IRoleService roleService, IUserAuthService userAuthService, IUserRoleService userRoleService) {
        this.userService = userService;
        this.authService = authService;
        this.roleService = roleService;
        this.userAuthService = userAuthService;
        this.userRoleService = userRoleService;
    }

    @GetMapping("list")
    String list(Model model) {
        List<User> userList = userService.list();
        model.addAttribute("userList", userList);
        return "user/list";
    }

    @GetMapping("edit")
    String edit(Model model, User user) {
        if (user.getUserId() != null) {
            BeanUtils.copyProperties(userService.get(user.getUserId()), user);
        }
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
        return "redirect:/user/list";
    }

    @PostMapping("delete")
    String delete(int[] userId) {
        userService.delete(userId);
        return "redirect:/user/list";
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
    String saveAuth(int userId, int[] authIds, int[] roleIds) {
        // 保存用户权限
        userAuthService.update(userId, authIds);

        // 保存用户角色
        userRoleService.update(userId, roleIds);
        return "redirect:/user/list";
    }
}
