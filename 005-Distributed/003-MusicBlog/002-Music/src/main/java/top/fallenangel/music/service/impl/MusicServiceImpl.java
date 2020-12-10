package top.fallenangel.music.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.falleanngel.music.model.entity.Music;
import top.falleanngel.music.service.IMusicService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {

    @Value("${application-name}")
    private String view;

    @Override
    public List<Music> list() {

        List<Music> musicList = new ArrayList<>();

        Collections.addAll(musicList,
                new Music(1, "Promise for the future", "Zete"),
                new Music(2, "きみと恋のままで終われない いつも夢のままじゃいられない", "熊太kuma"),
                new Music(3, "ふわふわ♪", "牧野由依"),
                new Music(4, "干物女（weiwei）", "三无MarBlue"),
                new Music(5, "琴之翼", "V.K克")
        );

        return musicList;
    }

    @Override
    public String view() {
        return view;
    }
}
