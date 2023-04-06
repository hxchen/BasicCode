package dp.houseRobber2;

import org.junit.Assert;
import org.junit.Test;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：3
 */
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        // 数组dp, 索引表示到第n家房, 值表示到这里可以偷盗最高金额
        int[] dp1 = new int[n];// 抢首 0; 不抢尾 n - 1
        int[] dp2 = new int[n];// 不抢首 0; 抢尾 n - 1
        // 初始
        dp1[0] = nums[0];
        dp1[1] = Math.max(dp1[0], nums[1]);
        dp2[1] = nums[1];

        for (int i = 2; i < n; i++){
            // 转移方程 dp[i]=max(dp[i−2]+nums[i],dp[i−1])
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }
        // 最优解应该是抢首不抢尾 或者 不抢首抢尾的最大值
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }

    @Test
    public void Test1(){
        int[] nums = new int[] {2, 3, 2};
        Assert.assertTrue(rob(nums) == 3);
    }

    @Test
    public void Test2(){
        int[] nums = new int[] {1, 2, 3, 1};
        Assert.assertTrue(rob(nums) == 4);
    }

    @Test
    public void Test3(){
        int[] nums = new int[] {1, 2, 3};
        Assert.assertTrue(rob(nums) == 3);
    }
}
