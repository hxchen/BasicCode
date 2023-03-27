package binarySearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {// 注意判断条件
            int mid = start + (end - start)/2;
            if (target == nums[mid]){
                return mid;
            } else if (nums[mid] > target){
                end = mid - 1;  // 是mid - 1不是mid
            }else {
                start = mid + 1;    // 是mid + 1不是mid
            }
        }
        return -1;
    }

    @Test
    public void Test1(){
        Assert.assertTrue(search(new int[]{-1, 0, 3, 5, 9, 12}, -1) == 0);
    }
    @Test
    public void Test2(){
        Assert.assertTrue(search(new int[]{-1, 0, 3, 5, 9, 12}, 0) == 1);
    }
    @Test
    public void Test3(){
        Assert.assertTrue(search(new int[]{-1, 0, 3, 5, 9, 12}, 3) == 2);
    }
    @Test
    public void Test4(){
        Assert.assertTrue(search(new int[]{-1, 0, 3, 5, 9, 12}, 5) == 3);
    }
    @Test
    public void Test5(){
        Assert.assertTrue(search(new int[]{-1, 0, 3, 5, 9, 12}, 9) == 4);
    }
    @Test
    public void Test6(){
        Assert.assertTrue(search(new int[]{-1, 0, 3, 5, 9, 12}, 12) == 5);
    }
}
