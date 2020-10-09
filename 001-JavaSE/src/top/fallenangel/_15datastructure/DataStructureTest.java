package top.fallenangel._15datastructure;

import top.fallenangel._15datastructure.queue.IQueue;
import top.fallenangel._15datastructure.queue.QueueArrayImpl;
import top.fallenangel._15datastructure.queue.QueueLinkImpl;
import top.fallenangel._15datastructure.stack.IStack;
import top.fallenangel._15datastructure.stack.StackArrayImpl;
import top.fallenangel._15datastructure.stack.StackLinkImpl;

public class DataStructureTest {
    public static void main(String[] args) {
        testStack(new StackArrayImpl<>(), "hello", "power", "node", "asd");
        System.out.println();
        System.out.println("************************************************************");
        System.out.println();
        testStack(new StackLinkImpl<>(), "hello", "power", "node", "asd");
        System.out.println("************************************************************");
        System.out.println();
        testQueue(new QueueArrayImpl<>(), "hello", "power", "node", "asd");
        System.out.println();
        System.out.println("************************************************************");
        System.out.println();
        testQueue(new QueueLinkImpl<>(), "hello", "power", "node", "asd");
    }

    @SafeVarargs
    public static <E> void testStack(IStack<E> stack, E... elements) {
        System.out.println(stack.empty() ? "栈空" : "不空");
        System.out.println("size：" + stack.size());

        for (E element : elements) {
            System.out.println(stack.push(element) + "\t入栈");
        }

        System.out.println("栈顶：" + stack.peek());
        System.out.println("size：" + stack.size());
        System.out.println(stack);
        System.out.println("power：" + stack.search("power"));

        System.out.println(stack.pop() + "出栈");
        System.out.println("size：" + stack.size());
        System.out.println(stack);
        System.out.println("power：" + stack.search("power"));

        stack.clear();

        System.out.println("栈已清空");
        System.out.println(stack.empty() ? "栈空" : "不空");
        System.out.println("size：" + stack.size());
        System.out.println(stack);
    }

    @SafeVarargs
    public static <E> void testQueue(IQueue<E> queue, E... elements) {
        System.out.println(queue.empty() ? "队空" : "不空");
        System.out.println("size：" + queue.size());

        {
            boolean flag = false;
            for (E element : elements) {
                if (flag) {
                    queue.add(element);
                } else {
                    queue.offer(element);
                }
                flag = !flag;
                System.out.println(element + "\t入队");
            }
        }

        System.out.println("队头：" + queue.peek());
        System.out.println("size：" + queue.size());
        System.out.println(queue);

        System.out.println(queue.poll() + "出队");
        System.out.println("size：" + queue.size());
        System.out.println(queue);

        System.out.println("队头：" + queue.element());
        System.out.println("size：" + queue.size());
        System.out.println(queue);

        System.out.println(queue.remove() + "出队");
        System.out.println("size：" + queue.size());
        System.out.println(queue);

        queue.clear();

        System.out.println("队已清空");
        System.out.println(queue.empty() ? "队空" : "不空");
        System.out.println("size：" + queue.size());
        System.out.println(queue);
    }
}