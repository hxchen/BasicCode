package binarySearch.searchInsertPosition;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }

    @Test
    public void Test1(){
        Assert.assertTrue(searchInsert(new int[]{1, 3, 5, 6}, 5) == 2);
    }
    @Test
    public void Test2(){
        Assert.assertTrue(searchInsert(new int[]{1, 3, 5, 6}, 2) == 1);
    }
    @Test
    public void Test3(){
        Assert.assertTrue(searchInsert(new int[]{1, 3, 5, 6}, 7) == 4);
    }
    @Test
    public void Test4(){
        Assert.assertTrue(searchInsert(new int[]{3, 5, 6}, 1) == 0);
    }
}
