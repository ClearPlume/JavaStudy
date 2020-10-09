package top.fallenangel._14collection.compare;

import top.fallenangel._14collection.Role;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/**
 * 尝试仿写Comparator中的comparing方法
 * 观察结论：
 * 接收一个Function<T, R extends Comparable<R>>参数，其中泛型：
 * T：要比较的参数类型
 * R：通过Function运算后得出的参数中要比较的数据，如学生(T)的学生的年龄(R)
 * 返回一个Comparator，泛型为传入的T，内容为对两个T类型中R数据的对比
 */
public class CompareTest {
    public static void main(String[] args) {
        List<Role> roles = new ArrayList<>();

        roles.add(new Role("八重樱", 507, '女'));
        roles.add(new Role("露西亚", 17, '女'));
        roles.add(new Role("奥  托", 525, '男'));
        roles.add(new Role("张  三", 525, '男'));
        roles.add(new Role("张  六", 525, '男'));
        roles.add(new Role("李  四", 525, '男'));
        roles.add(new Role("李  七", 525, '男'));
        roles.add(new Role("卡  莲", 503, '女'));
        roles.add(new Role("芽  衣", 20, '女'));

        printList(roles);

        roles.sort(comparing(Role::getAge).thenComparing((stu1, stu2) -> Collator.getInstance(Locale.CHINA).compare(stu1.getName(), stu2.getName())));

        printList(roles);
    }

    /**
     * 返回一个比较器
     *
     * @param valueExtract 从比较对象中取出要比较的数据，比如从学生对象中提取学生的年龄
     * @param <T>          参与排序的参数类型，如学生
     * @param <R>          实际比较的数据，如学生的年龄
     *
     * @return 按照指定规则对指定对象排序的比较器
     */
    @SuppressWarnings("ComparatorCombinators")
    private static <T, R extends Comparable<R>> Comparator<T> comparing(Function<T, R> valueExtract) {
        return (e1, e2) -> valueExtract.apply(e1).compareTo(valueExtract.apply(e2));
    }

    private static <T> void printList(List<T> list) {
        for (T t : list) {
            System.out.print(t);
            if (!t.equals(list.get(list.size() - 1))) {
                System.out.print(",\t");
            } else {
                System.out.println();
            }
        }
    }
}