package bfsOrDfs.maxAncestorDiff;

import BstDel.TreeNode;

import java.util.*;

/**
 * 给定二叉树的根节点root，找出存在于 不同 节点A 和B之间的最大值 V，其中V = |A.val - B.val|，且A是B的祖先。
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 *
 * 示例 1：
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 *
 * 示例 2：
 * 输入：root = [1,null,2,null,0,3]
 * 输出：3
 * 
 * @see：<a href="https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor">节点与其祖先之间的最大差值</>
 */
public class Solution {

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    /**
     * 深度优先搜索遍历
     * @param root  当前节点
     * @param min 根节点搜索到当前节点时的最小值
     * @param max 根节点搜索到当前节点时的最大值
     * @return
     */
    private int dfs(TreeNode root, int min, int max) {
        if (root == null){
            return 0;
        }
        int diff = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        diff = Math.max(diff, dfs(root.left, min, max));
        diff = Math.max(diff, dfs(root.right, min, max));
        return diff;
    }
}
