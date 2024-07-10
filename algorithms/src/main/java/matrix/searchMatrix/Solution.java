package matrix.searchMatrix;

import org.junit.jupiter.api.Test;

/**
 * 搜索二维矩阵
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class Solution {
    /**
     * 从左下角开始搜索
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix, 5)); // true
        System.out.println(searchMatrix(matrix, 18)); // true
        System.out.println(searchMatrix(matrix, 20)); // false
    }
}
