package top.fallenangel._14collection;

import java.text.Collator;
import java.util.Locale;
import java.util.Objects;

@SuppressWarnings("ALL")
public class Role implements Comparable<Role> {
    private String name;
    private int age;
    private char sex;

    public Role(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public int compareTo(Role o) {
        if (age != o.getAge()) {
            return Integer.compare(age, o.getAge());
        }
        return Collator.getInstance(Locale.CHINA).compare(name, o.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Role{" + "name='" + name + '\'' + ", age=" + age + ", sex=" + sex + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return age == role.age && sex == role.sex && name.equals(role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }
}