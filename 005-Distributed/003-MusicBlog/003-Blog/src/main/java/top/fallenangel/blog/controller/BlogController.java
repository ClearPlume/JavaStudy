package top.fallenangel.blog.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.falleanngel.music.service.IMusicService;

import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("blog")
@DefaultProperties(defaultFallback = "listError")
public class BlogController {

    @Autowired
    private IMusicService musicService;

    @GetMapping("list")
    @HystrixCommand
    public String list(Model model) {

        try {
            TimeUnit.SECONDS.sleep(3);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        model.addAttribute("musicList", musicService.list());
        model.addAttribute("musicView", musicService.view());

        return "blog/list";
    }

    @GetMapping
    public String listError(Model model) {

        model.addAttribute("error", "服务超时，请重试");

        return "blog/list";
    }
}
