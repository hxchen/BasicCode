package bfsOrDfs.flatten;

import BstDel.TreeNode;
import org.junit.Test;

public class Solution {

    /**
     * 给定一个二叉树，原地将它展开为一个单链表。
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同
     * @param root
     */
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    /**
     * 如果当前节点为空，返回 null。
     * 递归展开左子树和右子树，分别返回左子树和右子树的根节点。
     * 如果左子树不为空，将左子树放到右子树的位置，并将原来的右子树接在新的右子树的末尾。
     * 将当前节点的左子指针设为 null，右子指针指向新的右子树。
     * 返回当前节点。
     * @param root
     * @return
     */
    private TreeNode flattenTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        // 递归的展开左子树和右子树
        TreeNode leftSubtree = flattenTree(root.left);
        TreeNode rightSubtree = flattenTree(root.right);
        // 将左子树放到右子树的位置
        if (leftSubtree != null) {
            TreeNode leftTail = leftSubtree;
            while (leftTail.right != null) {
                leftTail = leftTail.right;
            }
            // 将原来的右子树接在新的右子树的末尾
            leftTail.right = rightSubtree;
            root.right = leftSubtree;
            root.left = null;
        }
        return root;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        right.right = new TreeNode(6);
        flatten(root);
        root.printInLayer();
    }
}
