package top.fallenangel._08faceobject._01packaging;

public class PackagingPractice {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        car.setGear(-1);
        car.info();
        Thread.sleep(2000);
        car.run();
        car.setGear(-1);
    }
}

class Car {
    private int speed;
    private int gear;

    public int getSpeed() {
        return speed;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        if (gear == -1 && speed > 15) {
            System.out.println("速度超过15公里每小时，禁止挂倒挡！");
        } else {
            this.gear = gear;
        }
    }

    public void run() throws Exception {
        while (speed >= 0 && speed < 100) {
            speed++;
            if (speed < 10) {
                setGear(1);
            } else if (speed / 10 <= 3) {
                setGear(2);
            } else if (speed / 10 <= 5) {
                setGear(3);
            } else {
                setGear(4);
            }
            info();
        }
    }

    public void info() throws InterruptedException {
        System.out.print("汽车挡位为：" + getGear() + "，时速为：" + getSpeed() + "。");
        Thread.sleep(100);
        System.out.print('\r');
    }
}

@SuppressWarnings("ALL")
class Student {
    private int age;

    public Student(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18 && age < 25) {
            this.age = age;
        } else {
            System.out.println("学生的年龄应当在18-25之间");
        }
    }
}