package top.fallenangel.crm.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.crm.model.dao.ILinkmanDao;
import top.fallenangel.crm.model.entity.Linkman;
import top.fallenangel.crm.service.ILinkmanService;
import top.fallenangel.crm.template.ITemplateDao;
import top.fallenangel.crm.template.impl.TemplateService;

import java.util.List;
import java.util.Map;

@Service
public class LinkmanService extends TemplateService<Linkman> implements ILinkmanService {
    private final ILinkmanDao linkmanDao;

    public LinkmanService(ILinkmanDao linkmanDao) {
        this.linkmanDao = linkmanDao;
    }

    @Override
    public ITemplateDao<Linkman> getDao() {
        return linkmanDao;
    }

    @Override
    public List<Map<String, Object>> relatedLinkman(int customerId) {
        return linkmanDao.relatedLinkman(customerId);
    }
}