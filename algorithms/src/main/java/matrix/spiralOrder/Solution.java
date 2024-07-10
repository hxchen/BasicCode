package matrix.spiralOrder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            int m = matrix.length;
            int n = matrix[0].length;
            // 定义左右上下四个边界
            int left = 0;
            int right = n - 1;
            int top = 0;
            int bottom = m - 1;

            while (left <= right && top <= bottom) {
                for (int j = left; j <= right; j++) {
                    result.add(matrix[top][j]);
                }
                for (int i = top + 1; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                if (left < right && top < bottom) {
                    for (int j = right - 1; j >= left; j--) {
                        result.add(matrix[bottom][j]);
                    }
                    for (int i = bottom - 1; i > top; i--) {
                        result.add(matrix[i][left]);
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }

            return result;
        }


        @Test
        public void test() {
            int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };
            List<Integer> result = spiralOrder(matrix);
            System.out.println(result);
        }
        @Test
        public void test2() {
            int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
            };
            List<Integer> result = spiralOrder(matrix);
            System.out.println(result);
        }
}
