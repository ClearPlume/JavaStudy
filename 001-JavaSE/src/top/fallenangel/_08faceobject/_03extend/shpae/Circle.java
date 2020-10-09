package top.fallenangel._08faceobject._03extend.shpae;

@SuppressWarnings("ALL")
public class Circle extends Shape {
    Circle(){
        this(0);
    }

    Circle(int a){
        this.a = a;
    }

    @Override
    protected double perimeter(){
        return Math.PI * a * 2;
    }

    @Override
    protected double area(){
        return Math.PI * a * a;
    }
}

@SuppressWarnings("ALL")
class Ellipse extends Circle {}