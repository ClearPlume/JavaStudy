package top.fallenangel.crm.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.crm.model.dao.IDealStageDao;
import top.fallenangel.crm.model.entity.DealStage;
import top.fallenangel.crm.model.entity.Employee;
import top.fallenangel.crm.service.IDealStageService;
import top.fallenangel.crm.template.ITemplateDao;
import top.fallenangel.crm.template.impl.TemplateService;
import top.fallenangel.crm.util.Util;

import java.util.Date;
import java.util.List;

@Service
public class DealStageService extends TemplateService<DealStage> implements IDealStageService {
    private final IDealStageDao dealStageDao;

    public DealStageService(IDealStageDao dealStageDao) {
        this.dealStageDao = dealStageDao;
    }

    @Override
    public ITemplateDao<DealStage> getDao() {
        return dealStageDao;
    }

    @Override
    public int save(int dealId, DealStage[] dealStages) {
        Employee loginEmployee = Util.getEmployeeFromSession();
        Date now = new Date();

        for (DealStage dealStage : dealStages) {
            dealStage.setDealId(dealId);
            dealStage.setCreator(loginEmployee);
            dealStage.setCreateTime(now);
            dealStage.setUpdater(loginEmployee);
            dealStage.setUpdateTime(now);
        }
        return dealStageDao.insertBatch(dealStages);
    }

    @Override
    public int delete(int id) {
        return dealStageDao.deleteAllByDeal(id);
    }

    @Override
    public List<DealStage> list(int dealId) {
        return dealStageDao.selectAll(dealId);
    }
}