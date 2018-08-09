package kthNodeInBST;

import commonDataStructures.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 二叉搜索树的第k个结点
 * 题目：给定一棵二叉搜索树，请找出其中的第k大的结点。
 * Created by hxchen on 2018/8/9.
 */
public class KthNodeInBST {

    public static BinaryTreeNode findKthNodeInBST(BinaryTreeNode root, int k){
        if (root == null || k <= 0)
            return null;
        return kthNodeInBST(root, k);
    }
    private static BinaryTreeNode kthNodeInBST(BinaryTreeNode root, int k){
        BinaryTreeNode target = null;

        if (root.left != null)
            target = kthNodeInBST(root.left, k);

        if (target == null){
            if (k == 1)
                target = root;
            else
                k--;
        }

        if (target == null && root.right != null)
            target = kthNodeInBST(root.right, k);

        return target;
    }
    //            8
    //        6      10
    //       5 7    9  11
    @Test
    public void Test1(){
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
        Assert.assertSame(findKthNodeInBST(node8, 0),null);

//        BinaryTreeNode exp = findKthNodeInBST(node8, 1);
//        Assert.assertSame(exp,node5);
//
//        exp = findKthNodeInBST(node8, 2);
//        Assert.assertSame(exp,node6);
//
//        Assert.assertSame(findKthNodeInBST(node8, 3),node7);
//        Assert.assertSame(findKthNodeInBST(node8, 4),node8);
//        Assert.assertSame(findKthNodeInBST(node8, 5),node9);
//        Assert.assertSame(findKthNodeInBST(node8, 6),node10);
        Assert.assertSame(findKthNodeInBST(node8, 7),node11);
        Assert.assertSame(findKthNodeInBST(node8, 8),null);

    }
    @Test
    public void Test2(){

    }
    @Test
    public void Test3(){

    }
    @Test
    public void Test4(){

    }
    @Test
    public void Test5(){

    }
}
