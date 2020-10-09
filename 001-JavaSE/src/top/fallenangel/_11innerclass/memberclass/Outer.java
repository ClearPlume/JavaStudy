package top.fallenangel._11innerclass.memberclass;

public class Outer {
    @SuppressWarnings("InnerClassMayBeStatic")
    class Inner {
        public void funSplit() {
            System.out.println("Outer的内部类Inner的funSplit方法");
        }

        public void fun() {
            System.out.println("Outer的内部类Inner的funSplit方法");
        }
    }
}