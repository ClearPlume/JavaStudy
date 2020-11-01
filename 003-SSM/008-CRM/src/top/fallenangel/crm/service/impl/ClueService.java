package top.fallenangel.crm.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.crm.model.dao.IClueDao;
import top.fallenangel.crm.model.entity.Clue;
import top.fallenangel.crm.service.IClueService;
import top.fallenangel.crm.template.ITemplateDao;
import top.fallenangel.crm.template.impl.TemplateService;

import java.util.List;

@Service
public class ClueService extends TemplateService<Clue> implements IClueService {
    private final IClueDao clueDao;

    public ClueService(IClueDao clueDao) {
        this.clueDao = clueDao;
    }

    @Override
    public ITemplateDao<Clue> getDao() {
        return clueDao;
    }

    @Override
    public List<Clue> fuzzySearch(String key) {
        return clueDao.fuzzySearch(key);
    }
}