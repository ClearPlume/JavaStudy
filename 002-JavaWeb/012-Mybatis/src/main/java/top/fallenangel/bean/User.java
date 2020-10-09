package top.fallenangel.bean;

import java.util.Arrays;

public class User {
    private String name;
    private short age;
    private char sex;
    private String[] hobbies;
    private String email;
    private String phone;
    private String pwd;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getHobbies() {
        return Arrays.toString(hobbies);
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies.split(", ");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", hobbies=" + hobbies +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}