package top.fallenangel._11innerclass.memberclass;

public class MemberClassTest {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner1 = outer.new Inner();
        inner1.funSplit();

        Outer.Inner inner2 = new Outer().new Inner();
        inner2.fun();
    }
}