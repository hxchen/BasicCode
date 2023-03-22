package dp.arithmeticSlices;

import org.junit.Test;

import java.util.Arrays;

/**
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 *
 *
 *
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：0
 */
public class Solution {

    /**
     * 时间
     * 3 ms
     * 击败
     * 5%
     * 内存
     * 69.2 MB
     * 击败
     * 5.14%
     *
     * 状态转移方程
     * dp[i][j]表示下标索引 i 到 j 是否是等差数列
     * 状态转移方程:dp[i][j] = dp[i][j - 1]  && nums[j] - nums[j - 1] == nums[i + 1] - nums[i]
     * 临界条件：j - i = 2
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) return 0;
        int ret = 0;

        boolean[][] dp = new boolean [len][len];

        for (int i = 0; i < len - 2; i++){
            for(int j = i + 2; j < len; j++){
                if (j - i == 2){
                    if (2 * nums[i + 1] == nums[i] + nums[i + 2]){
                        dp[i][j] = true;
                        ret++;
                        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, i, j + 1)));
                    } else {
                        dp[i][j] = false;
                        break;
                    }
                } else {
                    dp[i][j] = dp[i][j - 1] && (2 * nums[j - 1] == nums[j - 2] + nums[j]);
                    if (dp[i][j]) {
                        ret++;
                        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, i, j + 1)));
                    }else {
                        break;
                    }
                }
            }
        }
        return ret;
    }

    /**
     * 时间
     * 0 ms
     * 击败
     * 100%
     * 内存
     * 39 MB
     * 击败
     * 94%
     *
     * dp[i]表示以i结尾的子数列包含的等差数量
     * 转移方程：dp[i] = dp[i - 1] + 1;   (nums[i - 2], nums[i - 1], nums[i]是等差数列)
     *          dp[i] = dp[i - 1];      (nums[i - 2], nums[i - 1], nums[i]不是等差数列)
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices2(int[] nums){
        int n = nums.length;
        if (n < 3) return 0;
        int[] dp = new int[n];
        int ret = 0;
        for (int i = 2; i < n; i++){
            if (2 * nums[i - 1] == nums[i - 2] + nums[i]){
                dp[i] = dp[i - 1] + 1;
            }
            ret += dp[i];
        }
        return ret;
    }



    @Test
    public void Test1(){
        int nums[] = new int[]{1, 2, 3, 4, 5, 7, 9};
        System.out.println(numberOfArithmeticSlices(nums));
        System.out.println(numberOfArithmeticSlices2(nums));
    }
}
