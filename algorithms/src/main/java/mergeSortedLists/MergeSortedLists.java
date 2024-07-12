package mergeSortedLists;

import commonDataStructures.ListNode;
import org.junit.Test;

/**
 * 合并两个排序的链表
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
 * 照递增排序的。
 * Created by hxchen on 2018/6/17.
 */
public class MergeSortedLists {

    public static ListNode mergeSortdLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode listNode = null;
        if (list1.value <= list2.value) {
            listNode = list1;
            listNode.next = mergeSortdLists(list1.next, list2);
        } else {
            listNode = list2;
            listNode.next = mergeSortdLists(list1, list2.next);
        }

        return listNode;
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(list1 != null && list2 != null) {
            if(list1.value <= list2.value) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }
        return dummy.next;
    }

    @Test
    public void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode.ConnectListNode(node1, node3);
        ListNode.ConnectListNode(node3, node5);

        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode.ConnectListNode(node2, node4);
        ListNode.ConnectListNode(node4, node6);

        System.out.println("合并前链表1:");
        ListNode.PrintNode(node1);
        System.out.println("合并前链表2:");
        ListNode.PrintNode(node2);
        ListNode merge = MergeSortedLists.mergeSortdLists(node1, node2);
        System.out.println("合并完链表:");
        ListNode.PrintNode(merge);
    }

    @Test
    public void test2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        System.out.println("合并前链表1:");
        ListNode.PrintNode(node1);
        System.out.println("合并前链表2:");
        ListNode.PrintNode(node2);
        ListNode merge = MergeSortedLists.mergeSortdLists(node1, node2);
        System.out.println("合并完链表:");
        ListNode.PrintNode(merge);
    }

    @Test
    public void test3() {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode.ConnectListNode(node1, node3);
        ListNode.ConnectListNode(node3, node5);

        ListNode node2 = null;

        System.out.println("合并前链表1:");
        ListNode.PrintNode(node1);
        System.out.println("合并前链表2:");
        ListNode.PrintNode(node2);
        ListNode merge = MergeSortedLists.mergeSortdLists(node1, node2);
        System.out.println("合并完链表:");
        ListNode.PrintNode(merge);
    }

    @Test
    public void test4() {
        ListNode node1 = null;
        ListNode node2 = null;
        System.out.println("合并前链表1:");
        ListNode.PrintNode(node1);
        System.out.println("合并前链表2:");
        ListNode.PrintNode(node2);
        ListNode merge = MergeSortedLists.mergeSortdLists(node1, node2);
        System.out.println("合并完链表:");
        ListNode.PrintNode(merge);

    }

    @Test
    public void test5() {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode.ConnectListNode(node1, node3);
        ListNode.ConnectListNode(node3, node5);

        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode.ConnectListNode(node2, node4);
        ListNode.ConnectListNode(node4, node6);

        System.out.println("合并前链表1:");
        ListNode.PrintNode(node1);
        System.out.println("合并前链表2:");
        ListNode.PrintNode(node2);
        ListNode merge = MergeSortedLists.mergeTwoLists(node1, node2);
        System.out.println("合并完链表:");
        ListNode.PrintNode(merge);
    }
}
