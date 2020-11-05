package top.fallenangel.dubbo.zookeeper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.dubbo.zookeeper.entity.Address;
import top.fallenangel.dubbo.zookeeper.entity.Goods;
import top.fallenangel.dubbo.zookeeper.service.IShopService;

import java.util.ArrayList;

@Controller
@RequestMapping("shop")
public class ShopController {
    private final IShopService shopService;

    public ShopController(IShopService shopService) {
        this.shopService = shopService;
    }

    @RequestMapping("buy")
    public String buy(Goods goods, Integer userId, Model model) {
        model.addAttribute("order", shopService.createOrder(userId, goods));
        return "order-view";
    }

    @RequestMapping("addresses")
    public String addresses(ArrayList<Address> addresses) {
        addresses.addAll(shopService.showAddress());
        return "addresses-view";
    }
}