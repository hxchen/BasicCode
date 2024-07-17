package dp.numSquares;

import org.junit.Test;

/**
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 */
public class Solution {

    /**
     * 如果 i 可以表示为 i = j * j + (i - j * j)，其中 j * j 是一个完全平方数，
     * 那么问题就变成了对 i - j * j 的子问题求解，即求 i - j * j 最少由多少个完全平方数组成，再加上一个 j * j。
     * @param n
     * @return
     */
    public int numberSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(numberSquares(13));
    }
}
