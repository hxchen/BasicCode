package findPeakElement;

import org.junit.Assert;
import org.junit.Test;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */
public class Solution {
    /**
     * 二分查找一个最大值
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return  - 1;
        int left = 0, right = nums.length - 1;
        int middle;
        while (left < right){
            middle = (left + right) / 2;
            if (nums[middle] < nums[middle + 1]){
                left = middle + 1;
            } else{
                right = middle;
            }
        }
        return left;
    }

    @Test
    public  void Text1(){
        int[] nums = {1,2,3,1};
        Assert.assertTrue(findPeakElement(nums) == 2);
    }

    @Test
    public  void Text2(){
        int[] nums = {1,2,1,3,5,6,4};
        Assert.assertTrue(findPeakElement(nums) == 1 || findPeakElement(nums) == 5);
    }
}
