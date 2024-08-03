package stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> dataStack;
    Deque<Integer> minStack;

    /**
     * 初始化堆栈对象。
     */
    public MinStack() {
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);

    }

    /**
     * 将元素val推入堆栈。
     * @param val
     */
    public void push(int val) {
        dataStack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }

    /**
     * 删除堆栈顶部的元素。
     */
    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    /**
     * 获取堆栈顶部的元素。
     * @return
     */
    public int top() {
        return dataStack.peek();
    }

    /**
     * 获取堆栈中的最小元素。
     * @return
     */
    public int getMin() {
        return minStack.peek();
    }
}
