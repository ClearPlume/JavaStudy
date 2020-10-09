package top.fallenangel._08faceobject._03extend.shpae;

@SuppressWarnings("ALL")
public class Rectangle extends Shape {
    protected int b;

    @Override
    protected double perimeter() {
        return (a + b) * 2;
    }

    @Override
    protected double area() {
        return a * b;
    }
}

@SuppressWarnings("ALL")
class Square extends Rectangle {
}