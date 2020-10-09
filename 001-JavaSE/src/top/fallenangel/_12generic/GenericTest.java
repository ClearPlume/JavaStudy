package top.fallenangel._12generic;

public class GenericTest {
    public static void main(String[] args) {
        Data<Integer> data1 = new Data<>();
        data1.setData(1);
        System.out.println(data1.getData());

        Data<Double> data2 = new Data<>();
        data2.setData(2.0);
        System.out.println(data2.getData());
    }
}