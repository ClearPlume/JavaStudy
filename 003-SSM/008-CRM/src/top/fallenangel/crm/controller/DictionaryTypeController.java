package top.fallenangel.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.crm.model.entity.Dictionary;
import top.fallenangel.crm.model.entity.DictionaryType;
import top.fallenangel.crm.service.IDictionaryTypeService;
import top.fallenangel.crm.template.ITemplateService;
import top.fallenangel.crm.template.impl.TemplateController;
import top.fallenangel.crm.util.ApplicationCacheListener;
import top.fallenangel.crm.util.Constants;
import top.fallenangel.crm.util.Util;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("dictionaryType")
public class DictionaryTypeController extends TemplateController<DictionaryType> {
    private final IDictionaryTypeService dictionaryTypeService;

    public DictionaryTypeController(IDictionaryTypeService dictionaryTypeService) {
        this.dictionaryTypeService = dictionaryTypeService;
    }

    @Override
    public ITemplateService<DictionaryType> getService() {
        return dictionaryTypeService;
    }

    @Override
    public DictionaryType getInstance() {
        return new DictionaryType();
    }

    @Override
    public Integer getInstanceId(DictionaryType entity) {
        return entity.getDictionaryTypeId();
    }

    @RequestMapping("list")
    public void listEntry() { }

    @Override
    @RequestMapping("edit")
    public DictionaryType edit(Integer id) {
        return super.edit(id);
    }

    @Override
    @RequestMapping("save")
    public String save(DictionaryType entity) {
        Map<DictionaryType, Map<Integer, Dictionary>> dictionaries = Util.getDictionariesFromApplication();
        Map<Integer, Dictionary> dictionaryMap;

        if (entity.getDictionaryTypeId() == null) {
            dictionaryMap = new LinkedHashMap<>();
            dictionaryTypeService.save(entity);
        } else {
            DictionaryType oldDictionaryType = dictionaryTypeService.get(entity.getDictionaryTypeId());
            dictionaryMap = dictionaries.get(oldDictionaryType);
            dictionaries.remove(oldDictionaryType);
            dictionaryTypeService.update(entity);
        }
        dictionaries.put(entity, dictionaryMap);

        return "redirect:/dictionaryType/list";
    }

    @RequestMapping("updateCache")
    public String updateCache() {
        ApplicationCacheListener.loadDictionariesMapIntoApplication(Util.getServletContext());
        return "redirect:/dictionaryType/list";
    }
}