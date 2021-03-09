package commonDataStructures;

import org.junit.Test;

/**
 * @author haixiangchen
 */
public class ListNodeTest {
    @Test
    public void testReverse(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);
        ListNode.ConnectListNode(node4, node5);
        ListNode.PrintNode(node1);
        ListNode.PrintNode(ListNode.reverse(node1));
    }
}
