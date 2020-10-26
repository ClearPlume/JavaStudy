package top.fallenangel.crm.service;

import top.fallenangel.crm.model.entity.ActivityRemark;
import top.fallenangel.crm.template.ITemplateService;

import java.util.List;

public interface IActivityRemarkService extends ITemplateService<ActivityRemark> {
    List<ActivityRemark> list(int id);
}