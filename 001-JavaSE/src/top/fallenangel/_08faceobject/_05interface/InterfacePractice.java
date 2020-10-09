package top.fallenangel._08faceobject._05interface;

@SuppressWarnings("DuplicatedCode")
public class InterfacePractice {
    public static void main(String[] args) {
        Shape shape = new Rectangle("长方形", 2, 3);
        System.out.println(shape.getName() + "的周长是：" + shape.perimeter());
        System.out.println(shape.getName() + "的面积是：" + shape.area());
        System.out.println(shape.getName() + "的对角线长是：" + ((IDiagonal) shape).diagonal());

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
        ((IPenalty) car).penalty();

        System.out.println();

        car = new SpecialCar();
        car.upkeep();
        car.annual();

        System.out.println("****************************************");

        Person person = new Student();
        person.learn();
        ((IDrill) person).drill();

        System.out.println();

        person = new Teacher();
        person.learn();

        System.out.println();

        person = new Soldier();
        person.learn();
        ((IDrill) person).drill();

        System.out.println("****************************************");

        Animal animal = new Duck();
        animal.shout();
        ((ISwim) animal).swim();

        System.out.println();

        animal = new Chick();
        animal.shout();

        System.out.println();

        animal = new Dog();
        animal.shout();
        ((ISwim) animal).swim();
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

interface IDiagonal {
    double diagonal();
}

@SuppressWarnings("SameParameterValue")
class Rectangle extends Shape implements IDiagonal {
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

    @Override
    public double diagonal() {
        return Math.sqrt(a * a + b * b);
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
}

interface IPenalty {
    void penalty();
}

class SocialCar extends Car implements IPenalty {
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
    public void penalty() {
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
}

abstract class Person {
    abstract void learn();
}

interface IDrill {
    void drill();
}

class Student extends Person implements IDrill {
    @Override
    void learn() {
        System.out.println("学生学面向对象");
    }

    @Override
    public void drill() {
        System.out.println("学生跑步");
    }
}

class Teacher extends Person {
    @Override
    void learn() {
        System.out.println("老师学IOS");
    }
}

class Soldier extends Person implements IDrill {
    @Override
    void learn() {
        System.out.println("军人学厉史");
    }

    @Override
    public void drill() {
        System.out.println("军人穿越火墙");
    }
}

abstract class Animal {
    abstract void shout();
}

interface ISwim {
    void swim();
}

class Duck extends Animal implements ISwim {
    @Override
    void shout() {
        System.out.println("鸭子嘎嘎叫");
    }

    @Override
    public void swim() {
        System.out.println("鸭子红掌拨清波");
    }
}

class Chick extends Animal {
    @Override
    void shout() {
        System.out.println("鸡咯咯叫");
    }
}

class Dog extends Animal implements ISwim {
    @Override
    void shout() {
        System.out.println("狗在汪汪叫");
    }

    @Override
    public void swim() {
        System.out.println("狗在狗刨");
    }
}