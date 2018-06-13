package findEntryNodeInListLoop;

import commonDataStructures.ListNode;
import org.junit.Assert;
import org.junit.Test;


/**
 * 链表中环的入口结点
 * 题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
 * 环的入口结点是结点3。
 * Created by hxchen on 2018/6/14.
 */
public class FindEntryNodeInListLoop {
    /**
     * 查找环的入口点
     * @param head
     * @return
     */
    public static ListNode findEntryNodeInListLoop(ListNode head){
        ListNode meetingNode  = meetingNode(head);
        if (meetingNode == null)
            return null;

        int nodesCountInLoops = 1;  // 环的节点数目

        ListNode node = meetingNode;
        while (meetingNode != node.next){
            nodesCountInLoops++;
            node = node.next;
        }
        ListNode node1 = head;
        for (int i = 0; i < nodesCountInLoops; i++){
            node1 = node1.next;
        }
        ListNode node2 = head;
        while (node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;

    }

    /**
     * 查找链表中环内某一点,若没有环则返回null
     * @param head
     * @return
     */
    public static ListNode meetingNode(ListNode head){
        if (head == null)
            return null;
        ListNode slow = head.next;
        if(null == slow)
            return null;
        ListNode fast = slow.next;

        while (slow != null && fast != null){
            if(fast == slow)
                return fast;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return null;
    }
    // 单节点
    @Test
    public void test1(){
        ListNode node1 = new ListNode(1);
        ListNode entryNode = findEntryNodeInListLoop(node1);
        Assert.assertSame(entryNode, null);
    }
    // 单节点环
    @Test
    public void test2(){
        ListNode node1 = new ListNode(1);
        ListNode.ConnectListNode(node1, node1);
        ListNode entryNode = findEntryNodeInListLoop(node1);
        Assert.assertSame(entryNode, node1);
    }
    // 多节点环
    @Test
    public void test3(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);
        ListNode.ConnectListNode(node4, node5);
        ListNode.ConnectListNode(node5, node3);

        ListNode entryNode = findEntryNodeInListLoop(node1);
        Assert.assertSame(entryNode, node3);
    }
    // 多节点环
    @Test
    public void test4(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);
        ListNode.ConnectListNode(node4, node5);
        ListNode.ConnectListNode(node5, node1);

        ListNode entryNode = findEntryNodeInListLoop(node1);
        Assert.assertSame(entryNode, node1);
    }
    // 多节点环
    @Test
    public void test5(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);
        ListNode.ConnectListNode(node4, node5);
        ListNode.ConnectListNode(node5, node5);

        ListNode entryNode = findEntryNodeInListLoop(node1);
        Assert.assertSame(entryNode, node5);
    }

    // 多节点环
    @Test
    public void test6(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);
        ListNode.ConnectListNode(node4, node5);
        ListNode entryNode = findEntryNodeInListLoop(node1);
        Assert.assertSame(entryNode, null);
    }
    // 空节点测试
    @Test
    public void test7(){
        ListNode entryNode = findEntryNodeInListLoop(null);
        Assert.assertSame(entryNode, null);
    }

}
