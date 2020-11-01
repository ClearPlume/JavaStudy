package top.fallenangel.crm.model.dao;

import top.fallenangel.crm.model.entity.Customer;
import top.fallenangel.crm.template.ITemplateDao;

import java.util.List;
import java.util.Map;

public interface ICustomerDao extends ITemplateDao<Customer> {
    List<Map<String, Object>> relatedCustomer(String linkman);
}