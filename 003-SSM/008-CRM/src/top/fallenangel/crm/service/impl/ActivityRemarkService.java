package top.fallenangel.crm.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.crm.model.dao.IActivityRemarkDao;
import top.fallenangel.crm.model.entity.ActivityRemark;
import top.fallenangel.crm.service.IActivityRemarkService;
import top.fallenangel.crm.template.ITemplateDao;
import top.fallenangel.crm.template.impl.TemplateService;

import java.util.List;

@Service
public class ActivityRemarkService extends TemplateService<ActivityRemark> implements IActivityRemarkService {
    private final IActivityRemarkDao activityRemarkDao;

    public ActivityRemarkService(IActivityRemarkDao activityRemarkDao) {
        this.activityRemarkDao = activityRemarkDao;
    }

    @Override
    public ITemplateDao<ActivityRemark> getDao() {
        return activityRemarkDao;
    }

    @Override
    public List<ActivityRemark> list(int id) {
        return activityRemarkDao.selectAll(id);
    }
}