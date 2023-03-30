package twoPointers.removeNthNodeFromEnd;

import commonDataStructures.ListNode;
import org.junit.Test;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummp = new ListNode(0, head);
        ListNode quick = dummp;
        ListNode slow = dummp;
        for (int i = 0; i < n; i++) {
            quick = quick.next;
        }
        while (quick != null && quick.next != null){
            quick = quick.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummp.next;
    }
    @Test
    public void Test1(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);
        ListNode.ConnectListNode(node4, node5);
        ListNode.ConnectListNode(node5, node6);
        ListNode.PrintNode(removeNthFromEnd(node1, 6));
    }
}
