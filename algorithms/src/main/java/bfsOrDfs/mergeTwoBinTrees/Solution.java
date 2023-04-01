package bfsOrDfs.mergeTwoBinTrees;

import BstDel.TreeNode;
import org.junit.Test;

public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode newRoot  = null;
        if (root1 != null && root2 != null){
            newRoot = new TreeNode(root1.val + root2.val, mergeTrees(root1.left, root2.left), mergeTrees(root1.right, root2.right));
        }else if (root1 != null){
            newRoot = root1;
        } else if (root2 != null) {
            newRoot = root2;
        }
        return newRoot;
    }

    @Test
    public void Test1(){
        TreeNode node15 = new TreeNode(5);
        TreeNode node13 = new TreeNode(3, node15, null);
        TreeNode node12 = new TreeNode(2);
        TreeNode node11 = new TreeNode(1, node13, node12);
        node11.printInLayer();
        TreeNode node24 = new TreeNode(4);
        TreeNode node21 = new TreeNode(1, null, node24);
        TreeNode node27 = new TreeNode(7);
        TreeNode node23 = new TreeNode(3, null, node27);
        TreeNode node22 = new TreeNode(2, node21, node23);
        node22.printInLayer();
        TreeNode newRoot = mergeTrees(node11, node22);
        newRoot.printInLayer();
    }

    @Test
    public void Test2(){
        TreeNode node11 = new TreeNode(1);
        node11.printInLayer();

        TreeNode node22 = new TreeNode(2);
        TreeNode node21 = new TreeNode(1, node22, null);
        node21.printInLayer();

        TreeNode newRoot = mergeTrees(node11, node21);
        newRoot.printInLayer();
    }
}
