package timesOfK;

/**
 * 统计一个数字在排序数组中出现的次数。
 * @author haixiangchen
 */
public class Solution {

    public int search(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }

        return binarySearch(nums, target + 1) - binarySearch(nums, target);
    }

    private int binarySearch(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex)/2;
            if (nums[middleIndex] < target) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }

        return leftIndex;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        Solution solution = new Solution();
        System.out.println(solution.binarySearch(nums, target));
    }
}
