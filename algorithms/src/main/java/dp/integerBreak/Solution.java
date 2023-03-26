package dp.integerBreak;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 *
 * 示例 1:
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例 2:
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 */
public class Solution {
    /**
     * 整数拆分
     * n >= 3时, 最大整数应该是一个由 1、2、3、4组成的数。
     * dp[n] 表示正整数n的最大乘积
     * dp[i] = max(j * (i - j), dp[i-1] * 1, dp[i-2] * 2, dp[i - 3] * 3, dp[i -4] * 4); 注意不要忘记j * (i - j)情况
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            for (int j = 1; j <= 4 && j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[i - j] * j));
            }
        }
        return dp[n];
    }

    @Test
    public void Test1(){
        Assert.assertTrue(integerBreak(2) == 1);
    }
    @Test
    public void Test2(){
        Assert.assertTrue(integerBreak(3) == 2);
    }
    @Test
    public void Test3(){
        Assert.assertTrue(integerBreak(10) == 36);
    }
    @Test
    public void Test4(){
        Assert.assertTrue(integerBreak(5) == 6);
    }
}
