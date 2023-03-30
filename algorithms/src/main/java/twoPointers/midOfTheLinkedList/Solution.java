package twoPointers.midOfTheLinkedList;

import commonDataStructures.ListNode;
import org.junit.Test;

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
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
        ListNode.PrintNode(middleNode(node1));
    }
}
