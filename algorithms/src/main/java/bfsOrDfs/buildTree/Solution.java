package bfsOrDfs.buildTree;

import BstDel.TreeNode;

public class Solution {

    /**
     * 从前序与中序遍历序列构造二叉树
     *
     * 通过先序遍历和中序遍历构造二叉树，可以利用以下特性：
     * 先序遍历的第一个元素是树的根节点。
     * 中序遍历中根节点左边的元素是左子树，右边的元素是右子树。
     * 基于这个思路，可以使用递归来构造二叉树。
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // 前序遍历的第一个元素是根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 中序遍历找到根节点的位置
        int rootIndexInOrder = inStart;
        while(rootIndexInOrder <= inEnd && inorder[rootIndexInOrder] != rootVal){
            rootIndexInOrder++;
        }
        int leftSubtreeSize = rootIndexInOrder - inStart;
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize,
                inorder, inStart, rootIndexInOrder - 1);
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd,
                inorder, rootIndexInOrder + 1, inEnd);
        return root;
    }
}
