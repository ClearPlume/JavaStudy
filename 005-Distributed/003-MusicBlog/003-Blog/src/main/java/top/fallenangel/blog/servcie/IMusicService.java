package top.fallenangel.blog.servcie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import top.falleanngel.music.model.entity.Music;

import java.util.List;

@FeignClient("${fallenangel.music.service}")
public interface IMusicService {

    @GetMapping("${fallenangel.music.music-service}")
    List<Music> list();

    @GetMapping("${fallenangel.music.music-view}")
    String view();
}
