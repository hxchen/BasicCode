package numberOfIslands;

import org.junit.Test;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围
 *
 * 示例 1：
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 *
 * 示例 2：
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 */
public class Solution {

    public int numIslands(char[][] grid) {
        int res = 0;
        for(int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[0].length; c++){
                if (grid[r][c] == '1'){
                    res++;
                    islands(grid, r, c);
                }
            }
        }
        return res;
    }

    /**
     * 标记陆地
     * @param grid
     * @param r
     * @param c
     */
    private void islands(char[][] grid, int r, int c){
        if (!inArea(grid, r, c)) {
            return;
        }
        if (grid[r][c] != '1') {
            // 海洋或者已经处理过，返回
            return;
        }
        // 标记处理
        grid[r][c] = '2';

        islands(grid, r - 1, c);
        islands(grid, r + 1, c);
        islands(grid, r, c - 1);
        islands(grid, r, c + 1);
    }

    private boolean inArea(char[][]grid, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    ////////////////////////////////////////////////----------> 通用方法开始 <----------////////////////////////////////////////////////
    /**
     * 通用遍历方法
     * @param grid
     * @param r
     * @param c
     */
    private void dfs(int[][] grid, int r, int c){
        if(!inArea(grid, r, c)){
            return;
        }
        if (grid[r][c] != 1){
            return;
        }
        grid[r][c] = 2;
        // 遍历上下左右
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
    private boolean inArea(int[][]grid, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
    ////////////////////////////////////////////////----------> 通用方法结束 <----------////////////////////////////////////////////////
    @Test
    public void Test1(){
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        System.out.println(numIslands(grid));
    }

}
