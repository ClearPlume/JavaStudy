package top.fallenangel.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.falleanngel.music.service.IMusicService;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private IMusicService musicService;

    @GetMapping("list")
    public String list(Model model) {

        model.addAttribute("musicList", musicService.list());

        return "blog/list";
    }
}
