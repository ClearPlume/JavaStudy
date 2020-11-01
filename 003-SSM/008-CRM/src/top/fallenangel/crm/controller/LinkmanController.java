package top.fallenangel.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.crm.model.entity.Linkman;
import top.fallenangel.crm.service.ILinkmanService;
import top.fallenangel.crm.template.ITemplateService;
import top.fallenangel.crm.template.impl.TemplateController;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("linkman")
public class LinkmanController extends TemplateController<Linkman> {
    private final ILinkmanService linkmanService;

    public LinkmanController(ILinkmanService linkmanService) {
        this.linkmanService = linkmanService;
    }

    @Override
    public ITemplateService<Linkman> getService() {
        return linkmanService;
    }

    @Override
    public Linkman getInstance() {
        return new Linkman();
    }

    @Override
    public Integer getInstanceId(Linkman entity) {
        return entity.getLinkmanId();
    }

    @ResponseBody
    @RequestMapping("relatedLinkman")
    public List<Map<String, Object>> relatedLinkman(int customerId) {
        return linkmanService.relatedLinkman(customerId);
    }
}