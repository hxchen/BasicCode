package list_node;

import commonDataStructures.ListNode;
import org.junit.Test;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // 哨兵节点
        ListNode current = dummy;
        int carry = 0; // 进位值

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.value : 0;
            int y = (l2 != null) ? l2.value : 0;
            int sum = carry + x + y;
            carry = sum / 10; // 更新进位值
            current.next = new ListNode(sum % 10); // 创建新节点
            current = current.next; // 移动指针

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // 如果最后有进位值，创建新节点
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

}
