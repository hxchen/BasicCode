package symmetricalBinaryTree;

import commonDataStructures.BinaryTreeNode;
import org.junit.Test;

/**
 * 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和
 * 它的镜像一样，那么它是对称的。
 * Created by hxchen on 2018/6/22.
 */
public class SymmetricalBinaryTree {

    public static boolean isSymmetrical(BinaryTreeNode root){
        return isSymmetrical(root, root);
    }
    public static boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2){
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.value != root2.value)
            return false;
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
    // ====================测试代码====================
    public void Test(String testName, BinaryTreeNode root, boolean expected)
    {
        if(testName != null)
            System.out.println(testName+" begins: ");

        if(isSymmetrical(root) == expected)
            System.out.println("Passed.\n");
        else
            System.out.println("FAILED.\n");
    }

    //            8
    //        6      6
    //       5 7    7 5
    @Test
    public void Test1()
    {
        BinaryTreeNode pNode8 = new BinaryTreeNode(8);
        BinaryTreeNode pNode61 = new BinaryTreeNode(6);
        BinaryTreeNode pNode62 = new BinaryTreeNode(6);
        BinaryTreeNode pNode51 = new BinaryTreeNode(5);
        BinaryTreeNode pNode71 = new BinaryTreeNode(7);
        BinaryTreeNode pNode72 = new BinaryTreeNode(7);
        BinaryTreeNode pNode52 = new BinaryTreeNode(5);

        BinaryTreeNode.ConnectTreeNode(pNode8, pNode61, pNode62);
        BinaryTreeNode.ConnectTreeNode(pNode61, pNode51, pNode71);
        BinaryTreeNode.ConnectTreeNode(pNode62, pNode72, pNode52);

        Test("Test1", pNode8, true);

        
    }

    //            8
    //        6      9
    //       5 7    7 5
    @Test
    public void Test2()
    {
        BinaryTreeNode pNode8 = new BinaryTreeNode(8);
        BinaryTreeNode pNode61 = new BinaryTreeNode(6);
        BinaryTreeNode pNode9 = new BinaryTreeNode(9);
        BinaryTreeNode pNode51 = new BinaryTreeNode(5);
        BinaryTreeNode pNode71 = new BinaryTreeNode(7);
        BinaryTreeNode pNode72 = new BinaryTreeNode(7);
        BinaryTreeNode pNode52 = new BinaryTreeNode(5);

        BinaryTreeNode.ConnectTreeNode(pNode8, pNode61, pNode9);
        BinaryTreeNode.ConnectTreeNode(pNode61, pNode51, pNode71);
        BinaryTreeNode.ConnectTreeNode(pNode9, pNode72, pNode52);

        Test("Test2", pNode8, false);

        
    }

    //            8
    //        6      6
    //       5 7    7
    @Test
    public void Test3()
    {
        BinaryTreeNode pNode8 = new BinaryTreeNode(8);
        BinaryTreeNode pNode61 = new BinaryTreeNode(6);
        BinaryTreeNode pNode62 = new BinaryTreeNode(6);
        BinaryTreeNode pNode51 = new BinaryTreeNode(5);
        BinaryTreeNode pNode71 = new BinaryTreeNode(7);
        BinaryTreeNode pNode72 = new BinaryTreeNode(7);

        BinaryTreeNode.ConnectTreeNode(pNode8, pNode61, pNode62);
        BinaryTreeNode.ConnectTreeNode(pNode61, pNode51, pNode71);
        BinaryTreeNode.ConnectTreeNode(pNode62, pNode72, null);

        Test("Test3", pNode8, false);

        
    }

    //               5
    //              / \
    //             3   3
    //            /     \
    //           4       4
    //          /         \
    //         2           2
    //        /             \
    //       1               1
    @Test
    public void Test4()
    {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode31 = new BinaryTreeNode(3);
        BinaryTreeNode pNode32 = new BinaryTreeNode(3);
        BinaryTreeNode pNode41 = new BinaryTreeNode(4);
        BinaryTreeNode pNode42 = new BinaryTreeNode(4);
        BinaryTreeNode pNode21 = new BinaryTreeNode(2);
        BinaryTreeNode pNode22 = new BinaryTreeNode(2);
        BinaryTreeNode pNode11 = new BinaryTreeNode(1);
        BinaryTreeNode pNode12 = new BinaryTreeNode(1);

        BinaryTreeNode.ConnectTreeNode(pNode5, pNode31, pNode32);
        BinaryTreeNode.ConnectTreeNode(pNode31, pNode41, null);
        BinaryTreeNode.ConnectTreeNode(pNode32, null, pNode42);
        BinaryTreeNode.ConnectTreeNode(pNode41, pNode21, null);
        BinaryTreeNode.ConnectTreeNode(pNode42, null, pNode22);
        BinaryTreeNode.ConnectTreeNode(pNode21, pNode11, null);
        BinaryTreeNode.ConnectTreeNode(pNode22, null, pNode12);

        Test("Test4", pNode5, true);

    }


    //               5
    //              / \
    //             3   3
    //            /     \
    //           4       4
    //          /         \
    //         6           2
    //        /             \
    //       1               1
    @Test
    public void Test5()
    {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode31 = new BinaryTreeNode(3);
        BinaryTreeNode pNode32 = new BinaryTreeNode(3);
        BinaryTreeNode pNode41 = new BinaryTreeNode(4);
        BinaryTreeNode pNode42 = new BinaryTreeNode(4);
        BinaryTreeNode pNode6 = new BinaryTreeNode(6);
        BinaryTreeNode pNode22 = new BinaryTreeNode(2);
        BinaryTreeNode pNode11 = new BinaryTreeNode(1);
        BinaryTreeNode pNode12 = new BinaryTreeNode(1);

        BinaryTreeNode.ConnectTreeNode(pNode5, pNode31, pNode32);
        BinaryTreeNode.ConnectTreeNode(pNode31, pNode41, null);
        BinaryTreeNode.ConnectTreeNode(pNode32, null, pNode42);
        BinaryTreeNode.ConnectTreeNode(pNode41, pNode6, null);
        BinaryTreeNode.ConnectTreeNode(pNode42, null, pNode22);
        BinaryTreeNode.ConnectTreeNode(pNode6, pNode11, null);
        BinaryTreeNode.ConnectTreeNode(pNode22, null, pNode12);

        Test("Test5", pNode5, false);

    }

    //               5
    //              / \
    //             3   3
    //            /     \
    //           4       4
    //          /         \
    //         2           2
    //                      \
    //                       1
    @Test
    public void Test6()
    {
        BinaryTreeNode pNode5 = new BinaryTreeNode(5);
        BinaryTreeNode pNode31 = new BinaryTreeNode(3);
        BinaryTreeNode pNode32 = new BinaryTreeNode(3);
        BinaryTreeNode pNode41 = new BinaryTreeNode(4);
        BinaryTreeNode pNode42 = new BinaryTreeNode(4);
        BinaryTreeNode pNode21 = new BinaryTreeNode(2);
        BinaryTreeNode pNode22 = new BinaryTreeNode(2);
        BinaryTreeNode pNode12 = new BinaryTreeNode(1);

        BinaryTreeNode.ConnectTreeNode(pNode5, pNode31, pNode32);
        BinaryTreeNode.ConnectTreeNode(pNode31, pNode41, null);
        BinaryTreeNode.ConnectTreeNode(pNode32, null, pNode42);
        BinaryTreeNode.ConnectTreeNode(pNode41, pNode21, null);
        BinaryTreeNode.ConnectTreeNode(pNode42, null, pNode22);
        BinaryTreeNode.ConnectTreeNode(pNode21, null, null);
        BinaryTreeNode.ConnectTreeNode(pNode22, null, pNode12);

        Test("Test6", pNode5, false);

    }

    // 只有一个结点
    @Test
    public void Test7()
    {
        BinaryTreeNode pNode1 = new BinaryTreeNode(1);
        Test("Test7", pNode1, true);

    }

    // 没有结点
    @Test
    public void Test8()
    {
        Test("Test8", null, true);
    }

    // 所有结点都有相同的值，树对称
    //               5
    //              / \
    //             5   5
    //            /     \
    //           5       5
    //          /         \
    //         5           5
    @Test
    public void Test9()
    {
        BinaryTreeNode pNode1 = new BinaryTreeNode(5);
        BinaryTreeNode pNode21 = new BinaryTreeNode(5);
        BinaryTreeNode pNode22 = new BinaryTreeNode(5);
        BinaryTreeNode pNode31 = new BinaryTreeNode(5);
        BinaryTreeNode pNode32 = new BinaryTreeNode(5);
        BinaryTreeNode pNode41 = new BinaryTreeNode(5);
        BinaryTreeNode pNode42 = new BinaryTreeNode(5);

        BinaryTreeNode.ConnectTreeNode(pNode1, pNode21, pNode22);
        BinaryTreeNode.ConnectTreeNode(pNode21, pNode31, null);
        BinaryTreeNode.ConnectTreeNode(pNode22, null, pNode32);
        BinaryTreeNode.ConnectTreeNode(pNode31, pNode41, null);
        BinaryTreeNode.ConnectTreeNode(pNode32, null, pNode42);
        BinaryTreeNode.ConnectTreeNode(pNode41, null, null);
        BinaryTreeNode.ConnectTreeNode(pNode42, null, null);

        Test("Test9", pNode1, true);

    }

    // 所有结点都有相同的值，树不对称
    //               5
    //              / \
    //             5   5
    //            /     \
    //           5       5
    //          /       /
    //         5       5
    @Test
    public void Test10()
    {
        BinaryTreeNode pNode1 = new BinaryTreeNode(5);
        BinaryTreeNode pNode21 = new BinaryTreeNode(5);
        BinaryTreeNode pNode22 = new BinaryTreeNode(5);
        BinaryTreeNode pNode31 = new BinaryTreeNode(5);
        BinaryTreeNode pNode32 = new BinaryTreeNode(5);
        BinaryTreeNode pNode41 = new BinaryTreeNode(5);
        BinaryTreeNode pNode42 = new BinaryTreeNode(5);

        BinaryTreeNode.ConnectTreeNode(pNode1, pNode21, pNode22);
        BinaryTreeNode.ConnectTreeNode(pNode21, pNode31, null);
        BinaryTreeNode.ConnectTreeNode(pNode22, null, pNode32);
        BinaryTreeNode.ConnectTreeNode(pNode31, pNode41, null);
        BinaryTreeNode.ConnectTreeNode(pNode32, pNode42, null);
        BinaryTreeNode.ConnectTreeNode(pNode41, null, null);
        BinaryTreeNode.ConnectTreeNode(pNode42, null, null);

        Test("Test10", pNode1, false);

    }
}
