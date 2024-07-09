package arrayString.subarraySum;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class Solution {
    /**
     * 前缀和
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    /**
     * 直接计算
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println(solution.subarraySum(nums1, k1));

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println(solution.subarraySum(nums2, k2));

        // 极好的测试用例
        int[] nums3 = {1, -1, 0};
        int k3 = 0;
        System.out.println(solution.subarraySum(nums3, k3));

    }
}
