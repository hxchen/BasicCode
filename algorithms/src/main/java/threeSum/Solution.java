package threeSum;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return null;
        }
        // 关键先排序，提高效率
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // 固定一个，然后左右指针找
        for (int i = 0; i < nums.length - 2; i++){
            // 首项大于0,跳出
            if(nums[i] > 0) break;
            // 重复项,跳过
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum= nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]){
                        // 重复项,跳过
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        // 重复项,跳过
                        right--;
                    }
                    left++;
                    right--;
                } else if(sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    @Test
    public void Test1(){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }

    @Test
    public void Test2(){
        int[] nums = {3,0,-2,-1,1,2};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }
}
