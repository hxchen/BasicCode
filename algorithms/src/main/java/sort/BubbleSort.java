package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static int[] sort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length - 1 - i; j++){
                if (nums[j + 1] < nums[j]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        return nums;
    }

    @Test
    public void Test1(){
        int[] nums = new int[]{2, 1, 4, 5, 3};
        System.out.println(Arrays.toString(sort(nums)));
    }
}
