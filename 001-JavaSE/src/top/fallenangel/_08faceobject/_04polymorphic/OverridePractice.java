package top.fallenangel._08faceobject._04polymorphic;

@SuppressWarnings("DuplicatedCode")
abstract public class OverridePractice {
    public static void main(String[] args) {
        Shape shape = new Rectangle("长方形", 2, 3);
        System.out.println(shape.getName() + "的周长是：" + shape.perimeter());
        System.out.println(shape.getName() + "的面积是：" + shape.area());

        System.out.println();

        shape = new TripeAngle("三角形", 2);
        System.out.println(shape.getName() + "的周长是：" + shape.perimeter());
        System.out.println(shape.getName() + "的面积是：" + shape.area());

        System.out.println();

        shape = new Cycle("圆形", 2);
        System.out.println(shape.getName() + "的周长是：" + shape.perimeter());
        System.out.println(shape.getName() + "的面积是：" + shape.area());

        System.out.println("****************************************");

        Car car = new SocialCar();
        car.upkeep();
        car.annual();
        car.penalty();

        System.out.println();

        car = new SpecialCar();
        car.upkeep();
        car.annual();
        car.penalty();

        System.out.println("****************************************");

        Person person = new Emperor();
        person.praise();

        System.out.println();

        person = new Queen();
        person.praise();

        System.out.println();

        person = new Minister();
        person.praise();

        System.out.println();

        person = new Child();
        person.praise();
    }
}

abstract class Shape {
    protected int a;
    protected int b;
    protected String name;

    abstract double area();

    abstract double perimeter();

    String getName() {
        return name;
    }
}

@SuppressWarnings("SameParameterValue")
class Rectangle extends Shape {
    Rectangle(String name, int a, int b) {
        this.name = name;
        this.a = a;
        this.b = b;
    }

    @Override
    double area() {
        return a * b;
    }

    @Override
    double perimeter() {
        return 2 * (a + b);
    }
}

@SuppressWarnings("SameParameterValue")
class TripeAngle extends Shape {
    TripeAngle(String name, int a) {
        this.name = name;
        this.a = a;
    }

    @Override
    double area() {
        return Double.parseDouble(String.format("%.2f", Math.sqrt(3) / 4 * a * a));
    }

    @Override
    double perimeter() {
        return Double.parseDouble(String.format("%.2f", a * 3.0));
    }
}

@SuppressWarnings("SameParameterValue")
class Cycle extends Shape {
    Cycle(String name, int a) {
        this.name = name;
        this.a = a;
    }

    @Override
    double area() {
        return Double.parseDouble(String.format("%.2f", Math.PI * a * a));
    }

    @Override
    double perimeter() {

        return Double.parseDouble(String.format("%.2f", 2 * Math.PI * a));
    }
}

abstract class Car {
    protected String type;
    protected int score = 12;
    protected int money = 0;

    /**
     * 保养
     */
    abstract void upkeep();

    /**
     * 年检
     */
    abstract void annual();

    /**
     * 罚款
     */
    abstract void penalty();
}

class SocialCar extends Car {
    SocialCar() {
        type = "社会车辆";
    }

    @Override
    void upkeep() {
        System.out.println(type + "在4S店保养");
    }

    @Override
    void annual() {
        System.out.println(type + "社会车辆2年检修一次");
    }

    @Override
    void penalty() {
        score = score - 3;
        money = money - 200;
        System.out.println(type + "罚款200， 扣3分。剩余：" + score + "分，" + money + "￥");
    }
}

class SpecialCar extends Car {
    SpecialCar() {
        type = "专用车辆";
    }

    @Override
    void upkeep() {
        System.out.println(type + "在特别维修点保养");
    }

    @Override
    void annual() {
        System.out.println(type + "无需检修");
    }

    @Override
    void penalty() {
        System.out.println(type + "不会受到处罚");
    }
}

abstract class Person {
    protected String name;

    /**
     * 夸赞
     */
    abstract void praise();
}

class Emperor extends Person {
    Emperor() {
        name = "皇帝";
    }

    @Override
    void praise() {
        System.out.println(name + "：哎呀，真是太美了，我十二分的满意！");
    }
}

class Queen extends Person {
    Queen() {
        name = "皇后";
    }

    @Override
    void praise() {
        System.out.println(name + "：上帝，这些衣服多么合身啊，这些布料多么华丽啊！");
    }
}

class Minister extends Person {
    Minister() {
        name = "大巨";
    }

    @Override
    void praise() {
        System.out.println(name + "：美极了，真是太美了，多么美丽的色彩，多么美妙的花纹！");
    }
}

class Child extends Person {
    Child() {
        name = "小孩";
    }

    @Override
    void praise() {
        System.out.println(name + "：可是他什么衣服都没穿啊！");
    }
}