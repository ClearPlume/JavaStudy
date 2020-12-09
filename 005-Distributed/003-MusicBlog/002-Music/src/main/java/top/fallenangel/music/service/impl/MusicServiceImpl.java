package top.fallenangel.music.service.impl;

import org.springframework.stereotype.Service;
import top.falleanngel.music.model.entity.Music;
import top.falleanngel.music.service.IMusicService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {

    @Override
    public List<Music> list() {

        List<Music> musicList = new ArrayList<>();

        Collections.addAll(musicList,
                // new Music(1, "You", "Approaching Nirvana"),
                // new Music(2, "Aura", "Approaching Nirvana"),
                // new Music(3, "附录情歌", "王梓钰"),
                // new Music(4, "踏雪迎霜", "西皮士"),
                // new Music(5, "Story of a Boy and a Girl", "SouloStar")
                new Music(6, "Promise for the future", "Zete"),
                new Music(7, "きみと恋のままで終われない いつも夢のままじゃいられない", "熊太kuma"),
                new Music(8, "ふわふわ♪", "牧野由依"),
                new Music(9, "干物女（weiwei）", "三无MarBlue"),
                new Music(10, "V.K克", "V.K克")
        );

        return musicList;
    }
}
