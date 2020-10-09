package top.fallenangel.springtransaction.model.dao;

import top.fallenangel.springtransaction.model.bean.Account;

public interface IAccountDao {
    int deleteByPrimaryKey(Integer aId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer aId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    int out(String aName, int aAmount);

    int in(String aName, int aAmount);
}