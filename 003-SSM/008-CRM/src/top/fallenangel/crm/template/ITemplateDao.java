package top.fallenangel.crm.template;

import top.fallenangel.crm.template.impl.BaseEntity;

import java.util.List;

public interface ITemplateDao<T extends BaseEntity> {
    int insert(T record);

    int insertSelective(T record);

    int deleteByPrimaryKey(Integer[] id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    T selectByPrimaryKey(Integer id);

    List<T> selectAll();
}