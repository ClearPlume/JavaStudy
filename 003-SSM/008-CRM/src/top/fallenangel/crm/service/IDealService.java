package top.fallenangel.crm.service;

import top.fallenangel.crm.model.entity.Deal;
import top.fallenangel.crm.template.ITemplateService;

import java.util.List;

public interface IDealService extends ITemplateService<Deal> {
    List<Deal> list(Deal deal);

    Deal edit(Integer id);
}