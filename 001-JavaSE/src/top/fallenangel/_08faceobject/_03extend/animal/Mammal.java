package top.fallenangel._08faceobject._03extend.animal;

/**
 * 哺乳动物
 */
@SuppressWarnings("ALL")
public abstract class Mammal extends Animal {
    /**
     * 哺乳
     */
    protected abstract void lactation();
}

@SuppressWarnings("ALL")
abstract class Human extends Mammal {
    protected abstract void work();

    protected abstract void swim();
}

@SuppressWarnings("ALL")
class Student extends Human {
    @Override
    protected void lactation() {

    }

    @Override
    protected void work() {

    }

    @Override
    protected void swim() {

    }

    @Override
    protected void eat() {

    }

    @Override
    protected void sleep() {

    }
}

@SuppressWarnings("ALL")
class Solider extends Human {
    @Override
    protected void lactation() {

    }

    @Override
    protected void work() {

    }

    @Override
    protected void swim() {

    }

    @Override
    protected void eat() {

    }

    @Override
    protected void sleep() {

    }
}

@SuppressWarnings("ALL")
class Teacher extends Human {
    @Override
    protected void lactation() {

    }

    @Override
    protected void work() {

    }

    @Override
    protected void swim() {

    }

    @Override
    protected void eat() {

    }

    @Override
    protected void sleep() {

    }
}

@SuppressWarnings("ALL")
class Whale extends Mammal {
    private void swim() {

    }

    @Override
    protected void lactation() {

    }

    @Override
    protected void eat() {

    }

    @Override
    protected void sleep() {

    }
}