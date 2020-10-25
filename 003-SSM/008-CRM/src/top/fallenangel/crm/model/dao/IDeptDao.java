package top.fallenangel.crm.model.dao;

import top.fallenangel.crm.template.ITemplateDao;
import top.fallenangel.crm.template.impl.BaseEntity;

public interface IDeptDao<T extends BaseEntity> extends ITemplateDao<T> {}