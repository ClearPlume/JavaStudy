package top.fallenangel._15datastructure.queue;

@SuppressWarnings("ALL")
public interface IQueue<E> {
    /**
     * 添加一个元素到队列的末尾，返回添加成功与否
     *
     * @param e 要添加的元素
     *
     * @return 是否成功
     */
    boolean add(E e);

    /**
     * 添加一个元素到队列末尾，返回添加成功与否
     *
     * @param e 要添加的元素
     *
     * @return 是否成功
     */
    boolean offer(E e);

    /**
     * 返回队列的头，但不删除它
     *
     * @return 队列的头
     *
     * @throws java.util.NoSuchElementException 若队列为空
     */
    E element();

    /**
     * 返回队列的头，但不会删除它。若队列为空则返回null
     *
     * @return 队列的头
     */
    E peek();

    /**
     * 返回队列的头并删除它，即出列。若队列为空则返回null
     *
     * @return 队列的头
     */
    E poll();

    /**
     * 返回并删除队列的头，即出列
     *
     * @return 队列的头
     *
     * @throws java.util.NoSuchElementException 若队列为空
     */
    E remove();

    int size();

    boolean empty();

    void clear();
}