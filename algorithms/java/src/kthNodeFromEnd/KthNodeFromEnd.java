package kthNodeFromEnd;

import commonDataStructures.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 *  面试题22：链表中倒数第k个结点
 * 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
 * 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
 * 值为4的结点。
 * Created by hxchen on 2018/6/12.
 */
public class KthNodeFromEnd {


    public static ListNode kthNodeFromEnd(ListNode head, int k){
        if (null == head || k <= 0){
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < k-1; i++){
          if(first.next != null){
              first = first.next;
          }else{
              return null;
          }
        }
        while (first.next != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }
    // 中间测试
    @Test
    public void test1(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);
        ListNode.ConnectListNode(node4, node5);

        ListNode node = kthNodeFromEnd(node1, 2);
        Assert.assertSame(node4,node);
    }
    // 边界测试1
    @Test
    public void test2(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);
        ListNode.ConnectListNode(node4, node5);

        ListNode node = kthNodeFromEnd(node1, 1);
        Assert.assertSame(node5,node);
    }
    // 边界测试2
    @Test
    public void test3(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);
        ListNode.ConnectListNode(node4, node5);

        ListNode node = kthNodeFromEnd(node1, 5);
        Assert.assertSame(node1,node);
    }
    // 越界测试
    @Test
    public void test4(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);
        ListNode.ConnectListNode(node4, node5);

        ListNode node = kthNodeFromEnd(node1, 6);
        Assert.assertSame(null,node);
    }
    // 第二个参数为 0 测试
    @Test
    public void test5(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);
        ListNode.ConnectListNode(node4, node5);

        ListNode node = kthNodeFromEnd(node1, 0);
        Assert.assertSame(null,node);
    }

    // 空链表测试
    @Test
    public void test6(){
        ListNode node = kthNodeFromEnd(null, 2);
        Assert.assertSame(null,node);
    }


}
