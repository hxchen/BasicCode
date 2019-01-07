package constuctArray;

import org.junit.Assert;
import org.junit.Test;

/**
 * 构建乘积数组
 * 题目：给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，其
 * 中B中的元素B[i] =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * Created by hxchen on 2019/1/7.
 */
public class ConstuctArray {

    public static int[] buildArray(int[] input){
        int length = input.length;
        int[] output = new int[length];
        int[] partOne = new int[length];
        int[] partTwo = new int[length];

        partOne[0] = 1; // 初始化1
        for (int i = 1; i < length; i++){
            partOne[i] = partOne[i-1] * input[i-1];
        }

        partTwo[length-1] = 1; // 初始化1
        for (int j = length - 2; j >= 0; j--){
            partTwo[j] = partTwo[j+1] * input[j+1];
        }

        for (int m = 0; m < length; m++){
            output[m] = partOne[m] * partTwo[m];
        }
        return output;
    }

    public static boolean isEqual(int[] array1, int[] array2){
        if (array1.length != array2.length)
            return false;
        for(int i = 0; i < array1.length ; i++){
            if (array1[i] != array2[i])
                return false;
        }
        return true;
    }

    @Test
    public void test1(){
        int[] input = {1, 2, 3, 4, 5};
        int expected[] =  { 120, 60, 40, 30, 24 };
        int[] output = buildArray(input);
        Assert.assertTrue(isEqual(output, expected));
    }

    @Test
    public void test2(){
        int[] input = {1, 2, 0, 4, 0};
        int expected[] =  { 0, 0, 0, 0, 0 };
        int[] output = buildArray(input);
        Assert.assertTrue(isEqual(output, expected));
    }

    @Test
    public void test3(){
        int[] input = {1, 2, 0, 4, 5};
        int expected[] =  { 0, 0, 40, 0, 0 };
        int[] output = buildArray(input);
        Assert.assertTrue(isEqual(output, expected));
    }

    @Test
    public void test4(){
        int[] input = { 1, -2, 3, -4, 5 };
        int expected[] =  { 120, -60, 40, -30, 24 };
        int[] output = buildArray(input);
        Assert.assertTrue(isEqual(output, expected));
    }

    @Test
    public void test5(){
        int[] input = { 1, -2};
        int expected[] =  { -2, 1 };
        int[] output = buildArray(input);
        Assert.assertTrue(isEqual(output, expected));
    }



}
