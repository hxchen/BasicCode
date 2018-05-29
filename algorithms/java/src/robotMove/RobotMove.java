package robotMove;

import org.testng.annotations.Test;

/**
 * 机器人的运动范围
 * 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
 * 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
 * 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
 * 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * Created by hxchen on 2018/5/29.
 */
public class RobotMove {

    /**
     * 初始化工作
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public static int movingCount(int threshold, int rows, int cols){
        if(threshold < 0 || rows <= 0 || cols <= 0)
            return 0;

        boolean[] visited = new boolean[rows*cols];
        for (int i = 0; i < rows * cols; i++){
            visited[i] = false;
        }

        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);

        return count;
    }

    /**
     * 核心代码
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visited
     * @return
     */
    public static int movingCountCore(int threshold, int rows, int cols, int row , int col ,boolean[] visited){
        int count = 0;
        if(check(threshold, rows, cols, row, col, visited)){
            visited[row * cols + col] = true;

            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    /**
     * 检查坐标[row, col]是否可进。
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visited
     * @return
     */
    public static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited){
       if(row >= 0 && row < rows && col >= 0 && col < cols &&getDigitSum(row) + getDigitSum(col) <= threshold && !visited[row*cols +col]) {
//           System.out.println("[" + row + "," + col + "]");
           return true;
       }
        return false;
    }

    /**
     * 获取一个数字的数位之和,例如34,返回7(3+4)
     * @param number
     * @return
     */
    public static int getDigitSum(int number) {
        int sum = 0;
        while(number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
    // ====================测试代码====================
    public void test(String testName, int threshold, int rows, int cols, int expected) {
        if(testName != null)
            System.out.println("begins: "+testName);

        if(movingCount(threshold, rows, cols) == expected)
            System.out.println("Passed.\n");
        else
            System.out.println("FAILED.\n");
    }

    // 方格多行多列
    public void test1() {
        test("Test1", 5, 10, 10, 21);
    }

    // 方格多行多列
    public void test2() {
        test("Test2", 15, 20, 20, 359);
    }

    // 方格只有一行，机器人只能到达部分方格
    public void test3() {
        test("Test3", 10, 1, 100, 29);
    }

    // 方格只有一行，机器人能到达所有方格
    public void test4() {
        test("Test4", 10, 1, 10, 10);
    }

    // 方格只有一列，机器人只能到达部分方格
    public void test5() {
        test("Test5", 15, 100, 1, 79);
    }

    // 方格只有一列，机器人能到达所有方格
    public void test6() {
        test("Test6", 15, 10, 1, 10);
    }

    // 方格只有一行一列
    public void test7() {
        test("Test7", 15, 1, 1, 1);
    }

    // 方格只有一行一列
    public void test8() {
        test("Test8", 0, 1, 1, 1);
    }

    // 机器人不能进入任意一个方格
    public void test9() {
        test("Test9", -10, 10, 10, 0);
    }

    @Test
    public void teststart(){
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
    }
}
