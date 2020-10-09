package top.fallenangel._08faceobject._03extend.animal;

@SuppressWarnings("ALL")
public abstract class Animal {
    protected String name;
    protected String sex;
    protected int age;

    abstract protected void eat();

    protected abstract void sleep();
}