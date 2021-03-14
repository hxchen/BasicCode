package sort;

import java.util.Arrays;

/**
 * Top K 问题求解
 * @author haixiangchen
 */
public class TopK {

    public int[] topK(int[] array, int k){
        quickSort(array, 0, array.length-1, k);
        return Arrays.copyOfRange(array,array.length -k, array.length);
    }
    public  void quickSort(int[] arr, int start, int end, int k){
        if(start >= end || arr == null || arr.length <= 1){
            return;
        }
        // 基准为第一个
        int i = start, j = end, pivot = arr[start];
        while (i < j){
            // 右边选择第一个比基准小的
            while (i < j && arr[j] >= pivot){
                j--;
            }
            // 左边选择第一个比基准大的
            while (i < j && arr[i] <= pivot){
                i++;
            }
            if (i < j){
                swap(arr, i, j);
            }
        }
        swap(arr, start, i);
        if (i == arr.length - k){
            return;
        }
        quickSort(arr, start, i - 1, k);
        quickSort(arr, i + 1, end, k);

    }
    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    private void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        TopK solution = new TopK();
        int[] arr = new int[]{3, 7, 8, 5, 2, 1, 9, 5, 4, 12, 43, 45, 12, 1, 2,32};
        int[] ret = solution.topK(arr,10);
        solution.printArray(ret);
    }
}
