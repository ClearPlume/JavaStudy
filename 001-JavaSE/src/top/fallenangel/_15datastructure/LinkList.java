package top.fallenangel._15datastructure;

@SuppressWarnings("ALL")
public class LinkList<E> {
    private class Node {
        private E data;
        private Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private final Node head;
    private int size;

    public LinkList() {
        head = new Node(null, null);
        size = 0;
    }

    /**
     * 在链表末尾新增元素
     *
     * @param item 新增的元素
     */
    public void add(E item) {
        Node newNode = new Node(item, null);
        Node curLast = getSize() == 0 ? head : getNode(getSize() - 1);
        curLast.setNext(newNode);
        size++;
    }

    /**
     * 获取index位置的元素
     *
     * @param index 位置
     *
     * @return 元素
     */
    public E get(int index) {
        return getNode(index).getData();
    }

    /**
     * 获取index位置的节点
     *
     * @param index 位置
     *
     * @return 节点
     */
    private Node getNode(int index) {
        Node tar = head;

        for (int i = 0; i <= index; i++) {
            tar = tar.getNext();
        }

        return tar;
    }

    /**
     * 设置index位置的元素
     *
     * @param index 位置
     * @param item  元素
     */
    public void set(int index, E item) {
        getNode(index).setData(item);
    }

    public E remove(int index) {
        E item = get(index);
        getNode(index - 1).setNext(null);
        size--;
        return item;
    }

    /**
     * 清空链表
     */
    public void clear() {
        size = 0;
        head.setNext(null);
    }

    /**
     * 获取链表的长度
     *
     * @return 长度
     */
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder allData = new StringBuilder();

        for (int i = 0; i < size; i++) {
            allData.append(get(i));
            if (i != size - 1) {
                allData.append('\t');
            }
        }

        return "链表中的元素：{  " + allData.toString() + "  }";
    }
}