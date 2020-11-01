package top.fallenangel.crm.model.dao;

import top.fallenangel.crm.model.entity.MarketActivity;
import top.fallenangel.crm.template.ITemplateDao;

import java.util.List;

public interface IMarketActivityDao extends ITemplateDao<MarketActivity> {
    List<MarketActivity> selectAll(MarketActivity marketActivity);

    List<Integer> statistics();
}