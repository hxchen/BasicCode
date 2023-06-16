package dp.shortestPathInMatrix;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个M * N 的矩阵，矩阵的值是表示距离的，求从左上角到右下角的最短距离和
 */
public class Solution {
    /**
     * 动态规划
     * dp[i][j]为 [0][0]到[i][j]的最短路径
     * 转移方程
     * dp[i][j] = min(dp[i][j-1] + mat[i][j], dp[i-1][j] + mat[i][j]
     * 返回[m-1][n-1]
     * @param mat
     * @return
     */
    public int shortestPathInMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = mat[0][0];
        for (int j = 1; j < col; j++){
            dp[0][j] = dp[0][j-1] + mat[0][j];
        }
        for (int i = 1; i < row;i++){
            dp[i][0] = dp[i-1][0] + mat[i][0];
        }
        for (int i = 1;i < row; i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = Math.min(dp[i-1][j] + mat[i][j], dp[i][j-1] + mat[i][j]);
            }
        }
        return dp[row-1][col-1];
    }

    @Test
    public void Test1(){
        int[][] mat = new int[][]{
                {1, 2, 3},
                {3, 2, 3},
                {1, 1, 1}
        };
        Assert.assertTrue(shortestPathInMatrix(mat) == 7);
    }

    @Test
    public void Test2(){
        int[][] mat = new int[][]{
                {1, 4, 3},
                {3, 2, 3},
                {5, 1, 1}
        };
        Assert.assertTrue(shortestPathInMatrix(mat) == 8);
    }

}
