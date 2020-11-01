package top.fallenangel.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.crm.service.IDealService;
import top.fallenangel.crm.service.IMarketActivityService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("echarts")
public class EChartsController {
    private final IMarketActivityService marketActivityService;
    private final IDealService dealService;

    public EChartsController(IMarketActivityService marketActivityService, IDealService dealService) {
        this.marketActivityService = marketActivityService;
        this.dealService = dealService;
    }

    @RequestMapping("deal")
    public Map<String, Object> deal() {
        return dealService.statistics();
    }

    @RequestMapping("activity")
    public List<Integer> activity() {
        return marketActivityService.statistics();
    }
}