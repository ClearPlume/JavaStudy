package top.fallenangel.crm.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.crm.model.dao.IDictionaryDao;
import top.fallenangel.crm.model.entity.Dictionary;
import top.fallenangel.crm.service.IDictionaryService;
import top.fallenangel.crm.template.ITemplateDao;
import top.fallenangel.crm.template.impl.TemplateService;
import top.fallenangel.crm.util.Util;

import java.util.ArrayList;
import java.util.List;

@Service
public class DictionaryService extends TemplateService<Dictionary> implements IDictionaryService {
    private final IDictionaryDao dictionaryDao;

    public DictionaryService(IDictionaryDao dictionaryDao) {
        this.dictionaryDao = dictionaryDao;
    }

    @Override
    public ITemplateDao<Dictionary> getDao() {
        return dictionaryDao;
    }

    @Override
    public List<Dictionary> list(int dictionaryTypeId) {
        return new ArrayList<>(Util.getDictionariesFromApplicationByType(dictionaryTypeId).values());
    }
}