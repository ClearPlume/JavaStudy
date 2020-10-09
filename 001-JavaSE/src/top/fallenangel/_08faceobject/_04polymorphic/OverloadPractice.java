package top.fallenangel._08faceobject._04polymorphic;

public class OverloadPractice {
    public static void main(String[] args) {
        RegularTripeAngel tripeAngel = new RegularTripeAngel();
        System.out.println("通过边长算得面积是：" + tripeAngel.area(4));
        System.out.println("通过底和高算得面积是：" + tripeAngel.area(10, 2));

        System.out.println();

        CopyFile copy = new CopyFile();
        copy.copy();
        copy.copy("PowerNode", "FallenAngel");
    }
}

class RegularTripeAngel {
    /**
     * 通过边长计算面积
     *
     * @return 面积
     */
    public double area(int a) {
        return Math.sqrt(3) / 4 * a * a;
    }

    /**
     * 通过底和高计算面积
     *
     * @param base   底
     * @param height 高
     *
     * @return 面积
     */
    public double area(int base, int height) {
        return base * height / 2.0;
    }
}

class CopyFile {
    /**
     * 点击"快速连接"拷贝资料
     */
    public void copy() {
        System.out.println("点击\"快速连接\"连接教师机");
    }

    /**
     * 通过主机名和用户名拷贝资料
     *
     * @param hostName 主机名
     * @param userName 用户名
     */
    public void copy(String hostName, String userName) {
        System.out.println(userName + "通过主机名\"" + hostName + "\"连接教师机");
    }
}