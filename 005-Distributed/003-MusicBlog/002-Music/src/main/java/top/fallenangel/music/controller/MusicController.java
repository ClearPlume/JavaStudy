package top.fallenangel.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.falleanngel.music.model.entity.Music;
import top.falleanngel.music.service.IMusicService;

import java.util.List;

@Controller
@RequestMapping("music")
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @GetMapping("list")
    @ResponseBody
    public List<Music> list() {
        return musicService.list();
    }

    @GetMapping("view")
    @ResponseBody
    public String view () {
        return musicService.view();
    }
}
