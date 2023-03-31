package bfsOrDfs.floodFill;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // 注意要保存访问状态
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, image[sr][sc], color, visited);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int originalColor, int newColor, boolean[][] visited){
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        // ↑ → ↓ ←
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0},{0, -1}};
        for (int i = 0; i < dir.length; i++){
            int xx = sr + dir[i][0];
            int yy = sc + dir[i][1];
            if (inGrid(image, xx, yy) && image[xx][yy] == originalColor && !visited[xx][yy]){
                dfs(image, xx, yy, originalColor, newColor, visited);
            }
        }
    }

    private boolean inGrid(int[][] image, int sr, int sc){
        return sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length;
    }

    @Test
    public void Test1(){
        int[][] image = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] newImage = floodFill(image, sr, sc, newColor);
        for (int[] row : newImage) {
            System.out.println(Arrays.toString(row));
        }
    }
    @Test
    public void Test2(){
        int[][] image = new int[][]{
                {0, 0, 0},
                {0, 0, 0}
        };
        int sr = 0;
        int sc = 0;
        int newColor = 0;
        int[][] newImage = floodFill(image, sr, sc, newColor);
        for (int[] row : newImage) {
            System.out.println(Arrays.toString(row));
        }
    }

}
