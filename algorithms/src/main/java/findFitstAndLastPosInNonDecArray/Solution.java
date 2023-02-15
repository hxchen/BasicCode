package findFitstAndLastPosInNonDecArray;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int start = findStartIndex(nums, target);
        if(start == nums.length || nums[start] != target){
            return new int[]{-1, -1};
        }
        // 注意如何查找最后一次出现时的参数
        int end = findStartIndex(nums, target + 1) -1;
        return new int[] {start, end};

    }

    /**
     * 查找首次出现位置
     * @param nums
     * @param target
     * @return
     */
    public static int findStartIndex(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start <= end){
            // 注意中间位置
            mid = start + (end - start)/2;
            if(target > nums[mid]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
