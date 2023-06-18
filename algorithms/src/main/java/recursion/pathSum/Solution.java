package recursion.pathSum;

import BstDel.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * @see：<a href="https://leetcode.cn/problems/path-sum">LeetCode</a>
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    @Test
    public void Test1(){
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);

        TreeNode node4 = new TreeNode(11, node7, node8);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4, null, node9);

        TreeNode node2 = new TreeNode(4, node4, null);
        TreeNode node3 = new TreeNode(8, node5, node6);

        TreeNode node1 = new TreeNode(5, node2, node3);

        Assert.assertTrue(hasPathSum(node1, 22));

    }
}
