package printListInReversedOrder;

import org.junit.Test;


/**
 * 从尾到头打印链表
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 * Created by hxchen on 2018/5/17.
 */
public class PrintListInReversedOrder {

    // 1->2->3->4->5
    @Test
    public void Test1(){
        System.out.println("Test1 begins.");
        ListNode<Integer> listNode = new ListNode<Integer>();
        listNode.insert(1);
        listNode.insert(2);
        listNode.insert(3);
        listNode.insert(4);
        listNode.insert(5);
        listNode.print(listNode.head);
        System.out.print("PrintListReversingly_Iteratively:");
        listNode.PrintListReversingly_Iteratively(listNode.head);
        System.out.print("PrintListReversingly_Recursively:");
        listNode.PrintListReversingly_Recursively(listNode.head);
    }

    // 只有一个节点 1
    @Test
    public void Test2(){
        System.out.println("Test2 begins.");
        ListNode<Integer> listNode = new ListNode<Integer>();
        listNode.insert(1);
        listNode.print(listNode.head);
        System.out.print("PrintListReversingly_Iteratively:");
        listNode.PrintListReversingly_Iteratively(listNode.head);
        System.out.print("PrintListReversingly_Recursively:");
        listNode.PrintListReversingly_Recursively(listNode.head);
    }
}
