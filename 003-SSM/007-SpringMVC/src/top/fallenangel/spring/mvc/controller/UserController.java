package top.fallenangel.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.spring.mvc.entity.User;
import top.fallenangel.spring.mvc.model.service.IUserService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    public static final String LOGIN_USER = "LOGIN_USER";

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("registerPage")
    public void registerPage() { }

    @ResponseBody
    @RequestMapping("checkUserExists")
    public Map<String, Object> checkUserExists(String userName) {
        User dbUser = userService.get(userName);

        Map<String, Object> result = new HashMap<>();
        result.put("exists", dbUser != null);
        return result;
    }

    @RequestMapping("register")
    public String register(User user, HttpSession session) {
        userService.save(user);
        session.setAttribute(LOGIN_USER, user);
        return "forward:/index";
    }

    @RequestMapping("loginPage")
    public void loginPage() { }

    @RequestMapping("login")
    public String login(User user, HttpSession session) {
        User dbUser = userService.get(user.getUserName(), user.getUserPwd());

        if (dbUser == null) {
            user.setMsg("登录失败，用户名或密码错误！");
            return "forward:/user/loginPage";
        }
        session.setAttribute(LOGIN_USER, dbUser);
        return "redirect:/index";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute(LOGIN_USER);
        session.invalidate();
        return "redirect:/index";
    }
}