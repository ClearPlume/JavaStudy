package top.fallenangel._15datastructure.stack;

import top.fallenangel._15datastructure.LinkList;

public class StackLinkImpl<E> implements IStack<E> {
    private final LinkList<E> elements;
    private int size;

    public StackLinkImpl() {
        elements = new LinkList<>();
        size = 0;
    }

    public E push(E item) {
        size++;
        elements.add(item);
        return item;
    }

    public E peek() {
        return elements.get(size - 1);
    }

    public E pop() {
        size--;
        return elements.remove(elements.getSize() - 1);
    }

    public void clear() {
        elements.clear();
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size() == 0;
    }

    public int search(Object o) {
        int cursor = 1;
        boolean found = false;

        for (int i = size() - 1; i >= 0; i--) {
            if (elements.get(i).equals(o)) {
                found = true;
                break;
            }
            cursor++;
        }

        return found ? cursor : -1;
    }

    @Override
    public String toString() {
        StringBuilder elementsBuilder = new StringBuilder();

        for (int i = 0; i < size(); i++) {
            elementsBuilder.append(elements.get(i));
            if (i < size() - 1) {
                elementsBuilder.append('\t');
            }
        }

        return "栈中元素：{  " + elementsBuilder.toString() + "  }";
    }
}