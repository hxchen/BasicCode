package printTreeFromTopToBottom;

import commonDataStructures.BinaryTreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 不分行从上往下打印二叉树
 * 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 * Created by hxchen on 2018/6/29.
 */
public class PrintTreeFromTopToBottom {

    public static void printTreeFromTopToBottom(BinaryTreeNode root){
        if (root == null)
            return;
        Queue<BinaryTreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (queue.size() > 0){
            BinaryTreeNode node = queue.remove();
            System.out.print(node.value+"\t");
            if(node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    // ====================测试代码====================
    public void Test(String testName, BinaryTreeNode root){
        if(testName != null)
            System.out.format("%s begins: ", testName);

        printTreeFromTopToBottom(root);

        System.out.println("The nodes from top to bottom, from left to right are: \n");
        printTreeFromTopToBottom(root);

        System.out.println("\n\n");
    }
    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    @Test
    public void Test1(){
        BinaryTreeNode pNode10 = new BinaryTreeNode(10);
        BinaryTreeNode pNode6 = new BinaryTreeNode(6);
        BinaryTreeNode pNode14 = new BinaryTreeNode(14);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode8 = new BinaryTreeNode(8);
        BinaryTreeNode pNode12 = new BinaryTreeNode(12);
        BinaryTreeNode pNode16 = new BinaryTreeNode(16);

        BinaryTreeNode.ConnectTreeNode(pNode10, pNode6, pNode14);
        BinaryTreeNode.ConnectTreeNode(pNode6, pNode4, pNode8);
        BinaryTreeNode.ConnectTreeNode(pNode14, pNode12, pNode16);

        Test("Test1", pNode10);

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
    public void Test2(){
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);

        BinaryTreeNode.ConnectTreeNode(pNode5, pNode4, null);
        BinaryTreeNode.ConnectTreeNode(pNode4, pNode3, null);
        BinaryTreeNode.ConnectTreeNode(pNode3, pNode2, null);
        BinaryTreeNode.ConnectTreeNode(pNode2, pNode1, null);

        Test("Test2", pNode5);

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
    public void Test3(){
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);

        BinaryTreeNode.ConnectTreeNode(pNode1, null, pNode2);
        BinaryTreeNode.ConnectTreeNode(pNode2, null, pNode3);
        BinaryTreeNode.ConnectTreeNode(pNode3, null, pNode4);
        BinaryTreeNode.ConnectTreeNode(pNode4, null, pNode5);

        Test("Test3", pNode1);

    }

    // 树中只有1个结点
    @Test
    public void Test4(){
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        Test("Test4", pNode1);

    }

    // 树中没有结点
    @Test
    public void Test5(){
        Test("Test5", null);
    }
}
