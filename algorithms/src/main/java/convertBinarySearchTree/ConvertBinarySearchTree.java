package convertBinarySearchTree;

import commonDataStructures.BinaryTreeNode;
import org.junit.Test;

/**
 * 二叉搜索树与双向链表
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求
 * 不能创建任何新的结点，只能调整树中结点指针的指向。
 * Created by hxchen on 2018/7/7.
 */
public class ConvertBinarySearchTree {

    /**
     * 讲一个二叉树转换为排序的双向链表,转换后左子节点指向前一个节点,右子节点指向下一个节点。
     *
     * @param root
     * @return
     */
    public BinaryTreeNode convert(BinaryTreeNode root) {
        BinaryTreeNode lastNodeInList = null;   // 指向双向链表的尾节点
        lastNodeInList = convertNode(root, lastNodeInList);
        BinaryTreeNode headOfList = lastNodeInList;
        while (headOfList != null && headOfList.left != null) {
            headOfList = headOfList.left;
        }
        return headOfList;

    }

    private static BinaryTreeNode convertNode(BinaryTreeNode node, BinaryTreeNode lastNodeInList) {
        if (node == null)
            return null;

        BinaryTreeNode current = node;

        if (current.left != null)
            lastNodeInList = convertNode(current.left, lastNodeInList);

        current.left = lastNodeInList;

        if (lastNodeInList != null)
            lastNodeInList.right = current;

        lastNodeInList = current;
        if (current.right != null)
            lastNodeInList = convertNode(current.right, lastNodeInList);
        return lastNodeInList;
    }

    // ====================测试代码====================
    public void PrintDoubleLinkedList(BinaryTreeNode headOfList) {
        BinaryTreeNode node = headOfList;

        System.out.print("The nodes from left to right are:\n");
        while (node != null) {
            System.out.format("%d\t", node.value);

            if (node.right == null)
                break;
            node = node.right;
        }

        System.out.print("\nThe nodes from right to left are:\n");
        while (node != null) {
            System.out.format("%d\t", node.value);

            if (node.left == null)
                break;
            node = node.left;
        }

        System.out.print("\n");
    }

    public void Test(String testName, BinaryTreeNode root) {
        if (testName != null)
            System.out.format("%s begins:\n", testName);

        BinaryTreeNode.PrintTree(root);

        BinaryTreeNode headOfList = convert(root);

        PrintDoubleLinkedList(headOfList);
    }

    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    @Test
    public void Test1() {
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node14 = new BinaryTreeNode(14);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node12 = new BinaryTreeNode(12);
        BinaryTreeNode node16 = new BinaryTreeNode(16);

        BinaryTreeNode.ConnectTreeNode(node10, node6, node14);
        BinaryTreeNode.ConnectTreeNode(node6, node4, node8);
        BinaryTreeNode.ConnectTreeNode(node14, node12, node16);

        Test("Test1", node10);

    }

    //               5
    //              /
    //             4
    //            /
    //           3
    //          /
    //         2
    //        /
    //       1
    @Test
    public void Test2() {
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node1 = new BinaryTreeNode(1);

        BinaryTreeNode.ConnectTreeNode(node5, node4, null);
        BinaryTreeNode.ConnectTreeNode(node4, node3, null);
        BinaryTreeNode.ConnectTreeNode(node3, node2, null);
        BinaryTreeNode.ConnectTreeNode(node2, node1, null);

        Test("Test2", node5);

    }

    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    @Test
    public void Test3() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);

        BinaryTreeNode.ConnectTreeNode(node1, null, node2);
        BinaryTreeNode.ConnectTreeNode(node2, null, node3);
        BinaryTreeNode.ConnectTreeNode(node3, null, node4);
        BinaryTreeNode.ConnectTreeNode(node4, null, node5);

        Test("Test3", node1);

    }

    // 树中只有1个结点
    @Test
    public void Test4() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        Test("Test4", node1);

    }

    // 树中没有结点
    @Test
    public void Test5() {
        Test("Test5", null);
    }
}
