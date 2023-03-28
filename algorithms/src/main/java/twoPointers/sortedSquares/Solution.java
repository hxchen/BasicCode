package twoPointers.sortedSquares;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * [49, 9, 4, 9, 121]
 * 输出：[4,9,9,49,121]
 *
 */
public class Solution {
    /**
     * 除了这个常规操作，我们还可以双指针分别从首尾往中间靠拢，每次选择较大的数字放入新数组末尾。
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        for (int i = 0; i < len; i++){
            ret[i] = nums[i] * nums[i];
        }
        Arrays.sort(ret);
        return ret;
    }

    @Test
    public void Test1(){
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
    @Test
    public void Test2(){
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }
    @Test
    public void Test3(){
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -3, -2, -1})));
    }
    @Test
    public void Test4(){
        System.out.println(Arrays.toString(sortedSquares(new int[]{1, 3, 11})));
    }

}
