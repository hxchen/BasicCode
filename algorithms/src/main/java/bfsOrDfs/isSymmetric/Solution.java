package bfsOrDfs.isSymmetric;

import BstDel.TreeNode;
import org.junit.Test;

public class Solution {

    /**
     * 对称二叉树-递归-深度优先搜索
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(4);
        TreeNode rightLeft = new TreeNode(4);
        TreeNode rightRight = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;
        right.right = rightRight;
        System.out.println(isSymmetric(root));
    }
}
