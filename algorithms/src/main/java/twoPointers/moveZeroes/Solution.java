package twoPointers.moveZeroes;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0) continue;
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] != 0){
                    swap(nums, i, j);
                    break;
                }
            }
        }
    }

    private void swap(int[] nums, int m, int n){
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }

    @Test
    public void Test1(){
        int[] nums = new int[]{0, 1, 0, 3, 12, 0, -1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    @Test
    public void Test2(){
        int[] nums = new int[]{0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    @Test
    public void Test3(){
        int[] nums = new int[]{1, 0, 1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
