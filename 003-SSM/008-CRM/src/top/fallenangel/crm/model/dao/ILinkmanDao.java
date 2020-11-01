package top.fallenangel.crm.model.dao;

import top.fallenangel.crm.model.entity.Linkman;
import top.fallenangel.crm.template.ITemplateDao;

import java.util.List;
import java.util.Map;

public interface ILinkmanDao extends ITemplateDao<Linkman> {
    List<Map<String, Object>> relatedLinkman(int customerId);
}