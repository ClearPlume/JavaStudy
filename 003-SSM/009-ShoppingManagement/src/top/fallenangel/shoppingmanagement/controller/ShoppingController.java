package top.fallenangel.shoppingmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.shoppingmanagement.model.entity.Shopping;
import top.fallenangel.shoppingmanagement.service.IShoppingService;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("shopping")
public class ShoppingController {
    private final IShoppingService shoppingService;

    public ShoppingController(IShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @RequestMapping("list")
    public List<Shopping> list() {
        return shoppingService.list();
    }

    @RequestMapping("edit")
    public Shopping edit(Integer id) {
        Shopping shopping;

        if (id == null) {
            shopping = new Shopping();
        } else {
            shopping = shoppingService.get(id);
        }

        return shopping;
    }

    @RequestMapping("save")
    public String save(Shopping shopping) {
        shopping.setShoppingNo(new SimpleDateFormat("yyyyMMdd").format(shopping.getShoppingShelfDate()));

        if (shopping.getShoppingId() == null) {
            shoppingService.save(shopping);
        } else {
            shoppingService.update(shopping);
        }
        return "redirect:/shopping/list";
    }

    @RequestMapping("delete")
    public String delete(int[] id) {
        shoppingService.delete(id);
        return "redirect:/shopping/list";
    }
}