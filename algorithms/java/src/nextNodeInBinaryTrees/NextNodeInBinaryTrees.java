package nextNodeInBinaryTrees;

import constructBinaryTree.ConstructBinaryTree;
import org.junit.Test;

/**
 * 二叉树的下一个结点
 * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 * Created by hxchen on 2018/5/23.
 */
public class NextNodeInBinaryTrees {

    public static class BinaryTreeNode{
        int value;
        BinaryTreeNode mLeft;
        BinaryTreeNode mRight;
        BinaryTreeNode mParent;

        public BinaryTreeNode(int value){
            this.value = value;
        }
    }
    /**
     * 创建树
     * @param parent
     * @param left
     * @param right
     */
    public void ConnectTreeNodes(BinaryTreeNode parent, BinaryTreeNode left, BinaryTreeNode right){
        if(parent != null){
            parent.mLeft = left;
            parent.mRight = right;

            if (left != null){
                left.mParent = parent;
            }
            if(right != null){
                right.mParent = parent;
            }
        }
    }

    /**
     * 打印树节点
     * @param node
     */
    public void PrintTreeNode(BinaryTreeNode node){
        if(node != null){
            System.out.println("value of this node is "+node.value);
            if(node.mLeft != null){
                System.out.println("value of its left child is "+node.mLeft.value);
            }else{
                System.out.println("value of its left child is null");
            }
            if(node.mRight != null){
                System.out.println("value of its right child is "+node.mRight.value);
            }else{
                System.out.println("value of its right child is null");
            }
        }
    }

    /**
     * 完整打印树
     * @param root
     */
    public void PrintTree(BinaryTreeNode root){
        PrintTreeNode(root);
        if(root != null){
            if(root.mLeft != null){
                PrintTree(root.mLeft);
            }
            if(root.mRight != null){
                PrintTree(root.mRight);
            }
        }
    }
    public BinaryTreeNode getNext(BinaryTreeNode node){
        if(node == null){
            return null;
        }
        BinaryTreeNode next = null;
        if(node.mRight != null){
            //有右子树,下一个节点就是它的右子树中的最左子节点
            BinaryTreeNode right = node.mRight;
            while (right.mLeft != null){
                right = right.mLeft;
            }
            next = right;
        }else if(node.mParent != null){
            //没有右子树
            //如果他是他父节点的左子节点,那么他的下一个节点就是他的父节点。
            //如果他是他父节点的右子节点,我们沿着指向父节点的指针一直向上遍历,直到找到一个是他父节点的左子节点的节点,如果这样的节点存在,那么这个节点的父节点就是我们要找的下一个节点。
            BinaryTreeNode current = node;
            BinaryTreeNode parent = node.mParent;
            while (parent != null && current == parent.mRight){
                current = parent;
                parent = parent.mParent;
            }
            next = parent;
        }
        return next;
    }

    // ====================测试代码====================
    public void Test(String name, BinaryTreeNode node, BinaryTreeNode expected){
        if(null != name){
            System.out.print(name+"\t");
        }
        BinaryTreeNode next = getNext(node);
        if (next == expected){
            System.out.println("Passed.");
        }else{
            System.out.println("Failed.");
        }
    }
    
    //            8
    //        6      10
    //       5 7    9  11
    // {5,6,7,8,9,10,11}
    @Test
    public void Test1_7(){
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node11 = new BinaryTreeNode(11);

        ConnectTreeNodes(node8, node6, node10);
        ConnectTreeNodes(node6, node5, node7);
        ConnectTreeNodes(node10, node9, node11);

       Test("Test1", node8, node9);
       Test("Test2", node6, node7);
       Test("Test3", node10, node11);
       Test("Test4", node5, node6);
       Test("Test5", node7, node8);
       Test("Test6", node9, node10);
       Test("Test7", node11, null);
    }

    //            5
    //          4
    //        3
    //      2
    //{2,3,4,5}
    @Test
    public void Test8_11(){
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        ConnectTreeNodes(node5, node4, null);
        ConnectTreeNodes(node4, node3, null);
        ConnectTreeNodes(node3, node2, null);
        Test("Test8", node5, null);
        Test("Test9", node4, node5);
        Test("Test10", node3, node4);
        Test("Test11", node2, node3);
    }

    //        2
    //         3
    //          4
    //           5
    //{2,3,4,5}
    @Test
    public void Test12_15(){
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);


        ConnectTreeNodes(node2, null, node3);
        ConnectTreeNodes(node3, null, node4);
        ConnectTreeNodes(node4, null, node5);
        Test("Test12", node5, null);
        Test("Test13", node4, node5);
        Test("Test14", node3, node4);
        Test("Test15", node2, node3);
    }

    @Test
    public void Test16(){
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        Test("Test16", node5, null);
    }

}
