package top.fallenangel.springboot.p2p.service;

import com.github.pagehelper.PageInfo;
import top.fallenangel.springboot.p2p.model.entity.LoanInfo;

import java.util.List;
import java.util.Map;

public interface ILoanInfoService {
    /**
     * 查询产品平均收益率
     *
     * @return 平均收益率
     */
    double queryAvgRate();

    /**
     * 根据指定参数查询产品信息
     *
     * @param param 参数
     * @return 满足条件的产品信息
     */
    List<LoanInfo> queryProductInfo(Map<String, Object> param);

    /**
     * 查询第XX页的产品信息
     *
     * @param productType 产品类型
     * @param page        第XX页
     * @param pageSize    页显示产品数量
     * @return 第page页的productType类型产品
     */
    PageInfo<LoanInfo> queryProductInfo(Integer productType, Integer page, Integer pageSize);

    /**
     * 查询产品总页数
     *
     * @param productType 产品类型
     * @param pageSize    页面大小
     * @return 总页数
     */
    int queryTotalPage(Integer productType, Integer pageSize);

    /**
     * 查询产品信息
     *
     * @param loanId id
     * @return 产品信息
     */
    LoanInfo queryLoanInfo(Integer loanId);

    /**
     * 查找已满标但尚未生成收益计划的产品
     *
     * @return 已满标但尚未生成收益计划的产品
     */
    List<LoanInfo> queryFullyLoan();

    /**
     * 修改产品信息
     *
     * @param loanInfo 产品信息
     */
    void modify(LoanInfo loanInfo);
}
