package printTreeFromTopToBottom;

import commonDataStructures.BinaryTreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 *
 * 之字形打印二叉树
 * 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺
 * 序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，
 * 其他行以此类推。
 * Created by hxchen on 2018/7/2.
 */
public class PrintTreeInZigzag {

    public static void PrintTreeInZigzag(BinaryTreeNode root){
        if (root == null)
            return;
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (stack1.size() != 0 || stack2.size() != 0){
            while (stack1.size() != 0){
                BinaryTreeNode node = stack1.pop();
                System.out.print(node.value+"\t");
                if (node.left != null)
                    stack2.push(node.left);
                if (node.right != null)
                    stack2.push(node.right);

            }
            System.out.println();
            while (stack2.size() != 0){
                BinaryTreeNode node = stack2.pop();
                System.out.print(node.value+"\t");
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
        BinaryTreeNode pNode8 = new BinaryTreeNode(8);
        BinaryTreeNode pNode6 = new BinaryTreeNode(6);
        BinaryTreeNode pNode10 = new BinaryTreeNode(10);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode7 = new BinaryTreeNode(7);
        BinaryTreeNode pNode9 = new BinaryTreeNode(9);
        BinaryTreeNode pNode11 = new BinaryTreeNode(11);

        BinaryTreeNode.ConnectTreeNode(pNode8, pNode6, pNode10);
        BinaryTreeNode.ConnectTreeNode(pNode6, pNode5, pNode7);
        BinaryTreeNode.ConnectTreeNode(pNode10, pNode9, pNode11);

        System.out.println("====Test1 Begins: ====\n");
        System.out.println("Expected Result is:\n");
        System.out.println("8 \n");
        System.out.println("10 6 \n");
        System.out.println("5 7 9 11 \n\n");

        System.out.println("Actual Result is: \n");
        PrintTreeInZigzag(pNode8);
        System.out.println("\n");

    }

    //            5
    //          4
    //        3
    //      2
    @Test
    public void Test2() {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);

        BinaryTreeNode.ConnectTreeNode(pNode5, pNode4, null);
        BinaryTreeNode.ConnectTreeNode(pNode4, pNode3, null);
        BinaryTreeNode.ConnectTreeNode(pNode3, pNode2, null);

        System.out.println("====Test2 Begins: ====\n");
        System.out.println("Expected Result is:\n");
        System.out.println("5 \n");
        System.out.println("4 \n");
        System.out.println("3 \n");
        System.out.println("2 \n\n");

        System.out.println("Actual Result is: \n");
        PrintTreeInZigzag(pNode5);
        System.out.println("\n");

    }

    //        5
    //         4
    //          3
    //           2
    @Test
    public void Test3() {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);

        BinaryTreeNode.ConnectTreeNode(pNode5, null, pNode4);
        BinaryTreeNode.ConnectTreeNode(pNode4, null, pNode3);
        BinaryTreeNode.ConnectTreeNode(pNode3, null, pNode2);

        System.out.println("====Test3 Begins: ====\n");
        System.out.println("Expected Result is:\n");
        System.out.println("5 \n");
        System.out.println("4 \n");
        System.out.println("3 \n");
        System.out.println("2 \n\n");

        System.out.println("Actual Result is: \n");
        PrintTreeInZigzag(pNode5);
        System.out.println("\n");

    }

    @Test
    public void Test4() {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);

        System.out.println("====Test4 Begins: ====\n");
        System.out.println("Expected Result is:\n");
        System.out.println("5 \n\n");

        System.out.println("Actual Result is: \n");
        PrintTreeInZigzag(pNode5);
        System.out.println("\n");

    }

    @Test
    public void Test5() {
        System.out.println("====Test5 Begins: ====\n");
        System.out.println("Expected Result is:\n");

        System.out.println("Actual Result is: \n");
        PrintTreeInZigzag(null);
        System.out.println("\n");
    }

    //        100
    //        /
    //       50
    //         \
    //         150
    @Test
    public void Test6()
    {
        BinaryTreeNode pNode100 = new BinaryTreeNode(100);
        BinaryTreeNode pNode50 = new BinaryTreeNode(50);
        BinaryTreeNode pNode150 = new BinaryTreeNode(150);

        BinaryTreeNode.ConnectTreeNode(pNode100, pNode50, null);
        BinaryTreeNode.ConnectTreeNode(pNode50, null, pNode150);

        System.out.println("====Test6 Begins: ====\n");
        System.out.println("Expected Result is:\n");
        System.out.println("100 \n");
        System.out.println("50 \n");
        System.out.println("150 \n\n");

        System.out.println("Actual Result is: \n");
        PrintTreeInZigzag(pNode100);
        System.out.println("\n");
    }

    //                8
    //        4              12
    //     2     6       10      14
    //   1  3  5  7     9 11   13  15
    @Test
    public void Test7() {
        BinaryTreeNode pNode8 = new BinaryTreeNode(8);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode12 = new BinaryTreeNode(12);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode6 = new BinaryTreeNode(6);
        BinaryTreeNode pNode10 = new BinaryTreeNode(10);
        BinaryTreeNode pNode14 = new BinaryTreeNode(14);
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode7 = new BinaryTreeNode(7);
        BinaryTreeNode pNode9 = new BinaryTreeNode(9);
        BinaryTreeNode pNode11 = new BinaryTreeNode(11);
        BinaryTreeNode pNode13 = new BinaryTreeNode(13);
        BinaryTreeNode pNode15 = new BinaryTreeNode(15);

        BinaryTreeNode.ConnectTreeNode(pNode8, pNode4, pNode12);
        BinaryTreeNode.ConnectTreeNode(pNode4, pNode2, pNode6);
        BinaryTreeNode.ConnectTreeNode(pNode12, pNode10, pNode14);
        BinaryTreeNode.ConnectTreeNode(pNode2, pNode1, pNode3);
        BinaryTreeNode.ConnectTreeNode(pNode6, pNode5, pNode7);
        BinaryTreeNode.ConnectTreeNode(pNode10, pNode9, pNode11);
        BinaryTreeNode.ConnectTreeNode(pNode14, pNode13, pNode15);

        System.out.println("====Test7 Begins: ====\n");
        System.out.println("Expected Result is:\n");
        System.out.println("8 \n");
        System.out.println("12 4 \n");
        System.out.println("2 6 10 14 \n");
        System.out.println("15 13 11 9 7 5 3 1 \n\n");

        System.out.println("Actual Result is: \n");
        PrintTreeInZigzag(pNode8);
        System.out.println("\n");

    }
}
