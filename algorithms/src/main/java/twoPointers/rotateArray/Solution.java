package twoPointers.rotateArray;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int kk = k > len ? k%len : k;
        int[] ret = new int[len];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (len - kk < len){
                ret[i] = nums[len - kk];
                kk--;
            }else{
                ret[i] = nums[j++];
            }
        }
        System.arraycopy(ret, 0, nums, 0, len);
    }

    public void rotate2(int[] nums, int k) {
        int[] copy = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        int times = k % nums.length;
        int m = 0;
        for(int i = nums.length - times; i < nums.length; i ++) {
            nums[m++] = copy[i];
        }
        for(int j = 0; j < nums.length - times; j++) {
            nums[m++] = copy[j];
        }
    }

    @Test
    public void Test1(){
        int[] nums = new int[]{1, 2, 3, 4, 5};
        rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
