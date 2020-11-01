package top.fallenangel.crm.model.dao;

import top.fallenangel.crm.model.entity.Deal;
import top.fallenangel.crm.template.ITemplateDao;

import java.util.List;

public interface IDealDao extends ITemplateDao<Deal> {
    List<Deal> selectAll(Deal deal);
}