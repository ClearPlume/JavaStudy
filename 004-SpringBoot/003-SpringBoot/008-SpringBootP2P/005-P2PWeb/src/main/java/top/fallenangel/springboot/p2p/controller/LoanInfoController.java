package top.fallenangel.springboot.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.springboot.p2p.model.entity.LoanInfo;
import top.fallenangel.springboot.p2p.service.IBidInfoService;
import top.fallenangel.springboot.p2p.service.ILoanInfoService;

@SuppressWarnings("unused")
@Controller
@RequestMapping("loan")
public class LoanInfoController {
    @Reference(interfaceClass = ILoanInfoService.class, version = "1.0.0", timeout = 15000)
    private ILoanInfoService loanInfoService;

    @Reference(interfaceClass = IBidInfoService.class, version = "1.0.0", timeout = 15000)
    private IBidInfoService bidInfoService;

    /**
     * 某一页的产品信息
     *
     * @param productType 产品类型
     * @param page        某一页
     */
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

    /**
     * 下一页产品信息
     *
     * @param productType 产品类型
     * @param page        当前页
     */
    @GetMapping("next")
    public String nextPage(Model model, Integer productType, @RequestParam(defaultValue = "1") Integer page) {
        return loan(model, productType, page + 1);
    }

    /**
     * 上一页产品信息
     *
     * @param productType 产品类型
     * @param page        当前页
     */
    @GetMapping("prev")
    public String prevPage(Model model, Integer productType, @RequestParam(defaultValue = "1") Integer page) {
        return loan(model, productType, page - 1);
    }

    /**
     * 首页产品信息
     *
     * @param productType 产品类型
     */
    @GetMapping("first")
    public String firstPage(Model model, Integer productType) {
        return loan(model, productType, 1);
    }

    /**
     * 尾页产品信息
     *
     * @param productType 产品类型
     * @param page        当前页
     */
    @GetMapping("last")
    public String lastPage(Model model, Integer productType, @RequestParam(defaultValue = "1") Integer page) {
        return loan(model, productType, page);
    }

    /**
     * 某产品详情
     *
     * @param loanId 产品Id
     */
    @GetMapping("loanInfo")
    public String loanInfo(Model model, Integer loanId, @RequestParam(defaultValue = "1") Integer page) {
        int pages = bidInfoService.queryLoanBidPages(loanId, 5);

        if (page < 1) {
            page = 1;
        }
        if (page > pages) {
            page = pages;
        }
        model.addAttribute("loanInfo", loanInfoService.queryLoanInfo(loanId));
        model.addAttribute("page", page);
        model.addAttribute("pages", pages);
        model.addAttribute("bidRecordList", bidInfoService.queryBidRecord(loanId, page, 5));
        return "loanInfo";
    }

    @ResponseBody
    @GetMapping("prevRecord")
    public Object prevRecord(Model model, Integer loanId, @RequestParam(defaultValue = "1") Integer page) {
        loanInfo(model, loanId, page - 1);
        return model.getAttribute("bidRecordList");
    }

    @ResponseBody
    @GetMapping("nextRecord")
    public Object nextRecord(Model model, Integer loanId, @RequestParam(defaultValue = "1") Integer page) {
        loanInfo(model, loanId, page + 1);
        return model.getAttribute("bidRecordList");
    }
}
