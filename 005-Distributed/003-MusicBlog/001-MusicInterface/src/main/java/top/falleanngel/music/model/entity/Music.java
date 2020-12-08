package top.falleanngel.music.model.entity;

import java.io.Serializable;

public class Music implements Serializable {
    private Integer id;
    private String name;
    private String singer;

    public Music() {
    }

    public Music(Integer id, String name, String singer) {
        this.id = id;
        this.name = name;
        this.singer = singer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
