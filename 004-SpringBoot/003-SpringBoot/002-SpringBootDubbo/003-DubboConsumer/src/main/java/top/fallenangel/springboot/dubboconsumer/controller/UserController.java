package top.fallenangel.springboot.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fallenangel.springboot.dubbo_interface.IUserProviderService;

@RestController
@RequestMapping("user")
public class UserController {
    @Reference(interfaceClass = IUserProviderService.class, version = "1.0.0", timeout = 15000)
    private IUserProviderService userProviderService;

    @RequestMapping("say/{name}")
    public String say(@PathVariable("name") String name) {
        return userProviderService.say(name);
    }
}
