package top.fallenangel.crm.service;

import top.fallenangel.crm.model.entity.Dictionary;
import top.fallenangel.crm.template.ITemplateService;

import java.util.List;

public interface IDictionaryService extends ITemplateService<Dictionary> {
    List<Dictionary> list(int dictionaryTypeId);
}