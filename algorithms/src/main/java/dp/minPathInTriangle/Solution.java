package dp.minPathInTriangle;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 */
public class Solution {
    /**
     * dp[i][j]表示到第i层，第j个点的最小路径和
     * 那么结果就是dp[i][1...j]中的最小值
     * 转移方程：
     * dp[i][j] = Min(dp[i - 1][j], dp[i - 1][j - 1]) + nums[i][j]
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = 0;
        int depth = triangle.size();
        int[][]dp = new int[depth][depth];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < depth; i++){
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++){
                if (j == 0){
                    // 第一个点只能上面一行第一个点过来
                    dp[i][j] = dp[i - 1][j] + list.get(j);
                }else if (j == i){
                    // 最后一个店，只能上面一行最后一个点过来
                    dp[i][j] = dp[i - 1][j - 1] + list.get(j);
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j -1]) + list.get(j);
                }
            }
        }
        min = dp[depth - 1][0];
        for (int j = 1; j < depth; j++){
            min = Math.min(min, dp[depth - 1][j]);
        }
        return min;
    }

    @Test
    public void Test1(){
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        Assert.assertTrue(minimumTotal(triangle) == 11);
    }
    @Test
    public void Test2(){
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 1),
                Arrays.asList(8, 7, 6, 1, 1)
        );
        Assert.assertTrue(minimumTotal(triangle) == 15);
    }
}
