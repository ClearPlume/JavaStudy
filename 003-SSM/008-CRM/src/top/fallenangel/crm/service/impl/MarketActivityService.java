package top.fallenangel.crm.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.crm.model.dao.IMarketActivityDao;
import top.fallenangel.crm.model.entity.MarketActivity;
import top.fallenangel.crm.service.IMarketActivityService;
import top.fallenangel.crm.template.ITemplateDao;
import top.fallenangel.crm.template.impl.TemplateService;

import java.util.List;

@Service
public class MarketActivityService extends TemplateService<MarketActivity> implements IMarketActivityService {
    private final IMarketActivityDao marketActivityDao;

    public MarketActivityService(IMarketActivityDao marketActivityDao) {
        this.marketActivityDao = marketActivityDao;
    }

    @Override
    public ITemplateDao<MarketActivity> getDao() {
        return marketActivityDao;
    }

    @Override
    public List<MarketActivity> list(MarketActivity marketActivity) {
        return marketActivityDao.selectAll(marketActivity);
    }
}