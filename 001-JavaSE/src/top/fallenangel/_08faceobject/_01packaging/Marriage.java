package top.fallenangel._08faceobject._01packaging;

public class Marriage {
    public static void main(String[] args) {
        Husband jack = new Husband("Jack", 24);
        Wife mary = new Wife("Mary", 22);

        wedding(jack, mary);

        jack.wifeName();
        mary.husbandName();

        System.out.println("******************************");

        divorce(jack, mary);

        jack.wifeName();
        mary.husbandName();

        System.out.println("******************************");

        Wife ruth = new Wife("Ruth", 23);

        wedding(jack, ruth);

        jack.wifeName();
        mary.husbandName();
        ruth.husbandName();
    }

    /**
     * 结婚
     *
     * @param husband 男方
     * @param wife    女方
     */
    static void wedding(Husband husband, Wife wife) {
        husband.wife = wife;
        wife.husband = husband;
        System.out.println(husband.name + "和" + wife.name + "结婚了！");
    }

    /**
     * 离婚
     *
     * @param husband 男方
     * @param wife    女方
     */
    static void divorce(Husband husband, Wife wife) {
        husband.wife = null;
        wife.husband = null;
        System.out.println(husband.name + "和" + wife.name + "离婚了...");
    }
}

@SuppressWarnings("ALL")
class Husband {
    String name;
    int age;
    Wife wife;

    Husband(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void wifeName() {
        if (null != wife) {
            System.out.println(name + "妻子的名字是：" + wife.name);
        } else {
            System.out.println(name + "没有妻子");
        }
    }
}

@SuppressWarnings("ALL")
class Wife {
    String name;
    int age;
    Husband husband;

    Wife(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void husbandName() {
        if (null != husband) {
            System.out.println(name + "丈夫的名字是：" + husband.name);
        } else {
            System.out.println(name + "没有丈夫");
        }
    }
}