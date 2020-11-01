package top.fallenangel.crm.model.dao;

import top.fallenangel.crm.model.entity.DealStage;
import top.fallenangel.crm.template.ITemplateDao;

import java.util.List;

public interface IDealStageDao extends ITemplateDao<DealStage> {
    int insertBatch(DealStage[] dealStages);

    int deleteAllByDeal(int id);

    List<DealStage> selectAll(int dealId);
}