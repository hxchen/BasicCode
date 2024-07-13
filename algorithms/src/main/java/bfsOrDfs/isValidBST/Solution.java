package bfsOrDfs.isValidBST;

import BstDel.TreeNode;

public class Solution {
    /**
     * 验证二叉搜索树
     * 判断一棵二叉树是否为有效的二叉搜索树，可以使用递归方法来进行验证。有效的二叉搜索树（BST）要求每个节点的值都严格大于其左子树中的所有节点的值，并且严格小于其右子树中的所有节点的值。
     * 为了实现这一点，我们可以递归地检查每个节点，并传递一个值范围（min和max）给每个节点。对于每个节点，其值必须在该范围内。
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        // 如果当前节点的值不在有效范围内，返回 false
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // 递归检查左右子树
        // 左子树的所有节点值必须小于当前节点值
        // 右子树的所有节点值必须大于当前节点值
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

}
