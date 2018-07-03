package sequenceOfBST;

import org.junit.Test;

import javax.net.ssl.SSLContext;

/**
 * 二叉搜索树的后序遍历序列
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 * Created by hxchen on 2018/7/3.
 */
public class SequenceOfBST {


    public static boolean isSequenceOfBST(int[] sequence){
        if (sequence == null)
            return false;
        return isSequenceOfBST(sequence, 0, sequence.length-1);
    }
    public static boolean isSequenceOfBST(int[] sequence,int start, int end){
        if(start >= end){
            return true;
        }
        int root = sequence[end];
        int length = end-start+1;
        // 二叉搜索树中左子树所有节点的值小于该根节点

        int i = start;  //分界点
        for (; i < end; i++){
            if (sequence[i] > root){
                break;
            }
        }
        int j = i;
        // 二叉搜索树中右子树所有节点的值大于该根节点
        for(; j < end; j++){
            if(sequence[j] < root)
                return false;
        }
        boolean left = true;
        if (i > start){
            left = isSequenceOfBST(sequence,start,i-1);
        }
        boolean right = true;
        if (i < length-1){
            right = isSequenceOfBST(sequence,i, end-1);
        }
        return (left && right);
    }

    // ====================测试代码====================
    public void Test(String testName, int sequence[], boolean expected){
        if(testName != null)
            System.out.format("%s begins: ", testName);

        if(isSequenceOfBST(sequence) == expected)
            System.out.print("passed.\n");
        else
            System.out.print("failed.\n");
    }

    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    @Test
    public void Test1(){
        int data[] = {4, 8, 6, 12, 16, 14, 10};
        Test("Test1", data, true);
    }

    //           5
    //          / \
    //         4   7
    //            /
    //           6
    @Test
    public void Test2() {
        int data[] = {4, 6, 7, 5};
        Test("Test2", data, true);
    }

    //               5
    //              /
    //             4
    //            /
    //           3
    //          /
    //         2
    //        /
    //       1
    @Test
    public void Test3() {
        int data[] = {1, 2, 3, 4, 5};
        Test("Test3", data, true);
    }

    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    @Test
    public void Test4() {
        int data[] = {5, 4, 3, 2, 1};
        Test("Test4", data, true);
    }

    // 树中只有1个结点
    @Test
    public void Test5() {
        int data[] = {5};
        Test("Test5", data, true);
    }

    @Test
    public void Test6() {
        int data[] = {7, 4, 6, 5};
        Test("Test6", data,  false);
    }

    @Test
    public void Test7() {
        int data[] = {4, 6, 12, 8, 16, 14, 10};
        Test("Test7", data,  false);
    }

    @Test
    public void Test8() {
        Test("Test8", null, false);
    }
}
