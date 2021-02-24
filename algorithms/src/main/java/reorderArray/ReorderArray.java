package reorderArray;

import org.junit.Test;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
 * 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * Created by hxchen on 2018/6/11.
 */
public class ReorderArray {

    public static int[] ReorderArray(int[] array) {
        int begin = 0;
        int end = array.length - 1;

        while (begin < end) {
            // 奇数,继续找下一个,直到遇到偶数
            while (begin < end && array[begin] % 2 != 0)
                begin++;
            // 偶数,继续找上一个,直到遇到奇数
            while (begin < end && array[end] % 2 == 0)
                end--;
            // 交换找到的奇数和偶数
            int temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;
        }

        return array;
    }

    public void printArray(int[] array) {

        for (int number : array) {
            System.out.print(number + "\t");
        }
        System.out.println();
    }

    @Test
    public void test1() {
        int numbers[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("调整前:\t");
        printArray(numbers);
        int[] result = ReorderArray(numbers);
        System.out.print("调整后:\t");
        printArray(result);
    }

    @Test
    public void test2() {
        int numbers[] = {2, 4, 6, 1, 3, 5, 7};
        System.out.print("调整前:\t");
        printArray(numbers);
        int[] result = ReorderArray(numbers);
        System.out.print("调整后:\t");
        printArray(result);
    }

    @Test
    public void test3() {
        int numbers[] = {1, 3, 5, 7, 2, 4, 6};
        System.out.print("调整前:\t");
        printArray(numbers);
        int[] result = ReorderArray(numbers);
        System.out.print("调整后:\t");
        printArray(result);
    }

    @Test
    public void test4() {
        int numbers[] = {1};
        System.out.print("调整前:\t");
        printArray(numbers);
        int[] result = ReorderArray(numbers);
        System.out.print("调整后:\t");
        printArray(result);
    }

    @Test
    public void test5() {
        int numbers[] = {2};
        System.out.print("调整前:\t");
        printArray(numbers);
        int[] result = ReorderArray(numbers);
        System.out.print("调整后:\t");
        printArray(result);
    }

    @Test
    public void test6() {
        int numbers[] = {};
        System.out.print("调整前:\t");
        printArray(numbers);
        int[] result = ReorderArray(numbers);
        System.out.print("调整后:\t");
        printArray(result);
    }
}
