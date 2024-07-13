package bfsOrDfs.maxDepth;

import BstDel.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * 二叉树的最大深度-递归-深度优先搜索
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 二叉树的最大深度-迭代-广度优先搜索
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode e = queue.poll();
                if(e.left != null) {
                    queue.offer(e.left);
                }
                if(e.right != null) {
                    queue.offer(e.right);
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;
        System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
    }
}
