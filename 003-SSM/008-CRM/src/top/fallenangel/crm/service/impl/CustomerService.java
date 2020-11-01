package top.fallenangel.crm.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.crm.model.dao.ICustomerDao;
import top.fallenangel.crm.model.entity.Customer;
import top.fallenangel.crm.service.ICustomerService;
import top.fallenangel.crm.template.ITemplateDao;
import top.fallenangel.crm.template.impl.TemplateService;

import java.util.List;
import java.util.Map;

@Service
public class CustomerService extends TemplateService<Customer> implements ICustomerService {
    private final ICustomerDao customerDao;

    public CustomerService(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public ITemplateDao<Customer> getDao() {
        return customerDao;
    }

    @Override
    public List<Map<String, Object>> relatedCustomer(String linkman) {
        return customerDao.relatedCustomer(linkman);
    }
}