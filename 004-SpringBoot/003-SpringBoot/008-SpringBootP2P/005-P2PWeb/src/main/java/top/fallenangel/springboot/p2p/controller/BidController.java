package top.fallenangel.springboot.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.springboot.p2p.common.Result;

@Controller
@RequestMapping("bid")
public class BidController {

    @ResponseBody
    @GetMapping("invest")
    public Object invest() {
        return Result.success();
    }
}
