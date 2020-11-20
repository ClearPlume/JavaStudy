package top.fallenangel.springboot.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import top.fallenangel.springboot.p2p.model.entity.FinanceAccount;
import top.fallenangel.springboot.p2p.model.mapper.FinanceAccountMapper;
import top.fallenangel.springboot.p2p.service.IFinanceAccountService;

@org.springframework.stereotype.Service
@Service(interfaceClass = IFinanceAccountService.class, version = "1.0.0", timeout = 15000)
public class FinanceAccountService implements IFinanceAccountService {
    private final FinanceAccountMapper financeAccountMapper;

    public FinanceAccountService(FinanceAccountMapper financeAccountMapper) {
        this.financeAccountMapper = financeAccountMapper;
    }

    // 根据用户id查询帐户信息
    @Override
    public FinanceAccount queryFinanceAccount(Integer uId) {
        return financeAccountMapper.selectFinanceAccountByUserId(uId);
    }

    // 更新帐户信息
    @Override
    public void updateFinanceAccount(FinanceAccount financeAccount) {
        financeAccountMapper.updateByPrimaryKeySelective(financeAccount);
    }
}
