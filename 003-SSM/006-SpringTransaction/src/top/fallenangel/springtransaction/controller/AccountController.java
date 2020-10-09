package top.fallenangel.springtransaction.controller;

import org.springframework.stereotype.Controller;
import top.fallenangel.springtransaction.service.IAccountService;

@Controller
public class AccountController {
    private final IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void transfer(String outName, String inName, int amount) {
        accountService.transfer(outName, inName, amount);
    }
}