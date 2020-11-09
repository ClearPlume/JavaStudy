package top.fallenangel.springboot.dubbo_provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import top.fallenangel.springboot.dubbo_interface.IUserProviderService;

@org.springframework.stereotype.Service
@Service(interfaceClass = IUserProviderService.class, version = "1.0.0", timeout = 15000)
public class UserProviderService implements IUserProviderService {
    @Override
    public String say(String name) {
        return "Hello SpringBoot! This is " + name;
    }
}
