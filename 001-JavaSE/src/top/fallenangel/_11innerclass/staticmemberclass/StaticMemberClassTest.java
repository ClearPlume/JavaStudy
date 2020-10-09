package top.fallenangel._11innerclass.staticmemberclass;

public class StaticMemberClassTest {
    public static void main(String[] args) {
        Outer.Inner.staticFun();

        Outer.Inner inner = new Outer.Inner();
        inner.fun();
    }
}