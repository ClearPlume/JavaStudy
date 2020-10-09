package top.fallenangel._06method;

public class MethodNest {
    public static void main(String[] args) {
        MethodNest mn = new MethodNest();

        mn.carInsertFull();

        mn.catFast();

        mn.eleInIceBox();
    }

    // 汽车加油
    void carInsertFull() {
        openFull();
        insertFull();
        closeFull();
    }

    void openFull() {
        System.out.println("打开油箱盖");
    }

    void insertFull() {
        System.out.println("注入燃料");
    }

    void closeFull() {
        System.out.println("关闭油箱盖");
    }

    // 汽车加速
    void catFast() {
        minusGear();
        increaseFull();
        increaseGear();
    }

    void minusGear() {
        System.out.println("降档");
    }

    void increaseFull() {
        System.out.println("踩油门");
    }

    void increaseGear() {
        System.out.println("升档");
    }

    // 大象放冰箱
    void eleInIceBox() {
        openIceBox();
        pushEleIn();
        closeIceBox();
    }

    void openIceBox() {
        System.out.println("打开冰箱门");
    }

    void pushEleIn() {
        System.out.println("把大象放进冰箱");
    }

    void closeIceBox() {
        System.out.println("关闭冰箱门");
    }
}