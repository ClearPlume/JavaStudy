package top.fallenangel.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.crm.model.entity.Clue;
import top.fallenangel.crm.service.IClueService;
import top.fallenangel.crm.template.ITemplateService;
import top.fallenangel.crm.template.impl.TemplateController;

import java.util.List;

@Controller
@RequestMapping("clue")
public class ClueController extends TemplateController<Clue> {
    private final IClueService clueService;

    public ClueController(IClueService clueService) {
        this.clueService = clueService;
    }

    @Override
    public ITemplateService<Clue> getService() {
        return clueService;
    }

    @Override
    public Clue getInstance() {
        return new Clue();
    }

    @Override
    public Integer getInstanceId(Clue entity) {
        return entity.getClueId();
    }

    @ResponseBody
    @RequestMapping("fuzzySearch")
    public List<Clue> fuzzySearch(String key) {
        return clueService.fuzzySearch(key);
    }
}