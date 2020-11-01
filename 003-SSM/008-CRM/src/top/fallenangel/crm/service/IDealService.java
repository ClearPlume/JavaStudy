package top.fallenangel.crm.service;

import top.fallenangel.crm.model.entity.Deal;
import top.fallenangel.crm.template.ITemplateService;

import java.util.List;
import java.util.Map;

public interface IDealService extends ITemplateService<Deal> {
    List<Deal> list(Deal deal);

    Deal edit(Integer id);

    Map<String, Object> statistics();
}