package searchedRotatedSortedArray;

import org.junit.Assert;
import org.junit.Test;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class Solution {

    /**
     * 二分查找，在中间位置判断是否被旋转过特征
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int mid = (left + right)/2;
        while (left <= right){
            if(target == nums[mid]){
                return mid;
            }
            // 向前找的情况有：
            // 1.前面是有序数组(nums[0] < nums[mid])并且(nums[0] < target < nums[mid])
            // 2.前面是旋转数组(nums[mid] < nums[0])并且target <= nums[mid] < nums[0]
            // 3.前面是旋转数组(nums[mid] < nums[0])并且nums[mid] < nums[0] <= target
            if ((nums[0] <= target  && target< nums[mid]) || (nums[mid] < nums[0] &&(target <= nums[mid] || target >= nums[0]))){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
            mid = (left + right)/2;
        }
        return -1;
    }

    @Test
    public  void Test1(){
        int[] nums = {11, 13, 1, 3, 5, 7, 9};
        int target = 11;
        Assert.assertTrue(search(nums, target) == 0);
    }
    @Test
    public  void Test2(){
        int[] nums = {11, 13, 1, 3, 5, 7, 9};
        int target = 13;
        Assert.assertTrue(search(nums, target) == 1);
    }
    @Test
    public  void Test3(){
        int[] nums = {11, 13, 1, 3, 5, 7, 9};
        int target = 1;
        Assert.assertTrue(search(nums, target) == 2);
    }
    @Test
    public  void Test4(){
        int[] nums = {11, 13, 1, 3, 5, 7, 9};
        int target = 3;
        Assert.assertTrue(search(nums, target) == 3);
    }
    @Test
    public  void Test5(){
        int[] nums = {11, 13, 1, 3, 5, 7, 9};
        int target = 5;
        Assert.assertTrue(search(nums, target) == 4);
    }
    @Test
    public  void Test6(){
        int[] nums = {11, 13, 1, 3, 5, 7, 9};
        int target = 7;
        Assert.assertTrue(search(nums, target) == 5);
    }
    @Test
    public  void Test7(){
        int[] nums = {11, 13, 1, 3, 5, 7, 9};
        int target = 9;
        Assert.assertTrue(search(nums, target) == 6);
    }
}
