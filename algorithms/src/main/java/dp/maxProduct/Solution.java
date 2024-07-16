package dp.maxProduct;

import org.junit.Test;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class Solution {
    /**
     * 要找到数组中乘积最大的非空连续子数组，可以使用动态规划来解决这个问题。
     * 具体来说，我们需要在遍历数组的过程中，同时维护当前子数组的最大乘积和最小乘积（因为负数的存在，最小乘积可能会变成最大乘积）。通过这种方式，我们可以在 O(n) 时间复杂度内完成计算。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        // 边界情况处理，如果数组为空，返回0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 初始化当前的最大乘积和最小乘积为第一个元素
        int currentMax = nums[0];
        int currentMin = nums[0];
        int globalMax = nums[0];

        // 遍历数组从第二个元素开始
        for (int i = 1; i < nums.length; i++) {
            // 临时变量，用于保存当前的最大乘积
            int tempMax = currentMax;

            // 计算当前元素的最大乘积和最小乘积
            currentMax = Math.max(nums[i], Math.max(currentMax * nums[i], currentMin * nums[i]));
            currentMin = Math.min(nums[i], Math.min(tempMax * nums[i], currentMin * nums[i]));

            // 更新全局最大乘积
            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;
    }

    @Test
    public void test() {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }

    @Test
    public void test2() {
        int[] nums = {-2,3,-4};
        System.out.println(maxProduct(nums));
    }


}
