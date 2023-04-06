package dp.houseRobber;

import org.junit.Assert;
import org.junit.Test;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class Solution {
    /**
     * dp[i] 表示偷到第i家时候，最大金额
     * dp[i] = Max(dp[i - 2] + nums[i - 1], dp(i - 1))
     * @param nums
     * @return
     */
    public int rob(int[] nums){
        int length = nums.length;
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[length];
    }

    @Test
    public void Test1(){
        int[] nums = new int[]{2, 7, 9, 3, 1};
        Assert.assertTrue(rob(nums) == 12);
    }

}
