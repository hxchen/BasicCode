package searchA2dMatrix;

import org.junit.Assert;
import org.junit.Test;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int start = 0, end = matrix.length * matrix[0].length - 1;
        int mid = 0;
        while (start <= end){
            mid = (start + end) >>> 1;
            int row = mid / (matrix[0].length);
            int column = mid % (matrix[0].length);
            if (target == matrix[row][column]){
                return true;
            } else if(target > matrix[row][column]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return  false;
    }

    @Test
    public void Test1(){
       int[][] matrix =  {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
       int target = 3;
        Assert.assertTrue(searchMatrix(matrix, target));
    }
    @Test
    public void Test2(){
        int[][] matrix =  {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        Assert.assertTrue(!searchMatrix(matrix, target));
    }
}
