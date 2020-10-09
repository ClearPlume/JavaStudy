package top.fallenangel._15datastructure.queue;

import top.fallenangel._15datastructure.LinkList;

import java.util.NoSuchElementException;

@SuppressWarnings("ALL")
public class QueueLinkImpl<E> implements IQueue<E> {
    private int size;
    private final LinkList<E> elements;

    public QueueLinkImpl() {
        elements = new LinkList<>();
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
        elements.clear();
        size = 0;
    }

    @Override
    public boolean add(E e) {
        elements.add(e);
        size++;
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
        return elements.get(size - 1);
    }

    @Override
    public E peek() {
        return size == 0 ? null : elements.get(size - 1);
    }

    @Override
    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException("队列为空");
        }
        return elements.get(--size);
    }

    @Override
    public E poll() {
        return size == 0 ? null : elements.get(--size);
    }

    @Override
    public String toString() {
        StringBuilder elementsBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            elementsBuilder.append(elements.get(i));
            if (i < size - 1) {
                elementsBuilder.append('\t');
            }
        }

        return "队中元素：{  " + elementsBuilder + "  }";
    }
}