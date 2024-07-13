package bfsOrDfs.kthSmallest;

import BstDel.TreeNode;

public class Solution2 {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return result;
    }

    private void inorderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // 中序遍历左子树
        inorderTraversal(node.left, k);

        // 访问当前节点
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // 中序遍历右子树
        inorderTraversal(node.right, k);
    }
}
