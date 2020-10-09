package top.fallenangel._15datastructure.stack;

public interface IStack<E> {
    E push(E item);

    E peek();

    E pop();

    void clear();

    int size();

    boolean empty();

    int search(Object o);
}