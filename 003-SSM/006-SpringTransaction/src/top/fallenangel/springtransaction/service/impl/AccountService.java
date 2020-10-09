package top.fallenangel.springtransaction.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.springtransaction.model.dao.IAccountDao;
import top.fallenangel.springtransaction.service.IAccountService;

@Service
public class AccountService implements IAccountService {
    private final IAccountDao accountDao;

    public AccountService(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outName, String inName, int amount) {
        accountDao.out(outName, amount);
        accountDao.in(inName, amount);
    }
}