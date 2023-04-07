package bitOperation.powerOfTwo;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1) return false;
        if (n == 1) return true;
        int i = 1;
        while (true){
            i = i << 1;
            if(i == n){
                return true;
            }else if (i > n || i == 0){
                return false;
            }
        }
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


    @Test
    public void Test1(){
        Assert.assertTrue(isPowerOfTwo(1));
    }
    @Test
    public void Test2(){
        Assert.assertTrue(isPowerOfTwo(16));
    }
    @Test
    public void Test3(){
        Assert.assertTrue(!isPowerOfTwo(3));
    }
    @Test
    public void Test4(){
        Assert.assertTrue(isPowerOfTwo(4));
    }
    @Test
    public void Test5(){
        Assert.assertTrue(!isPowerOfTwo(0));
    }
    @Test
    public void Test7(){
        Assert.assertTrue(!isPowerOfTwo(1073741825));
    }
}
