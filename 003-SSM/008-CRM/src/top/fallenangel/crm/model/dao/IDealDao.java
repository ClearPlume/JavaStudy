package top.fallenangel.crm.model.dao;

import top.fallenangel.crm.model.entity.Deal;
import top.fallenangel.crm.template.ITemplateDao;

import java.util.List;
import java.util.Map;

public interface IDealDao extends ITemplateDao<Deal> {
    List<Deal> selectAll(Deal deal);

    List<Map<String, Object>> statistics();
}