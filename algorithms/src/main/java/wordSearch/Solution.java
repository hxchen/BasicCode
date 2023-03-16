package wordSearch;

import org.junit.Test;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 * 示例 1：
 * 输入：board = [
 *  ["A","B","C","E"],
 *  ["S","F","C","S"],
 *  ["A","D","E","E"]
 *  ], word = "ABCCED"
 * 输出：true
 *
 *
 */
public class Solution {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1},{0, 1}};

    /**
     * 递归回溯
     * 回溯时候一定要作撤销
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    System.out.println("找到一个初始点:(" + i + ", "+ j + ")");
                    used[i][j] = true;
                    if (dfs(board, word, used, 0, word.length(), i, j)){
                        return true;
                    }
                    // 回溯！！！
                    used[i][j] = false;
                }
            }
        }
        return res;
    }

    /**
     * 深度优先搜索 回溯
     * @param board
     * @param word
     * @param used
     * @param wordPos
     * @param length
     * @param x
     * @param y
     */
    private boolean dfs(char[][] board, String word, boolean[][] used, int wordPos, int length, int x, int y) {
        if (wordPos == length - 1){
            // 找到最后一个字符
            return true;
        }
        for (int i = 0; i < dir.length; i++){
            int xx = x + dir[i][0];
            int yy = y + dir[i][1];
            if (inGrid(board, xx, yy)){
                if (!used[xx][yy] && board[xx][yy] == word.charAt(wordPos + 1)){
                    used[xx][yy] = true;
                    if (dfs(board, word, used, wordPos + 1, length, xx, yy)){
                        return true;
                    }
                    // 回溯！！！
                    used[xx][yy] = false;
                }
            }
        }
        return false;
    }

    private boolean inGrid(char[][] board, int x, int y){
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    @Test
    public void Test1(){
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    @Test
    public void Test2(){
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCB";
        System.out.println(exist(board, word));
    }

    @Test
    public void Test3(){
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCESEEDA";
        System.out.println(exist(board, word));
    }

    @Test
    public void Test4(){
        char[][] board = new char[][]{
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        String word = "AAB";
        System.out.println(exist(board, word));
    }

}
