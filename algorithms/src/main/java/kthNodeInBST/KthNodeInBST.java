package kthNodeInBST;

import commonDataStructures.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 二叉搜索树的第k大结点
 * 题目：给定一棵二叉搜索树，请找出其中的第k大的结点。
 * 5
 * 3    7
 * 2  4  6  8
 * 按节点数值大小排序,第三大节点的值是4
 * Created by hxchen on 2018/8/9.
 */
public class KthNodeInBST {

    static int count = 0;

    public static BinaryTreeNode findKthNodeInBST(BinaryTreeNode root, int k) {
        if (root == null || k == 0)
            return null;
        int[] tmp = {k};
        return kthNodeInBSTCore(root, tmp);

    }

    /**
     * 递归遍历
     *
     * @param root
     * @param k
     * @return
     */
    private static BinaryTreeNode kthNodeInBSTCore(BinaryTreeNode root, int[] k) {
        BinaryTreeNode result = null;

        // 先左子树中找
        if (root.left != null) {
            result = kthNodeInBSTCore(root.left, k);
        }

        // 如果在左子树中没有找到
        if (result == null) {
            // 说明当前的根结点是所要找的结点
            if (k[0] == 1) {
                result = root;
            } else {
                // 当前的根结点不是要找的结点，但是已经找过了，所以计数器减一
                k[0]--;
            }
        }

        // 根结点以及根结点的左子结点都没有找到，则找其右子树
        if (result == null && root.right != null) {
            result = kthNodeInBSTCore(root.right, k);
        }

        return result;

    }

    /**
     * 解题算法：中序遍历
     * 实现方式：非递归（栈实现）
     */
    public static BinaryTreeNode InOrder_stack(BinaryTreeNode root, int k) {

        // 检查输入节点的合法性
        if (root == null || k < 0)
            return null;

        // 创建1个栈用于实现中序遍历
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        int count = 0;

        // 步骤1：直到当前结点为空 & 栈空时，循环结束
        while (root != null || stack.size() > 0) {

            // 步骤2：判断当前结点是否为空
            // a. 若不为空，执行3、4
            // b. 若为空，执行5、6
            if (root != null) {

                // 步骤3：入栈当前结点
                stack.push(root);

                // 步骤4：置当前结点的左孩子为当前节点
                // 返回步骤1
                root = root.left;

            } else {

                // 步骤5：出栈栈顶结点
                root = stack.pop();

                // 步骤6：判断出栈顺序是否等于所要求顺序，若是则输出
                // 即，不需将整个中序序列求出来，只需求到所需位置即可
                count++;
                if (count == k)
                    return root;

                // 步骤7：置当前结点的右孩子为当前节点
                root = root.right;
                // 返回步骤1
            }
        }
        return null;
    }

    /**
     * 中序遍历一棵树
     *
     * @param root
     */
    private static void print(BinaryTreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.printf("%-3d", root.value);
            print(root.right);
        }
    }

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
        print(node8);
        Assert.assertSame(null, findKthNodeInBST(node8, 0));
        Assert.assertSame(node5, findKthNodeInBST(node8, 1));
        Assert.assertSame(node6, findKthNodeInBST(node8, 2));
        Assert.assertSame(node7, findKthNodeInBST(node8, 3));
        Assert.assertSame(node8, findKthNodeInBST(node8, 4));
        Assert.assertSame(node9, findKthNodeInBST(node8, 5));
        Assert.assertSame(node10, findKthNodeInBST(node8, 6));
        Assert.assertSame(node11, findKthNodeInBST(node8, 7));
        Assert.assertSame(null, findKthNodeInBST(node8, 8));

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

        Assert.assertSame(null, findKthNodeInBST(node5, 0));
        Assert.assertSame(node1, findKthNodeInBST(node5, 1));
        Assert.assertSame(node2, findKthNodeInBST(node5, 2));
        Assert.assertSame(node3, findKthNodeInBST(node5, 3));
        Assert.assertSame(node4, findKthNodeInBST(node5, 4));
        Assert.assertSame(node5, findKthNodeInBST(node5, 5));
        Assert.assertSame(null, findKthNodeInBST(node5, 6));
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

        Assert.assertSame(null, findKthNodeInBST(node1, 0));
        Assert.assertSame(node1, findKthNodeInBST(node1, 1));
        Assert.assertSame(node2, findKthNodeInBST(node1, 2));
        Assert.assertSame(node3, findKthNodeInBST(node1, 3));
        Assert.assertSame(node4, findKthNodeInBST(node1, 4));
        Assert.assertSame(node5, findKthNodeInBST(node1, 5));
        Assert.assertSame(null, findKthNodeInBST(node1, 6));

    }

    @Test
    public void Test4() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        Assert.assertSame(null, findKthNodeInBST(node1, -1));
        Assert.assertSame(null, findKthNodeInBST(node1, 0));
        Assert.assertSame(node1, findKthNodeInBST(node1, 1));
        Assert.assertSame(null, findKthNodeInBST(node1, -2));
    }

    @Test
    public void Test5() {
        Assert.assertSame(null, findKthNodeInBST(null, 0));
        Assert.assertSame(null, findKthNodeInBST(null, 1));
    }
}
