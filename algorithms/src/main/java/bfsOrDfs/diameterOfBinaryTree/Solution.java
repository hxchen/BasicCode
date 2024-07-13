package bfsOrDfs.diameterOfBinaryTree;

import BstDel.TreeNode;
import org.junit.Test;

/**
 * 二叉树的直径
 */
public class Solution {
    private int diameter = 0;

    /**
     * 二叉树的直径
     * 要找到二叉树的直径，可以使用递归的方法来计算每个节点的左右子树的最大深度，同时维护一个全局变量来记录最大直径。
     * 每个节点的直径是它的左子树深度加上右子树深度。
     * 以下是具体的步骤和代码实现：
     * 定义递归函数：计算每个节点的左右子树深度，并更新全局直径变量。
     * 维护全局直径变量：记录最大直径。
     * 递归遍历每个节点：计算左子树和右子树的深度，更新最大直径。
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }

    @Test
    public void test0() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root));
    }
}
