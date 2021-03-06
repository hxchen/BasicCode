package findMaxSumOfSubArrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * 连续子数组的最大和
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整
 * 数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * Created by hxchen on 2018/7/11.
 */
public class FindMaxSumOfSubArrays {

    public static boolean isInvalidInput = false;

    public static int findMaxSumOfSubArrays(int[] arr) {
        if (null == arr) {
            isInvalidInput = true;
            return 0;
        }
        int currentSum = 0;
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (currentSum < 0) {
                currentSum = arr[i];
            } else {
                currentSum += arr[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    public void Test(int[] arr, int expectedMax, boolean flag) {
        int maxSum = findMaxSumOfSubArrays(arr);
        Assert.assertTrue(maxSum == expectedMax && isInvalidInput == flag);
    }

    @Test
    public void Test1() {
        int data[] = {1, -2, 3, 10, -4, 7, 2, -5};
        Test(data, 18, false);
    }

    @Test
    public void Test2() {
        int data[] = {-2, -8, -1, -5, -9};
        Test(data, -1, false);
    }

    @Test
    public void Test3() {
        int data[] = {2, 8, 1, 5, 9};
        Test(data, 25, false);
    }

    @Test
    public void Test4() {
        Test(null, 0, true);
    }

}
