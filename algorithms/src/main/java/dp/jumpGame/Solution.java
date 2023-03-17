package dp.jumpGame;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        // 表示在该位置可以到达的最远距离
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++){
            // 先计算上一个位置能否到该点
            if (dp[i - 1] < i){
                return false;
            }
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
        }
        return true;
    }

    @Test
    public void Test1(){
        int[] nums = new int[] {2, 3, 1, 1, 4};
        Assert.assertTrue(canJump(nums));
    }

    @Test
    public void Test2(){
        int[] nums = new int[] {3, 2, 1, 0, 4};
        Assert.assertTrue(!canJump(nums));
    }
    @Test
    public void Test3(){
        int[] nums = new int[] {0, 1};
        Assert.assertTrue(!canJump(nums));
    }

    @Test
    public void Test4(){
        int[] nums = new int[] {2, 0};
        Assert.assertTrue(canJump(nums));
    }

    @Test
    public void Test5(){
        int[] nums = new int[] {2, 0, 0};
        Assert.assertTrue(canJump(nums));
    }
}
