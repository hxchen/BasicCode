package commonDataStructures;

/**
 * Created by hxchen on 2018/6/21.
 */
public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value){
        this.value = value;
    }
    public static void ConnectTreeNode(BinaryTreeNode root, BinaryTreeNode left, BinaryTreeNode right){
        if (root != null){
            root.left = left;
            root.right = right;
        }
    }
    public static void PrintTreeNode(BinaryTreeNode node){
        if (node != null){
            System.out.println("value of this node is :"+node.value);
            if (node.left != null){
                System.out.println("value of its left child is: :"+node.left.value);
            }else{
                System.out.println("left child is null");
            }
            if (node.right != null){
                System.out.println("value of its right child is: :"+node.right.value);
            }else{
                System.out.println("right child is null");
            }
        }else{
            System.out.println("this node is null");
        }
    }
    public static void PrintTree(BinaryTreeNode root){
        PrintTreeNode(root);
        if (root != null){
            if(root.left != null){
                PrintTree(root.left);
            }
            if(root.right != null){
                PrintTree(root.right);
            }
        }
    }

    public static Boolean isSameTree(BinaryTreeNode tree1, BinaryTreeNode tree2){
        if (tree1 == null && tree2 == null)
            return true;
        if (tree1 == null || tree2 == null)
            return false;
        if (tree1.value == tree2.value)
            return true;
        return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "value=" + value +
                ", left=" + (left == null ? null:left.value) +
                ", right=" + (right == null ? null :right.value) +
                '}';
    }
}
