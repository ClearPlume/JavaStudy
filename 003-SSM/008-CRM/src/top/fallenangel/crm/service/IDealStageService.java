package top.fallenangel.crm.service;

import top.fallenangel.crm.model.entity.DealStage;
import top.fallenangel.crm.template.ITemplateService;

import java.util.List;

public interface IDealStageService extends ITemplateService<DealStage> {
    int save(int dealId, DealStage[] dealStages);

    int delete(int id);

    List<DealStage> list(int dealId);
}