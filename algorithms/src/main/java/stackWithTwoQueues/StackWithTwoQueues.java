package stackWithTwoQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用2个队列实现栈
 * Created by hxchen on 2018/5/26.
 */
public class StackWithTwoQueues {
    public static class JStack<E> {
        private Queue<E> queue1;
        private Queue<E> queue2;

        public JStack() {
            queue1 = new LinkedList<E>();
            queue2 = new LinkedList<E>();
        }

        public E pop() {
            if (queue1.size() == 0) {
                System.err.println("stack is empty.");
                return null;
            } else {
                while (queue1.size() > 1) {
                    E element = queue1.remove();
                    queue2.offer(element);
                }
                E element = queue1.remove();
                while (queue2.size() > 0) {
                    E ele = queue2.remove();
                    queue1.offer(ele);
                }
                return element;
            }
        }

        public E push(E ele) {
            queue1.offer(ele);
            return ele;
        }
    }

    // ====================测试代码====================
    public static void TestStack(String string, String expected) {
        if (string.equals(expected)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }

    public static void main(String[] args) {
        JStack<String> stack = new JStack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        String string = stack.pop();
        TestStack(string, "c");

        string = stack.pop();
        TestStack(string, "b");

        stack.push("e");
        string = stack.pop();
        TestStack(string, "e");

        string = stack.pop();
        TestStack(string, "a");
    }

}
