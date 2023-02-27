package removeDuplicatesFromSortedList;


/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * 输入：head = [1,2,3,3,4,4,5] 输出：[1,2,5]
 * 输入：head = [1,1,1,2,3] 输出：[2,3]
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        // 因为链表头结点可能会被删除，因此我们需要额外使用一个哑节点（dummy node）指向链表的头节点。
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, current = pre.next;
        while (current != null && current.next != null){
            if (current.val == current.next.val){
                int val = current.val;
                while (current != null && current.val == val){
                    current = current.next;
                }
                pre.next = current;
            } else {
                pre = current;
                current = current.next;
            }
        }
        return dummy.next;
    }
}
