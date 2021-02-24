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

}
