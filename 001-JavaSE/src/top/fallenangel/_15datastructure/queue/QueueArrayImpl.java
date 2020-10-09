package top.fallenangel._15datastructure.queue;

import java.util.NoSuchElementException;

@SuppressWarnings("ALL")
public class QueueArrayImpl<E> implements IQueue<E> {
    private int size;
    private int capacity;
    private Object[] elements;

    public QueueArrayImpl() {
        this(3);
    }

    public QueueArrayImpl(int capacity) {
        elements = new Object[capacity];
        this.capacity = capacity;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public boolean add(E e) {
        if (size == capacity) {
            capacity = capacity * 2;
            Object[] newElements = new Object[capacity];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size++] = e;
        return true;
    }

    @Override
    public boolean offer(E e) {
        add(e);
        return true;
    }

    @Override
    public E element() {
        if (size == 0) {
            throw new NoSuchElementException("队列为空");
        }
        return (E) elements[size - 1];
    }

    @Override
    public E peek() {
        return size == 0 ? null : (E) elements[size - 1];
    }

    @Override
    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException("队列为空");
        }
        return (E) elements[--size];
    }

    @Override
    public E poll() {
        return size == 0 ? null : (E) elements[--size];
    }

    @Override
    public String toString() {
        StringBuilder elementsBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            elementsBuilder.append(elements[i]);
            if (i < size - 1) {
                elementsBuilder.append('\t');
            }
        }

        return "队中元素：{  " + elementsBuilder + "  }";
    }
}