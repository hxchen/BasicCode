package recursion.mergeTwoSortedLists;

import commonDataStructures.ListNode;
import org.junit.Test;

public class Solution {
    /**
     * 递归合并升序链表
     * 时间 0 ms 击败 100%
     * 内存 41.3 MB 击败 6.31%
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null){
            ListNode node;
            if (list1.value < list2.value){
                node = list1;
                node.next = mergeTwoLists(list1.next, list2);
            }else{
                node = list2;
                node.next = mergeTwoLists(list1, list2.next);
            }
            return node;
        } if (list1 == null){
            return list2;
        }else {
            return list1;
        }
    }

    /**
     * 双指针合并
     * 时间 0 ms 击败 100%
     * 内存 41 MB 击败 46.42%
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2){
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode dummp = new ListNode(0);
        ListNode last = dummp;
        while (list1 != null && list2 != null){
            if (list1.value < list2.value){
                last.next = list1;
                list1 = list1.next;
            }else{
                last.next = list2;
                list2 = list2.next;
            }
            last = last.next;
        }
        if (list1 != null){
            last.next = list1;
        }
        if (list2 != null){
            last.next = list2;
        }
        return dummp.next;
    }

    @Test
    public void Test1(){

        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2, node4);
        ListNode node1 = new ListNode(1, node2);

        ListNode node24 = new ListNode(4);
        ListNode node23 = new ListNode(3, node24);
        ListNode node21 = new ListNode(1, node23);

        ListNode newNode = mergeTwoLists2(node1, node21);
        ListNode.PrintNode(newNode);
    }
    @Test
    public void Test3(){
        ListNode node20 = new ListNode(0);
        ListNode newNode = mergeTwoLists2(null, node20);
        ListNode.PrintNode(newNode);
    }
    @Test
    public void Test2(){
        ListNode newNode = mergeTwoLists2(null, null);
        ListNode.PrintNode(newNode);
    }
}
