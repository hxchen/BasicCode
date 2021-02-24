package firstCommonNodesInLists;

import commonDataStructures.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 两个链表的第一个公共结点
 * 题目：输入两个链表，找出它们的第一个公共结点。
 * Created by hxchen on 2018/8/5.
 */
public class FirstCommonNodesInLists {


    public ListNode firstCommonNodesInLists(ListNode listNode1, ListNode listNode2) {
        int length1 = getListNodeLength(listNode1);
        int length2 = getListNodeLength(listNode2);
        int diff = length1 - length2;
        ListNode longListNode = listNode1;
        ListNode shortListNode = listNode2;
        if (length2 > length1) {
            longListNode = listNode2;
            shortListNode = listNode1;
            diff = length2 - length1;
        }
        for (int i = 0; i < diff; i++) {
            longListNode = longListNode.next;
        }
        while (longListNode != null && shortListNode != null && longListNode != shortListNode) {
            longListNode = longListNode.next;
            shortListNode = shortListNode.next;
        }
        return longListNode;
    }

    /**
     * 获取 ListNode 长度
     *
     * @param listNode
     * @return
     */
    private int getListNodeLength(ListNode listNode) {
        int length = 0;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        return length;
    }

    // 第一个公共结点在链表中间
    // 1 - 2 - 3 \
    //            6 - 7
    //     4 - 5 /
    @Test
    public void Test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node6);
        ListNode.ConnectListNode(node4, node5);
        ListNode.ConnectListNode(node5, node6);
        ListNode.ConnectListNode(node6, node7);

        ListNode commonNode = firstCommonNodesInLists(node1, node4);
        Assert.assertSame(node6, commonNode);
    }

    // 没有公共结点
    // 1 - 2 - 3 - 4
    //
    // 5 - 6 - 7
    @Test
    public void Test2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);

        ListNode.ConnectListNode(node5, node6);
        ListNode.ConnectListNode(node6, node7);

        ListNode commonNode = firstCommonNodesInLists(node1, node5);
        Assert.assertTrue(null == commonNode);
    }

    // 公共结点是最后一个结点
    // 1 - 2 - 3 - 4 \
    //                7
    //         5 - 6 /
    @Test
    public void Test3() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);
        ListNode.ConnectListNode(node4, node7);

        ListNode.ConnectListNode(node5, node6);
        ListNode.ConnectListNode(node6, node7);

        ListNode commonNode = firstCommonNodesInLists(node1, node5);
        Assert.assertTrue(node7 == commonNode);
    }

    // 公共结点是第一个结点
    // 1 - 2 - 3 - 4 - 5
    // 两个链表完全重合
    @Test
    public void Test4() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);


        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);
        ListNode.ConnectListNode(node4, node5);


        ListNode commonNode = firstCommonNodesInLists(node1, node1);
        Assert.assertTrue(node1 == commonNode);
    }

    // 输入的两个链表有一个空链表
    @Test
    public void Test5() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);


        ListNode.ConnectListNode(node1, node2);
        ListNode.ConnectListNode(node2, node3);
        ListNode.ConnectListNode(node3, node4);


        ListNode commonNode = firstCommonNodesInLists(node1, null);
        Assert.assertTrue(null == commonNode);
    }

    // 输入2个空链表
    @Test
    public void Test6() {
        ListNode commonNode = firstCommonNodesInLists(null, null);
        Assert.assertTrue(null == commonNode);
    }

}
