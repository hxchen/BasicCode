package printMatrix;

import org.junit.Test;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * Created by hxchen on 2018/6/24.
 */
public class PrintMatrix {


    public static void PrintMatrixClockwisely(int[][] matrix){
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;  // 行
        int col = matrix[0].length;  // 列
        int start = 0;
        while (col > start * 2 && row > start * 2) { // 从外圈到内圈
            int endX = col - start - 1;
            int endY = row - start - 1;
            for (int i = start; i <= endX; i++) { // 从左到右
                System.out.print(matrix[start][i]+"\t");
            }
            if (start < endY) {
                for (int i = start + 1; i <= endY; i++) { // 从上到下
                    System.out.print(matrix[i][endX]+"\t");
                }
            }
            if (start < endX && start < endY) {
                for (int i = endX - 1; i >= start; i--) { // 从右到左
                    System.out.print(matrix[endY][i]+"\t");
                }
            }
            if (start < endX && start < endY - 1) {
                for (int i = endY - 1; i >= start + 1; i--) { // 从下到上
                    System.out.print(matrix[i][start]+"\t");
                }
            }
            start++;
        }
    }
    // 逐行打印矩阵
    public static void printMatrixOriginal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
    }

    // ====================测试代码====================
    public static void Test(int columns, int rows){
//        System.out.format("Test Begin: %d columns, %d rows.\n", columns, rows);

        if(columns < 1 || rows < 1)
            return;

        int[][] numbers =  new int[rows][columns];
        for (int i = 0 ; i < rows; i++){
            for (int j = 0; j < columns; j++){
                numbers[i][j] = i*columns+j+1;
            }
        }
        System.out.println("原来创建的矩阵：");
        printMatrixOriginal(numbers);
        System.out.println("顺时针打印矩阵：");
        PrintMatrixClockwisely(numbers);
        System.out.println();
    }
    @Test
    public void test1(){
        /*
        1
        */
        Test(1, 1);


    }
    @Test
    public void test2(){
        /*
        1    2
        3    4
        */
        Test(2, 2);


    }
    @Test
    public void test3(){
        /*
        1    2    3    4
        5    6    7    8
        9    10   11   12
        13   14   15   16
        */
        Test(4, 4);


    }
    @Test
    public void test4(){
        /*
        1    2    3    4    5
        6    7    8    9    10
        11   12   13   14   15
        16   17   18   19   20
        21   22   23   24   25
        */
        Test(5, 5);


    }
    @Test
    public void test5(){
        /*
        1
        2
        3
        4
        5
        */
        Test(1, 5);


    }@Test
    public void test6(){
        /*
        1    2
        3    4
        5    6
        7    8
        9    10
        */
        Test(2, 5);


    }@Test
    public void test7(){
        /*
        1    2    3
        4    5    6
        7    8    9
        10   11   12
        13   14   15
        */
        Test(3, 5);


    }@Test
    public void test8(){
        /*
        1    2    3    4
        5    6    7    8
        9    10   11   12
        13   14   15   16
        17   18   19   20
        */
        Test(4, 5);


    }
    @Test
    public void test9(){
        /*
        1    2    3    4    5
        */
        Test(5, 1);


    }
    @Test
    public void test10(){
        /*
        1    2    3    4    5
        6    7    8    9    10
        */
        Test(5, 2);


    }
    @Test
    public void test11(){
        /*
        1    2    3    4    5
        6    7    8    9    10
        11   12   13   14    15
        */
        Test(5, 3);


    }
    @Test
    public void test12(){
    /*
        1    2    3    4    5
        6    7    8    9    10
        11   12   13   14   15
        16   17   18   19   20
        */
        Test(5, 4);
    }

}
