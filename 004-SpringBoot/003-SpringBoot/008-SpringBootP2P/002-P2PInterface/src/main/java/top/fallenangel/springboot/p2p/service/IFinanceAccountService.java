package top.fallenangel.springboot.p2p.service;

import top.fallenangel.springboot.p2p.model.entity.FinanceAccount;

public interface IFinanceAccountService {
    /**
     * 根据用户id查询帐户信息
     *
     * @param uId 用户id
     * @return 余额
     */
    FinanceAccount queryFinanceAccount(Integer uId);

    /**
     * 更新帐户信息
     *
     * @param financeAccount 帐户信息
     */
    void updateFinanceAccount(FinanceAccount financeAccount);
}
