package commonDataStructures;



/**
 * Created by hxchen on 2018/6/12.
 */
public class ListNode {

    public int value;
    public ListNode next;

    public ListNode(int value){
        this.value = value;
    }

    /**
     * 串联2个节点为链表
     * @param firstNode
     * @param secondNode
     */
    public static void ConnectListNode(ListNode firstNode, ListNode secondNode){
        firstNode.next = secondNode;
    }

}
