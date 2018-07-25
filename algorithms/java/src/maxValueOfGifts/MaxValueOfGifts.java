package maxValueOfGifts;

import org.junit.Assert;
import org.junit.Test;

/**
 * 礼物的最大价值
 * 题目：在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值
 * （价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或
 * 者向下移动一格直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计
 * 算你最多能拿到多少价值的礼物？
 * Created by hxchen on 2018/7/25.
 */
public class MaxValueOfGifts {

    public static int getMaxValueOfGifts(int[][] array){
        if (array == null)
            return 0;

        int rows = array.length;
        int cols = array[0].length;
        int maxValues[][] = new int[rows][cols];    //保存到达坐标[i][j]时,拿到礼物价值总和的最大值

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                int left = 0;
                int up = 0;

                if (i > 0)
                    left = maxValues[i-1][j]+array[i][j];
                if (j > 0)
                    up = maxValues[i][j-1]+array[i][j];

                maxValues[i][j] = maxValue(left, up);

                if (i == 0 && j == 0)
                    maxValues[0][0] = array[0][0];

            }
        }
        return maxValues[rows-1][cols-1];
    }

    /**
     * 获取x y中的大值
     * @param x
     * @param y
     * @return
     */
    private static int maxValue(int x, int y){
        return x > y ? x : y;
    }

    @Test
    public void Test1(){
        int[][] values = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        Assert.assertTrue(getMaxValueOfGifts(values) == 29);
    }
    @Test
    public void Test2(){
        int[][] values = {
                { 1, 10, 3, 8 },
                { 12, 2, 9, 6 },
                { 5, 7, 4, 11 },
                { 3, 7, 16, 5 }
        };
        Assert.assertTrue(getMaxValueOfGifts(values) == 53);
    }
    @Test
    public void Test3(){
        int[][] values = {
                { 1, 10, 3, 8 }
        };
        Assert.assertTrue(getMaxValueOfGifts(values) == 22);
    }
    @Test
    public void Test4(){
        int[][] values = {
                { 1 },
                { 12 },
                { 5 },
                { 3 }
        };
        Assert.assertTrue(getMaxValueOfGifts(values) == 21);
    }
    @Test
    public void Test5(){
        int[][] values = {
                { 12 }
        };
        Assert.assertTrue(getMaxValueOfGifts(values) == 12);
    }
    @Test
    public void Test6(){
        int[][] values = null;
        Assert.assertTrue(getMaxValueOfGifts(values) == 0);
    }

}
