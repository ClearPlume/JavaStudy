package top.fallenangel._08faceobject._03extend.animal;

@SuppressWarnings("ALL")
public class Poultry extends Animal{
    @Override
    protected void eat() {

    }

    @Override
    protected void sleep() {

    }
}

@SuppressWarnings("ALL")
class Parrot extends Poultry {
}

@SuppressWarnings("ALL")
class Duck extends Poultry {
}