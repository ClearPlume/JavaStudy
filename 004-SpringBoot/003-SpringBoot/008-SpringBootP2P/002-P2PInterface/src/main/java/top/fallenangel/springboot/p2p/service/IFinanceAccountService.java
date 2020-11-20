package top.fallenangel.springboot.p2p.service;

public interface IFinanceAccountService {
    /**
     * 根据用户id查询帐户余额
     *
     * @param uId 用户id
     * @return 余额
     */
    int queryAccountAmount(Integer uId);
}
