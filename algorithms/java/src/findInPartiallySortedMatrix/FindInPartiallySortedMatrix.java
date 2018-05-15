package findInPartiallySortedMatrix;

/**
 *  二维数组中的查找
 *  题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
 *  照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
 *  整数，判断数组中是否含有该整数。
 * Created by hxchen on 2018/5/15.
 */
public class FindInPartiallySortedMatrix {

    public static boolean Find(int[][] matrix, int rows, int columns,int number){
        boolean found = false;
        if(matrix != null && rows > 0 && columns > 0){
            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0){
                if(matrix[row][column] == number) {
                    found = true;
                    break;
                }else if(matrix[row][column] > number){
                    --column;

                }else {
                    ++row;
                }
            }

        }
        return found;
    }


    // Test
    public static void Test(String testName, int[][] matrix, int rows, int columns, int number, boolean expexted){
        if(testName != null){
            System.out.print("begins:"+testName+"\t");
        }
        boolean result = Find(matrix, rows, columns, number);
        if(result == expexted){
            System.out.println("Passed.");
        }else{
            System.out.println("Failed.");
        }
    }
    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // 要查找的数在数组中
    public static void Test1(){
        int [][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test1", matrix, 4, 4, 7, true);
    }

    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // 要查找的数不在数组中
    public static void Test2(){
        int [][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test2", matrix, 4, 4, 5, false);
    }
    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // 要查找的数是数组中最小的数字
    public static void Test3()
    {
        int [][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test3", matrix, 4, 4, 1, true);
    }

    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // 要查找的数是数组中最大的数字
    public static void Test4()
    {
        int [][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test4", matrix, 4, 4, 15, true);
    }

    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // 要查找的数比数组中最小的数字还小
    public static void Test5()
    {
        int [][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test5", matrix, 4, 4, 0, false);
    }

    //  1   2   8   9
    //  2   4   9   12
    //  4   7   10  13
    //  6   8   11  15
    // 要查找的数比数组中最大的数字还大
    public static void Test6()
    {
        int [][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test6", matrix, 4, 4, 16, false);
    }
    //鲁棒性测试
    public static void Test7(){
        Test("Test7", null, 0, 0, 16, false);

    }
    public static void main(String[] args){
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        Test7();
    }

}
