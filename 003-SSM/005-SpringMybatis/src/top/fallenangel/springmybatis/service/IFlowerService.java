package top.fallenangel.springmybatis.service;

import top.fallenangel.springmybatis.model.bean.Flower;
import top.fallenangel.springmybatis.model.bean.FlowerVO;

import java.util.List;

public interface IFlowerService {
    void save(Flower flower);

    void delete(Integer fId);

    void modify(Flower flower);

    Flower get(Integer fId);

    List<Flower> list();

    List<Flower> listVO(FlowerVO flowerVO);
}