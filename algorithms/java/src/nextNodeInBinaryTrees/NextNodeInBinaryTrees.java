package nextNodeInBinaryTrees;

import constructBinaryTree.ConstructBinaryTree;

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
}
