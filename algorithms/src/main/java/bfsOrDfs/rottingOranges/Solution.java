package bfsOrDfs.rottingOranges;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 */
public class Solution {
    /**
     * 腐烂橘子开始进行周边腐烂
     * 广度优先搜索
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int minute = -1;
        int row = grid.length;
        int col = grid[0].length;
        // ↑ → ↓ ←
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0},{0, -1}};
        // 腐烂的橘子队列
        Queue<int[]> badQueue = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2){
                    badQueue.offer(new int[]{i, j});
                }
            }
        }
        while (!badQueue.isEmpty()){
            minute++;
            int badSize = badQueue.size();
            for (int i = 0; i < badSize; i++) {
                //当前坏的位置
                int[] currentBad = badQueue.poll();
                //新的方向是继续坏掉
                for (int index = 0; index < 4; index++){
                    int xx = currentBad[0] + dirs[index][0];
                    int yy = currentBad[1] + dirs[index][1];
                    if (inGrid(grid, xx, yy) && grid[xx][yy] == 1){
                        grid[xx][yy] = 2;
                        badQueue.offer(new int[]{xx, yy});
                    }
                }
            }
        }
        // 能腐烂的都腐烂完了，看看还有没有好的?
        for(int i = 0; i < row; i++){
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1){
                    // 有永远不会腐烂的橘子
                    return -1;
                }
            }
        }
        // 没有坏橘子也没有好橘子时候 minute = -1 此时应该返回0
        return minute == -1 ? 0 : minute;
    }
    private boolean inGrid(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    @Test
    public void Test1(){
        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        Assert.assertTrue(orangesRotting(grid) == 4);
    }
    @Test
    public void Test2(){
        int[][] grid = new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        Assert.assertTrue(orangesRotting(grid) == -1);
    }
    @Test
    public void Test3(){
        int[][] grid = new int[][]{
                {0, 2},

        };
        Assert.assertTrue(orangesRotting(grid) == 0);
    }

    /**
     * 没有橘子
     */
    @Test
    public void Test4(){
        int[][] grid = new int[][]{
                {0},
        };
        Assert.assertTrue(orangesRotting(grid) == 0);
    }

    /**
     * 只有一个新鲜橘子
     */
    @Test
    public void Test5(){
        int[][] grid = new int[][]{
                {1},
        };
        Assert.assertTrue(orangesRotting(grid) == -1);
    }

    @Test
    public void Test6(){
        int[][] grid = new int[][]{
                {2, 2},
                {1, 1},
                {0, 0},
                {2, 0}
        };
        Assert.assertTrue(orangesRotting(grid) == 1);
    }
}
