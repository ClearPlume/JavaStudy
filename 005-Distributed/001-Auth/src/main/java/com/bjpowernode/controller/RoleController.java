package com.bjpowernode.controller;

import com.bjpowernode.entity.Role;
import com.bjpowernode.entity.RoleAuth;
import com.bjpowernode.model.service.IAuthService;
import com.bjpowernode.model.service.IRoleAuthService;
import com.bjpowernode.model.service.IRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    private final IRoleService roleService;

    private final IAuthService authService;

    private final IRoleAuthService roleAuthService;

    public RoleController(IRoleService roleService, IAuthService authService, IRoleAuthService roleAuthService) {
        this.roleService = roleService;
        this.authService = authService;
        this.roleAuthService = roleAuthService;
    }

    @GetMapping("list")
    String list(Model model) {
        List<Role> roleList = roleService.list();
        model.addAttribute("roleList", roleList);
        return "role/list";
    }

    /**
     * 新增解角色入口
     */
    @GetMapping("add")
    String add(Model model) {
        Role role = new Role();
        role.setRoleStatus(1);

        model.addAttribute("role", role);
        model.addAttribute("authList", authService.list());

        return "role/edit";
    }

    /**
     * 修改角色入口
     *
     * @param role 接收前台提交的角色数据
     */
    @GetMapping("modify")
    String modify(Model model, Role role) {
        // 根据角色id，从角色表中查询角色基本信息
        BeanUtils.copyProperties(roleService.get(role.getRoleId()), role);

        // 根据角色id，从角色权限表中查询角色所拥有的权限
        List<RoleAuth> roleAuths = roleAuthService.list(role.getRoleId());
        List<Integer> roleAuthsId = new ArrayList<>();

        for (RoleAuth roleAuth : roleAuths) {
            roleAuthsId.add(roleAuth.getAuthId());
        }
        role.setAuthIds(roleAuthsId);

        model.addAttribute("role", role);
        model.addAttribute("authList", authService.list());

        return "role/edit";
    }

    /**
     * 保存角色，对应新增角色和保存角色
     *
     * @param role 新增或保存的角色信息
     * @return 返回到角色列表页面
     */
    @PostMapping("save")
    String save(Role role) {
        // 若角色id为空，则是在新建角色
        if (role.getRoleId() == null) {
            roleService.save(role);
        } else {
            roleService.update(role);
        }
        // 角色权限信息存入角色权限表
        roleAuthService.save(role.getRoleId(), role.getAuthIds());
        return "redirect:list";
    }

    @PostMapping("delete")
    String delete(int[] roleId) {
        roleService.delete(roleId);
        return "redirect:list";
    }

    @RequestMapping("role")
    Role role(int roleId) {
        return roleService.get(roleId);
    }
}
