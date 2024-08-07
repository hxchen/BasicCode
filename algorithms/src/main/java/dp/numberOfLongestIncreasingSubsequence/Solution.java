package dp.numberOfLongestIncreasingSubsequence;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 * 注意 这个数列必须是 严格 递增的。
 *
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 *
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 */
public class Solution {
    /**
     * 动态规划解法
     * dp[i] 表示 以nums[i]结尾的最大严格递增子序列长度
     * cnt[i] 表示以 nums[i] 结尾的最长上升子序列的个数, 对于cnt[i] 等于所有满足dp[j] + 1 = dp[i]的cnt[j]的和
     * 动态规划中同步更新dp 和 cnt
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxLen = 0, ans = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j]; // 重置计数
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i]; // 重置计数
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }

    /**
     * 1. 定义状态：
     * dp[i] 表示以 nums[i] 结尾的最长递增子序列的长度。
     *
     * 2. 状态转移方程：
     * 对于每个位置 i，我们需要检查 0 到 i-1 的每个位置 j，如果 nums[j] < nums[i]，则 dp[i] 可以更新为 dp[j] + 1。
     * 具体的转移方程为：
     * dp[i]=max(dp[i],dp[j]+1)for all j<i and nums[j]<nums[i]
     *
     * 3. 初始化：
     * 每个位置的初始值都为 1，因为每个元素本身就可以是一个长度为 1 的递增子序列。
     *
     * 4. 最终结果：
     * 所有 dp[i] 中的最大值即为最长递增子序列的长度。
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    @Test
    public void Test1(){
        Assert.assertTrue(findNumberOfLIS(new int[]{1,3,5,4,7}) == 2);
    }

    @Test
    public void Test2(){
        Assert.assertTrue(findNumberOfLIS(new int[]{2, 2, 2, 2, 2}) == 5);
    }
}
