package reorderList;

import commonDataStructures.ListNode;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author haixiangchen
 */
public class Solution {

    public void reorderList(ListNode head) {

        if (head == null) {
            return;
        }

        // 获得中间节点
        ListNode mid = findMid(head);

        // 中间节点之后的部分进行反转
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverse(head2);

        // 合并
        ListNode head1 = head;
        mergeList(head1, head2);
    }

    private void mergeList(ListNode head1, ListNode head2) {
        ListNode next1 = null;
        ListNode next2 = null;
        while (head1 != null && head2 != null) {
            next1 = head1.next;
            next2 = head2.next;

            head1.next = head2;
            head1 = next1;

            head2.next = head1;
            head2 = next2;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }

    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);
        ListNode.PrintNode(node1);
        Solution solution = new Solution();
        solution.reorderList(node1);
        ListNode.PrintNode(node1);
    }

}
