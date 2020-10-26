package top.fallenangel.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.crm.model.entity.ActivityRemark;
import top.fallenangel.crm.service.IActivityRemarkService;
import top.fallenangel.crm.template.ITemplateService;
import top.fallenangel.crm.template.impl.TemplateController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("remark")
public class ActivityRemarkController extends TemplateController<ActivityRemark> {
    private final IActivityRemarkService activityRemarkService;

    public ActivityRemarkController(IActivityRemarkService activityRemarkService) {
        this.activityRemarkService = activityRemarkService;
    }

    @Override
    public ITemplateService<ActivityRemark> getService() {
        return activityRemarkService;
    }

    @Override
    public ActivityRemark getInstance() {
        return new ActivityRemark();
    }

    @Override
    public Integer getInstanceId(ActivityRemark entity) {
        return entity.getRemarkId();
    }

    @Override
    @RequestMapping("edit")
    @ResponseBody
    public ActivityRemark edit(Integer id) {
        return super.edit(id);
    }

    @Override
    @RequestMapping("save")
    public String save(ActivityRemark entity) {
        super.save(entity);
        String param = "?id=" + entity.getActivityId();
        return "redirect:/activity/edit" + param;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> deleteNoJump(Integer[] id) {
        Map<String, Object> result = new HashMap<>();
        try {
            super.delete(id);
            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
            e.printStackTrace();
        }
        return result;
    }
}