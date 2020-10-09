package top.fallenangel._15datastructure.stack;

@SuppressWarnings("ALL")
public class StackArrayImpl<E> implements IStack<E> {
    private Object[] elements;
    private int capacity;
    private int size;

    public StackArrayImpl() {
        this(10);
    }

    public StackArrayImpl(int capacity) {
        elements = new Object[capacity];
        this.capacity = capacity;
        size = 0;
    }

    /**
     * 将元素添加到栈顶并返回
     *
     * @param item 要添加的元素
     *
     * @return 返回结果
     */
    public E push(E item) {
        if (size == capacity) {
            capacity = capacity * 2;
            Object[] newElements = new Object[capacity];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size++] = item;
        return item;
    }

    /**
     * 查看栈顶元素但不删除它
     *
     * @return 栈顶元素
     */
    @SuppressWarnings("unchecked")
    public E peek() {
        return (E) elements[size - 1];
    }

    /**
     * 删除栈顶元素，然后返回它
     *
     * @return 栈顶元素
     */
    public E pop() {
        E item = peek();
        size--;
        return item;
    }

    /**
     * 搜索元素在栈中的从栈顶往下数的位置，不存在则返回-1
     *
     * @param o 要搜索的元素
     *
     * @return o在栈中的位置
     */
    public int search(Object o) {
        int pos = 1;
        boolean found = false;

        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(o)) {
                found = true;
                break;
            }
            pos++;
        }

        return found ? pos : -1;
    }

    /**
     * 判断当前栈是否为空
     *
     * @return 判断结果
     */
    public boolean empty() {
        return size == 0;
    }

    /**
     * 返回当前栈中元素的数量
     *
     * @return 元素数量
     */
    public int size() {
        return size;
    }

    /**
     * 清空栈中元素
     */
    public void clear() {
        size = 0;
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
        return "栈中元素：{ " + elementsBuilder.toString() + " }";
    }
}