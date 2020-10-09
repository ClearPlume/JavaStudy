package top.fallenangel.springmybatis.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.fallenangel.springmybatis.model.bean.Flower;
import top.fallenangel.springmybatis.model.bean.FlowerVO;
import top.fallenangel.springmybatis.service.impl.FlowerService;
import top.fallenangel.util.InputUtil;
import top.fallenangel.util.NormalUtil;

import java.util.List;

public class SpringMybatisTest {
    public static void main(String[] args) {
        new SpringMybatisTest().entry();
    }

    private final ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    private final FlowerService flowerService = xmlApplicationContext.getBean(FlowerService.class);

    public void entry() {
        while (true) {
            switch (mainUI()) {
                case 1:
                    list();
                    break;
                case 2:
                    get();
                    break;
                case 3:
                    listVO();
                    break;
                case 4:
                    save();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    public byte mainUI() {
        NormalUtil.showUI("鲜花管理系统", "鲜花管理", "查询所有", "根据ID查找", "按条件查找", "添加鲜花", "删除鲜花", "退出");
        return InputUtil.inByte();
    }

    public void list() {
        List<Flower> flowers = flowerService.list();
        System.out.println("鲜花：");
        for (Flower flower : flowers) {
            System.out.println(flower);
        }
        NormalUtil.enterContinue();
    }

    public void get() {
        System.out.print("输入ID：");
        Integer fId = InputUtil.inInt();
        Flower flower = flowerService.get(fId);
        System.out.println("flower = " + flower);
        NormalUtil.enterContinue();
    }

    public void listVO() {
        System.out.println("按用途、价格查找鲜花：");
        System.out.print("输入用途(!为不输)：");
        String usageTmp = InputUtil.inStr();
        String usage = usageTmp.equals("!") || usageTmp.equals("！") ? null : usageTmp;
        System.out.print("输入最低价格(!为不输)：");
        String minPriceTmp = InputUtil.inStr();
        System.out.print("输入最高价格(!为不输)：");
        String maxPriceTmp = InputUtil.inStr();
        Integer minPrice = minPriceTmp.equals("!") || minPriceTmp.equals("！") ? null : Integer.parseInt(minPriceTmp);
        Integer maxPrice = maxPriceTmp.equals("!") || maxPriceTmp.equals("！") ? null : Integer.parseInt(maxPriceTmp);
        FlowerVO flowerVO = new FlowerVO(usage, minPrice, maxPrice);
        List<Flower> flowers = flowerService.listVO(flowerVO);
        System.out.println("鲜花：");
        for (Flower flower : flowers) {
            System.out.println(flower);
        }
        NormalUtil.enterContinue();
    }

    public void save() {
        System.out.println("添加鲜花：");
        System.out.print("输入用途：");
        int usage = InputUtil.inInt();
        System.out.print("输入名称：");
        String name = InputUtil.inStr();
        System.out.print("输入价格：");
        double price = InputUtil.inDouble();

        Flower flower = new Flower();
        flower.setcId(usage);
        flower.setfName(name);
        flower.setfPrice(price);
        flowerService.save(flower);
        list();
    }

    public void delete() {
        System.out.println("删除鲜花：");
        System.out.print("输入ID：");
        int id = InputUtil.inInt();
        flowerService.delete(id);
        list();
    }
}