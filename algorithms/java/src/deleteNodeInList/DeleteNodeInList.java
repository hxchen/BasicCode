package deleteNodeInList;

import org.junit.Test;

/**
 * 在O(1)时间删除链表结点
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该
 * 结点。
 * Created by hxchen on 2018/6/6.
 */
public class DeleteNodeInList {

    public class ListNode{
        int value;
        ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }

    /**
     * 删除链表节点
     * @param head
     * @param deletedNode
     */
    public static void deleteNode(ListNode head, ListNode deletedNode){
        if(head == null || deletedNode == null){
            return;
        }
        if(deletedNode.next != null){   // 链表有多个节点，要删除的不是尾节点:O(1)时间
            ListNode nextNode = deletedNode.next;
            deletedNode.value = nextNode.value;
            deletedNode.next = nextNode.next;
            nextNode = null;
        }else if(head == deletedNode){  // 链表只有一个结点，删除头结点（也是尾结点）:O(1)时间
            deletedNode = null;
            head = null;
        }else{// 链表有多个节点，要删除的是尾节点:O(n)时间
            ListNode node = head;
            while (node.next != deletedNode){
                node = node.next;
            }
            node.next = null;
            deletedNode = null;
        }
    }

    /**
     * 打印链表
     * @param node
     */
    public static void PrintList(ListNode node){
        if(node == null){
            System.out.println("空链表");
        }else{
            System.out.print(node.value + "\t");
            while (node.next != null){
                node = node.next;
                System.out.print(node.value+ "\t");
            }
        }
        System.out.println();

    }

    /**
     * 串联2个节点为链表
     * @param firstNode
     * @param secondNode
     */
    public static void ConnectListNode(ListNode firstNode, ListNode secondNode){
        firstNode.next = secondNode;
    }

    // ====================测试代码====================
    public void Test(ListNode head, ListNode deleteNode){
        System.out.println("*********************");
        System.out.println("原始链表:");
        PrintList(head);
        System.out.println("想要删除的节点\t" + (null == deleteNode ? null : deleteNode.value));
        deleteNode(head, deleteNode);
        System.out.println("删除后的链表:");
        PrintList(head);
    }

    // 链表中有多个结点，删除中间的结点
    public void test1(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ConnectListNode(node1, node2);
        ConnectListNode(node2, node3);
        ConnectListNode(node3, node4);
        ConnectListNode(node4, node5);

        Test(node1, node3);
    }

    // 链表中有多个结点，删除尾结点
    public void test2(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ConnectListNode(node1, node2);
        ConnectListNode(node2, node3);
        ConnectListNode(node3, node4);
        ConnectListNode(node4, node5);

        Test(node1, node5);
    }

    // 链表中有多个结点，删除头结点
    public void test3(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ConnectListNode(node1, node2);
        ConnectListNode(node2, node3);
        ConnectListNode(node3, node4);
        ConnectListNode(node4, node5);

        Test(node1, node1);
    }

    // 链表中只有一个结点，删除头结点
    // 只是局部变量传入,只会导致局部变量被删除
    public void test4(){
        ListNode node1 = new ListNode(1);
        Test(node1, node1);
    }

    // 链表为空
    public void test5(){
        Test(null ,null);
    }

    @Test
    public void startTest(){
        test1();
        test2();
        test3();
        test4();
        test5();
    }

}
