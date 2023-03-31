package bfsOrDfs.maxAreaOfIsland;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
public class Solution {
    int current = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    current = 0;
                    dfs(grid, i, j, visited);
                    max = Math.max(max, current);
                }
            }
        }
        return max;
    }
    private void dfs(int[][] grid, int row, int col, boolean[][] visited){
        visited[row][col] = true;
        current++;
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0},{0, -1}};
        for (int i = 0; i < dir.length; i++){
            int xx = row + dir[i][0];
            int yy = col + dir[i][1];
            if (inGrid(grid, xx, yy) && grid[xx][yy] == 1 && !visited[xx][yy]){
                dfs(grid, xx, yy, visited);
            }
        }
    }
    private boolean inGrid(int[][] grid, int sr, int sc){
        return sr >= 0 && sr < grid.length && sc >= 0 && sc < grid[0].length;
    }

    @Test
    public void Test1(){
        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        Assert.assertTrue(maxAreaOfIsland(grid) == 6);
    }

    @Test
    public void Test2(){
        int[][] grid = new int[][]{
                {0,0,0,0,0,0,0,0}
        };
        Assert.assertTrue(maxAreaOfIsland(grid) == 0);
    }
}
