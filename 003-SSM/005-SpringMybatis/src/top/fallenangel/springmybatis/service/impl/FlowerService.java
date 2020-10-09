package top.fallenangel.springmybatis.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.springmybatis.model.bean.Flower;
import top.fallenangel.springmybatis.model.bean.FlowerVO;
import top.fallenangel.springmybatis.model.dao.IFlowerDao;
import top.fallenangel.springmybatis.service.IFlowerService;

import java.util.List;

@Service
public class FlowerService implements IFlowerService {
    private final IFlowerDao flowerDao;

    public FlowerService(IFlowerDao flowerDao) {this.flowerDao = flowerDao;}

    @Override
    public void save(Flower flower) {
        flowerDao.insert(flower);
    }

    @Override
    public void delete(Integer fId) {
        flowerDao.deleteByPrimaryKey(fId);
    }

    @Override
    public void modify(Flower flower) {
        flowerDao.updateByPrimaryKey(flower);
    }

    @Override
    public Flower get(Integer fId) {
        return flowerDao.selectByPrimaryKey(fId);
    }

    @Override
    public List<Flower> list() {
        return flowerDao.selectAll();
    }

    @Override
    public List<Flower> listVO(FlowerVO flowerVO) {
        return flowerDao.selectAllSelective(flowerVO);
    }
}