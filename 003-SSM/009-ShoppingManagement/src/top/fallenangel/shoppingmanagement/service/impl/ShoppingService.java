package top.fallenangel.shoppingmanagement.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.shoppingmanagement.model.dao.IShoppingDao;
import top.fallenangel.shoppingmanagement.model.entity.Shopping;
import top.fallenangel.shoppingmanagement.service.IShoppingService;

import java.util.List;

@Service
public class ShoppingService implements IShoppingService {
    private final IShoppingDao shoppingDao;

    public ShoppingService(IShoppingDao shoppingDao) {
        this.shoppingDao = shoppingDao;
    }

    @Override
    public int save(Shopping shopping) {
        return shoppingDao.insertSelective(shopping);
    }

    @Override
    public int delete(int[] id) {
        return shoppingDao.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Shopping shopping) {
        return shoppingDao.updateByPrimaryKeySelective(shopping);
    }

    @Override
    public Shopping get(int id) {
        return shoppingDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Shopping> list() {
        return shoppingDao.selectAll();
    }
}