package queueWithTwoStacks;

import junit.framework.Test;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
 * 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 * Created by hxchen on 2018/5/26.
 */
public class QueueWithTwoStacks {
    public static class JQueue<E>{

        private Stack<E> stack1;
        private Stack<E> stack2;

        public JQueue(){
            stack1 = new Stack<E>();
            stack2 = new Stack<E>();
        }
        public void appendTail(E ele){
            stack1.push(ele);
        }
        public E deleteHead(){
            if(stack2.size() == 0){
                while (stack1.size() > 0){
                    E element = stack1.pop();
                    stack2.push(element);
                }
            }
            if(stack2.size() == 0){
                System.err.println("queue is empty");
            }
            E element = stack2.pop();
            return element;
        }
    }

    // ====================测试代码====================
    public static void TestQueue(String string, String expected){
        if(string.equals(expected)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
    }

    public static void main(String[] args) {
        JQueue<String> queue = new JQueue<String>();
        queue.appendTail("a");
        queue.appendTail("b");
        queue.appendTail("c");

        String head = queue.deleteHead();
        TestQueue(head, "a");

        head = queue.deleteHead();
        TestQueue(head, "b");

        queue.appendTail("d");
        head = queue.deleteHead();
        TestQueue(head, "c");

        queue.appendTail("e");
        head = queue.deleteHead();
        TestQueue(head, "d");

        head = queue.deleteHead();
        TestQueue(head, "e");

    }
}
