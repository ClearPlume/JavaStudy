package top.fallenangel.service.impl;

import top.fallenangel.bean.Classify;
import top.fallenangel.bean.Flower;
import top.fallenangel.bean.FlowerVO;
import top.fallenangel.mapper.FlowerMapper;
import top.fallenangel.service.IFlowerService;
import top.fallenangel.util.MybatisUtil;

import java.util.List;
import java.util.Map;

public class FlowerServiceImpl implements IFlowerService {
    private final FlowerMapper flowerMapper;

    {
        MybatisUtil.initial(MybatisUtil.getResource("MybatisConfig.xml"));
        flowerMapper = MybatisUtil.getMapper(FlowerMapper.class);
    }

    @Override
    public List<Map<String, Object>> list(FlowerVO flowerVO) {
        return flowerMapper.list(flowerVO);
    }

    @Override
    public int count(FlowerVO flowerVO) {
        return flowerMapper.count(flowerVO);
    }

    @Override
    public Map<String, Object> query(int f_id) {
        return flowerMapper.query(f_id);
    }

    @Override
    public List<Classify> classifies() {
        return flowerMapper.classifies();
    }

    @Override
    public void insert(Flower flower) {
        flowerMapper.insert(flower);
    }

    @Override
    public void delete(int[] f_id) {
        flowerMapper.delete(f_id);
    }

    @Override
    public void resetF_id(String tb_name) {
        flowerMapper.resetF_id(tb_name);
    }

    @Override
    public void modify(Flower flower) {
        flowerMapper.modify(flower);
    }
}