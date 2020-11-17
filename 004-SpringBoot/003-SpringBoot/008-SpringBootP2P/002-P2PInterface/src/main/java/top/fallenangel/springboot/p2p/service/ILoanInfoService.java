package top.fallenangel.springboot.p2p.service;

import com.github.pagehelper.PageInfo;
import top.fallenangel.springboot.p2p.model.entity.LoanInfo;

import java.util.List;
import java.util.Map;

public interface ILoanInfoService {
    double queryAvgRate();

    List<LoanInfo> queryProductInfo(Map<String, Object> param);

    PageInfo<LoanInfo> queryProductInfo(Integer productType, Integer page, Integer pageSize);

    int queryTotalPage(Integer productType, Integer pageSize);
}
