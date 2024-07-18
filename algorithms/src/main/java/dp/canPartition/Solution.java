package dp.canPartition;

public class Solution {
    /**
     * 这个问题可以转换为一个经典的背包问题（0-1 Knapsack Problem）：是否可以从数组 nums 中选择一些元素，使得它们的和等于数组总和的一半。
     *
     * 总和判断：
     *
     * 首先计算数组 nums 的总和 sum。
     * 如果 sum 是奇数，则不可能分割成两个元素和相等的子集，直接返回 false。
     * 状态定义：
     *
     * 定义一个布尔数组 dp，其中 dp[j] 表示是否可以通过选择一些元素使得这些元素的和为 j。
     * 状态初始化：
     *
     * dp[0] 初始化为 true，因为总和为 0 是可以通过不选任何元素实现的。
     * 状态转移：
     *
     * 遍历数组 nums 中的每个元素 num，更新 dp 数组。
     * 对于每个 num，从 target 到 num 的位置反向更新 dp 数组：
     * 如果 dp[j - num] 为 true，则 dp[j] 也为 true。
     * 结果判断：
     *
     * 最后检查 dp[target] 是否为 true，其中 target 是 sum/2。
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 如果总和是奇数，则不能分割成两个和相等的子集
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1
        int[] nums1 = {1, 5, 11, 5};
        System.out.println(solution.canPartition(nums1)); // 输出: true

        // 示例 2
        int[] nums2 = {1, 2, 3, 5};
        System.out.println(solution.canPartition(nums2)); // 输出: false
    }
}
