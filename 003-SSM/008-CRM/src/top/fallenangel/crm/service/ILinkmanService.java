package top.fallenangel.crm.service;

import top.fallenangel.crm.model.entity.Linkman;
import top.fallenangel.crm.template.ITemplateService;

import java.util.List;
import java.util.Map;

public interface ILinkmanService extends ITemplateService<Linkman> {
    List<Map<String, Object>> relatedLinkman(int customerId);
}