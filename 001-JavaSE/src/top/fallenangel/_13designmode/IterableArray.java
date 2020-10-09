package top.fallenangel._13designmode;

import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("ALL")
public class IterableArray<T> implements Iterable<T> {
    private class ArrayIterator implements Iterator<T> {
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor < length;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            return (T) data[cursor++];
        }
    }

    private final int length;
    private final Object[] data;

    public IterableArray(int length) {
        this.length = length;
        data = new Object[length];
        fill(null);
    }
    public int getLength() {
        return length;
    }

    public void setElement(int index, T element) {
        data[index] = element;
    }

    @SafeVarargs
    public final void setElements(T... elements) {
        System.arraycopy(elements, 0, data, 0, elements.length);
    }

    public void fill(T element) {
        Arrays.fill(data, element);
    }

    @SuppressWarnings("unchecked")
    public T getElement(int index) {
        return (T) data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }
}