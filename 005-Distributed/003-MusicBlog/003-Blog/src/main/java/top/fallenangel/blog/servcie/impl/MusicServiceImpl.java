package top.fallenangel.blog.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.falleanngel.music.model.entity.Music;
import top.falleanngel.music.service.IMusicService;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${fallenangel.music.music-service}")
    private String musicServiceAddr;

    @Value("${fallenangel.music.music-view}")
    private String musicViewAddr;

    @Override
    public List<Music> list() {
        //noinspection unchecked
        return restTemplate.getForEntity(musicServiceAddr, List.class).getBody();
    }

    @Override
    public String view() {
        return restTemplate.getForEntity(musicViewAddr, String.class).getBody();
    }
}
