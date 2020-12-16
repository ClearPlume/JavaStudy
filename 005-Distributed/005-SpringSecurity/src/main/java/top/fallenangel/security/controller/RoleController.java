package top.fallenangel.security.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.security.model.entity.Role;
import top.fallenangel.security.model.entity.RoleAuth;
import top.fallenangel.security.service.IAuthService;
import top.fallenangel.security.service.IRoleAuthService;
import top.fallenangel.security.service.IRoleService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IAuthService authService;

    @Autowired
    private IRoleAuthService roleAuthService;

    @GetMapping("list")
    String list(Model model) {
        List<Role> roleList = roleService.list();
        model.addAttribute("roleList", roleList);
        return "role/list";
    }

    /**
     * 编辑角色，对应新增解角色和修改角色入口
     *
     * @param role 由Spring新建或接收前台改过的角色数据
     */
    @GetMapping("edit")
    String edit(Model model, Role role) {
        // 角色id为空，代表这是在新建角色，这个role是由Spring创建的
        if (role.getRoleId() == null) {
            role.setRoleStatus(1);
        }
        else {
            // 根据角色id，从角色表中查询角色基本信息
            BeanUtils.copyProperties(roleService.get(role.getRoleId()), role);

            // 根据角色id，从角色权限表中查询角色所拥有的权限
            List<RoleAuth> roleAuths = roleAuthService.list(role.getRoleId());
            List<Integer> roleAuthsId = new ArrayList<>();

            for (RoleAuth roleAuth : roleAuths) {
                roleAuthsId.add(roleAuth.getAuthId());
            }
            role.setAuthIds(roleAuthsId);
        }

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
        }
        else {
            roleService.update(role);
        }
        // 角色权限信息存入角色权限表
        roleAuthService.save(role.getRoleId(), role.getAuthIds());
        return "redirect:/role/list";
    }

    @PostMapping("delete")
    String delete(int[] roleId) {
        roleService.delete(roleId);
        return "redirect:/role/list";
    }

    @RequestMapping("role")
    Role role(int roleId) {
        return roleService.get(roleId);
    }
}
