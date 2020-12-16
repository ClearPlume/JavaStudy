package top.fallenangel.security.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.security.model.entity.Auth;
import top.fallenangel.security.service.IAuthService;

import java.util.List;

@Controller
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @RequestMapping("list")
    String list(Model model) {
        List<Auth> authList = authService.list();
        model.addAttribute("authList", authList);
        return "auth/list";
    }

    @GetMapping("add")
    String add(Model model) {
        Auth auth = new Auth();
        auth.setAuthStatus(1);
        model.addAttribute("auth", auth);
        return "auth/edit";
    }

    @GetMapping("modify")
    String modify(Model model, Auth auth) {
        BeanUtils.copyProperties(authService.get(auth.getAuthId()), auth);
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
        return "redirect:/auth/list";
    }

    @RequestMapping("delete")
    String delete(int[] authId) {
        authService.delete(authId);
        return "redirect:/auth/list";
    }

    @RequestMapping("auth")
    Auth auth(int authId) {
        return authService.get(authId);
    }
}
