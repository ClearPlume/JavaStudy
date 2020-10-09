package top.fallenangel._11innerclass.anonymousclass;

@SuppressWarnings("ALL")
public class AnonymousTest {
    public static void main(String[] args) {
        Shape triangle = new Shape(10) {
            @Override
            public int perimeter() {
                return a * 3;
            }
        };

        System.out.println("匿名内部类计算的三角形周长：" + triangle.perimeter());
    }
}