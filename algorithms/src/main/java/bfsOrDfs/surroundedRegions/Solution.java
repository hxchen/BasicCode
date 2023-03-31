package bfsOrDfs.surroundedRegions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * @see <a href="https://leetcode.cn/problems/surrounded-regions/">surrounded-regions</a>
 *
 * 输入：board = [
 *      ["X","X","X","X"],
 *      ["X","O","O","X"],
 *      ["X","X","O","X"],
 *      ["X","O","X","X"]
 *      ]
 * 输出：[
 *      ["X","X","X","X"],
 *      ["X","X","X","X"],
 *      ["X","X","X","X"],
 *      ["X","O","X","X"]
 *      ]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Solution {
    /**
     * 找到边界上的O,BFS遍历查找O标记为A。直到边界上的O全都处理完毕。
     * 遍历board,遇到O标记为X，遇到A还原标记O
     * @param board
     */
    public void solve(char[][] board) {
        if (board.length < 3 || board[0].length < 3) return;

        int height = board.length, width = board[0].length;

        // 队列存储坐标值
        Queue<int[]> queue = new LinkedList<>();
        // 竖边界
        for (int i = 0; i < height; i++){
            //左
            if (board[i][0] == 'O'){
                queue.offer(new int[]{i,0});
                board[i][0] = 'A';
            }
            // 右
            if (board[i][width - 1] == 'O'){
                queue.offer(new int[]{i, width - 1});
                board[i][width - 1] = 'A';
            }
        }
        // 横边界
        for (int i = 1; i < width - 1; i++){
            // 上
            if (board[0][i] == 'O'){
                queue.offer(new int[]{0, i});
                board[0][i] = 'A';
            }
            // 下
            if (board[height - 1][i] == 'O'){
                queue.offer(new int[]{height - 1, i});
                board[height - 1][i] = 'A';
            }
        }
        // 对 queue 里面的点进行 bfs , 遇到O就标记为A
        // 4个方向
        int[][] dir = new int[][]{{0, -1}, {0, 1}, {-1, 0},{1, 0}};
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < dir.length; i++){
               int xx = x + dir[i][0];
               int yy = y + dir[i][1];
               if (xx < 0 || xx >= height || yy < 0 || yy >= width || board[xx][yy] != 'O'){
                   continue;
               }
               queue.offer(new int[]{xx, yy});
               board[xx][yy] = 'A';
            }
        }

        // 重新遍历board，将O设置为X。A设置O
        for (int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    @Test
    public void Test1(){
        char[][] board = {
                {'X', 'X','X','X'},
                {'X', 'O','O','X'},
                {'X', 'X','O','X'},
                {'X', 'O','X','X'}
        };
        solve(board);
        for (int i = 0; i < board.length; i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }

    @Test
    public void Test2(){
        char[][] board = {
                {'X'}
        };
        solve(board);
        for (int i = 0; i < board.length; i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }

    @Test
    public void Test3(){
        char[][] board = {
                {'O', 'O','O'},
                {'O', 'O','O'},
                {'O', 'O','O'}
        };
        solve(board);
        for (int i = 0; i < board.length; i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }

    @Test
    public void Test4(){
        char[][] board = {
                {'X', 'O','X','X'},
                {'O', 'X','O','X'},
                {'X', 'O','X','O'},
                {'O', 'X','O','X'}
        };
        solve(board);
        for (int i = 0; i < board.length; i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }

    @Test
    public void Test5(){
        char[][] board = {
                {'X', 'O','X','O','X','O'},
                {'O', 'X','O','X','O','X'},
                {'X', 'O','X','O','X','O'},
                {'O', 'X','O','X','O','X'}
        };
        solve(board);
        for (int i = 0; i < board.length; i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
