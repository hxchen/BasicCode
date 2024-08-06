package bfsOrDfs.maxPathSum;

import BstDel.TreeNode;

/**
 * 二叉树中的最大路径和
 *
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class Solution {
    private int maxSum = Integer.MIN_VALUE;
    /**
     * 定义递归函数: 定义一个递归函数 maxGain(node)，这个函数计算从当前节点出发，到任何一个叶子节点的路径的最大和。
     * 递归基: 如果节点为空，则返回 0，因为空节点对路径和没有贡献。
     * 递归计算左子树和右子树的最大贡献值: 计算左子树和右子树的最大贡献值，如果某个子树的贡献值为负数，则取0，因为我们可以选择不包括这个子树。
     * 更新最大路径和: 计算当前节点的路径和，如果路径经过当前节点，并更新全局的最大路径和。
     * 返回当前节点的最大贡献值: 返回当前节点的最大贡献值给它的父节点使用。
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        // 当前节点的最大路径和
        int priceNewPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, priceNewPath);
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assert (solution.maxPathSum(root) == 6);

        root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assert (solution.maxPathSum(root) == 42);

    }
}
