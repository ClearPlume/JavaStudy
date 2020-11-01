package top.fallenangel.crm.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fallenangel.crm.model.dao.IDealDao;
import top.fallenangel.crm.model.entity.Deal;
import top.fallenangel.crm.model.entity.DealStage;
import top.fallenangel.crm.service.IDealService;
import top.fallenangel.crm.service.IDealStageService;
import top.fallenangel.crm.template.ITemplateDao;
import top.fallenangel.crm.template.impl.TemplateService;
import top.fallenangel.crm.util.Util;

import java.util.*;

@Service
public class DealService extends TemplateService<Deal> implements IDealService {
    private final IDealStageService dealStageService;
    private final IDealDao dealDao;

    public DealService(IDealStageService dealStageService, IDealDao dealDao) {
        this.dealStageService = dealStageService;
        this.dealDao = dealDao;
    }

    @Override
    public ITemplateDao<Deal> getDao() {
        return dealDao;
    }

    @Override
    public Deal edit(Integer id) {
        Deal deal;
        if (id == null) {
            deal = new Deal();
        } else {
            deal = dealDao.selectByPrimaryKey(id);
            deal.setDealStages(dealStageService.list(deal.getDealId()).toArray(new DealStage[0]));
        }
        return deal;
    }

    @Override
    @Transactional
    public int save(Deal record) {
        int result;

        if (record.getDealId() == null) {
            record.setDealNo(Util.getDealNo());
            result = super.save(record);
        } else {
            result = super.update(record);
            dealStageService.delete(record.getDealId());
        }
        dealStageService.save(record.getDealId(), record.getDealStages());
        return result;
    }

    @Override
    public List<Deal> list(Deal deal) {
        List<Deal> deals = dealDao.selectAll(deal);

        for (Deal dealDB : deals) {
            dealDB.setDealStages(dealStageService.list(dealDB.getDealId()).toArray(new DealStage[]{}));
        }
        return deals;
    }

    @Override
    public Map<String, Object> statistics() {
        Map<String, Object> result = new HashMap<>();
        Set<String> dealTypeSet = new LinkedHashSet<>();
        List<List<Integer>> dataList = new ArrayList<>();

        result.put("dealTypeSet", dealTypeSet);
        result.put("dataList", dataList);

        dealTypeSet.add("'product'");

        List<Map<String, Object>> statistics = dealDao.statistics();
        List<Integer> data = null;
        String month = "";

        for (Map<String, Object> statistic : statistics) {
            dealTypeSet.add('\'' + statistic.get("type").toString() + '\'');

            if (!month.equals(statistic.get("month").toString())) {
                data = new ArrayList<>();
                dataList.add(data);
                month = statistic.get("month").toString();
            }
            assert data != null;
            data.add(((Long) statistic.get("count")).intValue());
        }
        return result;
    }
}