package matrix.rotate;


import org.junit.jupiter.api.Test;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class Solution {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 矩阵转置：将矩阵的行和列互换。
        // 使用双重循环遍历矩阵，只处理上三角部分（j >= i），将 matrix[i][j] 和 matrix[j][i] 互换，实现矩阵转置。
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 每行反转：将每一行的元素顺序颠倒。
        // 再次使用双重循环遍历矩阵，对每一行进行反转，将 matrix[i][j] 和 matrix[i][n - 1 - j] 互换。
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    @Test
    public void test() {
        int[][] matrix = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        rotate(matrix);
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
