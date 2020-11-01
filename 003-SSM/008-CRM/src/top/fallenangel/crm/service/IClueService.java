package top.fallenangel.crm.service;

import top.fallenangel.crm.model.entity.Clue;
import top.fallenangel.crm.template.ITemplateService;

import java.util.List;

public interface IClueService extends ITemplateService<Clue> {
    List<Clue> fuzzySearch(String key);
}