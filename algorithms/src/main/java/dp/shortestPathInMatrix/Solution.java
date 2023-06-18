package dp.shortestPathInMatrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

    ////////////////////////////// 深度优先搜索解法 //////////////////////////////
    private static int minPathSum;
    public int minPathSum(int[][] grid){
        minPathSum = Integer.MAX_VALUE;
        dfs(grid, 0, 0, 0);
        return minPathSum;
    }

    private  void dfs(int[][] grid, int row, int col, int currentSum) {
        int m = grid.length;
        int n = grid[0].length;

        // 到达右下角位置
        if (row == m - 1 && col == n - 1) {
            currentSum += grid[row][col];
            minPathSum = Math.min(minPathSum, currentSum);
            return;
        }
        
        // 向右移动
        if (col < n - 1) {
            dfs(grid, row, col + 1, currentSum + grid[row][col]);
        }

        // 向下移动
        if (row < m - 1) {
            dfs(grid, row + 1, col, currentSum + grid[row][col]);
        }
    }

    ////////////////////////////// 广度优先搜索解法 //////////////////////////////
    public  int minPathSumOfBFS(int[][] grid) {
        int m = grid.length;    // 矩阵的行数
        int n = grid[0].length; // 矩阵的列数

        int[][] distance = new int[m][n]; // 用于存储到达每个位置的最短距离和
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // 将起点加入队列
        distance[0][0] = grid[0][0];   // 起点的最短距离和为起点的值

        int[][] directions = {{0, 1}, {1, 0}}; // 右移和下移的方向

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            // 对相邻的格子进行探索
            for (int[] dir : directions) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int newDistance = distance[currRow][currCol] + grid[newRow][newCol];
                    if (newDistance < distance[newRow][newCol]) {
                        distance[newRow][newCol] = newDistance;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        // 返回右下角位置的最短距离和
        return distance[m - 1][n - 1];
    }

    @Test
    public void Test1(){
        int[][] mat = new int[][]{
                {1, 2, 3},
                {3, 2, 3},
                {1, 1, 1}
        };
        Assert.assertTrue(shortestPathInMatrix(mat) == 7);
        Assert.assertTrue(minPathSum(mat) == 7);
        Assert.assertTrue(minPathSumOfBFS(mat) == 7);
    }

    @Test
    public void Test2(){
        int[][] mat = new int[][]{
                {1, 4, 3},
                {3, 2, 3},
                {5, 1, 1}
        };
        Assert.assertTrue(shortestPathInMatrix(mat) == 8);
        Assert.assertTrue(minPathSum(mat) == 8);
        Assert.assertTrue(minPathSumOfBFS(mat) == 8);
    }

    @Test
    public void Test3(){
        int[][] mat = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        Assert.assertTrue(shortestPathInMatrix(mat) == 7);
        Assert.assertTrue(minPathSum(mat) == 7);
        Assert.assertTrue(minPathSumOfBFS(mat) == 7);
    }

}
