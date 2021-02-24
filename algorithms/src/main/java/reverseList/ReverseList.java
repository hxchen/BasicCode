package reverseList;

import commonDataStructures.ListNode;
import org.junit.Test;


/**
 * 反转链表
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
 * 头结点。
 * Created by hxchen on 2018/6/14.
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode newHead = null;
        ListNode node = head;
        ListNode preNode = null;
        while (node != null) {
            ListNode nextNode = node.next;
            if (nextNode == null)
                newHead = node;

            node.next = preNode;
            preNode = node;
            node = nextNode;
        }
        return newHead;
    }

    public void test(ListNode head) {
        System.out.print("原来链表是:");
        ListNode.PrintNode(head);
        System.out.print("反转后的链表是:");
        ListNode newHead = reverseList(head);
        ListNode.PrintNode(newHead);
    }

    // 反转多节点
    @Test
    public void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);
        ListNode.ConnectListNode(node4, node5);

        test(node1);
    }

    // 反转单节点
    @Test
    public void test2() {
        ListNode node1 = new ListNode(1);

        test(node1);
    }

    @Test
    public void test3() {
        test(null);
    }

}
