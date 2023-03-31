package bfsOrDfs.shortestPathBinaryMatrix;

import org.junit.Test;

import java.util.*;

/**
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 *
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 *
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 *
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 * 输出：-1
 */
public class Solution {
    /**
     * 广度优先搜索，最短路径一定是选择没有访问过的路径
     * 已经访问过的路径可以标记为1
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1){
            return -1;
        }
        //方向
        int[][] dir = new int[][]{{0, -1},{1, 1},{1, 0},{1, -1},{0, 1},{-1, 1},{-1, 0},{-1, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        int length = 0;
        while (!queue.isEmpty()){
            length++;
            // 逐层搜索
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] tmp = queue.poll();
                // 当前点坐标
                int x = tmp[0];
                int y = tmp[1];
                if (x == grid.length - 1 && y == grid[0].length - 1){
                    //走到了出口
                    return length;
                }
                //标记处理过
                grid[tmp[0]][tmp[1]] = 1;
                for (int j = 0; j < dir.length; j++){
                    // 邻居点坐标
                    int xx = x + dir[j][0];
                    int yy = y + dir[j][1];
                    if (xx >= 0 && xx < grid[0].length && yy >= 0 && yy < grid.length && grid[xx][yy] == 0){
                        queue.offer(new int[]{xx, yy});
                        grid[xx][yy] = 1;
                    }
                }
            }
        }
        return -1;
    }

    @Test
    public void Test1(){
        int grid[][] = {
                {0,0,0},
                {1,1,0},
                {1,1,0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    @Test
    public void Test2(){
        int grid[][] = {
                {0,1},
                {1,0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    @Test
    public void Test3(){
        int grid[][] = {
                {1,0,0},
                {1,1,0},
                {1,1,0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    @Test
    public void Test4(){
        int grid[][] = {
                {0,0,0},
                {1,0,0},
                {1,1,0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }

}
