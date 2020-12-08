package top.fallenangel.blog.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.falleanngel.music.service.IMusicService;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List list() {
        return restTemplate.getForEntity("http://localhost:18080/music/music/list", List.class).getBody();
    }
}
