package top.fallenangel._08faceobject._02abstract;

public class AbstractPractice {
    public static void main(String[] args) {
        // 老师类
        Teacher teacher = new Teacher("0013", "张三", 25, "13800000000");

        teacher.eat();
        teacher.teach();
        teacher.selfIntroduction();

        System.out.println();

        // 长方形
        Rectangle rectangle = new Rectangle(4, 6);

        System.out.println("长方形的周长是：" + rectangle.perimeter());
        System.out.println("长方形的面积是：" + rectangle.area());
        System.out.println("长方形的对角线是：" + rectangle.diagonal());

        System.out.println();

        // 三角形
        RegularTriangle regularTriangle = new RegularTriangle(12);

        System.out.println("三角形的周长是：" + regularTriangle.perimeter());
        System.out.println("三角形的面积是：" + regularTriangle.area());
    }
}

@SuppressWarnings("ALL")
class Teacher {
    String no;
    String name;
    int age;
    String phone;

    Teacher(String no, String name, int age, String phone) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    void eat() {
        System.out.println(name + "老师在吃饭");
    }

    void teach() {
        System.out.println(name + "老师在讲课");
    }

    void selfIntroduction() {
        System.out.println("老师叫" + name + ", 年龄是" + age + "，手机号是" + phone + "。");
    }
}

@SuppressWarnings("ALL")
class Rectangle {
    int width;
    int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int perimeter() {
        return 2 * (width + height);
    }

    int area() {
        return width * height;
    }

    double diagonal() {
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }
}

@SuppressWarnings("ALL")
class RegularTriangle {
    int sideLength;

    RegularTriangle(int sideLength) {
        this.sideLength = sideLength;
    }

    int perimeter() {
        return sideLength * 3;
    }

    double area() {
        return sideLength * (Math.sqrt(Math.pow(sideLength, 2) - Math.pow(sideLength / 2.0, 2))) / 2;
    }
}