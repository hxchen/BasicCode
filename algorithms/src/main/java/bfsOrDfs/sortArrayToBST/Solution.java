package bfsOrDfs.sortArrayToBST;

import BstDel.TreeNode;

public class Solution {

    /**
     * 要将一个升序排列的整数数组转换为一棵平衡二叉搜索树，可以使用递归的方法。具体思路如下：
     * 选择中间元素作为根节点：这样可以保证左子树和右子树的节点数目尽可能相等，从而保持树的平衡。
     * 递归构建左子树和右子树：分别对中间元素左边的子数组和右边的子数组递归地进行相同的操作。
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);

        return root;
    }

}
