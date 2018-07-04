package pathInTree;

import commonDataStructures.BinaryTreeNode;
import org.junit.Test;

import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

/**
 * 二叉树中和为某一值的路径
 * 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
 * 有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * Created by hxchen on 2018/7/4.
 */
public class PathInTree {
    public static void findPath(BinaryTreeNode root, int total){
        if (null == root)
            return;
        Vector<Integer> path = new Vector<>();
        int currentSum =0;

        findPath(root, total, path, currentSum);
    }
    public static void findPath(BinaryTreeNode root, int total, Vector<Integer> path, int currentSum){
        currentSum += root.value;
        path.addElement(root.value);
        // 如果是叶结点，并且路径上结点的和等于输入的值
        // 打印出这条路径
        boolean isLeaf = (root.left == null && root.right == null);
        if (currentSum == total && isLeaf){
            System.out.print("Find a path:");
            Iterator<Integer> it = path.iterator();
            while (it.hasNext()){
                System.out.print(it.next().intValue()+"\t");
            }
        }
        // 如果不是叶结点，则遍历它的子结点
        if (root.left != null)
            findPath(root.left, total, path,currentSum);
        if (root.right != null)
            findPath(root.right, total, path, currentSum);
        // 在返回到父结点之前，在路径上删除当前结点，并在currentSum中减去当前结点的值
        path.remove(path.size()-1);// start with 0
    }
    // ====================测试代码====================
    void Test(String testName, BinaryTreeNode root, int expectedSum)
    {
        if(testName != null)
            System.out.format("%s begins:\n", testName);

        findPath(root, expectedSum);

        System.out.format("\n");
    }

    //            10
    //         /      \
    //        5        12
    //       /\
    //      4  7
    // 有两条路径上的结点和为22
    @Test
    public void Test1() {
        BinaryTreeNode pNode10 = new BinaryTreeNode(10);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode12 = new BinaryTreeNode(12);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode7 = new BinaryTreeNode(7);

        BinaryTreeNode.ConnectTreeNode(pNode10, pNode5, pNode12);
        BinaryTreeNode.ConnectTreeNode(pNode5, pNode4, pNode7);

        System.out.format("Two paths should be found in Test1.\n");
        Test("Test1", pNode10, 22);

    }

    //            10
    //         /      \
    //        5        12
    //       /\
    //      4  7
    // 没有路径上的结点和为15
    @Test
    public void Test2() {
        BinaryTreeNode pNode10 = new BinaryTreeNode(10);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode12 = new BinaryTreeNode(12);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode7 = new BinaryTreeNode(7);

        BinaryTreeNode.ConnectTreeNode(pNode10, pNode5, pNode12);
        BinaryTreeNode.ConnectTreeNode(pNode5, pNode4, pNode7);

        System.out.format("No paths should be found in Test2.\n");
        Test("Test2", pNode10, 15);

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
    // 有一条路径上面的结点和为15
    @Test
    public void Test3() {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);

        BinaryTreeNode.ConnectTreeNode(pNode5, pNode4, null);
        BinaryTreeNode.ConnectTreeNode(pNode4, pNode3, null);
        BinaryTreeNode.ConnectTreeNode(pNode3, pNode2, null);
        BinaryTreeNode.ConnectTreeNode(pNode2, pNode1, null);

        System.out.format("One path should be found in Test3.\n");
        Test("Test3", pNode5, 15);

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
    // 没有路径上面的结点和为16
    @Test
    public void Test4() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        BinaryTreeNode pNode2 = new BinaryTreeNode(2);
        BinaryTreeNode pNode3 = new BinaryTreeNode(3);
        BinaryTreeNode pNode4 = new BinaryTreeNode(4);
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);

        BinaryTreeNode.ConnectTreeNode(pNode1, null, pNode2);
        BinaryTreeNode.ConnectTreeNode(pNode2, null, pNode3);
        BinaryTreeNode.ConnectTreeNode(pNode3, null, pNode4);
        BinaryTreeNode.ConnectTreeNode(pNode4, null, pNode5);

        System.out.format("No paths should be found in Test4.\n");
        Test("Test4", pNode1, 16);

    }

    // 树中只有1个结点
    @Test
    public void Test5() {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);

        System.out.format("One path should be found in Test5.\n");
        Test("Test5", pNode1, 1);

    }

    // 树中没有结点
    @Test
    public void Test6() {
        System.out.format("No paths should be found in Test6.\n");
        Test("Test6", null, 0);
    }
}
