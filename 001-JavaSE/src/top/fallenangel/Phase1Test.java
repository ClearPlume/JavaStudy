package top.fallenangel;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

@SuppressWarnings("ALL")
public class Phase1Test {
    public static void main(String[] args) {
        calc1_100Even();
        System.out.println("************************************************************");
        taxiPriceWithMileage();
        System.out.println("************************************************************");
        shoppingData();
    }

    /**
     * 计算并输出1到100之间所有的偶数的和
     */
    private static void calc1_100Even() {
        int sum = 0;

        for (int i = 2; i <= 100; i = i + 2) {
            sum = sum + i;
        }

        System.out.println("1~100之间所有偶数的和是：" + sum);
    }

    /**
     * 设计一个出租车计价器程序，计价规则：
     * 1）起步价10元，3公里
     * 2）3公里之后，行程在10公里以内部分（包含10公里），2元每公里。行程超过10公里的部分，2.5元每公里
     * 3）无论行程多少均收取1元燃油附加税
     */
    private static void taxiPriceWithMileage() {
        System.out.print("请输入走了多少公里：");
        int km = new Scanner(System.in).nextInt();
        double price;

        if (km < 0) {
            throw new NumberFormatException("公里数不能为负！");
        }

        if (km <= 3) {
            price = 10;
        } else if (km <= 10) {
            price = (km - 3) * 2 + 10;
        } else {
            price = 10 + (10 - 3) * 2 + (km - 10) * 2.5;
        }

        price = price + 1;

        System.out.println("行驶" + km + "公里，费用为：" + price + "元");
    }

    /**
     * 采购部小张在编辑excel时不小心拷贝重复了很多数据，请编写一个程序帮小张把多余的重复数据删掉：
     * 1) 当ID相等时认为是同一条数据
     * 2) 要求使用集合类当中最恰当的集合实现(提示：这是商品的集合，要对集合中元素的去重复)
     * 3) excel数据内容如下：
     * 编号	商品名称	           进货价	零售价  厂家
     * 001	旺仔牛奶铁罐330ml       3.5   	5.5 	旺旺食品有限公司
     * 002	旺仔牛奶铁罐330mlx24    72.3  	99.0	旺旺食品有限公司
     * 003	旺旺仙贝30g             1.2 	1.5	    旺旺食品有限公司
     * 004	脉动青柠味500ml         3.2  	4.5	    可口可乐中国有限公司
     * 001	旺仔牛奶铁罐330ml	   3.5  	5.5	    旺旺食品有限公司
     * 001	旺仔牛奶铁罐330ml	   3.5  	5.5	    旺旺食品有限公司
     * 001	旺仔牛奶铁罐330ml	   3.5  	5.5	    旺旺食品有限公司
     * 002	旺仔牛奶铁罐330mlx24	   72.3 	99.0	旺旺食品有限公司
     */
    private static void shoppingData() {
        class Shopping {
            private final String id;
            private final String name;
            // 进价
            private final double purchase;
            // 零售价
            private final double retail;
            // 厂家
            private final String manufacturers;

            public Shopping(String id, String name, double purchase, double retail, String manufacturers) {
                this.id = id;
                this.name = name;
                this.purchase = purchase;
                this.retail = retail;
                this.manufacturers = manufacturers;
            }

            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public double getPurchase() {
                return purchase;
            }

            public double getRetail() {
                return retail;
            }

            public String getManufacturers() {
                return manufacturers;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                Shopping shopping = (Shopping) o;
                return id.equals(shopping.id);
            }

            @Override
            public int hashCode() {
                return Objects.hash(id);
            }

            @Override
            public String toString() {
                return "商品：{" + "编号：'" + id + '\'' + ", 名称：'" + name + '\'' + ", 进价：" + purchase + ", 卖价：" + retail + ", 厂家：'" + manufacturers + '\'' + '}';
            }
        }

        Set<Shopping> goods = new HashSet<>();

        goods.add(new Shopping("001", "旺仔牛奶铁罐330ml", 3.5, 5.5, "旺旺食品有限公司"));
        goods.add(new Shopping("002", "旺仔牛奶铁罐330mlx24", 72.3, 99, "旺旺食品有限公司"));
        goods.add(new Shopping("003", "旺旺仙贝30g", 1.2, 1.5, "旺旺食品有限公司"));
        goods.add(new Shopping("004", "脉动青柠味500ml", 3.2, 4.5, "可口可乐中国有限公司"));
        goods.add(new Shopping("001", "旺仔牛奶铁罐330ml", 3.5, 5.5, "旺旺食品有限公司"));
        goods.add(new Shopping("001", "旺仔牛奶铁罐330ml", 3.5, 5.5, "旺旺食品有限公司"));
        goods.add(new Shopping("001", "旺仔牛奶铁罐330ml", 3.5, 5.5, "旺旺食品有限公司"));
        goods.add(new Shopping("002", "旺仔牛奶铁罐330mlx24", 72.3, 99, "旺旺食品有限公司"));

        for (Shopping good : goods) {
            System.out.println(good);
        }
    }
}