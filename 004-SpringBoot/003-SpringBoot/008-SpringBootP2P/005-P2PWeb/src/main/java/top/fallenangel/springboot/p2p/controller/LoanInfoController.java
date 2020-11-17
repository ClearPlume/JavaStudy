package top.fallenangel.springboot.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.fallenangel.springboot.p2p.model.entity.LoanInfo;
import top.fallenangel.springboot.p2p.service.ILoanInfoService;

@SuppressWarnings("unused")
@Controller
@RequestMapping("loan")
public class LoanInfoController {
    @Reference(interfaceClass = ILoanInfoService.class, version = "1.0.0", timeout = 15000)
    private ILoanInfoService loanInfoService;

    @GetMapping("loan")
    public String loan(Model model, Integer productType, @RequestParam(defaultValue = "1") Integer page) {
        if (page < 1) {
            page = 1;
        }
        int totalPage = loanInfoService.queryTotalPage(productType, 9);
        if (page > totalPage) {
            page = totalPage;
        }
        PageInfo<LoanInfo> loanInfoPageInfo = loanInfoService.queryProductInfo(productType, page, 9);
        model.addAttribute("productType", productType);
        model.addAttribute("loanInfoPageInfo", loanInfoPageInfo);
        model.addAttribute("loanInfos", loanInfoPageInfo.getList());
        return "loan";
    }

    @GetMapping("next")
    public String nextPage(Model model, Integer productType, @RequestParam(defaultValue = "1") Integer page) {
        return loan(model, productType, page + 1);
    }

    @GetMapping("prev")
    public String prevPage(Model model, Integer productType, @RequestParam(defaultValue = "1") Integer page) {
        return loan(model, productType, page - 1);
    }

    @GetMapping("first")
    public String firstPage(Model model, Integer productType) {
        return loan(model, productType, 1);
    }

    @GetMapping("last")
    public String lastPage(Model model, Integer productType, @RequestParam(defaultValue = "1") Integer page) {
        return loan(model, productType, page);
    }
}
