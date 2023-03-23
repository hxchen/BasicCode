package dp.longestIncreasingSubsequence;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 *
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 */
public class Solution {
    /**
     * 错误思路！！！
     * 最长子序列
     * 从 i = 0...(n-1) 位置开始找,遇到当前数字和已经有的数列进行比较。
     * 如果当前数字比数列最后一个值大，那么直接把当前数字加入队列。
     * 如果当前数字比数列最后一个值小，却比倒数第二个值大，那么更新此数字为数列最后一个值。
     * 由于数列有用的数字，只有最后2个，所以我们只保存这2个值。
     *
     * Test5 击垮了这个思路
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        int count = 1;
        int last = nums[0];
        int sencondLast = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > last){
                sencondLast = last;
                last = nums[i];
                count++;
            } else if (nums[i] < last && nums[i] > sencondLast) {
                last = nums[i];
            }
        }
        return count;
    }

    /**
     * 动态规划解法
     * dp[i] 表示 以nums[i]结尾的最大严格递增子序列长度
     * 状态转移方程：dp[i] = Max(dp[j]) + 1; j < i && nums[j] < nums[i]
     * 结果就是dp[i] 里面的最大值
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i] && dp[j] >= dp[i]){   //注意等号条件
                    dp[i] = dp[j] + 1;
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    @Test
    public void Test1(){
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        Assert.assertTrue(lengthOfLIS(nums) == 4);
    }
    @Test
    public void Test2(){
        int[] nums = new int[]{0,1,0,3,2,3};
        Assert.assertTrue(lengthOfLIS(nums) == 4);
    }
    @Test
    public void Test3(){
        int[] nums = new int[]{7,7,7,7,7,7,7};
        Assert.assertTrue(lengthOfLIS(nums) == 1);
    }
    @Test
    public void Test4(){
        int[] nums = new int[]{6, 5, 4, 3, 2, 1};
        Assert.assertTrue(lengthOfLIS(nums) == 1);
    }

    @Test
    public void Test5(){
        int[] nums = new int[]{3,5,6,2,5,4,19,5,6,7,12};
        Assert.assertTrue(lengthOfLIS(nums) == 6);
    }

}
