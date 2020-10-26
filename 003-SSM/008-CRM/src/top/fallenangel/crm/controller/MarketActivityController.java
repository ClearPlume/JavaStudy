package top.fallenangel.crm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.fallenangel.crm.model.entity.ActivityRemark;
import top.fallenangel.crm.model.entity.MarketActivity;
import top.fallenangel.crm.service.IActivityRemarkService;
import top.fallenangel.crm.service.IMarketActivityService;
import top.fallenangel.crm.template.ITemplateService;
import top.fallenangel.crm.template.impl.TemplateController;

import java.util.ArrayList;

@Controller
@RequestMapping("activity")
public class MarketActivityController extends TemplateController<MarketActivity> {
    private final IMarketActivityService marketActivityService;
    private final IActivityRemarkService activityRemarkService;

    public MarketActivityController(IMarketActivityService marketActivityService, IActivityRemarkService activityRemarkService) {
        this.marketActivityService = marketActivityService;
        this.activityRemarkService = activityRemarkService;
    }

    @Override
    public ITemplateService<MarketActivity> getService() {
        return marketActivityService;
    }

    @Override
    public MarketActivity getInstance() {
        return new MarketActivity();
    }

    @Override
    public Integer getInstanceId(MarketActivity entity) {
        return entity.getActivityId();
    }

    @RequestMapping("list")
    public PageInfo<MarketActivity> list(MarketActivity marketActivity, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return PageInfo.of(marketActivityService.list(marketActivity));
    }

    @RequestMapping("edit")
    public MarketActivity edit(Integer id, ArrayList<ActivityRemark> remarks) {
        remarks.addAll(activityRemarkService.list(id));
        return super.edit(id);
    }

    @Override
    @RequestMapping("save")
    public String save(MarketActivity entity) {
        String viewName;
        if (entity.getActivityId() == null) {
            marketActivityService.save(entity);
            viewName = "redirect:/activity/list";
        } else {
            marketActivityService.update(entity);
            viewName = "redirect:/activity/edit?id=" + entity.getActivityId();
        }
        return viewName;
    }

    @Override
    @RequestMapping("delete")
    public String delete(Integer[] id) {
        return super.delete(id);
    }
}