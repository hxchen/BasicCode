package bfsOrDfs.matrix01;


import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1：
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 */
public class Solution {
    /**
     * 广度优先搜索
     * 巧妙得利用：起点是所有为0的位置
     * @param mat
     * @return
     */
    public int[][] updateMatrix(int[][] mat) {
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0},{0, -1}};
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if (mat[i][j] == 0){
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()){
            // 当前位置
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 4; i++){
                // 邻居
                int xx = x + dir[i][0];
                int yy = y + dir[i][1];
                if (inGrid(mat, xx, yy) && !visited[xx][yy]){
                    // 没有处理过的邻居
                    mat[xx][yy] = mat[x][y] + 1;    // 巧妙利用当前值更新新值
                    queue.offer(new int[]{xx, yy});
                    visited[xx][yy] = true;
                }

            }
        }
        return mat;
    }

    private boolean inGrid(int[][] grid, int sr, int sc){
        return sr >= 0 && sr < grid.length && sc >= 0 && sc < grid[0].length;
    }

    @Test
    public void Test1(){
        int[][] mat = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        int[][] newMat = updateMatrix(mat);
        for (int i = 0; i < newMat.length; i++){
            System.out.println(Arrays.toString(newMat[i]));
        }
    }

    @Test
    public void Test2(){
        int[][] mat = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] newMat = updateMatrix(mat);
        for (int i = 0; i < newMat.length; i++){
            System.out.println(Arrays.toString(newMat[i]));
        }
    }
}
