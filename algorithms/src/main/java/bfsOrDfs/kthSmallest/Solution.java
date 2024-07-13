package bfsOrDfs.kthSmallest;

import BstDel.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list.get(k-1);
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) return;
        if(root.left != null) {
            inorderTraversal(root.left, list);
        }
        list.add(root.val);
        if(root.right != null) {
            inorderTraversal(root.right, list);
        }
    }
}
