package top.fallenangel.crm.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.crm.model.dao.IDictionaryTypeDao;
import top.fallenangel.crm.model.entity.DictionaryType;
import top.fallenangel.crm.service.IDictionaryTypeService;
import top.fallenangel.crm.template.ITemplateDao;
import top.fallenangel.crm.template.impl.TemplateService;

@Service
public class DictionaryTypeService extends TemplateService<DictionaryType> implements IDictionaryTypeService {
    private final IDictionaryTypeDao dictionaryTypeDao;

    public DictionaryTypeService(IDictionaryTypeDao dictionaryTypeDao) {
        this.dictionaryTypeDao = dictionaryTypeDao;
    }

    @Override
    public ITemplateDao<DictionaryType> getDao() {
        return dictionaryTypeDao;
    }
}