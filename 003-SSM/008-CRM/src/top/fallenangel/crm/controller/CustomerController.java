package top.fallenangel.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.crm.model.entity.Customer;
import top.fallenangel.crm.service.ICustomerService;
import top.fallenangel.crm.template.ITemplateService;
import top.fallenangel.crm.template.impl.TemplateController;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("customer")
public class CustomerController extends TemplateController<Customer> {
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {this.customerService = customerService;
    }

    @Override
    public ITemplateService<Customer> getService() {
        return customerService;
    }

    @Override
    public Customer getInstance() {
        return new Customer();
    }

    @Override
    public Integer getInstanceId(Customer entity) {
        return entity.getCustomerId();
    }

    @RequestMapping("relatedCustomer")
    @ResponseBody
    public List<Map<String, Object>> relatedCustomer(String customerKey) {
        return customerService.relatedCustomer(customerKey);
    }
}