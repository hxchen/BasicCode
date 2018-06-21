package mirrorOfBinaryTree;

import com.sun.source.tree.BinaryTree;
import commonDataStructures.BinaryTreeNode;
import org.junit.Test;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * Created by hxchen on 2018/6/21.
 */
public class MirrorOfBinaryTree {
    /**
     * 递归调用,交换左右子树
     * @param node
     */
    public static void MirrotRecursively(BinaryTreeNode node){
        if (node == null || (node.left == null && node.right == null))
            return;
        BinaryTreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        if (node.left != null)
            MirrotRecursively(node.left);
        if(node.right != null)
            MirrotRecursively(node.right);
    }

    // ====================测试代码====================
    // 测试完全二叉树：除了叶子节点，其他节点都有两个子节点
    //            8
    //        6      10
    //       5 7    9  11
    @Test
    public void test1(){
        System.out.println("Test1 start");
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
        BinaryTreeNode.PrintTree(node8);
        System.out.println("=====Test1: MirrorRecursively=====");
        MirrotRecursively(node8);
        BinaryTreeNode.PrintTree(node8);
    }
    // 测试二叉树：出叶子结点之外，左右的结点都有且只有一个左子结点
    //            8
    //          7
    //        6
    //      5
    //    4
    @Test
    public void test2(){
        System.out.println("Test2 start");
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode.ConnectTreeNode(node8, node7, null);
        BinaryTreeNode.ConnectTreeNode(node7, node6, null);
        BinaryTreeNode.ConnectTreeNode(node6, node5, null);
        BinaryTreeNode.ConnectTreeNode(node5, node4, null);
        BinaryTreeNode.PrintTree(node8);
        System.out.println("=====Test2: MirrorRecursively=====");
        MirrotRecursively(node8);
        BinaryTreeNode.PrintTree(node8);

    }
    // 测试二叉树：出叶子结点之外，左右的结点都有且只有一个右子结点
    //            8
    //             7
    //              6
    //               5
    //                4
    @Test
    public void test3(){
        System.out.println("Test3 start");
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode.ConnectTreeNode(node8, null, node7);
        BinaryTreeNode.ConnectTreeNode(node7, null, node6);
        BinaryTreeNode.ConnectTreeNode(node6, null, node5);
        BinaryTreeNode.ConnectTreeNode(node5, null, node4);
        BinaryTreeNode.PrintTree(node8);
        System.out.println("=====Test3: MirrorRecursively=====");
        MirrotRecursively(node8);
        BinaryTreeNode.PrintTree(node8);

    }
    // 测试空二叉树：根结点为空指针
    @Test
    public void test4(){
        System.out.println("Test4 start");
        BinaryTreeNode node = null;
        BinaryTreeNode.PrintTree(node);
        System.out.println("=====Test4: MirrorRecursively=====");
        MirrotRecursively(node);
        BinaryTreeNode.PrintTree(node);

    }
    // 测试只有一个结点的二叉树
    @Test
    public void test5(){
        System.out.println("Test5 start");
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode.PrintTree(node8);
        System.out.println("=====Test5: MirrorRecursively=====");
        MirrotRecursively(node8);
        BinaryTreeNode.PrintTree(node8);

    }
}
