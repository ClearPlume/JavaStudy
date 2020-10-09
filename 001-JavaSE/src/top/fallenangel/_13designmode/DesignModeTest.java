package top.fallenangel._13designmode;

public class DesignModeTest {
    public static void main(String[] args) {
        SingleInstance instance1 = SingleInstance.getInstance();
        SingleInstance instance2 = SingleInstance.getInstance();
        SingleInstance instance3 = SingleInstance.getInstance();

        System.out.println(instance1 == instance2 && instance2 == instance3);

        System.out.println("*******************************************************");
        IterableArray<Integer> array = new IterableArray<>(10);
        array.setElements(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        array.setElement(5, 965);
        for (Integer integer : array) {
            System.out.println(integer);
        }
    }
}