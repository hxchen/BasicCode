package printTreeFromTopToBottom;

import commonDataStructures.BinaryTreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * 之字形打印二叉树
 * 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺
 * 序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，
 * 其他行以此类推。
 * Created by hxchen on 2018/7/2.
 */
public class PrintTreeInZigzag {

    public static void PrintTreeInZigzag(BinaryTreeNode root) {
        if (root == null)
            return;
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (stack1.size() != 0 || stack2.size() != 0) {
            while (stack1.size() != 0) {
                BinaryTreeNode node = stack1.pop();
                System.out.print(node.value + "\t");
                if (node.left != null)
                    stack2.push(node.left);
                if (node.right != null)
                    stack2.push(node.right);

            }
            System.out.println();
            while (stack2.size() != 0) {
                BinaryTreeNode node = stack2.pop();
                System.out.print(node.value + "\t");
                if (node.right != null)
                    stack1.push(node.right);
                if (node.left != null)
                    stack1.push(node.left);
            }
            System.out.println();
        }
    }

    // ====================测试代码====================
    //            8
    //        6      10
    //       5 7    9  11
    @Test
    public void Test1() {
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node11 = new BinaryTreeNode(11);

        BinaryTreeNode.ConnectTreeNode(node8, node6, node10);
        BinaryTreeNode.ConnectTreeNode(node6, node5, node7);
        BinaryTreeNode.ConnectTreeNode(node10, node9, node11);

        System.out.println("====Test1 Begins: ====");
        System.out.println("Expected Result is:");
        System.out.println("8 ");
        System.out.println("10 6 ");
        System.out.println("5 7 9 11 ");

        System.out.println("Actual Result is: ");
        PrintTreeInZigzag(node8);
        System.out.println("");

    }

    //            5
    //          4
    //        3
    //      2
    @Test
    public void Test2() {
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(2);

        BinaryTreeNode.ConnectTreeNode(node5, node4, null);
        BinaryTreeNode.ConnectTreeNode(node4, node3, null);
        BinaryTreeNode.ConnectTreeNode(node3, node2, null);

        System.out.println("====Test2 Begins: ====");
        System.out.println("Expected Result is:");
        System.out.println("5 ");
        System.out.println("4 ");
        System.out.println("3 ");
        System.out.println("2 ");

        System.out.println("Actual Result is: ");
        PrintTreeInZigzag(node5);
        System.out.println("");

    }

    //        5
    //         4
    //          3
    //           2
    @Test
    public void Test3() {
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(2);

        BinaryTreeNode.ConnectTreeNode(node5, null, node4);
        BinaryTreeNode.ConnectTreeNode(node4, null, node3);
        BinaryTreeNode.ConnectTreeNode(node3, null, node2);

        System.out.println("====Test3 Begins: ====");
        System.out.println("Expected Result is:");
        System.out.println("5 ");
        System.out.println("4 ");
        System.out.println("3 ");
        System.out.println("2 ");

        System.out.println("Actual Result is: ");
        PrintTreeInZigzag(node5);
        System.out.println("");

    }

    @Test
    public void Test4() {
        BinaryTreeNode node5 = new BinaryTreeNode(5);

        System.out.println("====Test4 Begins: ====");
        System.out.println("Expected Result is:");
        System.out.println("5 ");

        System.out.println("Actual Result is: ");
        PrintTreeInZigzag(node5);
        System.out.println("");

    }

    @Test
    public void Test5() {
        System.out.println("====Test5 Begins: ====");
        System.out.println("Expected Result is");

        System.out.println("Actual Result is: ");
        PrintTreeInZigzag(null);
        System.out.println("");
    }

    //        100
    //        /
    //       50
    //         \
    //         150
    @Test
    public void Test6() {
        BinaryTreeNode node100 = new BinaryTreeNode(100);
        BinaryTreeNode pNode50 = new BinaryTreeNode(50);
        BinaryTreeNode pNode150 = new BinaryTreeNode(150);

        BinaryTreeNode.ConnectTreeNode(node100, pNode50, null);
        BinaryTreeNode.ConnectTreeNode(pNode50, null, pNode150);

        System.out.println("====Test6 Begins: ====");
        System.out.println("Expected Result is:");
        System.out.println("100 ");
        System.out.println("50 ");
        System.out.println("150 ");

        System.out.println("Actual Result is: ");
        PrintTreeInZigzag(node100);
        System.out.println("");
    }

    //                8
    //        4              12
    //     2     6       10      14
    //   1  3  5  7     9 11   13  15
    @Test
    public void Test7() {
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node12 = new BinaryTreeNode(12);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node14 = new BinaryTreeNode(14);
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node11 = new BinaryTreeNode(11);
        BinaryTreeNode node13 = new BinaryTreeNode(13);
        BinaryTreeNode node15 = new BinaryTreeNode(15);

        BinaryTreeNode.ConnectTreeNode(node8, node4, node12);
        BinaryTreeNode.ConnectTreeNode(node4, node2, node6);
        BinaryTreeNode.ConnectTreeNode(node12, node10, node14);
        BinaryTreeNode.ConnectTreeNode(node2, node1, node3);
        BinaryTreeNode.ConnectTreeNode(node6, node5, node7);
        BinaryTreeNode.ConnectTreeNode(node10, node9, node11);
        BinaryTreeNode.ConnectTreeNode(node14, node13, node15);

        System.out.println("====Test7 Begins: ====");
        System.out.println("Expected Result is:");
        System.out.println("8 ");
        System.out.println("12 4 ");
        System.out.println("2 6 10 14 ");
        System.out.println("15 13 11 9 7 5 3 1 ");

        System.out.println("Actual Result is: ");
        PrintTreeInZigzag(node8);
        System.out.println("");

    }
}
