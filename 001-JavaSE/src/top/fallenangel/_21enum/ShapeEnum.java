package top.fallenangel._21enum;

public enum ShapeEnum {
    RECT("矩形"), TRIANGLE("三角形"), CYCLE("圆形");

    private final String name;

    ShapeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}