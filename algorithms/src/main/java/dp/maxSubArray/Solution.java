package dp.maxSubArray;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组
 * 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class Solution {

        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            // base case
            dp[0] = nums[0];
            // 状态转移方程
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            }
            // 得到最大值
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
            System.out.println(solution.maxSubArray(nums));
        }

}
