package tree;

import commonDataStructures.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 平衡二叉树
 * 题目：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中
 * 任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * Created by hxchen on 2018/8/12.
 */
public class BalancedBinaryTree {
    public static final int UNB = -1;

    /**
     * 自顶向下判断
     * 缺点是会重复计算子节点
     *
     * @param root
     * @return
     */
    public static boolean isBalancedBinaryTree_Solution1(BinaryTreeNode root) {
        if (root == null)
            return true;
        int left = TreeDepth.treeDepth(root.left);
        int right = TreeDepth.treeDepth(root.right);
        int diff = left - right;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return isBalancedBinaryTree_Solution1(root.left) && isBalancedBinaryTree_Solution1(root.right);
    }


    /**
     * 后序遍历判断
     *
     * @param root
     * @return
     */
    public static boolean isBalancedBinaryTree_Solution2(BinaryTreeNode root) {
        int result = isBalanced(root);

        if (result != UNB)
            return true;
        else
            return false;
    }

    /**
     * 返回树的深度
     * 非平衡二叉树返回 -1
     *
     * @param root
     * @return
     */
    private static int isBalanced(BinaryTreeNode root) {
        if (root == null)
            return 0;
        int left = isBalanced(root.left);
        int right = isBalanced(root.right);
        if (left == UNB || right == UNB || Math.abs(left - right) > 1)
            return UNB;
        return 1 + (left > right ? left : right);
    }

    // 完全二叉树
    //             1
    //         /      \
    //        2        3
    //       /\       / \
    //      4  5     6   7
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
        BinaryTreeNode.ConnectTreeNode(node3, node6, node7);

        Assert.assertTrue(isBalancedBinaryTree_Solution2(node1));
    }

    // 不是完全二叉树，但是平衡二叉树
    //             1
    //         /      \
    //        2        3
    //       /\         \
    //      4  5         6
    //        /
    //       7
    @Test
    public void Test2() {
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

        Assert.assertTrue(isBalancedBinaryTree_Solution2(node1));
    }

    // 不是平衡二叉树
    //             1
    //         /      \
    //        2        3
    //       /\
    //      4  5
    //        /
    //       6
    @Test
    public void Test3() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);

        BinaryTreeNode.ConnectTreeNode(node1, node2, node3);
        BinaryTreeNode.ConnectTreeNode(node2, node4, node5);
        BinaryTreeNode.ConnectTreeNode(node5, node6, null);
        Assert.assertFalse(isBalancedBinaryTree_Solution2(node1));
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
    public void Test4() {
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node1 = new BinaryTreeNode(1);

        BinaryTreeNode.ConnectTreeNode(node5, node4, null);
        BinaryTreeNode.ConnectTreeNode(node4, node3, null);
        BinaryTreeNode.ConnectTreeNode(node3, node2, null);
        BinaryTreeNode.ConnectTreeNode(node2, node1, null);

        Assert.assertFalse(isBalancedBinaryTree_Solution2(node5));

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
    public void Test5() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);

        BinaryTreeNode.ConnectTreeNode(node1, null, node2);
        BinaryTreeNode.ConnectTreeNode(node2, null, node3);
        BinaryTreeNode.ConnectTreeNode(node3, null, node4);
        BinaryTreeNode.ConnectTreeNode(node4, null, node5);

        Assert.assertFalse(isBalancedBinaryTree_Solution2(node1));

    }

    // 树中只有1个结点
    @Test
    public void Test6() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        Assert.assertTrue(isBalancedBinaryTree_Solution2(node1));

    }

    // 树中没有结点
    @Test
    public void Test7() {
        Assert.assertTrue(isBalancedBinaryTree_Solution2(null));
    }
}
