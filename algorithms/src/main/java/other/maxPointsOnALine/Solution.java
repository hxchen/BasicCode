package other.maxPointsOnALine;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * 暴力解法
     * 点A(x1, y1) B(x2, y2) C(x3,y3)在同一条直线上的话，有：
     * (y2 - y1)/(x2 - x1) = (y3 - y1)/(x3 - x1) 即：（y2 - y1）* (x3 - x1) =(x2 - x1)* (y3 - y1)
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        if (points.length < 2) return points.length;
        int max = 2;
        for(int i = 0; i < points.length; i++){
            for (int j = i + 1; j < points.length; j++){
                // 点i 和 点 j
                int res = 2;
                for (int m = j + 1; m < points.length; m++){
                    // points[i] points[j] points[m]
                    if((points[j][1] - points[i][1]) * (points[m][0] - points[i][0]) == (points[j][0] - points[i][0]) * (points[m][1] - points[i][1])){
                        res++;
                    }
                }
                max = Math.max(max, res);
            }
        }
        return max;
    }

    @Test
    public void Test1(){
       int[][] points = new int[][]{
               {1, 1},
               {2, 2},
               {3, 3}
       };
        Assert.assertTrue(maxPoints(points) == 3);
    }

    @Test
    public void Test2(){
        int[][] points = new int[][]{
                {1, 1},
                {3, 2},
                {5, 3},
                {4, 1},
                {2, 3},
                {1, 4}
        };
        Assert.assertTrue(maxPoints(points) == 4);
    }


    @Test
    public void Test3(){
        int[][] points = new int[][]{
                {1, 1},
                {1, 1},
                {1, 1},
                {2, 2}
        };
        Assert.assertTrue(maxPoints(points) == 4);
    }

    @Test
    public void Test4(){
        int[][] points = new int[][]{
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0}
        };
        Assert.assertTrue(maxPoints(points) == 4);
    }
}
