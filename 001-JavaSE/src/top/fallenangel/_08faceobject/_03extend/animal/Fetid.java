package top.fallenangel._08faceobject._03extend.animal;

/**
 * 猫科动物
 */
public abstract class Fetid extends Animal{
}

/**
 * 东北虎
 */
@SuppressWarnings("ALL")
class ManchurianTiger extends Fetid {
    @Override
    protected void eat() {
        System.out.println("东北虎在吃肉");
    }

    @Override
    protected void sleep() {
        System.out.println("东北虎在睡觉");
    }
}

/**
 * 加菲猫
 */
@SuppressWarnings("ALL")
class Garfield extends Fetid {
    @Override
    protected void eat() {
        System.out.println("加菲猫在吃饭");
    }

    @Override
    protected void sleep() {
        System.out.println("加菲猫在睡觉");
    }
}