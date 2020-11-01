package top.fallenangel.crm.model.dao;

import top.fallenangel.crm.model.entity.Clue;
import top.fallenangel.crm.template.ITemplateDao;

import java.util.List;

public interface IClueDao extends ITemplateDao<Clue> {
    List<Clue> fuzzySearch(String key);
}