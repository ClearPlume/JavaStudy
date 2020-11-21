package top.fallenangel.springboot.p2p.service;

import java.util.List;
import java.util.Map;

/**
 * 投资记录Service
 *
 * @author FallenAngel
 */
public interface IBidInfoService {
    /**
     * 查询平台总成交额
     *
     * @return 平台总成交额
     */
    double queryTotalDealMoney();

    /**
     * 查询指定页产品投资记录
     *
     * @param loanId   产品Id
     * @param page     指定页
     * @param pageSize 页面大小
     * @return 产品投资记录(投资人 投资金额 投资时间)
     */
    List<Map<String, Object>> queryBidRecord(Integer loanId, Integer page, Integer pageSize);

    /**
     * 查询产品的投资记录总页数
     *
     * @param loanId   产品id
     * @param pageSize 页面大小
     * @return 页数
     */
    int queryLoanBidPages(Integer loanId, Integer pageSize);

    /**
     * 用户投资
     * <p>
     * 返回值中的code：1：当前未登录 2：余额不足 3：产品可投金额不足 4：产品已满标 5：系统维护中
     *
     * @param userId   用户Id
     * @param loanId   投资产品
     * @param bidMoney 投资金额
     * @return 投资结果
     */
    Map<String, Object> invest(int userId, int loanId, double bidMoney);
}
