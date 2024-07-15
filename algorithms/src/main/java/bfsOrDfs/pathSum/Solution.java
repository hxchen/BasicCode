package bfsOrDfs.pathSum;

import BstDel.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径总和
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * @return
 */
public class Solution {

    /**
     * 要计算二叉树中所有路径和等于目标值 targetSum 的路径数，可以使用深度优先搜索（DFS）结合前缀和的思想。具体实现可以通过递归来进行遍历，并使用一个哈希表来记录从根节点到当前节点的所有路径和的出现次数。
     *
     * 具体步骤如下：
     *
     * 使用深度优先搜索（DFS）遍历每个节点。
     * 记录从根节点到当前节点的路径和。
     * 利用前缀和的思想，通过哈希表记录路径和出现的次数，快速计算出以当前节点为结尾且路径和等于 targetSum 的路径数。
     * 递归处理左右子树。
     * 回溯时更新哈希表，确保路径和统计的准确性。
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        // 初始化前缀和为0的路径数量为1
        prefixSumCount.put(0L, 1);
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }

        // 当前路径和
        currentSum += node.val;
        // 统计路径和等于 targetSum 的路径数量
        int numPathsToCurrent = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        // 更新路径和的计数
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // 递归处理左右子树
        int result = numPathsToCurrent + dfs(node.left, currentSum, targetSum, prefixSumCount) + dfs(node.right, currentSum, targetSum, prefixSumCount);

        // 回溯时更新哈希表，确保路径和统计的准确性
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return result;
    }
}
