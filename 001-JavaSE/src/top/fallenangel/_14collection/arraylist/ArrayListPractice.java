package top.fallenangel._14collection.arraylist;

import top.fallenangel._14collection.Role;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPractice {
    public static void main(String[] args) {
        add1_100();
        addAZ();
        add_a_z();
        add4Students();
    }

    static void add1_100() {
        List<Integer> integers = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            integers.add(i);
        }

        listIterator(integers);
    }

    static void addAZ() {
        List<Character> characters = new ArrayList<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            characters.add(c);
        }

        listIterator(characters);
    }

    static void add_a_z() {
        List<Character> characters = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++) {
            characters.add(c);
        }

        listIterator(characters);
    }

    static void add4Students() {
        List<Role> roles = new ArrayList<>();

        roles.add(new Role("露西亚", 17, '女'));
        roles.add(new Role("八重樱", 500, '女'));
        roles.add(new Role("卡莲", 500, '女'));
        roles.add(new Role("芽衣", 20, '女'));

        listIterator(roles);
    }

    static <T> void listIterator(List<T> list) {
        System.out.print('[');
        for (T e : list) {
            System.out.print(e);
            if (e != list.get(list.size() - 1)) {
                System.out.print(",\t");
            }
        }
        System.out.println(']');
    }
}