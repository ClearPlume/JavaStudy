package top.fallenangel.crm.service;

import top.fallenangel.crm.model.entity.Customer;
import top.fallenangel.crm.template.ITemplateService;

import java.util.List;
import java.util.Map;

public interface ICustomerService extends ITemplateService<Customer> {
    List<Map<String, Object>> relatedCustomer(String linkman);
}