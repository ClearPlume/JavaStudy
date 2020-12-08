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
                new Music(1, "You", "Approaching Nirvana"),
                new Music(2, "Aura", "Approaching Nirvana"),
                new Music(3, "附录情歌", "王梓钰"),
                new Music(4, "踏雪迎霜", "西皮士"),
                new Music(5, "Story of a Boy and a Girl", "SouloStar")
        );

        return musicList;
    }
}
