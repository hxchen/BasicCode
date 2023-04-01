package BstDel;

import java.util.*;

/**
 * @author haixiangchen
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public List<String> getValInLayer(TreeNode node){
        List<String> ret = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (node != null){
            queue.add(node);
        }
        while (!queue.isEmpty()){
            int length = queue.size();
            for (int i = 0; i < length; i++){
                TreeNode curNode = queue.poll();
                if (curNode != null){
                    ret.add(String.valueOf(curNode.val));
                    if (curNode.left != null) queue.add(curNode.left);
                    if (curNode.right != null) queue.add(curNode.right);
                }
            }
        }
        return ret;
    }

    /**
     * 逐层打印
     */
    public void printInLayer(){
        System.out.println(Arrays.toString(getValInLayer(this).toArray()));
    }
}
