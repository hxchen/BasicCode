package arrayString.prefixAligned;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个长度为 n 、下标从 1 开始的二进制字符串，所有位最开始都是 0 。我们会按步翻转该二进制字符串的所有位（即，将 0 变为 1）。
 *
 * 给你一个下标从 1 开始的整数数组 flips ，其中 flips[i] 表示对应下标 i 的位将会在第 i 步翻转。
 *
 * 二进制字符串 前缀一致 需满足：在第 i 步之后，在 闭 区间[1, i] 内的所有位都是 1 ，而其他位都是 0 。
 *
 * 返回二进制字符串在翻转过程中 前缀一致 的次数。
 *
 * @see：<a href="https://leetcode.cn/problems/number-of-times-binary-string-is-prefix-aligned">LeetCode</a>
 */
public class Solution {
    /**
     * 走过的下标个数等于当前最大值，即可认为是前缀一致。
     * @param flips
     * @return
     */
    public int numTimesAllBlue(int[] flips) {
        int max = 0;
        int times = 0;
        for(int i = 0; i < flips.length; i++){
            max = Math.max(max, flips[i]);
            if (i+1 == max){
                times++;
            }
        }
        return times;
    }

    @Test
    public void Test1(){
        int[] flips = new int[]{3, 2, 4, 1, 5};
        Assert.assertTrue(numTimesAllBlue(flips) == 2);
    }

    @Test
    public void Test2(){
        int[] flips = new int[]{4, 1, 2, 3};
        Assert.assertTrue(numTimesAllBlue(flips) == 1);
    }
}
