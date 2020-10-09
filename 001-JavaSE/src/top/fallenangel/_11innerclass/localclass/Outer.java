package top.fallenangel._11innerclass.localclass;

public class Outer {
    public void fun() {
        class Inner {
            public void fun() {
                System.out.println("LocalClass的fun方法的局部内部类Inner的fun方法");
            }
        }

        Inner inner = new Inner();
        inner.fun();
    }
}