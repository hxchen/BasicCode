package SerializeBinaryTrees;

import commonDataStructures.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 序列化和反序列化二叉树
 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树。
 * Created by hxchen on 2018/7/7.
 */
public class SerializeBinaryTrees {
    public static int index = -1;

    /**
     * 序列化
     * 利用前序遍历序列化二叉树，然后从记录的字符串中反序列化二叉树。
     * 遇到空节点需要用特殊字符加以标记。如“#”
     * @param root
     * @return
     */
    public static String Serialize(BinaryTreeNode root){
        StringBuffer sb = new StringBuffer();
        if (root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.value+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    /**
     * 反序列化
     * 根据输入的前序序列,反序列化
     * @param string
     * @return
     */
    public static BinaryTreeNode Deserialize(String string){
        if (null == string)
            return null;
        index++;
        String[] DLRseq = string.split(",");
        BinaryTreeNode leave = null;
        if(!DLRseq[index].equals("#")){
            leave = new BinaryTreeNode(Integer.valueOf(DLRseq[index]));
            leave.left = Deserialize(string);
            leave.right = Deserialize(string);
        }
        return leave;
    }
    ////////////////////////////测试代码////////////////////////////
    //            8
    //        6      10
    //       5 7    9  11
    @Test
    public void Test1(){
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node11 = new BinaryTreeNode(11);

        BinaryTreeNode.ConnectTreeNode(node8, node6, node10);
        BinaryTreeNode.ConnectTreeNode(node6, node5, node7);
        BinaryTreeNode.ConnectTreeNode(node10, node9, node11);

        System.out.println("Test1 starts ,Tree is:");

        BinaryTreeNode.PrintTree(node8);

        System.out.println("After serialize:");
        String result = Serialize(node8);
        System.out.println(result);
        BinaryTreeNode tree = Deserialize(result);
        Assert.assertTrue(BinaryTreeNode.isSameTree(node8, tree));

    }
    //            5
    //          4
    //        3
    //      2
    @Test
    public void Test2(){
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(2);


        BinaryTreeNode.ConnectTreeNode(node5, node4, null);
        BinaryTreeNode.ConnectTreeNode(node4, node3, null);
        BinaryTreeNode.ConnectTreeNode(node3, node2, null);

        System.out.println("Test2 starts ,Tree is:");

        BinaryTreeNode.PrintTree(node5);

        System.out.println("After serialize:");
        String result = Serialize(node5);
        System.out.println(result);
        BinaryTreeNode tree = Deserialize(result);
        Assert.assertTrue(BinaryTreeNode.isSameTree(node5, tree));

    }
    //        5
    //         4
    //          3
    //           2
    @Test
    public void Test3(){
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(2);


        BinaryTreeNode.ConnectTreeNode(node5, null, node4);
        BinaryTreeNode.ConnectTreeNode(node4, null, node3);
        BinaryTreeNode.ConnectTreeNode(node3, null, node2);

        System.out.println("Tes3 starts ,Tree is:");

        BinaryTreeNode.PrintTree(node5);

        System.out.println("After serialize:");
        String result = Serialize(node5);
        System.out.println(result);
        BinaryTreeNode tree = Deserialize(result);
        Assert.assertTrue(BinaryTreeNode.isSameTree(node5, tree));
    }
    // 单节点
    @Test
    public void Test4(){
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        System.out.println("Tes4 starts ,Tree is:");

        BinaryTreeNode.PrintTree(node5);

        System.out.println("After serialize:");
        String result = Serialize(node5);
        System.out.println(result);
        BinaryTreeNode tree = Deserialize(result);
        Assert.assertTrue(BinaryTreeNode.isSameTree(node5, tree));
    }
    @Test
    public void Test5(){
        Deserialize(null);
        Serialize(null);
    }
}
