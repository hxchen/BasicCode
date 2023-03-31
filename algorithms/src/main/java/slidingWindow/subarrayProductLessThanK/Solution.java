package slidingWindow.subarrayProductLessThanK;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 *
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2]、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 *
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int number = 0;
        for (int i = 0; i < nums.length; i++){
            int result = 1;
            for (int j = i; j < nums.length; j++){
                result *= nums[j];
                if(result < k){
                    ++number;
                } else {
                    break;
                }
            }
        }
        return number;
    }

    @Test
    public void Test1(){
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    @Test
    public void Test2(){
        int[] nums = {1, 2, 3};
        int k = 0;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    @Test
    public void Test3(){
        int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int k = 19;
        System.out.println("预期结果:" + numSubarrayProductLessThanK(nums, k));
    }

}
