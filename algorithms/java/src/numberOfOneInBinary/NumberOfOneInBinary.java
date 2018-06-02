package numberOfOneInBinary;

import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * 二进制中1的个数
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
 * 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 * Created by hxchen on 2018/6/2.
 */
public class NumberOfOneInBinary {

    /**
     * 把一个正数减去1,在和原来正数做 与 运算,会把该正数最右边的 1 变成 0
     * @param n
     * @return
     */
    public int NumberOfOneInBinary(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }

    // ====================测试代码====================
    // 正数边界1、0x7FFFFFFF
    // 负数边界0x80000000、0xFFFFFFFF
    // 输入0
    @Test
    public void test0(){
        Assert.assertTrue(NumberOfOneInBinary(0) == 0);
    }
    // 输入1
    @Test
    public void test1(){
        Assert.assertTrue(NumberOfOneInBinary(1) == 1);
    }
    // 输入10
    @Test
    public void test2(){
        Assert.assertTrue(NumberOfOneInBinary(10) == 2);
    }
    // 输入0x7FFFFFFF
    @Test
    public void test3(){
        Assert.assertTrue(NumberOfOneInBinary(0x7FFFFFFF) == 31);
    }
    // 输入0xFFFFFFFF（负数）
    @Test
    public void test4(){
        Assert.assertTrue(NumberOfOneInBinary(0xFFFFFFFF) == 32);
    }
    // 输入0x80000000（负数）
    @Test
    public void test5(){
        Assert.assertTrue(NumberOfOneInBinary(0x80000000) == 1);
    }

}
