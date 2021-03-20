package sort;

/**
 * 快速排序
 * 1.从数列中挑出一个元素，称为"基准"（pivot），
 * 2.重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任何一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * 3.递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * Created by hxchen on 2018/7/9.
 */
public class QuickSort {

    /**
     * @param arr
     * @param head
     * @param tail
     */
    public static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        System.out.printf("head = %d, tail = %d.\t", head, tail);
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        System.out.printf("pivot_index = %d,pivot = %d.\t", (head + tail) / 2, pivot);
        printArray(arr);
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                swap(arr, i, j);
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    /**
     * 基准为第一个的快速排序
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end || arr == null || arr.length <= 1) {
            return;
        }
        // 基准为第一个
        int i = start, j = end, pivot = arr[start];
        while (i < j) {
            // 右边选择第一个比基准小的
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            // 左边选择第一个比基准大的
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, start, i);
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 8, 5, 2, 1, 9, 5, 4};
//        qSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }

    private static void printArray(int[] arr) {
        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
