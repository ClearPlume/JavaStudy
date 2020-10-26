package top.fallenangel.crm.model.dao;

import top.fallenangel.crm.model.entity.ActivityRemark;
import top.fallenangel.crm.template.ITemplateDao;

import java.util.List;

public interface IActivityRemarkDao extends ITemplateDao<ActivityRemark> {
    List<ActivityRemark> selectAll(int id);
}