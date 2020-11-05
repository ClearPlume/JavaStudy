package top.fallenangel.dubbo.zookeeper.entity;

import java.io.Serializable;

public class Address implements Serializable {
    private Integer id;
    private String name;
    private String city;
    private String street;

    public Address() {
    }

    public Address(Integer id, String name, String city, String street) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}