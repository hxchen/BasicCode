package tree;

import commonDataStructures.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 二叉树的深度
 * 题目：输入一棵二叉树的根结点，求该树的深度。从根结点到叶结点依次经过的
 * 结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * Created by hxchen on 2018/8/12.
 */
public class TreeDepth {

    public static int treeDepth(BinaryTreeNode root) {
        if (root == null)
            return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return left > right ? (left + 1) : (right + 1);
    }

    //            1
    //         /      \
    //        2        3
    //       /\         \
    //      4  5         6
    //        /
    //       7
    @Test
    public void Test1() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);

        BinaryTreeNode.ConnectTreeNode(node1, node2, node3);
        BinaryTreeNode.ConnectTreeNode(node2, node4, node5);
        BinaryTreeNode.ConnectTreeNode(node3, null, node6);
        BinaryTreeNode.ConnectTreeNode(node5, node7, null);
        Assert.assertSame(4, treeDepth(node1));
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
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node1 = new BinaryTreeNode(1);

        BinaryTreeNode.ConnectTreeNode(node5, node4, null);
        BinaryTreeNode.ConnectTreeNode(node4, node3, null);
        BinaryTreeNode.ConnectTreeNode(node3, node2, null);
        BinaryTreeNode.ConnectTreeNode(node2, node1, null);

        Assert.assertSame(5, treeDepth(node5));

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
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);

        BinaryTreeNode.ConnectTreeNode(node1, null, node2);
        BinaryTreeNode.ConnectTreeNode(node2, null, node3);
        BinaryTreeNode.ConnectTreeNode(node3, null, node4);
        BinaryTreeNode.ConnectTreeNode(node4, null, node5);

        Assert.assertSame(5, treeDepth(node1));

    }

    // 树中只有1个结点
    @Test
    public void Test4(){
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        Assert.assertSame(1, treeDepth(node1));

    }

    // 树中没有结点
    @Test
    public void Test5(){
        Assert.assertSame(0, treeDepth(null));
    }

}
