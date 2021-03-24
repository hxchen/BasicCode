package rightSideView;

import java.util.*;

/**
 * @author haixiangchen
 */
public class RightSideView {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 右侧视图
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root != null) {
            Deque<TreeNode> deque = new LinkedList<>();
            int currentLevelCount = 1;
            int nextLevelCount = 0;
            TreeNode node;
            deque.addLast(root);
            while(deque.size() > 0) {
                node = deque.removeFirst();
                currentLevelCount--;

                if(node.left != null) {
                    nextLevelCount++;
                    deque.addLast(node.left);
                }
                if(node.right != null) {
                    nextLevelCount++;
                    deque.addLast(node.right);
                }

                if(currentLevelCount == 0) {
                    result.add(node.val);
                    currentLevelCount = nextLevelCount;
                    nextLevelCount = 0;
                }
            }
        }
        return result;
    }
}
