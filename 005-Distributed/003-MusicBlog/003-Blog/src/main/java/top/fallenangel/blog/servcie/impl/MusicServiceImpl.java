package top.fallenangel.blog.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.falleanngel.music.service.IMusicService;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${fallenangel.music.music-service}")
    private String musicServiceAddr;

    @Override
    public List list() {
        return restTemplate.getForEntity(musicServiceAddr, List.class).getBody();
    }
}
