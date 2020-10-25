package top.fallenangel.crm.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.crm.model.entity.Dictionary;
import top.fallenangel.crm.model.entity.DictionaryType;
import top.fallenangel.crm.service.IDictionaryService;
import top.fallenangel.crm.service.IDictionaryTypeService;
import top.fallenangel.crm.template.ITemplateService;
import top.fallenangel.crm.template.impl.TemplateController;
import top.fallenangel.crm.util.ApplicationCacheListener;
import top.fallenangel.crm.util.Util;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("dictionary")
public class DictionaryController extends TemplateController<Dictionary> {
    private final IDictionaryService dictionaryService;
    private final IDictionaryTypeService dictionaryTypeService;

    public DictionaryController(IDictionaryService dictionaryService, IDictionaryTypeService dictionaryTypeService) {
        this.dictionaryService = dictionaryService;
        this.dictionaryTypeService = dictionaryTypeService;
    }

    @Override
    public ITemplateService<Dictionary> getService() {
        return dictionaryService;
    }

    @Override
    public Dictionary getInstance() {
        return new Dictionary();
    }

    @Override
    public Integer getInstanceId(Dictionary entity) {
        return entity.getDictionaryId();
    }

    @RequestMapping("list")
    public List<Dictionary> list(int dictionaryTypeId, DictionaryType dictionaryType) {
        DictionaryType type = dictionaryTypeService.get(dictionaryTypeId);
        BeanUtils.copyProperties(type, dictionaryType);
        return dictionaryService.list(dictionaryTypeId);
    }

    @RequestMapping("updateCache")
    public String updateCache(int dictionaryTypeId) {
        ApplicationCacheListener.loadDictionariesMapIntoApplication(Util.getServletContext());
        //noinspection SpringMVCViewInspection
        return "redirect:/dictionary/list?dictionaryTypeId=" + dictionaryTypeId;
    }

    @RequestMapping("edit")
    public Dictionary edit(Integer id, Integer order, Integer type) {
        Dictionary dictionary;

        if (id == null) {
            dictionary = new Dictionary();
            dictionary.setDictionaryOrder(order);
            dictionary.setDictionaryType(Util.getDictionaryTypeFromApplication(type));
        } else {
            dictionary = Util.getDictionaryFromApplicationById(id);
        }
        return dictionary;
    }

    @Override
    @RequestMapping("save")
    public String save(Dictionary entity) {
        Map<Integer, Dictionary> dictionaryMap = Util.getDictionariesFromApplicationByType(entity.getDictionaryType().getDictionaryTypeId());
        entity.setDictionaryType(Util.getDictionaryTypeFromApplication(entity.getDictionaryType().getDictionaryTypeId()));

        if (entity.getDictionaryId() == null) {
            dictionaryService.save(entity);
            dictionaryMap.put(entity.getDictionaryId(), entity);
        } else {
            dictionaryService.update(entity);
            dictionaryMap.replace(entity.getDictionaryId(), dictionaryService.get(entity.getDictionaryId()));
        }
        ApplicationCacheListener.loadDictionariesMapIntoApplication(Util.getServletContext());
        //noinspection SpringMVCViewInspection
        return "redirect:/dictionary/list?dictionaryTypeId=" + entity.getDictionaryType().getDictionaryTypeId();
    }
}