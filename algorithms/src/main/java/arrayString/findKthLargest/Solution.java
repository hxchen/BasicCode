package arrayString.findKthLargest;

import java.util.Random;

public class Solution {
    private Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * 快速选择算法
     * @param nums
     * @param left
     * @param right
     * @param index
     * @return
     */
    private int quickSelect(int[] nums, int left, int right, int index) {
        int pivotIndex = partition(nums, left, right);
        if (pivotIndex == index) {
            return nums[pivotIndex];
        } else if (pivotIndex < index) {
            return quickSelect(nums, pivotIndex + 1, right, index);
        } else {
            return quickSelect(nums, left, pivotIndex - 1, index);
        }
    }

    /**
     * 随机选择基准点并将其与右边界元素交换：
     *
     * 使用 random.nextInt(right - left + 1) 生成一个在 [left, right] 范围内的随机索引 pivotIndex。
     * 将基准值 pivotValue 设为 nums[pivotIndex]。
     * 将基准元素与右边界元素交换：swap(nums, pivotIndex, right)。
     * 初始化存储索引 storeIndex：
     *
     * 将 storeIndex 初始化为 left。storeIndex 用于指示下一个小于基准值的元素应当放置的位置。
     * 遍历数组并进行分区操作：
     *
     * 遍历数组中的元素，从 left 到 right - 1。
     * 对于每个元素 nums[i]，如果它小于基准值 pivotValue，则将 nums[i] 与 storeIndex 位置的元素交换，并将 storeIndex 增加1。
     * 将基准点移到 storeIndex 位置：
     *
     * 遍历结束后，将基准元素（目前在 right 位置）移到 storeIndex 位置：swap(nums, storeIndex, right)。
     * 返回 storeIndex：
     *
     * storeIndex 是基准值的最终位置，这个位置将数组分成两个部分：左边部分的元素都小于基准值，右边部分的元素都大于基准值。
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int pivotIndex = left + random.nextInt(right - left + 1);
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 假设 nums = [3, 2, 1, 5, 6, 4]，left = 0，right = 5。随机选择的基准点 pivotIndex = 2，pivotValue = 1。
     *
     * 交换基准点和右边界元素：nums = [3, 2, 4, 5, 6, 1]。
     * 初始化 storeIndex = 0。
     * 遍历数组：
     * nums[0] = 3，大于 pivotValue，不交换。
     * nums[1] = 2，大于 pivotValue，不交换。
     * nums[2] = 4，大于 pivotValue，不交换。
     * nums[3] = 5，大于 pivotValue，不交换。
     * nums[4] = 6，大于 pivotValue，不交换。
     * 遍历结束后，将基准点 1 移到 storeIndex 位置：nums = [1, 2, 4, 5, 6, 3]。
     * 返回 storeIndex = 0。
     * 经过分区操作，基准值 1 被放置到最终位置，左边部分为空，右边部分为 [2, 4, 5, 6, 3]。
     *
     * 这样，partition 函数确保每次递归都将数组分成两个子数组，并逐步完成排序。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println(solution.findKthLargest(nums1, k1)); // 输出: 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println(solution.findKthLargest(nums2, k2)); // 输出: 4
    }
}
