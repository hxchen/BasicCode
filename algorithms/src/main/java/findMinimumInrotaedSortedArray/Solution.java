package findMinimumInrotaedSortedArray;

import org.junit.Assert;
import org.junit.Test;

/***
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        int middle = 0;
        while (start < end){
            middle = (start + end) / 2;
            if(nums[middle] < nums[end]){
                end = middle;
            } else{
                start = middle + 1;
            }
        }
        return nums[start];
    }

    @Test
    public void Test1(){
        int[] nums = {3,4,5,1,2};
        Assert.assertTrue(findMin(nums) == 1);
    }

    @Test
    public void Test2(){
        int[] nums = {4,5,6,7,0,1,2};
        Assert.assertTrue(findMin(nums) == 0);
    }
    @Test
    public void Test3(){
        int[] nums = {11,13,15,17};
        Assert.assertTrue(findMin(nums) == 11);
    }

    @Test
    public void Test4(){
        int[] nums = {2,1};
        Assert.assertTrue(findMin(nums) == 1);
    }

    @Test
    public void Test5(){
        int[] nums = {3, 1, 2};
        Assert.assertTrue(findMin(nums) == 1);
    }
}
