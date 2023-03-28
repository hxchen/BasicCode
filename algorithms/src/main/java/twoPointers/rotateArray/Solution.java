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

    @Test
    public void Test1(){
        int[] nums = new int[]{1, 2, 3, 4, 5};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
