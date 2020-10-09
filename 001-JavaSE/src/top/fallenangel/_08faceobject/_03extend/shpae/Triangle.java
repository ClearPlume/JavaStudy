package top.fallenangel._08faceobject._03extend.shpae;

@SuppressWarnings("ALL")
public class Triangle extends Shape {
    protected int b;
    protected int c;

    @Override
    protected double perimeter() {
        return a + b + c;
    }

    @Override
    protected double area() {
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

@SuppressWarnings("ALL")
class RightTriangle extends Triangle {
}

@SuppressWarnings("ALL")
class EquilarTriangle extends Triangle {
}

@SuppressWarnings("ALL")
class RegularTriangle extends EquilarTriangle {
}