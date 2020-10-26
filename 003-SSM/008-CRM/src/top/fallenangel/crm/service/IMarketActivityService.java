package top.fallenangel.crm.service;

import top.fallenangel.crm.model.entity.MarketActivity;
import top.fallenangel.crm.template.ITemplateService;

import java.util.List;

public interface IMarketActivityService extends ITemplateService<MarketActivity> {
    List<MarketActivity> list(MarketActivity marketActivity);
}