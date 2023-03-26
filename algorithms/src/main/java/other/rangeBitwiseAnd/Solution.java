package other.rangeBitwiseAnd;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 */
public class Solution {
    /**
     * 二进制字符串的公共前缀再用零补上后面的剩余位。
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // 找到公共前缀
        while (left < right) {
            left >>= 1;
            right >>= 1;
            ++shift;
        }
        return left << shift;
    }

    @Test
    public void Test1(){
        Assert.assertTrue(rangeBitwiseAnd(5, 7) == 4);
    }
    @Test
    public void Test2(){
        Assert.assertTrue(rangeBitwiseAnd(1, 2147483647) == 0);
    }
}
