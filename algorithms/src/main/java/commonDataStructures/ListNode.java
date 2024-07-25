package commonDataStructures;



/**
 * Created by hxchen on 2018/6/12.
 */
public class ListNode {

    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    /**
     * 串联2个节点为链表
     *
     * @param firstNode
     * @param secondNode
     */
    public static void ConnectListNode(ListNode firstNode, ListNode secondNode) {
        firstNode.next = secondNode;
    }

    public static void PrintNode(ListNode head) {
        if (head == null) {
            System.out.print("空链表");
        }
        while (head != null) {
            System.out.print(head.value + "   ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 迭代方式逆序链表
     *
     * @param head
     */
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 删除倒数第N个节点
     * @param head
     * @param n
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public static void main(String[] args) throws Exception {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ConnectListNode(node1, node2);
        ConnectListNode(node2, node3);
        ConnectListNode(node3, node4);
        ConnectListNode(node4, node5);
        ConnectListNode(node5, node6);
        PrintNode(node1);
        PrintNode(removeNthFromEnd(node1, 6));
    }
}
