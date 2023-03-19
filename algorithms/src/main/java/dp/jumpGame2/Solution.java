package dp.jumpGame2;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 *
 *
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class Solution {

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        // 这里的节点能到达的最远距离下标。 状态转移方程 longMost[i] = Max(longMost[i - 1], nums[i] + i)
        int[] longMost = new int[nums.length];
        // 节点到这里用过的最小步数。会多次对比更新最小值
        int[] minStep = new int[nums.length];
        longMost[0] = nums[0];
        minStep[0] = 0;
        minStep[1] = 1;
        for (int i = 0; i < nums.length - 1; i++){
            if (i != 0){
                longMost[i] = Math.max(longMost[i - 1], nums[i] + i);
            }
            // 往后数longMost[i]个点计算最小步数,更新minStep
            for (int j = i + 1; j <= longMost[i] && j < nums.length - 1; j++){
                if (minStep[j] != 0){
                    minStep[j] = Math.min(minStep[j - 1] + 1, minStep[j]);
                }else{
                    minStep[j] = minStep[i] + 1;
                }
            }
            if (longMost[i] >= nums.length - 1){
                return minStep[i] + 1;
            }
        }
        return minStep[nums.length - 1];
    }

    @Test
    public void Test1(){
        int[] nums = {2, 3, 1, 1, 4, 1, 1, 2, 2};
        Assert.assertTrue(jump(nums) == 3);
    }

    @Test
    public void Test2(){
        int[] nums = {0};
        Assert.assertTrue(jump(nums) == 0);
    }

    @Test
    public void Test3(){
        int[] nums = {1, 2};
        Assert.assertTrue(jump(nums) == 1);
    }

    @Test
    public void Test4(){
        int[] nums = {3, 2, 1};
        Assert.assertTrue(jump(nums) == 1);
    }
}
