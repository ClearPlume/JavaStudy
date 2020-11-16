package top.fallenangel.springboot.p2p.service;

import top.fallenangel.springboot.p2p.model.entity.LoanInfo;

import java.util.List;
import java.util.Map;

public interface ILoanInfoService {
    double queryAvgRate();

    List<LoanInfo> queryProductInfo(Map<String, Object> param);
}
