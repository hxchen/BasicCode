package slidingWindow.miniumSizeSubArraySum;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = 0;
        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if (minLength != 0 && (j - i + 1) > minLength){
                    break;
                }
                if (sum >= target){
                    if (j == i){
                        return 1;
                    }
                    if (minLength == 0){
                        minLength = j - i + 1;
                    } else{
                        minLength = Math.min(minLength, (j - i + 1));
                    }
                    break;
                }
            }
        }
        return minLength;
    }

    public int minSubArrayLen2(int target, int[] nums){
        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
        while (right < nums.length){
            sum += nums[right++];
            while (sum >= target){
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
