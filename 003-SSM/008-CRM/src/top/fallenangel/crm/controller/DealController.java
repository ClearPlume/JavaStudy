package top.fallenangel.crm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.fallenangel.crm.model.entity.Deal;
import top.fallenangel.crm.service.IDealService;
import top.fallenangel.crm.template.ITemplateService;
import top.fallenangel.crm.template.impl.TemplateController;

@Controller
@RequestMapping("deal")
public class DealController extends TemplateController<Deal> {
    private final IDealService dealService;

    public DealController(IDealService dealService) {
        this.dealService = dealService;
    }

    @Override
    public ITemplateService<Deal> getService() {
        return dealService;
    }

    @Override
    public Deal getInstance() {
        return new Deal();
    }

    @Override
    public Integer getInstanceId(Deal entity) {
        return entity.getDealId();
    }

    @Override
    @RequestMapping("edit")
    public Deal edit(Integer id) {
        return dealService.edit(id);
    }

    @Override
    @RequestMapping("save")
    public String save(Deal entity) {
        dealService.save(entity);
        return "redirect:/deal/list";
    }

    @RequestMapping("list")
    public PageInfo<Deal> list(Deal deal, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return PageInfo.of(dealService.list(deal));
    }
}