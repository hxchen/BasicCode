package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {
    
    public static int[] sort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            int minIndex = i;
            for (int j = i; j < nums.length; j++){
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    @Test
    public void Test1(){
        int[] nums = new int[]{2, 1, 4, 5, 3};
        System.out.println(Arrays.toString(sort(nums)));
    }
}
