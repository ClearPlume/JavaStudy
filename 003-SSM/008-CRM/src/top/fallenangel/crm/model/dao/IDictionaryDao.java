package top.fallenangel.crm.model.dao;

import top.fallenangel.crm.model.entity.Dictionary;
import top.fallenangel.crm.template.ITemplateDao;

import java.util.List;

public interface IDictionaryDao extends ITemplateDao<Dictionary> {
    List<Dictionary> selectAllByDictionaryTypeId(int dictionaryTypeId);
}