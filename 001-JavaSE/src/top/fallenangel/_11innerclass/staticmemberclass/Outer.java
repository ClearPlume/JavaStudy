package top.fallenangel._11innerclass.staticmemberclass;

public class Outer {
    static class Inner {
        public static void staticFun() {
            System.out.println("Outer的静态内部类Inner的静态fun方法");
        }

        public void fun() {
            System.out.println("Outer的静态内部类Inner的fun方法");
        }
    }
}