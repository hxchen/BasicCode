package list_node;

import commonDataStructures.ListNode;

/**
 * 环形链表
 */
public class HasCycle {

    /**
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
     * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * 不允许修改 链表。
     *
     * 要检测一个链表是否有环，并找到环的起始节点，可以使用 Floyd 的「龟兔赛跑」算法（也称为「快慢指针」算法）。该算法分两步完成：
     * 检测链表中是否有环：
     * 使用快慢指针，快指针每次移动两步，慢指针每次移动一步。如果链表中有环，快慢指针最终会在环内相遇。
     * 找到环的起始节点：
     * 当快慢指针相遇后，将慢指针移回链表头节点，同时快指针保持在相遇点。然后，两指针每次都移动一步，它们最终会在环的起始节点相遇。
     * 具体实现如下：
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if there is a cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // Cycle detected
                break;
            }
        }

        // If no cycle is detected
        if (fast == null || fast.next == null) {
            return null;
        }

        // Step 2: Find the start node of the cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // slow (or fast) is the start of the cycle
    }
}
